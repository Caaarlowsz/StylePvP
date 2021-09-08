package fodastico.user.Warp;

import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class WarpsMenu
{
    public static void inventoryWarps(final Player p) {
        final Inventory menu = Bukkit.createInventory((InventoryHolder)p, 9, "§aWarps");
        menu.setItem(2, createMenuItem(Material.GLASS, "§3§lFPS", new String[] { "§fEsta §e§lWARP §ffoi feita para quem", "§fdar mais fps para tem um pc fraco" }));
        menu.setItem(1, createMenuItem(Material.BLAZE_ROD, "§b§l1v1", new String[] { "§fNesta §e§lWARP §fvoc\u00ea pode desafiar", "§fqualquer jogador para §b§l1v1 §fjusto!" }));
        menu.setItem(3, createMenuItem(Material.LAVA, "§c§lCHALLENGE", new String[] { "§fAqui, voc\u00ea pode treinar suas §9§lHABILIDADES", "§fem tomar sopa! (tankar, refil, recraft)" }));
        menu.setItem(0, createMenuItem(Material.COOKIE, "§5§lTEXTURA", new String[] { "§fAqui contem recursos [sopa espadas etc]", "§fpara voce analisar sua §5§lTEXTURA" }));
        menu.setItem(4, createMenuItem(Material.POTION, "§a§lPOTPVP", new String[] { "§fAqui tem §a§lPO\u00c7\u00d5ES", "§fque regeneram sua §a§lVIDA" }));
        p.openInventory(menu);
    }
    
    public static ItemStack createMenuItem(final Material material, final String nome, final String[] habilidade) {
        final ItemStack item = new ItemStack(material);
        final ItemMeta kitem = item.getItemMeta();
        kitem.setDisplayName(nome);
        kitem.setLore((List)Arrays.asList(habilidade));
        item.setItemMeta(kitem);
        return item;
    }
}
