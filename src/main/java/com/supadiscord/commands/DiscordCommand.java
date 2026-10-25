package com.supadiscord.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public final class DiscordCommand implements CommandExecutor, TabCompleter {

    private static final TextColor MESSAGE_COLOR = TextColor.color(0x37BFF8);
    private static final String DISCORD_URL = "https://discord.gg/examplesmp";

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        }

        player.sendActionBar(noItalic(
                Component.text("The link has been sent in chat!", TextColor.color(0xA8A8A8))
        ));

        player.sendMessage(Component.empty());

        player.sendMessage(noItalic(Component.text(
                "ᴊᴏɪɴ ᴛʜᴇ ᴇxᴀᴍᴘʟᴇꜱᴍᴘ ᴅɪꜱᴄᴏʀᴅ ᴄᴏᴍᴍᴜɴɪᴛʏ!",
                MESSAGE_COLOR
        )));

        Component link = Component.text("● ", MESSAGE_COLOR)
                .append(noItalic(Component.text("discord.gg/examplesmp", NamedTextColor.WHITE)
                        .decorate(TextDecoration.UNDERLINED)
                        .clickEvent(ClickEvent.openUrl(DISCORD_URL))));

        player.sendMessage(link);
        player.sendMessage(Component.empty());

        player.playSound(
                player.getLocation(),
                Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
                1.0f,
                1.0f
        );

        return true;
    }

    private Component noItalic(Component component) {
        return component.decoration(TextDecoration.ITALIC, false);
    }

    @Override
    public List<String> onTabComplete(
            CommandSender sender,
            Command command,
            String alias,
            String[] args
    ) {
        return List.of();
    }
}