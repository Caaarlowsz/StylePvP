package fodastico.user.Managers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class ListenerManager {
	public static void onEventsLoad() {
		for (final Class<?> Classes : ClassGetter.getClassesForPackage(StylePvP.getPlugin(StylePvP.class),
				"fodastico.user.Events")) {
			try {
				if (!Listener.class.isAssignableFrom(Classes)) {
					continue;
				}
				final Listener listener = (Listener) Classes.newInstance();
				Bukkit.getPluginManager().registerEvents(listener, (Plugin) StylePvP.getPlugin(StylePvP.class));
				Bukkit.getConsoleSender().sendMessage("�e�lEVENTO �fO �e�lEVENTO �7(�e"
						+ listener.getClass().getSimpleName() + "�ffoi carregado com sucesso!");
			} catch (Exception ex) {
			}
		}
	}
}
