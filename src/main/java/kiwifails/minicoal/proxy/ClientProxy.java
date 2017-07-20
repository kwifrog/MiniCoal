package kiwifails.minicoal.proxy;

import kiwifails.minicoal.MiniCoal;
import kiwifails.minicoal.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        //ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MiniCoal.MODID + ":" + id, "inventory"));
    	ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		ModelResourceLocation modelRes = new ModelResourceLocation(MiniCoal.MODID + ":" + id,
				"inventory");
		mesher.register(item, meta, modelRes);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
    	ModItems.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
