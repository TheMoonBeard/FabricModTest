package com.example;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(TagGenerator::new);

        // Adding a provider example:
        // 
        // pack.addProvider(AdvancementsProvider::new);
    }

    private static final TagKey<Item> CUSTOM_ARROWS = TagKey.of(RegistryKeys.ITEM, new Identifier("tmb_mod:custom_arrows"));

    private static class TagGenerator extends FabricTagProvider.ItemTagProvider {
        public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        private static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("tmb_mod:smelly_items"));
        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {

            getOrCreateTagBuilder(SMELLY_ITEMS)
                    .add(Items.SLIME_BALL)
                    .add(Items.ROTTEN_FLESH)
                    .addOptionalTag(ItemTags.DIRT);
        }


    }
}