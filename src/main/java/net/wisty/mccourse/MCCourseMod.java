package net.wisty.mccourse;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.wisty.mccourse.block.ModBlocks;
import net.wisty.mccourse.item.ModCreativeModeTabs;
import net.wisty.mccourse.item.ModItems;
import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mccourse";

    private static final Logger LOGGER = LogUtils.getLogger();

    public MCCourseMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ALEXANDERITE);
            event.accept(ModItems.RAW_ALEXANDERITE);
            event.accept(ModItems.SUPERORE);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.ALEXANDERITE_BLOCK);
            event.accept(ModBlocks.RAW_ALEXANDERITE_BLOCK);
            event.accept(ModBlocks.SUPERORE_BLOCK);
            event.accept(ModBlocks.ALEXANDERITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_ALEXANDERITE_ORE);
            event.accept(ModBlocks.NETHER_ALEXANDERITE_ORE);
            event.accept(ModBlocks.END_STONE_ALEXANDERITE_ORE);
            event.accept(ModBlocks.BLOCK_OF_SUPERORE);
            event.accept(ModBlocks.DEEPSLATE_BLOCK_OF_SUPERORE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}