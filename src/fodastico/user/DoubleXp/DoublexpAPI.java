package fodastico.user.DoubleXp;

import org.bukkit.entity.Player;

import fodastico.user.Apis.XpAPI;
import fodastico.user.Commands.Doublexp;

public class DoublexpAPI {
	public static void addXps(final Player p, final int Qntd) {
		if (Doublexp.doublexp.contains(p.getName())) {
			XpAPI.addXp(p, 2 * Qntd);
			p.sendMessage("§a§lXP §fVoc\u00ea recebeu §a§l" + 2 * Qntd + " §fde §2§lXP´s §7(Doublexp)");
			return;
		}
		XpAPI.addXp(p, Qntd);
		p.sendMessage("§a§lXP §fVoc\u00ea recebeu §a§l" + Qntd + " §fde §2§lXP´s");
	}
}
