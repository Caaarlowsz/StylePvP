package fodastico.user.Commands;

import fodastico.user.Events.SubEventos;
import fodastico.user.Main;
import org.bukkit.Bukkit;
import fodastico.user.Managers.TimeAPI;
import fodastico.user.DoubleXp.BDoubleXpsAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;

public class Doublexp implements CommandExecutor
{
    public static ArrayList<String> doublexp;
    public static ArrayList<String> ondoublexp;
    public static ArrayList<String> delaydoublexp;
    
    static {
        Doublexp.doublexp = new ArrayList<String>();
        Doublexp.ondoublexp = new ArrayList<String>();
        Doublexp.delaydoublexp = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("doublexp")) {
            if (!p.hasPermission("kitpvp.doublexp")) {
                p.sendMessage("§c§lPERMISSAO §fVoc\u00ea n\u00e3o possui §c§lPERMISSAO §fpara executar este §b§lCOMANDO§f!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§9§lDOUBLEXP §fUtilize: /doublexp <usar>");
                p.sendMessage("§9§lDOUBLEXP §fSeus §b§lDOUBLEXP´s §f- §3§l" + BDoubleXpsAPI.getDoubleXps(p));
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("usar")) {
                    if (Doublexp.ondoublexp.contains(p.getName())) {
                        p.sendMessage("§9§lDOUBLEXP §fVoc\u00ea j\u00e1 possui um §b§lDOUBLEXP §fatualmente em §a§lUSO§f!");
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("usar")) {
                        if (Doublexp.delaydoublexp.contains(p.getName())) {
                            p.sendMessage("§9§lDOUBLEXP §fVoc\u00ea est\u00e1 em §c§lCOOLDOWN §fpara §a§lUSAR §fum §b§lDOUBLEXP§f! O §c§lCOOLDOWN §fir\u00e1 §c§lACABAR§b");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("usar")) {
                            if (BDoubleXpsAPI.getDoubleXps(p) <= 0) {
                                p.sendMessage("§9§lDOUBLEXP §fVoc\u00ea n\u00e3o §e§lPOSSUI §fnenhum §b§lDOUBLEXP §fpara §a§lUSAR§f!");
                                return true;
                            }
                            TimeAPI.addTempo(p.getName(), 1, 0, 0);
                            p.sendMessage("§9§lDOUBLEXP §fVoc\u00ea agora est\u00e1 §a§lUSANDO §fum §b§lDOUBLEXP§f! Ele ir\u00e1 §c§lACABAR§b");
                            BDoubleXpsAPI.removeDoubleXps(p, 1);
                            Doublexp.ondoublexp.add(p.getName());
                            Doublexp.doublexp.add(p.getName());
                            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    Doublexp.doublexp.remove(p.getName());
                                    Doublexp.ondoublexp.remove(p.getName());
                                    TimeAPI.removeTempo(p.getName());
                                    TimeAPI.addTempo(p.getName(), 3, 0, 0);
                                    Doublexp.delaydoublexp.add(p.getName());
                                    SubEventos.removeCooldownXp(p);
                                }
                            }, 72000L);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
