package net.crazymonkey68.chimeraville.datagen;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Chimeraville.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE_LAYLA);
        simpleItem(ModItems.SHRINE_OLEG);
        simpleItem(ModItems.CLAW_DEMIR);

        simpleItem(ModItems.RAW_LION_MEAT);
        simpleItem(ModItems.COOKED_LION_MEAT);

        simpleItem(ModItems.PROPANE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Chimeraville.MOD_ID, "item/" + item.getId().getPath()));
    }
}
