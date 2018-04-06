package kiwifails.minicoal.items;


import kiwifails.minicoal.config.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase minicoal;
    public static ItemBase minicharcoal;
    private static IForgeRegistry registryEvent;

    public static void init(IForgeRegistry event) {
        registryEvent = event;

        if (!Config.disableMiniCoal)
            minicoal = register(new ItemOre("minicoal", "minicoal").setCreativeTab(CreativeTabs.MATERIALS));

        if (!Config.disableMiniCharcoal)
            minicharcoal = register(new ItemOre("minicharcoal", "minicharcoal").setCreativeTab(CreativeTabs.MATERIALS));
    }

    private static <T extends Item> T register(T item) {
        registryEvent.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase) item).registerItemModel();
        }
        if (item instanceof ItemOreDict) {
            ((ItemOreDict) item).initOreDict();
        }

        return item;
    }

    @SubscribeEvent
    public final void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.init(event.getRegistry());
    }
}
