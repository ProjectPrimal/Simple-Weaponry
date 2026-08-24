package net.projectprimal.simple_weaponry.registries.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.projectprimal.simple_weaponry.SimpleWeaponry;

import java.util.function.Supplier;

public class SWTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleWeaponry.MOD_ID);

    public static final Supplier<CreativeModeTab> SIMPLE_WEAPONRY_TAB = CREATIVE_MODE_TAB.register("simple_weaponry_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(SWItems.WOODEN_CLUB.get()))
            .title(Component.translatable("creativetab.simple_weaponry.simple_weaponry_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                // Release
                output.accept(SWItems.WOODEN_CLUB);
                if (ModList.get().isLoaded("create")) {
                    output.accept(SWItems.COPPER_STUDDED_CLUB);}
                output.accept(SWItems.IRON_STUDDED_CLUB);
                if (ModList.get().isLoaded("create")) {
                    output.accept(SWItems.ZINC_STUDDED_CLUB);}
                output.accept(SWItems.GOLD_STUDDED_CLUB);
                if (ModList.get().isLoaded("create")) {
                    output.accept(SWItems.BRASS_STUDDED_CLUB);}
                if (ModList.get().isLoaded("alexscaves")) {
                    output.accept(SWItems.URANIUM_STUDDED_CLUB);}

                output.accept(SWItems.WOODEN_DAGGER);
                output.accept(SWItems.STONE_DAGGER);
                output.accept(SWItems.IRON_DAGGER);
                output.accept(SWItems.GOLDEN_DAGGER);
                output.accept(SWItems.DIAMOND_DAGGER);
                output.accept(SWItems.NETHERITE_DAGGER);

                output.accept(SWItems.WOODEN_HAMMER);
                output.accept(SWItems.STONE_HAMMER);
                output.accept(SWItems.IRON_HAMMER);
                output.accept(SWItems.GOLDEN_HAMMER);
                output.accept(SWItems.DIAMOND_HAMMER);
                output.accept(SWItems.NETHERITE_HAMMER);

                output.accept(SWItems.DYNAMITE);

                // Upcoming Pirate Update
                output.accept(SWItems.COAST_UPGRADE_SMITHING_TEMPLATE);

                output.accept(SWItems.WOODEN_CUTLASS);
                output.accept(SWItems.STONE_CUTLASS);
                output.accept(SWItems.IRON_CUTLASS);
                output.accept(SWItems.GOLDEN_CUTLASS);
                output.accept(SWItems.DIAMOND_CUTLASS);
                output.accept(SWItems.NETHERITE_CUTLASS);


                // Upcoming Jungle Update
                //output.accept(SWItems.AZTEC_CLUB);
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}