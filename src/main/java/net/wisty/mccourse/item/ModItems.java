package net.wisty.mccourse.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wisty.mccourse.MCCourseMod;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDERITE = ITEMS.register("alexanderite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUPERORE = ITEMS.register("superore",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALEXANDERITE = ITEMS.register("raw_alexanderite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
