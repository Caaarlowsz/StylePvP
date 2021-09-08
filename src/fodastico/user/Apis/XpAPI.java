package fodastico.user.Apis;

import org.bukkit.entity.Player;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import fodastico.user.Main;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class XpAPI
{
    public static File Xps;
    public static FileConfiguration Xp;
    
    public static void createFile1() {
        XpAPI.Xps = new File("plugins/" + Main.plugin.getDataFolder().getName() + "/Xp.yml");
        XpAPI.Xp = (FileConfiguration)YamlConfiguration.loadConfiguration(XpAPI.Xps);
        saveXp();
    }
    
    public static void saveXp() {
        try {
            XpAPI.Xp.save(XpAPI.Xps);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void createXpAcc(final Player p) {
        if (!XpAPI.Xp.contains(p.getName())) {
            XpAPI.Xp.set(p.getName(), (Object)0);
            saveXp();
        }
    }
    
    public static int getXp(final Player p) {
        return XpAPI.Xp.getInt(p.getName());
    }
    
    public static void addXp(final Player p, final int Qntd) {
        XpAPI.Xp.set(p.getName(), (Object)(getXp(p) + Qntd));
        saveXp();
    }
    
    public static void removeXp(final Player p, final int Qntd) {
        XpAPI.Xp.set(p.getName(), (Object)(getXp(p) - Qntd));
        saveXp();
    }
}
