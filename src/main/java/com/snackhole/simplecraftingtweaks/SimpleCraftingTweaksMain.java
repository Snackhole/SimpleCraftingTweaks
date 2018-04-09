package com.snackhole.simplecraftingtweaks;

import com.snackhole.simplecraftingtweaks.proxy.IProxy;
import com.snackhole.simplecraftingtweaks.recipe.ModRecipes;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SimpleCraftingTweaksMain.MODID, version = SimpleCraftingTweaksMain.VERSION)
public class SimpleCraftingTweaksMain {
    public static final String MODID = "simplecraftingtweaks";
    public static final String VERSION = "2";
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
        ModRecipes.init();
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public SimpleCraftingTweaksMain() {
        simpleCraftingTweaksMainInstance = this;
    }

    @Mod.EventBusSubscriber
    public static class AnvilRepairHandler {
        @SubscribeEvent
        public static void anvilUpdateEvent(AnvilUpdateEvent event) {
            event.getLeft().setRepairCost(0);
            event.getRight().setRepairCost(0);
        }

        @SubscribeEvent
        public static void anvilRepairEvent(AnvilRepairEvent event) {
            event.getItemResult().setRepairCost(0);
        }
    }
}
