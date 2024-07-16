package net.crazymonkey68.chimeraville.item;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.block.custom.FuelItem;
import net.crazymonkey68.chimeraville.item.custom.ModFoods;
import net.crazymonkey68.chimeraville.item.custom.SapphireLaylaItem;
import net.crazymonkey68.chimeraville.item.custom.ShrineOlegItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Chimeraville.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE_LAYLA = ITEMS.register("sapphire_layla",
            () -> new SapphireLaylaItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> SHRINE_OLEG = ITEMS.register("shrine_oleg",
            () -> new ShrineOlegItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> CLAW_DEMIR = ITEMS.register("claw_demir",
            () -> new SwordItem(new ForgeTier(3, 500, 1, 0, 0,null, null),
                    2, 2, new Item.Properties()));

    public static final RegistryObject<Item> RAW_LION_MEAT = ITEMS.register("raw_lion_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_LION_MEAT)));

    public static final RegistryObject<Item> COOKED_LION_MEAT = ITEMS.register("cooked_lion_meat",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_LION_MEAT)));

    public static final RegistryObject<Item> PROPANE = ITEMS.register("propane",
            () -> new FuelItem(new Item.Properties().stacksTo(1), 64000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
