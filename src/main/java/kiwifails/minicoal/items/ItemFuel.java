package kiwifails.minicoal.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ItemFuel implements IFuelHandler {

    private static final List<Fuel> FUEL_LIST = new ArrayList<Fuel>();

    public static void init() {

        GameRegistry.registerFuelHandler(new ItemFuel());

        addFuel(ModItems.miniCoal, 0, 200);
        addFuel(ModItems.miniCharcoal, 0, 200);

    }

    private static void addFuel(Item item, int meta, int value) {

        FUEL_LIST.add(new Fuel(new ItemStack(item, 1, meta), value));
    }

    @Override
    public int getBurnTime(ItemStack stack){
        if(stack != null){
            for(Fuel fuel : FUEL_LIST){
                if(stack.isItemEqual(fuel.fuel)){
                    return fuel.burnTime;
                }
            }
        }
        return 0;
    }

    private static class Fuel {

        public ItemStack fuel;
        public int burnTime;

        public Fuel(ItemStack fuel, int burnTime) {
            this.fuel = fuel;
            this.burnTime = burnTime;
        }
    }
}
