package io.github.schntgaispock.slimehud.placeholder;

import io.github.schntgaispock.slimehud.SlimeHUD;
import org.bukkit.Bukkit;

public class PlaceholderManager {
    public static void setup() {
        if (SlimeHUD.getInstance().getConfig().getBoolean("options.placeholder-api-support", true)) {
            if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                new PlaceholderHook().register();
            } else {
                SlimeHUD.getInstance().getLogger().info("PlaceholderAPI 未安装，相关功能将不会启用。");
            }
        }
    }
}
