package xyz.dashnetwork.legacyfixes.fix;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

public final class OcelotFix implements Listener {

    public OcelotFix(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.OCELOT) {
            Ocelot ocelot = (Ocelot) event.getEntity();
            ocelot.setRemoveWhenFarAway(false);
        }
    }

}
