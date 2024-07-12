package net.crazymonkey68.chimeraville.item;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Chimeraville.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE_LAYLA = ITEMS.register("sapphire_layla",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHRINE_OLEG = ITEMS.register("shrine_oleg",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
