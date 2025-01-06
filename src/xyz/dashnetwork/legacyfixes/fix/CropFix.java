package xyz.dashnetwork.legacyfixes.fix;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public final class CropFix implements Listener {

    public CropFix(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL)
            breakAbove(event.getClickedBlock());
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        Block block = event.getBlock();

        if (block.getTypeId() == 60)
            breakAbove(block);
    }

    @SuppressWarnings("deprecation")
    private void breakAbove(Block block) {
        Block crop = block.getRelative(BlockFace.UP);

        switch (crop.getTypeId()) {
            case 59: // minecraft:wheat
            case 104: // minecraft:pumpkin_stem
            case 105: // minecraft:melon_stem
            case 141: // minecraft:carrots
            case 142: // minecraft:potatoes
                crop.breakNaturally();
        }
    }

}
