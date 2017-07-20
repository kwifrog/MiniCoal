package kiwifails.minicoal.handler;

import kiwifails.minicoal.items.ModItems;
import kiwifails.minicoal.items.ModRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	@SubscribeEvent
	public static void onItemRegistry(RegistryEvent.Register<Item> event) {
		ModItems.onItemRegistry(event);
	}
	
	@SubscribeEvent
	public static void onRecipeRegistry(RegistryEvent.Register<IRecipe> event) {
		ModRecipes.onRecipeRegistry(event);
	}
}
