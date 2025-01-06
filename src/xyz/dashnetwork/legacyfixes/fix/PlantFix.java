package xyz.dashnetwork.legacyfixes.fix;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.plugin.Plugin;

import java.util.List;

public final class PlantFix implements Listener {

    public PlantFix(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        breakAbove(event.getBlock());
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        breakAbove(event.getBlock());
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        List<Block> blocks = event.blockList();

        for (Block block : blocks)
            if (!blocks.contains(block.getRelative(BlockFace.UP)))
                breakAbove(block);
    }

    @EventHandler
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {
        breakAbove(event.getBlock().getRelative(event.getDirection()));
    }

    @EventHandler
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {
        breakAbove(event.getBlock().getRelative(event.getDirection().getOppositeFace(), 2));
    }

    @SuppressWarnings("deprecation")
    private void breakAbove(Block block) {
        Block above = block.getRelative(BlockFace.UP);

        switch (above.getTypeId()) {
            case 6: // minecraft:sapling
            case 31: // minecraft:tallgrass
            case 32: // minecraft:deadbush
            case 37: // minecraft:yellow_flower
            case 38: // minecraft:red_flower
            case 39: // minecraft:brown_mushroom
            case 40: // minecraft:red_mushroom
            case 59: // minecraft:wheat
            case 104: // minecraft:pumpkin_stem
            case 105: // minecraft:melon_stem
            case 141: // minecraft:carrots
            case 142: // minecraft:potatoes
                above.breakNaturally();
        }
    }

}
