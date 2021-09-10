package fodastico.user.PerderKillStreak;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fodastico.user.Apis.TopKsAPI;

public class LostKillStreak {
	public static void lostKillStreak(final Player p, final Player k) {
		if (TopKsAPI.getStreak(p) >= 10) {
			Bukkit.getServer().broadcastMessage("§4§lKILLSTREAK §1§l" + p.getName() + " §fperdeu seu §6§lKILLSTREAK DE "
					+ TopKsAPI.getStreak(p) + " PARA §c§l" + k.getName());
		}
	}
}
