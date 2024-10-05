package kiwi.minicoal;

import kiwi.minicoal.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(MiniCoal.MODID)
public class MiniCoal
{
    public static final String MODID = "minicoal";

    public MiniCoal(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        NeoForge.EVENT_BUS.register(this);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(new ItemStack((ItemLike) ModItems.MINI_COAL));
            event.accept(new ItemStack((ItemLike) ModItems.MINI_CHARCOAL));
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

}
