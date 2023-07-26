package dev.spaxter.curseguard.command;

import dev.spaxter.curseguard.core.Language;
import dev.spaxter.curseguard.models.Action;
import dev.spaxter.curseguard.storage.GlobalMemory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AddExemptWordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("curseguard.words.add")) {
            if (args.length != 1) {
                return false;
            }
            String word = args[0];
            if (GlobalMemory.wordActions.containsKey(word)) {
                commandSender.sendMessage(Language.Prefix.NOTIFICATION_PREFIX + Language.Notification.ADD_WORD_WORD_EXISTS.replace("%word%", word));
                return true;
            }
            commandSender.sendMessage(Language.Prefix.NOTIFICATION_PREFIX + Language.Notification.ADD_WORD_SUCCESS.replace("%word%", word));
        } else {
            commandSender.sendMessage(Language.Notification.PERMISSION_DENIED);
        }
        return true;
    }
}