package xyz.dashnetwork.legacyfixes;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.dashnetwork.legacyfixes.fix.*;

public final class LegacyFixes extends JavaPlugin {

    @Override
    public void onEnable() {
        new ChatFix(this);
        new CropFix(this);
        new EndFix(this);
        new OcelotFix(this);
        new PlantFix(this);
        new PortalFix(this);
        new WolfFix(this);
    }

}
