package azo.broken_palette.item;

import azo.broken_palette.BrokenPalette;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup BROKEN_PALETTE_ITEM_GROUP;

    public static void registerItemGroups(){
        BROKEN_PALETTE_ITEM_GROUP = FabricItemGroup.builder(new
                Identifier(BrokenPalette.MOD_ID, "broken_palette"))
                .displayName(Text.translatable("itemgroup.broken_palette"))
                .icon(() -> new ItemStack(ModItems.DRIFTED_COFFER)).build();
    }
}
