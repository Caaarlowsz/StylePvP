package fodastico.user.Managers;

import fodastico.user.Main;
import org.bukkit.Bukkit;
import java.util.concurrent.TimeUnit;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class CooldownAPI
{
    public static HashMap<String, Long> pCooldown;
    
    static {
        CooldownAPI.pCooldown = new HashMap<String, Long>();
    }
    
    public static void addCooldown(final Player p, final int tempo) {
        if (CooldownAPI.pCooldown.containsKey(p.getName())) {
            CooldownAPI.pCooldown.remove(p.getName());
        }
        CooldownAPI.pCooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(tempo));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                CooldownAPI.removeCooldown(p);
            }
        }, (long)(tempo * 20));
    }
    
    public static void addCooldown(final String string, final int tempo) {
        if (CooldownAPI.pCooldown.containsKey(string)) {
            CooldownAPI.pCooldown.remove(string);
        }
        CooldownAPI.pCooldown.put(string, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(tempo));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                CooldownAPI.removeCooldown(string);
            }
        }, (long)(tempo * 20));
    }
    
    public static void removeCooldown(final String string) {
        if (CooldownAPI.pCooldown.containsKey(string)) {
            CooldownAPI.pCooldown.remove(string);
        }
    }
    
    public static void removeCooldown(final Player p) {
        if (CooldownAPI.pCooldown.containsKey(p.getName())) {
            CooldownAPI.pCooldown.remove(p.getName());
        }
    }
    
    public static boolean checkCooldown(final Player p) {
        return !CooldownAPI.pCooldown.containsKey(p.getName()) || CooldownAPI.pCooldown.get(p.getName()) <= System.currentTimeMillis();
    }
    
    public static long getCooldown(final Player p) {
        final long tempo = TimeUnit.MILLISECONDS.toSeconds(CooldownAPI.pCooldown.get(p.getName()) - System.currentTimeMillis());
        if (CooldownAPI.pCooldown.containsKey(p.getName()) || CooldownAPI.pCooldown.get(p.getName()) > System.currentTimeMillis()) {
            return tempo;
        }
        return 0L;
    }
    
    public static long getCooldown(final String string) {
        final long tempo = TimeUnit.MILLISECONDS.toSeconds(CooldownAPI.pCooldown.get(string) - System.currentTimeMillis());
        if (CooldownAPI.pCooldown.containsKey(string) || CooldownAPI.pCooldown.get(string) > System.currentTimeMillis()) {
            return tempo;
        }
        return 0L;
    }
}
