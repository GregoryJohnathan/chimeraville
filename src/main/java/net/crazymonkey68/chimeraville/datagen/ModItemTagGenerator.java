package net.crazymonkey68.chimeraville.datagen;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.item.ModItems;
import net.crazymonkey68.chimeraville.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Chimeraville.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.CHIMERA_ARTIFACTS)
                .add(ModItems.SAPPHIRE_LAYLA.get(),
                        ModItems.SHRINE_OLEG.get(),
                        ModItems.CLAW_DEMIR.get());
    }
}
