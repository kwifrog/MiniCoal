package kiwifails.minicoal.items;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static ItemBase miniCoal;
    public static ItemBase miniCharcoal;

    public static void init() {
        miniCoal = register(new ItemOre("miniCoal", "miniCoal").setCreativeTab(CreativeTabs.MATERIALS));
        miniCharcoal = register(new ItemOre("miniCharcoal", "miniCharcoal").setCreativeTab(CreativeTabs.MATERIALS));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase) item).registerItemModel();
        }
        if (item instanceof ItemOreDict) {
            ((ItemOreDict) item).initOreDict();
        }

        return item;
    }
}
