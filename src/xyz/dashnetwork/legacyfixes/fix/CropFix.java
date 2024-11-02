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

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        Block block = event.getBlock();

        if (block.getType() == Material.SOIL)
            breakAbove(block);
    }

    private void breakAbove(Block block) {
        Block crop = block.getRelative(BlockFace.UP);

        switch (crop.getType()) {
            case CROPS:
            case CARROT:
            case POTATO:
            case MELON_STEM:
            case PUMPKIN_STEM:
                crop.breakNaturally();
        }
    }

}
