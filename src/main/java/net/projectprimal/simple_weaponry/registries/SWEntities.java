package net.projectprimal.simple_weaponry.registries;

import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Dynamite.Dynamite;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SWEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SimpleWeaponry.MOD_ID);

    public static final Supplier<EntityType<Dynamite>> DYNAMITE =
            ENTITY_TYPES.register("dynamite", () -> EntityType.Builder.<Dynamite>of(Dynamite::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("dynamite"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}