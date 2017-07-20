package kiwifails.minicoal.items;

import kiwifails.minicoal.MiniCoal;
import kiwifails.minicoal.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void onRecipeRegistry(RegistryEvent.Register<IRecipe> event) {
		ResourceLocation group = new ResourceLocation(MiniCoal.NAME);

		if (!Config.disableMiniCoal) {
			// GameRegistry.addShapelessRecipe(new ItemStack(ModItems.minicoal, 8), new
			// ItemStack(Items.COAL));
			GameRegistry.addShapelessRecipe(new ResourceLocation(MiniCoal.MODID, ModItems.minicoal.name), group,
					new ItemStack(ModItems.minicoal, 8), Ingredient.fromStacks(new ItemStack(Items.COAL)));
		}
		if (!Config.disableMiniCharcoal) {
			// GameRegistry.addShapelessRecipe(new ItemStack(ModItems.minicharcoal, 8), new
			// ItemStack(Items.COAL, 1, 1));
			GameRegistry.addShapelessRecipe(new ResourceLocation(MiniCoal.MODID, ModItems.minicharcoal.name), group,
					new ItemStack(ModItems.minicharcoal, 8), Ingredient.fromStacks(new ItemStack(Items.COAL, 1, 1)));
		}
		if (!Config.reformMiniCoal) {
			// GameRegistry.addShapedRecipe(new ItemStack(Items.COAL, 1),
			// "AAA",
			// "A A",
			// "AAA",
			// 'A', new ItemStack(ModItems.minicoal));
			
			Ingredient m = Ingredient.fromItems(ModItems.minicoal);
			Ingredient a = Ingredient.fromItems(Items.AIR);
			Ingredient[] coalRecipeIngredients = {
					m,m,m,
					m,a,m,
					m,m,m
			};
			NonNullList<Ingredient> coalRecipe = NonNullList.create();
			for (Ingredient ingredient : coalRecipeIngredients) {
				coalRecipe.add(ingredient);
			}
			ShapedRecipes minicoalReform = new ShapedRecipes(group.toString(), 3, 3, coalRecipe,
					new ItemStack(Items.COAL, 1));
			minicoalReform.setRegistryName(MiniCoal.MODID, "coal");
			event.getRegistry().register(minicoalReform);
		}
		if (!Config.reformMiniCharcoal) {
			// GameRegistry.addShapedRecipe(new ItemStack(Items.COAL, 1, 1),
			// "BBB",
			// "B B",
			// "BBB",
			// 'B', new ItemStack(ModItems.minicharcoal));
			Ingredient m = Ingredient.fromItems(ModItems.minicharcoal);
			Ingredient a = Ingredient.fromItems(Items.AIR);
			Ingredient[] charcoalRecipeIngredients = {
					m,m,m,
					m,a,m,
					m,m,m
			};
			NonNullList<Ingredient> charcoalRecipe = NonNullList.create();
			for (Ingredient ingredient : charcoalRecipeIngredients) {
				charcoalRecipe.add(ingredient);
			}
			ShapedRecipes minicharcoalReform = new ShapedRecipes(group.toString(), 3, 3, charcoalRecipe,
					new ItemStack(Items.COAL, 1, 1));
			minicharcoalReform.setRegistryName(MiniCoal.MODID, "charcoal");
			event.getRegistry().register(minicharcoalReform);
		}
	}

}
