package kiwifails.minicoal.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    private static Config instance = null;
    public static String CATEGORY_GENERAL = "GENERAL";
    public static String CATEGORY_RECIPE = "RECIPES";

    public static boolean disableMiniCoal;
    public static boolean reformMiniCoal;

    public static boolean disableMiniCharcoal;
    public static boolean reformMiniCharcoal;

    public static Configuration config;

    private Config(File configFile) {
        config = new Configuration(configFile);
        config.load();

        Config.Configs();

        config.save();
    }

    public static Config initialize(File configFile) {
        if (instance == null)
            instance =  new Config(configFile);
        else
            throw new IllegalStateException("Cannot initialize MiniCoal config twice");
        return instance;
    }

    public static Config instance() {
        if (instance == null) {
            throw new IllegalStateException("Instance of MiniCoal Config requested before initialization");
        }
        return instance;
    }

    public static void Configs() {
        disableMiniCoal = config.get(CATEGORY_GENERAL, "Disable Mini Coal", false, "Set to true to disable Mini Coal").getBoolean();

        disableMiniCharcoal = config.get(CATEGORY_GENERAL, "Disable Mini Charcoal", false, "Set to true to disable Mini Charcoal").getBoolean();

        reformMiniCoal = config.get(CATEGORY_RECIPE, "Disable Mini Coal to Coal", false, "Set to true to remove the Mini Coal to Coal recipe").getBoolean();

        reformMiniCharcoal = config.get(CATEGORY_RECIPE, "Disable Mini Charcoal to Charcoal", false, "Set to true to remove the Mini Charcoal to Charcoal recipe").getBoolean();

        if (config.hasChanged())
            config.save();
    }

}
