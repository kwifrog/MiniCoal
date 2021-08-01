package kiwi.minicoal;

import kiwi.minicoal.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
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
   }
}
