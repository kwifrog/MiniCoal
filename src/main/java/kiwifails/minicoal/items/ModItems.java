package kiwifails.minicoal.items;


import kiwifails.minicoal.config.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static ItemBase minicoal;
    public static ItemBase minicharcoal;

    public static void init() {

        if(!Config.disableMiniCoal)
        minicoal = register(new ItemOre("minicoal", "minicoal").setCreativeTab(CreativeTabs.MATERIALS));

        if(!Config.disableMiniCharcoal)
        minicharcoal = register(new ItemOre("minicharcoal", "minicharcoal").setCreativeTab(CreativeTabs.MATERIALS));
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
