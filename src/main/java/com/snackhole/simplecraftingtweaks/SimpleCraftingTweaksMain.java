package com.snackhole.simplecraftingtweaks;

import com.snackhole.simplecraftingtweaks.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimpleCraftingTweaksMain.MODID, version = SimpleCraftingTweaksMain.VERSION)
public class SimpleCraftingTweaksMain {
    public static final String MODID = "simplecraftingtweaks";
    public static final String VERSION = "1";
    @SidedProxy(clientSide = "com.snackhole.simplecraftingtweaks.proxy.ClientProxy", serverSide = "com.snackhole.simplecraftingtweaks.proxy.ServerProxy")
    public static IProxy proxy;
    @Mod.Instance
    public static SimpleCraftingTweaksMain simpleCraftingTweaksMainInstance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public SimpleCraftingTweaksMain() {
        simpleCraftingTweaksMainInstance = this;
    }
}