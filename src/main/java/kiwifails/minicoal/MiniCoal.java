package kiwifails.minicoal;

import java.io.File;

import kiwifails.minicoal.config.Config;
import kiwifails.minicoal.handler.EventHandler;
import kiwifails.minicoal.handler.FuelHandler;
import kiwifails.minicoal.items.ModItems;
import kiwifails.minicoal.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MiniCoal.MODID, version = MiniCoal.VERSION, name = MiniCoal.NAME)
public class MiniCoal {
    public static final String MODID = "minicoal";
    public static final String VERSION = "1.0";
    public static final String NAME = "MiniCoal";

    @SidedProxy(clientSide = "kiwifails.minicoal.proxy.ClientProxy", serverSide = "kiwifails.minicoal.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static MiniCoal instance;

    public static Config config;
    
    //Constructor to setup EventHandler
    public MiniCoal() {
		MinecraftForge.EVENT_BUS.register(EventHandler.class);
	}

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        String path = event.getSuggestedConfigurationFile().getAbsolutePath().replace(MiniCoal.MODID, "MiniCoal");
        config = Config.initialize(new File(path));
        //ModItems.init();
        proxy.preInit(event);

    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
        ModItems.init();
        GameRegistry.registerFuelHandler(new FuelHandler());

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        proxy.postInit(event);

    }
}
