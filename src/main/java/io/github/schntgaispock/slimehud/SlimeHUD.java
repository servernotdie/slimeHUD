package io.github.schntgaispock.slimehud;

import javax.annotation.Nonnull;

import com.tcoded.folialib.FoliaLib;
import io.github.schntgaispock.slimehud.placeholder.PlaceholderManager;
import io.github.schntgaispock.slimehud.translation.TranslationManager;
import io.github.schntgaispock.slimehud.waila.HudController;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.slimehud.command.CommandManager;
import io.github.schntgaispock.slimehud.waila.WAILAManager;
import lombok.Getter;

public class SlimeHUD extends AbstractAddon {

    @Getter AddonConfig playerData;
    static @Getter SlimeHUD instance;
    private HudController hudController;
    private TranslationManager translationManager;
    private static FoliaLib foliaLib;

    public SlimeHUD() {
        super("SlimefunGuguProject", "SlimeHUD", "master", "options.auto-update");
    }

    @Override
    public void enable() {
        instance = this;
        foliaLib = new FoliaLib(this);

        getLogger().info("#=================================#");
        getLogger().info("#    SlimeHUD by SchnTgaiSpock    #");
        getLogger().info("#=================================#");

        Metrics metrics = new Metrics(this, 15883);
        metrics.addCustomChart(
            new SimplePie("disabled", () -> {
                return "" + getConfig().getBoolean("waila.disabled");
            })
        );
        metrics.addCustomChart(
            new SimplePie("waila_location", () -> {
                return getConfig().getString("waila.location");
            })
        );

        playerData = new AddonConfig("player.yml");

        WAILAManager.setup();
        CommandManager.setup();
        PlaceholderManager.setup();
        hudController = new HudController();
        translationManager = new TranslationManager();

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "SlimefunGuguProject", "SlimeHUD", "master");
        }
    }

    @Override
    public void disable() {
        instance = null;
        getPlayerData().save();
    }

    public static HudController getHudController() {
        return instance.hudController;
    }

    public static TranslationManager getTranslationManager() {
        return instance.translationManager;
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
        return new NamespacedKey(SlimeHUD.getInstance(), name);
    }

    public static FoliaLib getFoliaLib() {
        return foliaLib;
    }
}
