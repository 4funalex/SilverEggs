package com.funalex.silvereggs;

import com.funalex.silvereggs.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class SilverEggs implements ModInitializer {
    public static final String MODID = "silvereggs";

    @Override
    public void onInitialize() {
        ItemRegistry.registerItems();
    }
}
