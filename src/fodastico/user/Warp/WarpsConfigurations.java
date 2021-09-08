package fodastico.user.Warp;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import org.bukkit.plugin.Plugin;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

public class WarpsConfigurations
{
    public static WarpsConfigurations folder;
    FileConfiguration Warps;
    File FileWarps;
    
    static {
        WarpsConfigurations.folder = new WarpsConfigurations();
    }
    
    public static WarpsConfigurations getConfig() {
        return WarpsConfigurations.folder;
    }
    
    public void createYMLFil(final Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        this.FileWarps = new File(plugin.getDataFolder(), "warps.yml");
        if (this.FileWarps.exists()) {
            try {
                this.FileWarps.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.Warps = (FileConfiguration)YamlConfiguration.loadConfiguration(this.FileWarps);
    }
    
    public FileConfiguration config() {
        return this.Warps;
    }
    
    public void saveAllWarps() {
        try {
            this.Warps.save(this.FileWarps);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public class Warps
    {
    }
}
