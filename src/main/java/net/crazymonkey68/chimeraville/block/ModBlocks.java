package net.crazymonkey68.chimeraville.block;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.block.custom.VocalBlock;
import net.crazymonkey68.chimeraville.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Chimeraville.MOD_ID);

    public static final RegistryObject<Block> RED_TILE_BLOCK = registerBlock("red_tile_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> LION_SQUID_BLOCK = registerBlock("lion_squid_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> VOCAL_BLOCK = registerBlock("vocal_block",
            () -> new VocalBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

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
