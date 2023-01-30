package kiwi.minicoal.registry;

import kiwi.minicoal.MiniCoal;
import kiwi.minicoal.items.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MiniCoal.MODID);

    public static final RegistryObject<FuelItem> MINI_COAL = ITEMS.register(
            "mini_coal", () -> new FuelItem(new Item.Properties()));
    public static final RegistryObject<Item> MINI_CHARCOAL = ITEMS.register(
            "mini_charcoal", () -> new FuelItem(new Item.Properties()));
}

