package fodastico.user.Apis;

import org.bukkit.entity.Player;
import fodastico.user.Commands.Warp;
import org.bukkit.Bukkit;

public class EventoAPI
{
    public static boolean onEvent;
    public static boolean closeEvent;
    
    public static void quitEvent() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (Warp.inEvent.containsKey(todos.getName())) {
                todos.chat((String)Warp.inEvent.get(todos.getName()));
                Warp.inEvent.remove(todos.getName());
            }
        }
    }
    
    public static void removeEvent(final Player p) {
        if (Warp.inEvent.containsKey(p.getName())) {
            Warp.inEvent.remove(p.getName());
        }
    }
}
