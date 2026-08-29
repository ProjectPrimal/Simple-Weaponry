package net.projectprimal.simple_weaponry.mixin;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.projectprimal.simple_weaponry.registries.Item.SWItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.mehvahdjukaar.supplementaries.common.entities.PlundererEntity")
public class PirateWeapon {

    @Inject(
            method = "finalizeSpawn",
            at = @At("TAIL"),
            remap = false
    )
    private void replaceSwordWithDagger(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData spawnGroupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        Mob plunderer = (Mob) (Object) this;
        plunderer.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(SWItems.GOLDEN_CUTLASS.get()));
    }
}
