package fodastico.user.Apis;

import org.bukkit.entity.Player;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import fodastico.user.Main;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class MoneyAPI
{
    public static File Moneys;
    public static FileConfiguration Money;
    
    public static void createFile1() {
        MoneyAPI.Moneys = new File("plugins/" + Main.plugin.getDataFolder().getName() + "/Money.yml");
        MoneyAPI.Money = (FileConfiguration)YamlConfiguration.loadConfiguration(MoneyAPI.Moneys);
        saveMoney();
    }
    
    public static void saveMoney() {
        try {
            MoneyAPI.Money.save(MoneyAPI.Moneys);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int getMoney(final Player p) {
        return MoneyAPI.Money.getInt(p.getName());
    }
    
    public static void addMoney(final Player p, final int Qntd) {
        MoneyAPI.Money.set(p.getName(), (Object)(getMoney(p) + Qntd));
        saveMoney();
    }
    
    public static void removeMoney(final Player p, final int Qntd) {
        MoneyAPI.Money.set(p.getName(), (Object)(getMoney(p) - Qntd));
        saveMoney();
    }
}
