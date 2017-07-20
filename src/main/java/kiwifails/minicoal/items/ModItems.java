package kiwifails.minicoal.items;

import kiwifails.minicoal.config.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

	public static ItemBase minicoal;
	public static ItemBase minicharcoal;

	//Would be preInit, but registry is done by event now
	public static void onItemRegistry(RegistryEvent.Register<Item> event) {

		if (!Config.disableMiniCoal)
			minicoal = register(event, new ItemOre("minicoal", "minicoal").setCreativeTab(CreativeTabs.MATERIALS));

		if (!Config.disableMiniCharcoal)
			minicharcoal = register(event, new ItemOre("minicharcoal", "minicharcoal").setCreativeTab(CreativeTabs.MATERIALS));
	}

	private static <T extends Item> T register(RegistryEvent.Register<Item> event, T item) {
		event.getRegistry().register(item);

		if (item instanceof ItemOreDict) {
			((ItemOreDict) item).initOreDict();
		}

		return item;
	}
	
	public static void init() {
    	if(!Config.disableMiniCoal)
    		minicoal.registerItemModel();

        if(!Config.disableMiniCharcoal)
            minicharcoal.registerItemModel();
	}
}
