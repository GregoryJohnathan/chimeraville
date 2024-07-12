package net.crazymonkey68.chimeraville.item;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chimeraville.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHIMERAVILLE_TAB = CREATIVE_MODE_TABS.register("chimeraville_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SHRINE_OLEG.get()))
                    .title(Component.translatable("creativetab.chimeraville_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE_LAYLA.get());
                        pOutput.accept(ModItems.SHRINE_OLEG.get());
                        pOutput.accept(Items.DIAMOND);

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
