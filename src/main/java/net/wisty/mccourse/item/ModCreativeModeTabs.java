package net.wisty.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wisty.mccourse.MCCourseMod;
import net.wisty.mccourse.block.ModBlocks;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SUPERORE.get()))
                    .title(Component.translatable("creativetab.course_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDERITE.get());
                        output.accept(ModItems.RAW_ALEXANDERITE.get());
                        output.accept(ModItems.SUPERORE.get());

                        output.accept(ModBlocks.ALEXANDERITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDERITE_BLOCK.get());
                        output.accept(ModBlocks.SUPERORE_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDERITE_ORE.get());
                        output.accept(ModBlocks.NETHER_ALEXANDERITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ALEXANDERITE_ORE.get());
                        output.accept(ModBlocks.END_STONE_ALEXANDERITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_BLOCK_OF_SUPERORE.get());
                        output.accept(ModBlocks.BLOCK_OF_SUPERORE.get());
                    }).build());

    public static void register(IEventBus eventbus){
        CREATIVE_MODE_TABS.register(eventbus);
    }



}
