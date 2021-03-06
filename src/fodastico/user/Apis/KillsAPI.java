package fodastico.user.Apis;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class KillsAPI {
	public static File Killss;
	public static FileConfiguration Kills;

	public static void createFile1() {
		KillsAPI.Killss = new File("plugins/" + StylePvP.plugin.getDataFolder().getName() + "/Kills.yml");
		KillsAPI.Kills = (FileConfiguration) YamlConfiguration.loadConfiguration(KillsAPI.Killss);
		saveKills();
	}

	public static void saveKills() {
		try {
			KillsAPI.Kills.save(KillsAPI.Killss);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createKillsAcc(final Player p) {
		if (!KillsAPI.Kills.contains(p.getName())) {
			KillsAPI.Kills.set(p.getName(), (Object) 0);
			saveKills();
		}
	}

	public static int getKills(final Player p) {
		return KillsAPI.Kills.getInt(p.getName());
	}

	public static void addKills(final Player p, final int Qntd) {
		KillsAPI.Kills.set(p.getName(), (Object) (getKills(p) + Qntd));
		saveKills();
	}

	public static void removeKills(final Player p, final int Qntd) {
		KillsAPI.Kills.set(p.getName(), (Object) (getKills(p) - Qntd));
		saveKills();
	}
}
