package fodastico.user.DoubleXp;

import org.bukkit.entity.Player;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import fodastico.user.Main;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class BDoubleXpsAPI
{
    public static File Doublexps;
    public static FileConfiguration Doublexp;
    
    public static void createFile1() {
        BDoubleXpsAPI.Doublexps = new File("plugins/" + Main.plugin.getDataFolder().getName() + "/BDoubleXps.yml");
        BDoubleXpsAPI.Doublexp = (FileConfiguration)YamlConfiguration.loadConfiguration(BDoubleXpsAPI.Doublexps);
        saveDoubleXps();
    }
    
    public static void saveDoubleXps() {
        try {
            BDoubleXpsAPI.Doublexp.save(BDoubleXpsAPI.Doublexps);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void createDoubleXpsAcc(final Player p) {
        if (!BDoubleXpsAPI.Doublexp.contains(p.getName())) {
            BDoubleXpsAPI.Doublexp.set(p.getName(), (Object)0);
            saveDoubleXps();
        }
    }
    
    public static int getDoubleXps(final Player p) {
        return BDoubleXpsAPI.Doublexp.getInt(p.getName());
    }
    
    public static void addDoubleXps(final Player p, final int Qntd) {
        BDoubleXpsAPI.Doublexp.set(p.getName(), (Object)(getDoubleXps(p) + Qntd));
        saveDoubleXps();
    }
    
    public static void removeDoubleXps(final Player p, final int Qntd) {
        BDoubleXpsAPI.Doublexp.set(p.getName(), (Object)(getDoubleXps(p) - Qntd));
        saveDoubleXps();
    }
}
