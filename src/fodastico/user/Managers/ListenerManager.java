package fodastico.user.Managers;

import java.util.Iterator;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import fodastico.user.Main;

public class ListenerManager
{
    public static void onEventsLoad() {
        for (final Class<?> Classes : ClassGetter.getClassesForPackage(Main.getPlugin((Class)Main.class), "fodastico.user.Events")) {
            try {
                if (!Listener.class.isAssignableFrom(Classes)) {
                    continue;
                }
                final Listener listener = (Listener)Classes.newInstance();
                Bukkit.getPluginManager().registerEvents(listener, (Plugin)Main.getPlugin((Class)Main.class));
                Bukkit.getConsoleSender().sendMessage("§e§lEVENTO §fO §e§lEVENTO §7(§e" + listener.getClass().getSimpleName() + "§ffoi carregado com sucesso!");
            }
            catch (Exception ex) {}
        }
    }
}
