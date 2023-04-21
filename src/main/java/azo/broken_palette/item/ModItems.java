package azo.broken_palette.item;

import azo.broken_palette.BrokenPalette;
import azo.broken_palette.item.custom.DriftedCofferItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DRIFTED_COFFER = registerItem("drifted_coffer",
            new DriftedCofferItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,
                new Identifier(BrokenPalette.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.BROKEN_PALETTE_ITEM_GROUP, DRIFTED_COFFER);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        BrokenPalette.LOGGER.info("Registering Mod Items for " + BrokenPalette.MOD_ID);
        addItemsToItemGroup();
    }
}
