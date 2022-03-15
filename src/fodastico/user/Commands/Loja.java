package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class Loja implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("loja")) {
			p.sendMessage(" ");
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-1").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-2").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-3").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-4").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-5").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-6").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-LOJA-7").replace("&", "�"));
			p.sendMessage(" ");
		}
		return false;
	}
}
