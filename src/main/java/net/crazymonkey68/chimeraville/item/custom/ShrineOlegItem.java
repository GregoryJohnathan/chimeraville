package net.crazymonkey68.chimeraville.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShrineOlegItem extends Item {

    // Standard initialization like any item
    public ShrineOlegItem(Properties pProperties) {
        super(pProperties);
    }

    // Activates when right-clicking on a block
    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if(pContext.getLevel().isClientSide()) {

            // Retrieves player object and position of position clicked
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            player.sendSystemMessage(Component.literal("Oleg is not to be disturbed..."));
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chimeraville.shrine_oleg.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
