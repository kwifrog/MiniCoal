package kiwi.minicoal;

import kiwi.minicoal.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MiniCoal.MODID)
@Mod.EventBusSubscriber(modid = MiniCoal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiniCoal {
   public static final String MODID = "minicoal";

   public MiniCoal() {
      final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

      ModItems.ITEMS.register(modEventBus);

      MinecraftForge.EVENT_BUS.register(this);

      modEventBus.addListener(this::addCreative);
   }

   private void addCreative(CreativeModeTabEvent.BuildContents event) {
      if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
         event.accept(ModItems.MINI_COAL);
         event.accept(ModItems.MINI_CHARCOAL);
      }
   }
}
