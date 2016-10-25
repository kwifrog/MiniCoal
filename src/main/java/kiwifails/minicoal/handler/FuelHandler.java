package kiwifails.minicoal.handler;

import kiwifails.minicoal.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == ModItems.miniCoal) {
            return 200;
        }
        if (fuel.getItem() == ModItems.miniCharcoal) {
            return 200;
        }

        return 0;
    }
}
