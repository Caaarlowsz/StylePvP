package fodastico.user.Commands;

import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import fodastico.user.Apis.BuildScoreAPI;
import fodastico.user.Apis.APIs;
import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Admin.AdminAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Admin implements CommandExecutor, Listener
{
    public static HashMap<String, String> salvarkit;
    public static HashMap<String, ItemStack[]> salvarinventario;
    public static HashMap<String, ItemStack[]> salvarinventarioarmaduras;
    
    static {
        Admin.salvarkit = new HashMap<String, String>();
        Admin.salvarinventario = new HashMap<String, ItemStack[]>();
        Admin.salvarinventarioarmaduras = new HashMap<String, ItemStack[]>();
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("admin")) {
            if (!p.hasPermission("kitpvp.admin")) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
                return true;
            }
            if (!AdminAPI.inAdmin.contains(p)) {
                AdminAPI.inAdmin.add(p);
                Admin.salvarkit.put(p.getName(), KitAPI.getkit(p));
                Admin.salvarinventario.put(p.getName(), p.getInventory().getContents());
                Admin.salvarinventarioarmaduras.put(p.getName(), p.getInventory().getArmorContents());
                p.getInventory().clear();
                p.getInventory().setArmorContents((ItemStack[])null);
                final ItemStack Item = new ItemStack(Material.STICK);
                final ItemMeta kItem = Item.getItemMeta();
                kItem.addEnchant(Enchantment.KNOCKBACK, 5, true);
                kItem.setDisplayName("§aKnockBack 5");
                Item.setItemMeta(kItem);
                KitAPI.setKit(p, "Admin");
                p.sendMessage("§c§lADMIN §fVoc\u00ea §a§lENTROU §fno modo §c§lADMIN");
                p.sendMessage("§6§lVANISH §fVoc\u00ea est\u00e1 §e§lINVIS\u00cdVEL §fpara jogadores normais.");
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().setItem(1, Item);
                p.getInventory().setItem(2, APIs.criarItem(p, Material.NETHER_FENCE, "§cTest Forcefield/KillAura", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(3, APIs.criarItem(p, Material.getMaterial(351), "§cFast Admin", new String[] { "" }, 1, (short)8));
                p.getInventory().setItem(4, APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cTest Auto-Soup", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(5, APIs.criarItem(p, Material.BEDROCK, "§cCage", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(6, APIs.criarItem(p, Material.IRON_FENCE, "§cScreenshare", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(7, APIs.criarItem(p, Material.PAPER, "§cInforma\u00e7\u00f5es do Jogador", new String[] { "" }, 1, (short)0));
                BuildScoreAPI.forceBuild(p);
                setAdmin(p);
                AdminAPI.isPlaying.remove(p);
                return true;
            }
            if (AdminAPI.inAdmin.contains(p)) {
                AdminAPI.inAdmin.remove(p);
                p.sendMessage("§c§lADMIN §fVoc\u00ea §c§lSAIU §fdo modo §c§lADMIN");
                p.sendMessage("§6§lVANISH §fVoc\u00ea est\u00e1 §e§lVIS\u00cdVEL §fpara jogadores normais.");
                outAdmin(p);
                KitAPI.RemoveKit(p);
                p.getInventory().clear();
                p.getInventory().setArmorContents((ItemStack[])null);
                p.updateInventory();
                p.setGameMode(GameMode.ADVENTURE);
                p.setAllowFlight(false);
                KitAPI.setKit(p, Admin.salvarkit.get(p.getName()));
                p.getInventory().setContents((ItemStack[])Admin.salvarinventario.get(p.getName()));
                p.getInventory().setArmorContents((ItemStack[])Admin.salvarinventarioarmaduras.get(p.getName()));
                AdminAPI.isPlaying.add(p);
                outAdmin(p);
                outAdmin(p);
                BuildScoreAPI.forceBuild(p);
            }
        }
        return false;
    }
    
    @EventHandler
    public static void outAdmin(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player pl = onlinePlayers[i];
            p.showPlayer(pl);
        }
    }
    
    public static void updateAdmin(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (p.hasPermission("kitpvp.admin") && AdminAPI.inAdmin.contains(todos)) {
                todos.showPlayer(p);
                p.showPlayer(todos);
            }
            else if (AdminAPI.inAdmin.contains(todos)) {
                p.hidePlayer(todos);
            }
        }
    }
    
    public static void setAdmin(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (todos.hasPermission("kitpvp.admin") && AdminAPI.inAdmin.contains(p)) {
                todos.showPlayer(p);
                p.showPlayer(todos);
            }
            else if (AdminAPI.inAdmin.contains(p)) {
                todos.hidePlayer(p);
            }
        }
    }
    
    public static void checarAdmin() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (AdminAPI.inAdmin.contains(todos)) {
                setAdmin(todos);
            }
        }
    }
}
