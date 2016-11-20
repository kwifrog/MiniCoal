package kiwifails.minicoal.items;

import kiwifails.minicoal.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {

        addItemRecipes();

    }

    public static void addItemRecipes() {

        if(!Config.disableMiniCoal)
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.minicoal, 8), new ItemStack(Items.COAL));

        if(!Config.disableMiniCharcoal)
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.minicharcoal, 8), new ItemStack(Items.COAL, 1, 1));

        if(!Config.reformMiniCoal)
            GameRegistry.addShapedRecipe(new ItemStack(Items.COAL, 1),
                    "AAA",
                    "A A",
                    "AAA",
                    'A', new ItemStack(ModItems.minicoal));

        if(!Config.reformMiniCharcoal)
            GameRegistry.addShapedRecipe(new ItemStack(Items.COAL, 1, 1),
                    "BBB",
                    "B B",
                    "BBB",
                    'B', new ItemStack(ModItems.minicharcoal));
    }

}
