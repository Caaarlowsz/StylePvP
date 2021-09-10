package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Apis.KitAPI;
import fodastico.user.Events.KitEvents;

public class Kits implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (!(Sender instanceof Player)) {
			Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("kits") && KitAPI.getkit(p) != "Spawn") {
			p.sendMessage("§b§lKITS §fVoc\u00ea n\u00e3o pode abrir o menu de §b§lKITS §ffora do §9§lSPAWN§f!");
			return true;
		}
		if (KitAPI.getkit(p) == "Spawn") {
			KitEvents.onOpenInvKits(p);
		}
		return false;
	}
}
