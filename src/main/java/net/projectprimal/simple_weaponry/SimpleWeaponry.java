package net.projectprimal.simple_weaponry;

import net.projectprimal.simple_weaponry.registries.SWEntities;
import net.projectprimal.simple_weaponry.registries.SWItems;
import net.projectprimal.simple_weaponry.registries.SWSounds;
import net.projectprimal.simple_weaponry.registries.SWTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(SimpleWeaponry.MOD_ID)
public class SimpleWeaponry {
    public static final String MOD_ID = "simple_weaponry";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SimpleWeaponry(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        SWItems.register(modEventBus);
        SWTabs.register(modEventBus);
        SWEntities.register(modEventBus);
        SWSounds.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(FMLCommonSetupEvent event) {
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
