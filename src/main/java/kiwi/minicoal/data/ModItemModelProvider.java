/*
package kiwi.minicoal.data;

import kiwi.minicoal.MiniCoal;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public static final String GENERATED = "item/generated";

    public ModItemModelProvider(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MiniCoal.MODID, helper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc(GENERATED));
        builder(itemGenerated, "mini_coal");
        builder(itemGenerated, "mini_charcoal");
    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
*/
