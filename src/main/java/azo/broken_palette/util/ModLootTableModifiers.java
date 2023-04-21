package azo.broken_palette.util;

import azo.broken_palette.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier TREAUSRE_ID
            = new Identifier("minecraft","gameplay/fishing/treasure");
    private static final Identifier DROWNED_ID
            = new Identifier("minecraft","entities/drowned");

    private static final Identifier BURIED_TREASURE_ID
            = new Identifier("minecraft","chests/buried_treasure");
    private static final Identifier SHIPWRECK_TREASURE_ID
            = new Identifier("minecraft","chests/shipwreck_treasure");
    private static final Identifier UNDERWATER_RUIN_BIG_ID
            = new Identifier("minecraft","chests/underwater_ruin_big");
    private static final Identifier UNDERWATER_RUIN_SMALL_ID
            = new Identifier("minecraft","chests/underwater_ruin_small");


    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(TREAUSRE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.20f)) // Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.DRIFTED_COFFER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(BURIED_TREASURE_ID.equals(id) || SHIPWRECK_TREASURE_ID.equals(id) || UNDERWATER_RUIN_BIG_ID.equals(id) || UNDERWATER_RUIN_SMALL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.20f)) // Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.DRIFTED_COFFER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(DROWNED_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f)) // Drops 15% of the time
                        .with(ItemEntry.builder(ModItems.DRIFTED_COFFER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });


    }
}
