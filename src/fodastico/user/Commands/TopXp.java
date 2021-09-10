package fodastico.user.Commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fodastico.user.Apis.XpAPI;

public class TopXp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] Args) {
		if (cmd.getName().equalsIgnoreCase("topxp")) {
			final HashMap<String, Integer> players = new HashMap<String, Integer>();
			for (final String playerName : XpAPI.Xp.getKeys(false)) {
				players.put(playerName, XpAPI.Xp.getInt(playerName));
			}
			sender.sendMessage("§6§l TOP §7§l(§f§l10§7§l) §a§lXP!");
			String nextTop = "None";
			Integer nextTopXps = 0;
			for (int i = 1; i < 11; ++i) {
				for (final String playerName2 : players.keySet()) {
					if (players.get(playerName2) > nextTopXps) {
						nextTop = playerName2;
						nextTopXps = players.get(playerName2);
					}
				}
				sender.sendMessage("§3" + i + "° §a§o" + nextTop + " §f- §a§l§o" + nextTopXps);
				players.remove(nextTop);
				nextTop = "None";
				nextTopXps = 0;
			}
		}
		return false;
	}
}
