package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Main;
import fodastico.user.Apis.KitAPI;

public class Spawn implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (!(Sender instanceof Player)) {
			Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("spawn")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.sendSpawn(p);
					p.sendMessage("§3§lSPAWN §fVoc\u00ea foi teleportado \u00e1o §9§lSPAWN");
					Main.sc.registerScoreBoard(p);
				}
			}, 0L);
		}
		return false;
	}
}
