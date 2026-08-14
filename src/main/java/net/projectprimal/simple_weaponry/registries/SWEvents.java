package net.projectprimal.simple_weaponry.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents; // Import vanilla sound events
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.DaggerWeapon;

@EventBusSubscriber(modid = "simple_weaponry", bus = EventBusSubscriber.Bus.GAME)
public class SWEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            ItemStack weapon = attacker.getMainHandItem();

            if (weapon.getItem() instanceof DaggerWeapon dagger) {
                LivingEntity target = event.getEntity();
                Level level = target.level();

                Vec3 attackerLook = attacker.getLookAngle().normalize();
                Vec3 targetLook = target.getLookAngle().normalize();
                double dotProduct = attackerLook.dot(targetLook);

                if (dotProduct > 0.6) {
                    float originalDamage = event.getAmount();
                    float newDamage = originalDamage * dagger.getBackstabMultiplier();
                    event.setAmount(newDamage);

                    if (!level.isClientSide()) {
                        level.playSound(
                                null,
                                target.getX(), target.getY(), target.getZ(),
                                SoundEvents.PLAYER_ATTACK_CRIT,
                                SoundSource.PLAYERS,
                                1.0F,
                                1.4F);

                    if (attacker instanceof ServerPlayer serverPlayer) {
                            ResourceLocation advancementId = ResourceLocation.fromNamespaceAndPath("simple_weaponry", "backstab");
                            var advancementHolder = serverPlayer.server.getAdvancements().get(advancementId);
                            if (advancementHolder != null) {
                                serverPlayer.getAdvancements().award(advancementHolder, "backstab");
                            }
                        }
                    }
                }
            }
        }
    }
}