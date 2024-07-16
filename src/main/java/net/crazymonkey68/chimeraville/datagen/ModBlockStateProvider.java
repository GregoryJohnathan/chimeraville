package net.crazymonkey68.chimeraville.datagen;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chimeraville.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LION_SQUID_BLOCK);
        blockWithItem(ModBlocks.VOCAL_BLOCK);
        blockWithItem(ModBlocks.RED_TILE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
