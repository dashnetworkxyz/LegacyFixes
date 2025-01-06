package xyz.dashnetwork.legacyfixes.fix;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.Plugin;

public final class EndFix implements Listener {

    public EndFix(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityPortal(EntityPortalEvent event) {
        generatePlatform(event.getTo());
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        generatePlatform(event.getTo());
    }

    private void generatePlatform(Location location) {
        if (location.getWorld().getEnvironment() != World.Environment.THE_END)
            return;

        Block block = location.getBlock();

        fillAround(block.getRelative(0, -1, 0), Material.OBSIDIAN);
        fillAround(block, Material.AIR);
        fillAround(block.getRelative(0, 1, 0), Material.AIR);
        fillAround(block.getRelative(0, 2, 0), Material.AIR);
    }

    private void fillAround(Block block, Material material) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                block.getRelative(x, 0, z).setType(material);
            }
        }
    }

}
