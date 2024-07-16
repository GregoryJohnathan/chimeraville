package net.crazymonkey68.chimeraville.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class SapphireLaylaItem extends Item {

    // Standard initialization like any item
    public SapphireLaylaItem(Properties pProperties) {
        super(pProperties);
    }

    // Activates when right-clicking on a block
    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if(pContext.getLevel().isClientSide()) {

            // Retrieves player object and position of position clicked
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            Level pLevel = pContext.getLevel();

            boolean foundBlock = false;

            // Loops through every block below the block
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    pLevel.playSound(player, player.getOnPos(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS,
                            1f, 1f);

                    break;
                }
            }

            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No valuables found!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState){
        return blockState.is(Blocks.EMERALD_ORE) || blockState.is(Blocks.DIAMOND_ORE) || blockState.is(Blocks.GOLD_ORE) || blockState.is(Blocks.LAPIS_ORE);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chimeraville.sapphire_layla.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
