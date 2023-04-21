package azo.broken_palette.item.custom;

import azo.broken_palette.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.util.math.random.Random.createLocal;

public class DriftedCofferItem extends Item {
    public DriftedCofferItem(Settings settings) {
        super(settings);
    }

    public static TypedActionResult<ItemStack> consumeHeldItem(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);

        player.setStackInHand(hand, getTreasure());
        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 15f, 0f);
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            // return between 32 and 64 sea glass
            return consumeHeldItem(world, user, hand);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemScatterer.spawn(entity.getEntityWorld(), entity.getX(), entity.getY(), entity.getZ(), getTreasure());
        super.onItemEntityDestroyed(entity);
    }

    public static Item getTreasureType(){
        switch(Random.createLocal().nextInt(4)) {
            case 0:
                return ModBlocks.AEGEAN_SEA_GLASS.asItem();
            case 1:
                return ModBlocks.CARMINE_SEA_GLASS.asItem();
            case 2:
                return ModBlocks.CERISE_SEA_GLASS.asItem();
        }
        return ModBlocks.MAUVE_SEA_GLASS.asItem();
    }

    public static ItemStack getTreasure(){
        ItemStack treasureItemStack = new ItemStack(getTreasureType());
        treasureItemStack.setCount(createLocal().nextInt(33) + 32);
        return treasureItemStack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.broken_palette.drifted_coffer.tooltip").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
