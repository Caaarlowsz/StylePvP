package fodastico.user.PerderKillStreak;

import org.bukkit.Bukkit;
import fodastico.user.Apis.TopKsAPI;
import org.bukkit.entity.Player;

public class LostKillStreak
{
    public static void lostKillStreak(final Player p, final Player k) {
        if (TopKsAPI.getStreak(p) >= 10) {
            Bukkit.getServer().broadcastMessage("§4§lKILLSTREAK §1§l" + p.getName() + " §fperdeu seu §6§lKILLSTREAK DE " + TopKsAPI.getStreak(p) + " PARA §c§l" + k.getName());
        }
    }
}
