package net.projectprimal.simple_weaponry.registries;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.projectprimal.simple_weaponry.registries.Item.SWItems;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Pickaxe.HammerWeapon;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Sword.DaggerWeapon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = "simple_weaponry", bus = EventBusSubscriber.Bus.GAME)
public class SWEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onLivingDamage(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            ItemStack weapon = attacker.getMainHandItem();

            if (weapon.getItem() instanceof DaggerWeapon dagger) {
                LivingEntity target = event.getEntity();
                Level level = target.level();

                Vec3 attackerLook = attacker.getLookAngle();
                Vec3 targetLook = target.getLookAngle();

                attackerLook = attackerLook.normalize();
                targetLook = targetLook.normalize();
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
                    }

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

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerWeapon hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerWeapon.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(SWItems.IRON_STUDDED_CLUB.get(), 1), 12, 3, 0.05f));

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(SWItems.IRON_DAGGER.get(), 1), 12, 3, 0.05f));
        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(SWItems.STONE_HAMMER.get(), 1), 12, 3, 0.2f));

        }
    }
}