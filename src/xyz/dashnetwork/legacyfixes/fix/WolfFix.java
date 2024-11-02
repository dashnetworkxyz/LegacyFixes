package xyz.dashnetwork.legacyfixes.fix;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.plugin.Plugin;

public final class WolfFix implements Listener {

    public WolfFix(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.WOLF) {
            Wolf wolf = (Wolf) event.getEntity();
            wolf.setRemoveWhenFarAway(false);
            wolf.setCollarColor(DyeColor.RED);
        }
    }

    @EventHandler
    public void onEntityTame(EntityTameEvent event) {
        if (event.getEntityType() == EntityType.WOLF) {
            Wolf wolf = (Wolf) event.getEntity();
            wolf.setCollarColor(DyeColor.RED);
        }
    }

}
