package fodastico.user.Apis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class StaffOnlineAPI
{
    public static HashMap<Player, String> isOnline;
    
    static {
        StaffOnlineAPI.isOnline = new HashMap<Player, String>();
    }
    
    public static void putStaffOnline(final Player p) {
        if (p.hasPermission("rank.staff")) {
            StaffOnlineAPI.isOnline.put(p, p.getName());
        }
    }
    
    public static void removeStaffOnline(final Player p) {
        if (StaffOnlineAPI.isOnline.containsKey(p)) {
            StaffOnlineAPI.isOnline.remove(p);
        }
    }
    
    public static void getStaffsOnline(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (StaffOnlineAPI.isOnline.containsKey(todos)) {
                p.sendMessage("§b§lSTAFF §fO §d§lSTAFFER §a" + StaffOnlineAPI.isOnline.get(todos) + " §fest\u00e1 online!");
                p.sendMessage(" ");
            }
        }
    }
}
