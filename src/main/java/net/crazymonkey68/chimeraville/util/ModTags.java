package net.crazymonkey68.chimeraville.util;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Chimeraville.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> CHIMERA_ARTIFACTS = tag("chimera_artifacts");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Chimeraville.MOD_ID, name));
        }
    }
}
