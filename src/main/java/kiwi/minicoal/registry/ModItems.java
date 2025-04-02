package kiwi.minicoal.registry;

import kiwi.minicoal.items.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static kiwi.minicoal.MiniCoal.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> MINI_COAL = ITEMS.register("mini_coal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> MINI_CHARCOAL = ITEMS.register("mini_charcoal",
            () -> new FuelItem(new Item.Properties(), 200));

//    public static final DeferredItem<FuelItem> MINI_COAL = ITEMS.register(
//            "mini_coal", () -> new FuelItem(new Item.Properties()));
//    public static final DeferredItem<FuelItem> MINI_CHARCOAL = ITEMS.register(
//            "mini_charcoal", () -> new FuelItem(new Item.Properties()));

}
