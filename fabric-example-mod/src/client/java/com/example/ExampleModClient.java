package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleModClient implements ClientModInitializer {

	public static final Item CustomItems = new TestItem(new FabricItemSettings());
	public static final EntityType<TestArrow> testArrowType = Registry.register(Registries.ENTITY_TYPE, new Identifier("tmb_testmod", "test_arrow"), FabricEntityTypeBuilder.<TestArrow>create(SpawnGroup.MISC, TestArrow::new).dimensions(EntityDimensions.fixed(0.25f,0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build());
	@Override
	public void onInitializeClient() {

		Registry.register(Registries.ITEM, new Identifier("tmb_testmod", "testitem"), CustomItems);

		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}