package fodastico.user.Apis;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class DeathAPI {
	public static File Deaths;
	public static FileConfiguration Death;

	public static void createFile1() {
		DeathAPI.Deaths = new File("plugins/" + StylePvP.plugin.getDataFolder().getName() + "/Deaths.yml");
		DeathAPI.Death = (FileConfiguration) YamlConfiguration.loadConfiguration(DeathAPI.Deaths);
		saveDeath();
	}

	public static void saveDeath() {
		try {
			DeathAPI.Death.save(DeathAPI.Deaths);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createDeathAcc(final Player p) {
		if (!DeathAPI.Death.contains(p.getName())) {
			DeathAPI.Death.set(p.getName(), (Object) 0);
			saveDeath();
		}
	}

	public static int getDeath(final Player p) {
		return DeathAPI.Death.getInt(p.getName());
	}

	public static void addDeath(final Player p, final int Qntd) {
		DeathAPI.Death.set(p.getName(), (Object) (getDeath(p) + Qntd));
		saveDeath();
	}

	public static void removeDeath(final Player p, final int Qntd) {
		DeathAPI.Death.set(p.getName(), (Object) (getDeath(p) - Qntd));
		saveDeath();
	}
}
