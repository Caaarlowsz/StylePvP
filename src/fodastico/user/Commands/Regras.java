package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class Regras implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender p, final Command cmd, final String string, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("regras")) {
			p.sendMessage(" ");
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-1").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-2").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-3").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-4").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-5").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-6").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-7").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-8").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-9").replace("&", "�"));
			p.sendMessage(StylePvP.getInstance().getConfig().getString("MSG-REGRAS-10").replace("&", "�"));
			p.sendMessage(" ");
			return true;
		}
		return false;
	}
}
