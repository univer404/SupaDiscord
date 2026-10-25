package com.supadiscord;

import com.supadiscord.commands.DiscordCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SupaDiscord extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand discordCommand = getCommand("discord");
        if (discordCommand == null) {
            getLogger().severe("The /discord command is missing from plugin.yml. Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        DiscordCommand executor = new DiscordCommand();
        discordCommand.setExecutor(executor);
        discordCommand.setTabCompleter(executor);
        getLogger().info("SupaDiscord enabled.");
    }
}