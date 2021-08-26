package kiwi.minicoal.data;

import kiwi.minicoal.MiniCoal;
import kiwi.minicoal.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    private static ResourceLocation modid(String path) {
        return new ResourceLocation(MiniCoal.MODID, path);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.MINI_COAL.get(), 8)
                .requires(Items.COAL)
                .unlockedBy("has_coal", has(Items.COAL))
                .group("minicoal")
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.MINI_CHARCOAL.get(), 8)
                .requires(Items.CHARCOAL)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .unlockedBy("has_mini_charcoal", has(ModItems.MINI_CHARCOAL.get()))
                .group("minicoal")
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(Items.COAL)
                .requires(ModItems.MINI_COAL.get(), 8)
                .unlockedBy("has_mini_coal", has(ModItems.MINI_COAL.get()))
                .group("minicoal")
                .save(consumer, "mini_coal_to_coal");
        ShapelessRecipeBuilder.shapeless(Items.CHARCOAL)
                .requires(ModItems.MINI_CHARCOAL.get(), 8)
                .unlockedBy("has_mini_charcoal", has(ModItems.MINI_CHARCOAL.get()))
                .group("minicoal")
                .save(consumer, "mini_charcoal_to_charcoal");
    }
}
