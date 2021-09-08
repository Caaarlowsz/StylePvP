package fodastico.user.Commands;

import java.util.Iterator;
import fodastico.user.Apis.KillsAPI;
import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class TopKills implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("topkills")) {
            final HashMap<String, Integer> players = new HashMap<String, Integer>();
            for (final String playerName : KillsAPI.Kills.getKeys(false)) {
                players.put(playerName, KillsAPI.Kills.getInt(playerName));
            }
            sender.sendMessage("§6§l TOP §7§l(§f§l10§7§l) §6§lKILLS!");
            String nextTop = "None";
            Integer nextTopKills = 0;
            for (int i = 1; i < 11; ++i) {
                for (final String playerName2 : players.keySet()) {
                    if (players.get(playerName2) > nextTopKills) {
                        nextTop = playerName2;
                        nextTopKills = players.get(playerName2);
                    }
                }
                sender.sendMessage("§3" + i + "° §b§o" + nextTop + " §7- §b§l§o" + nextTopKills);
                players.remove(nextTop);
                nextTop = "None";
                nextTopKills = 0;
            }
        }
        return false;
    }
}
