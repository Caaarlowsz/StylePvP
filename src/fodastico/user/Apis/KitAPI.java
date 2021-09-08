package fodastico.user.Apis;

import org.bukkit.GameMode;
import fodastico.user.Commands.Build;
import fodastico.user.Warp.WarpsManager;
import java.util.Random;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import fodastico.user.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class KitAPI implements Listener
{
    public static HashMap<String, String> pKit;
    public static HashMap<Player, Long> noscape;
    public static ArrayList<String> emprotecao;
    public static HashMap<String, Location> oldl;
    
    static {
        KitAPI.pKit = new HashMap<String, String>();
        KitAPI.noscape = new HashMap<Player, Long>();
        KitAPI.emprotecao = new ArrayList<String>();
        KitAPI.oldl = new HashMap<String, Location>();
    }
    
    public static boolean getSimpleKitCooldown(final Player p) {
        return KitAPI.noscape.containsKey(p);
    }
    
    public static void removeSimpleKitCooldown(final Player p) {
        KitAPI.noscape.remove(p);
    }
    
    public static void addSimpleCooldownKit(final Player p, final int seconds) {
        final long cooldownLength = System.currentTimeMillis() + seconds * 1000;
        KitAPI.noscape.remove(p);
        KitAPI.noscape.put(p, cooldownLength);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                KitAPI.noscape.remove(p);
            }
        }, (long)(seconds * 20));
    }
    
    public static long getSimpleCooldownKitLeft(final Player p) {
        final long cooldownLength = KitAPI.noscape.get(p);
        final long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
        return left;
    }
    
    public static void setKit(final Player p, final String kit) {
        KitAPI.pKit.put(p.getName(), kit);
    }
    
    public static String getkit(final Player p) {
        return KitAPI.pKit.containsKey(p.getName()) ? KitAPI.pKit.get(p.getName()) : "Nenhum";
    }
    
    public static void RemoveKit(final Player p) {
        KitAPI.pKit.remove(p.getName());
    }
    
    public static void setDefaultItens(final Player p) {
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        p.getInventory().setItem(0, APIs.criarItem(p, Material.DIAMOND_SWORD, ChatColor.YELLOW + "Espada", new String[1], 1, (short)0));
        p.getInventory().setItem(15, APIs.criarItem(p, Material.BROWN_MUSHROOM, ChatColor.YELLOW + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(14, APIs.criarItem(p, Material.RED_MUSHROOM, ChatColor.RED + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(13, APIs.criarItem(p, Material.BOWL, ChatColor.GRAY + "Pote", new String[1], 64, (short)0));
        for (int i = 1; i < 35; ++i) {
            p.getInventory().addItem(new ItemStack[] { APIs.criarItem(p, Material.MUSHROOM_SOUP, ChatColor.GREEN + "Sopa", new String[1], 1, (short)0) });
        }
        getRandomArena(p);
    }
    
    public static void setGladItens(final Player p) {
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        final ItemStack espadapvp = new ItemStack(Material.DIAMOND_SWORD);
        final ItemMeta espadapvpmeta = espadapvp.getItemMeta();
        espadapvpmeta.setDisplayName("§eEspada");
        espadapvp.setItemMeta(espadapvpmeta);
        espadapvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        p.getInventory().setItem(0, espadapvp);
        p.getInventory().setItem(1, APIs.criarItem(p, Material.COBBLE_WALL, ChatColor.WHITE + "CobbleWall", new String[1], 64, (short)0));
        p.getInventory().setItem(9, APIs.criarItem(p, Material.IRON_HELMET, ChatColor.WHITE + "Iron Helmet", new String[1], 64, (short)0));
        p.getInventory().setItem(10, APIs.criarItem(p, Material.IRON_CHESTPLATE, ChatColor.WHITE + "Iron Chest", new String[1], 64, (short)0));
        p.getInventory().setItem(11, APIs.criarItem(p, Material.IRON_LEGGINGS, ChatColor.WHITE + "Iron Leggings", new String[1], 64, (short)0));
        p.getInventory().setItem(12, APIs.criarItem(p, Material.IRON_BOOTS, ChatColor.WHITE + "Ion Boots", new String[1], 64, (short)0));
        p.getInventory().setItem(18, APIs.criarItem(p, Material.IRON_HELMET, ChatColor.WHITE + "Iron Helmet", new String[1], 64, (short)0));
        p.getInventory().setItem(19, APIs.criarItem(p, Material.IRON_CHESTPLATE, ChatColor.WHITE + "Iron Chest", new String[1], 64, (short)0));
        p.getInventory().setItem(20, APIs.criarItem(p, Material.IRON_LEGGINGS, ChatColor.WHITE + "Iron Leggings", new String[1], 64, (short)0));
        p.getInventory().setItem(21, APIs.criarItem(p, Material.IRON_BOOTS, ChatColor.WHITE + "Ion Boots", new String[1], 64, (short)0));
        p.getInventory().setItem(15, APIs.criarItem(p, Material.COCOA, ChatColor.WHITE + "Cocoa Bean", new String[1], 64, (short)0));
        p.getInventory().setItem(14, APIs.criarItem(p, Material.COCOA, ChatColor.WHITE + "Cocoa Bean", new String[1], 64, (short)0));
        p.getInventory().setItem(13, APIs.criarItem(p, Material.BOWL, ChatColor.WHITE + "Pote", new String[1], 64, (short)0));
        p.getInventory().setItem(22, APIs.criarItem(p, Material.BOWL, ChatColor.WHITE + "Pote", new String[1], 64, (short)0));
        p.getInventory().setItem(23, APIs.criarItem(p, Material.COCOA, ChatColor.WHITE + "Cocoa Bean", new String[1], 64, (short)0));
        p.getInventory().setItem(24, APIs.criarItem(p, Material.COCOA, ChatColor.WHITE + "Cocoa Bean", new String[1], 64, (short)0));
        p.getInventory().setItem(27, APIs.criarItem(p, Material.LOG, ChatColor.WHITE + "Iron Helmet", new String[1], 64, (short)1));
        p.getInventory().setItem(17, APIs.criarItem(p, Material.COBBLE_WALL, ChatColor.WHITE + "CobbleWall", new String[1], 64, (short)0));
    }
    
    public static void setNoArmorDefaultItens(final Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(15, APIs.criarItem(p, Material.BROWN_MUSHROOM, ChatColor.YELLOW + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(14, APIs.criarItem(p, Material.RED_MUSHROOM, ChatColor.RED + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(13, APIs.criarItem(p, Material.BOWL, ChatColor.GRAY + "Pote", new String[1], 64, (short)0));
        for (int i = 1; i < 35; ++i) {
            p.getInventory().addItem(new ItemStack[] { APIs.criarItem(p, Material.MUSHROOM_SOUP, ChatColor.GREEN + "Sopa", new String[1], 1, (short)0) });
        }
    }
    
    public static void setChallengeItens(final Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(15, APIs.criarItem(p, Material.BROWN_MUSHROOM, ChatColor.YELLOW + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(14, APIs.criarItem(p, Material.RED_MUSHROOM, ChatColor.RED + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(13, APIs.criarItem(p, Material.BOWL, ChatColor.GRAY + "Pote", new String[1], 64, (short)0));
        for (int i = 1; i < 35; ++i) {
            p.getInventory().addItem(new ItemStack[] { APIs.criarItem(p, Material.MUSHROOM_SOUP, ChatColor.GREEN + "Sopa", new String[1], 1, (short)0) });
        }
    }
    
    public static void setFpsItens(final Player p) {
        p.getInventory().clear();
        final ItemStack espadapvp = new ItemStack(Material.DIAMOND_SWORD);
        final ItemMeta espadapvpmeta = espadapvp.getItemMeta();
        espadapvpmeta.setDisplayName("§eEspada");
        espadapvp.setItemMeta(espadapvpmeta);
        espadapvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        p.getInventory().setItem(0, espadapvp);
        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        p.getInventory().setItem(15, APIs.criarItem(p, Material.BROWN_MUSHROOM, ChatColor.YELLOW + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(14, APIs.criarItem(p, Material.RED_MUSHROOM, ChatColor.RED + "Cogumelo", new String[1], 64, (short)0));
        p.getInventory().setItem(13, APIs.criarItem(p, Material.BOWL, ChatColor.GRAY + "Pote", new String[1], 64, (short)0));
        for (int i = 1; i < 35; ++i) {
            p.getInventory().addItem(new ItemStack[] { APIs.criarItem(p, Material.MUSHROOM_SOUP, ChatColor.GREEN + "Sopa", new String[1], 1, (short)0) });
        }
    }
    
    public static void setPotItens(final Player p) {
        p.getInventory().clear();
        final ItemStack espadapvp = new ItemStack(Material.DIAMOND_SWORD);
        final ItemMeta espadapvpmeta = espadapvp.getItemMeta();
        espadapvpmeta.setDisplayName("§eEspada");
        espadapvp.setItemMeta(espadapvpmeta);
        espadapvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        p.getInventory().setItem(0, espadapvp);
        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        for (int i = 1; i < 36; ++i) {
            p.getInventory().addItem(new ItemStack[] { APIs.criarItem(p, Material.POTION, ChatColor.GREEN + "Vida", new String[1], 1, (short)16389) });
        }
        getRandomArena(p);
    }
    
    public static void getRandomArena(final Player p) {
        final Random dice = new Random();
        final int number = dice.nextInt(4);
        switch (number) {
            case 1: {
                WarpsManager.Ir(p, "Arena1");
                break;
            }
            case 2: {
                WarpsManager.Ir(p, "Arena2");
                break;
            }
            case 3: {
                WarpsManager.Ir(p, "Arena3");
                break;
            }
        }
    }
    
    public static void sendSpawn(final Player p) {
        WarpsManager.Ir(p, "Spawn");
        ImortalAPI.setInvensibility(p);
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.getInventory().setItem(0, APIs.criarItem(p, Material.CHEST, ChatColor.YELLOW + "§lKITS", new String[1], 1, (short)0));
        p.getInventory().setItem(1, APIs.criarItem(p, Material.COMPASS, ChatColor.YELLOW + "§lWARPS", new String[1], 1, (short)0));
        p.getInventory().setItem(4, APIs.criarItem(p, Material.BOOK, ChatColor.YELLOW + "§lESTATISTICAS", new String[1], 1, (short)0));
        p.getInventory().setItem(8, APIs.criarItem(p, Material.EMERALD, ChatColor.YELLOW + "§lSHOP", new String[1], 1, (short)0));
        setKit(p, "Spawn");
        Build.Build.put(p.getName(), Build.BuilderMode.FALSE);
        p.setLevel(0);
        p.setGameMode(GameMode.ADVENTURE);
        p.setAllowFlight(false);
        p.setFlying(false);
        KitAPI.oldl.put(p.getName(), p.getLocation());
    }
}
