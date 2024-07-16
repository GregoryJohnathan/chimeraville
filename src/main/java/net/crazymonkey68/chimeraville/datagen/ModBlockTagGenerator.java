package net.crazymonkey68.chimeraville.datagen;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.block.ModBlocks;
import net.crazymonkey68.chimeraville.item.ModItems;
import net.crazymonkey68.chimeraville.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Chimeraville.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LION_SQUID_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LION_SQUID_BLOCK.get());
    }
}
