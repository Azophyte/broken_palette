package azo.broken_palette.block;

import azo.broken_palette.BrokenPalette;
import azo.broken_palette.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block AEGEAN_SEA_GLASS = registerBlock("aegean_sea_glass",
            new Block(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CARMINE_SEA_GLASS = registerBlock("carmine_sea_glass",
            new Block(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CERISE_SEA_GLASS = registerBlock("cerise_sea_glass",
            new Block(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block MAUVE_SEA_GLASS = registerBlock("mauve_sea_glass",
            new Block(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);

    public static final Block ASHAKITE_TILES = registerBlock("ashakite_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block BLEACHED_PURPUR = registerBlock("bleached_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CARVED_PURPUR = registerBlock("carved_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CORALSTONE = registerBlock("coralstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CORALSTONE_BRICK = registerBlock("coralstone_brick",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CORALSTONE_CARVED = registerBlock("coralstone_carved",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block CORALSTONE_GRIT = registerBlock("coralstone_grit",
            new FallingBlock(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(1.0f)), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block DARK_EMERALD_TILES = registerBlock("dark_emerald_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f)), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block DARK_PURPUR = registerBlock("dark_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block DEEP_PURPUR = registerBlock("deep_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block EMERALD_TILES = registerBlock("emerald_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block GLOOMY_LAPIS_FLAGSTONE = registerBlock("gloomy_lapis_flagstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block RAW_ASHAKITE = registerBlock("raw_ashakite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block SORROWFUL_LAPIS_FLAGSTONE = registerBlock("sorrowful_lapis_flagstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);
    public static final Block SWIRLY_PRISMARINE = registerBlock("swirly_prismarine",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BROKEN_PALETTE_ITEM_GROUP);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(BrokenPalette.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(BrokenPalette.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        BrokenPalette.LOGGER.info("Registering ModBlocks for " + BrokenPalette.MOD_ID);
    }
}
