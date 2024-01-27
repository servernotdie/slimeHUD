package io.github.schntgaispock.slimehud.translation;

import io.github.schntgaispock.slimehud.SlimeHUD;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import net.guizhanss.slimefuntranslation.SlimefunTranslation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class TranslationManager {
    private boolean translationEnabled;

    public TranslationManager() {
        if (SlimeHUD.getInstance().getConfig().getBoolean("options.slimefun-translation-support", true)) {
            if (Bukkit.getPluginManager().getPlugin("SlimefunTranslation") != null) {
                translationEnabled = true;
            } else {
                SlimeHUD.getInstance().getLogger().info("SlimefunTranslation 未安装，相关功能将不会启用。");
                translationEnabled = false;
            }
        }
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public String getItemName(Player p, SlimefunItem sfItem) {
        if (!translationEnabled) {
            return sfItem.getItemName();
        }
        
        try {
            return SlimefunTranslation.getTranslationService().getTranslatedItemName(
                    SlimefunTranslation.getUserService().getUser(p),
                    sfItem);
        } catch (NoClassDefFoundError e) {
            SlimeHUD.getInstance().getLogger().info("无法获取物品翻译，请更新 SlimefunTranslation!");
            translationEnabled = false;
            return sfItem.getItemName();
        }
    }
}
