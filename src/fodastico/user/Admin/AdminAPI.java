package fodastico.user.Admin;

import java.util.UUID;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class AdminAPI
{
    public static ArrayList<Player> isPlaying;
    public static ArrayList<Player> autoSoupChecking;
    public static ArrayList<Player> inAdmin;
    
    static {
        AdminAPI.isPlaying = new ArrayList<Player>();
        AdminAPI.autoSoupChecking = new ArrayList<Player>();
        AdminAPI.inAdmin = new ArrayList<Player>();
    }
    
    public static boolean getAdminUUID(final UUID uuid) {
        return true;
    }
    
    public static boolean isInAdmin(final Player p) {
        return AdminAPI.inAdmin.contains(p);
    }
    
    public static boolean isPlaying(final Player p) {
        return AdminAPI.isPlaying.contains(p);
    }
    
    public static boolean isOffline(final Player p) {
        return !p.isOnline();
    }
}
