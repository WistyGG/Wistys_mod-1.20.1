package net.wisty.mccourse.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wisty.mccourse.MCCourseMod;
import net.wisty.mccourse.block.custom.SoundBlock;
import net.wisty.mccourse.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> ALEXANDERITE_BLOCK = registerBlock("alexanderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SUPERORE_BLOCK = registerBlock("superore_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> RAW_ALEXANDERITE_BLOCK = registerBlock("raw_alexanderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));



    public static final RegistryObject<Block> ALEXANDERITE_ORE = registerBlock("alexanderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDERITE_ORE = registerBlock("deepslate_alexanderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> END_STONE_ALEXANDERITE_ORE = registerBlock("end_stone_alexanderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
    public static final RegistryObject<Block> NETHER_ALEXANDERITE_ORE = registerBlock("nether_alexanderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));


    public static final RegistryObject<Block> BLOCK_OF_SUPERORE = registerBlock("block_of_superore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(5f).requiresCorrectToolForDrops(),UniformInt.of(3,6)));

    public static final RegistryObject<Block> DEEPSLATE_BLOCK_OF_SUPERORE = registerBlock("deepslate_block_of_superore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(5f).requiresCorrectToolForDrops(),UniformInt.of(3,6)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
