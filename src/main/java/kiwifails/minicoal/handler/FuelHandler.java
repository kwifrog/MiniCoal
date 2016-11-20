package kiwifails.minicoal.handler;

import kiwifails.minicoal.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == ModItems.minicoal) {
            return 200;
        }
        if (fuel.getItem() == ModItems.minicharcoal) {
            return 200;
        }

        return 0;
    }
}
