package net.crazymonkey68.chimeraville.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

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

}
