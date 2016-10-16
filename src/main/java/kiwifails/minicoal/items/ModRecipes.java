package kiwifails.minicoal.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.miniCoal, 8), new ItemStack(Items.COAL));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.miniCharcoal, 8), new ItemStack(Items.COAL, 1, 1));

    }

}
