package fodastico.user.Events;

import org.bukkit.event.entity.EntityDeathEvent;
import java.util.HashSet;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.util.Iterator;
import org.bukkit.event.entity.EntityDamageEvent;
import java.util.Random;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.EventPriority;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import fodastico.user.Apis.APIs;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Snowball;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.Effect;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.util.Vector;
import fodastico.user.Managers.CooldownAPI;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Material;
import fodastico.user.Apis.KitAPI;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.block.Block;
import org.bukkit.Location;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.ArrayList;
import fodastico.user.Main;
import org.bukkit.event.Listener;

public class Kits implements Listener
{
    public static Main plugin;
    static ArrayList<String> potato;
    public static HashMap<String, ItemStack[]> salvararmor;
    public static ArrayList<String> emphantom;
    public long cooldownLenght;
    public static ArrayList<Player> cooldownm;
    ArrayList<String> timer;
    ArrayList<String> noescape;
    public HashMap<Player, Player> a;
    public HashMap<Player, Long> b;
    public static List<Player> cooldownbk;
    public boolean sendThroughInventory;
    public static HashMap<String, ItemStack[]> salvarinventarioglad;
    public static HashMap<String, ItemStack[]> salvarinventarioarmadurasglad;
    public boolean generateGlass;
    public static ArrayList<Player> noExecut;
    public static ArrayList<Player> semdelay;
    public static HashMap<String, Location> oldl;
    public static ArrayList<String> delaycooldown;
    public static ArrayList<String> incombofly;
    public static HashMap<String, String> fighting;
    public static HashMap<String, String> fightingtrap;
    public HashMap<Integer, ArrayList<Location>> blocks;
    public static HashMap<Player, Location> localizacao;
    public static HashMap<Location, Block> bloco;
    public HashMap<Integer, String[]> players;
    public HashMap<String, Integer> tasks;
    int nextID;
    public static int id1;
    public static int id2;
    
    static {
        Kits.potato = new ArrayList<String>();
        Kits.cooldownm = new ArrayList<Player>();
        Kits.cooldownbk = new ArrayList<Player>();
        Kits.salvarinventarioglad = new HashMap<String, ItemStack[]>();
        Kits.salvarinventarioarmadurasglad = new HashMap<String, ItemStack[]>();
        Kits.noExecut = new ArrayList<Player>();
        Kits.semdelay = new ArrayList<Player>();
        Kits.oldl = new HashMap<String, Location>();
        Kits.fighting = new HashMap<String, String>();
        Kits.fightingtrap = new HashMap<String, String>();
        Kits.localizacao = new HashMap<Player, Location>();
        Kits.bloco = new HashMap<Location, Block>();
    }
    
    public Kits() {
        Kits.salvararmor = new HashMap<String, ItemStack[]>();
        Kits.emphantom = new ArrayList<String>();
        this.cooldownLenght = 0L;
        this.timer = new ArrayList<String>();
        this.noescape = new ArrayList<String>();
        this.a = new HashMap<Player, Player>();
        this.b = new HashMap<Player, Long>();
        this.sendThroughInventory = true;
        this.generateGlass = true;
        Kits.delaycooldown = new ArrayList<String>();
        Kits.incombofly = new ArrayList<String>();
        this.blocks = new HashMap<Integer, ArrayList<Location>>();
        this.players = new HashMap<Integer, String[]>();
        this.tasks = new HashMap<String, Integer>();
        this.nextID = 0;
    }
    
    @EventHandler
    public void aoPoseidon(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (KitAPI.getkit(p) == "Poseidon" && (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
        }
    }
    
    @EventHandler
    public void onPlayerInteract1(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Sniper" && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInHand().getType() == Material.BONE) {
            if (CooldownAPI.pCooldown.containsKey(p.getName())) {
                p.sendMessage("§3§lSNIPER §fVoc\u00ea ainda est\u00e1 em §c§lCOOLDOWN §fde §c§l" + CooldownAPI.getCooldown(p) + "s");
                return;
            }
            final Vector velo2 = p.getLocation().getDirection().normalize().multiply(100);
            velo2.add(new Vector(Math.random() * 0.0 - 0.0, 0.0, 0.0));
            CooldownAPI.addCooldown(p, 30);
            ((Arrow)p.launchProjectile((Class)Arrow.class)).setVelocity(velo2);
        }
    }
    
    @EventHandler
    public void onSniperShoot(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            final Arrow s = (Arrow)e.getDamager();
            final Player damaged = (Player)e.getEntity();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (KitAPI.getkit(shooter) == "Sniper") {
                    e.setDamage(8.0);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_WIRE);
                    damaged.getEyeLocation().getWorld().playEffect(damaged.getLocation(), Effect.BOW_FIRE, 50000, 10000);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.BLAZE_SHOOT, 10000, 10000);
                }
            }
        }
    }
    
    @EventHandler
    public void onPutPOTATO(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player k = (Player)e.getRightClicked();
            if (p.getItemInHand().getType().equals((Object)Material.TNT) && KitAPI.getkit(p) == "HotPotato") {
                if (Gladiator.fighting.containsKey(p.getName())) {
                    p.sendMessage("§3§lHOTPOTATO §fVoc\u00ea n\u00e3o pode usar este §b§lKIT no §9§lGLADIATOR");
                }
                else {
                    if (CooldownAPI.pCooldown.containsKey(p.getName())) {
                        p.sendMessage("§3§lHOTPOTATO §fVoc\u00ea ainda est\u00e1 em §c§lCOOLDOWN §fde §c§l" + CooldownAPI.getCooldown(p) + "s");
                        return;
                    }
                    KitAPI.addSimpleCooldownKit(p, 20);
                    Kits.potato.add(k.getName());
                    p.sendMessage("§3§lHOTPOTATO §fVoc\u00ea colocou a §c§l§oTNT §fno §e§o" + k.getName());
                    k.sendMessage("§3§lHOTPOTATO §c§o" + p.getName() + " §fcolocou uma §c§l§oTNT §fna sua cabe\u00e7a!");
                    final ItemStack tnt = new ItemStack(Material.TNT);
                    final ItemMeta tntmeta = tnt.getItemMeta();
                    tntmeta.setDisplayName("§cTNT");
                    tnt.setItemMeta(tntmeta);
                    k.getInventory().setHelmet(tnt);
                    new BukkitRunnable() {
                        public void run() {
                            if (Kits.potato.contains(k.getName())) {
                                k.sendMessage("§3§lHOTPOTATO §fA §c§l§oTNT §fna sua cabe\u00e7a §4§lEXPLODIR\u00c1 §fem 3 segundo!");
                                k.sendMessage("§3§lHOTPOTATO §fAbra seu invent\u00e1rio e §c§lREMOVA §fela!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 0L);
                    new BukkitRunnable() {
                        public void run() {
                            if (Kits.potato.contains(k.getName())) {
                                k.sendMessage("§3§lHOTPOTATO §fA §c§l§oTNT §fna sua cabe\u00e7a §4§lEXPLODIR\u00c1 §fem 2 segundo!");
                                k.sendMessage("§3§lHOTPOTATO §fAbra seu invent\u00e1rio e §c§lREMOVA §fela!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 20L);
                    new BukkitRunnable() {
                        public void run() {
                            if (Kits.potato.contains(k.getName())) {
                                k.sendMessage("§3§lHOTPOTATO §fA §c§l§oTNT §fna sua cabe\u00e7a §4§lEXPLODIR\u00c1 §fem 1 segundo!");
                                k.sendMessage("§3§lHOTPOTATO §fAbra seu invent\u00e1rio e §c§lREMOVA §fela!");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 40L);
                    new BukkitRunnable() {
                        public void run() {
                            if (Kits.potato.contains(k.getName())) {
                                k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
                                k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
                                k.setLastDamage(9999.0);
                                Kits.potato.remove(k.getName());
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance(), 60L);
                }
            }
        }
    }
    
    @EventHandler
    public void onRemoverTNT(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (KitAPI.getkit(p) != "Nenhum" && e.getSlot() == 39 && e.getCurrentItem().getType().equals((Object)Material.TNT) && Kits.potato.contains(p.getName())) {
            Kits.potato.remove(p.getName());
            e.setCancelled(true);
            p.getInventory().setHelmet((ItemStack)null);
            p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
            p.sendMessage("§3§lHOTPOTATO §fVoc\u00ea §a§lDESARMOU §fa §9§lHOTPOTATO");
            p.closeInventory();
        }
    }
    
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Deshzin") {
            if (p.getGameMode() == GameMode.CREATIVE) {
                return;
            }
            if (p.isOnGround() && !p.getAllowFlight()) {
                p.setAllowFlight(true);
            }
        }
    }
    
    @EventHandler
    public void switcherKit(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (KitAPI.getkit(shooter) == "Switcher") {
                    final Location shooterLoc = shooter.getLocation();
                    shooter.teleport(e.getEntity().getLocation());
                    e.getEntity().teleport(shooterLoc);
                    shooter.getInventory().addItem(new ItemStack[] { APIs.criarItem(shooter, Material.SNOW_BALL, ChatColor.GREEN + "Switcher", new String[1], 5, (short)0) });
                    shooter.sendMessage("§3§lSWITCHER §a§l+ 5 BOLINHAS");
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
                    shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
                }
            }
        }
    }
    
    @EventHandler
    public void dano1(final EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getDamager();
        if (KitAPI.getkit(p) == "Viking" && p.getItemInHand().getType() == Material.DIAMOND_AXE) {
            e.setDamage(e.getDamage() + 2.0);
        }
    }
    
    @EventHandler
    public void aoPhantom(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p).equalsIgnoreCase("Phantom") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            if (Kits.emphantom.contains(p.getName())) {
                p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §fj\u00e1 est\u00e1 ativado.");
                return;
            }
        }
        if (KitAPI.getkit(p).equalsIgnoreCase("Phantom") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            if (CooldownAPI.pCooldown.containsKey(p.getName())) {
                p.sendMessage("§3§lPHANTOM §fVoc\u00ea est\u00e1 em §c§lCOOLDOWN §fde §c§l" + CooldownAPI.getCooldown(p) + "s");
                return;
            }
            Kits.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
            p.updateInventory();
            Kits.emphantom.add(p.getName());
            p.setAllowFlight(true);
            p.setFlying(true);
            p.getInventory().setArmorContents((ItemStack[])null);
            final ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
            final LeatherArmorMeta kPeito = (LeatherArmorMeta)Peito.getItemMeta();
            kPeito.setDisplayName("§cPeitoral");
            kPeito.setColor(Color.BLUE);
            Peito.setItemMeta((ItemMeta)kPeito);
            final ItemStack Cal\u00e7a = new ItemStack(Material.LEATHER_LEGGINGS);
            final LeatherArmorMeta kCa\u00e7a = (LeatherArmorMeta)Cal\u00e7a.getItemMeta();
            kCa\u00e7a.setDisplayName("§cCal\u00e7a");
            kCa\u00e7a.setColor(Color.GREEN);
            Cal\u00e7a.setItemMeta((ItemMeta)kCa\u00e7a);
            final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
            final LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
            kBota.setDisplayName("§cBotas");
            kBota.setColor(Color.PURPLE);
            Bota.setItemMeta((ItemMeta)kBota);
            final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
            final LeatherArmorMeta kCasapete = (LeatherArmorMeta)Capacete.getItemMeta();
            kCasapete.setDisplayName("§cCapacete");
            kCasapete.setColor(Color.AQUA);
            Capacete.setItemMeta((ItemMeta)kCasapete);
            p.getInventory().setChestplate(Peito);
            p.getInventory().setLeggings(Cal\u00e7a);
            p.getInventory().setHelmet(Capacete);
            p.getInventory().setBoots(Bota);
            p.updateInventory();
            CooldownAPI.addCooldown(p, 30);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §facaba em §9§l5 SEGUNDOS");
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §facaba em §9§l4 SEGUNDOS");
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §facaba em §9§l3 SEGUNDOS");
                }
            }, 40L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §facaba em §9§l2 SEGUNDOS");
                }
            }, 60L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §facaba em §9§l1 SEGUNDOS");
                }
            }, 80L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§3§lPHANTOM §fSeu §9§lPHANTOM §9§lACABOU");
                    Kits.emphantom.remove(p.getName());
                    p.getInventory().setArmorContents((ItemStack[])Kits.salvararmor.get(p.getName()));
                    p.updateInventory();
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.closeInventory();
                    p.getInventory().remove(Material.LEATHER_BOOTS);
                    p.getInventory().remove(Material.LEATHER_CHESTPLATE);
                    p.getInventory().remove(Material.LEATHER_HELMET);
                    p.getInventory().remove(Material.LEATHER_LEGGINGS);
                    p.updateInventory();
                }
            }, 100L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerHitAnchor(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player a = (Player)e.getDamager();
        if (KitAPI.getkit(p) == "Anchor") {
            p.setVelocity(new Vector());
            p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0f, 4.0f);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instancea, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.setVelocity(new Vector());
                }
            }, 1L);
        }
        if (KitAPI.getkit(a) == "Anchor") {
            a.playSound(a.getLocation(), Sound.ANVIL_BREAK, 4.0f, 4.0f);
            p.setVelocity(new Vector());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instancea, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.setVelocity(new Vector());
                }
            }, 1L);
        }
    }
    
    @EventHandler
    public void onGetArmors(final InventoryClickEvent e) {
        try {
            final Player p = (Player)e.getWhoClicked();
            if (Kits.emphantom.contains(p.getName()) && e.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
                e.setCancelled(true);
            }
        }
        catch (Exception ex) {}
    }
    
    @EventHandler
    public void Pescar(final PlayerFishEvent e) {
        final Player p = e.getPlayer();
        if (e.getCaught() instanceof Player && KitAPI.getkit(p) == "Fisherman") {
            final Player t = (Player)e.getCaught();
            t.teleport((Entity)p);
            p.sendMessage("§3§lFISHERMAN §fVoc\u00ea puxou o jogador §c§o" + t.getName());
            e.setCancelled(false);
        }
    }
    
    @EventHandler
    public void onLauncher(final PlayerFishEvent e) {
        final Player p = e.getPlayer();
        if (e.getCaught() instanceof Player && KitAPI.getkit(p) == "Launcher") {
            final Player t = (Player)e.getCaught();
            if (this.hasCooldown()) {
                p.sendMessage("§3§lLAUNCHER §fSeu §c§lCOOLDOWN §facaba em §c§l" + this.cooldownTimeRemaining());
                return;
            }
            t.setVelocity(t.getVelocity().setY(1.0));
            this.addCooldown(p, 30);
        }
    }
    
    public void addCooldown(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
    
    @EventHandler
    public void Andar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND || e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE) && KitAPI.getkit(p) == "Camel") {
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
        }
    }
    
    @EventHandler
    public void Bater(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player t = (Player)e.getDamager();
            if (KitAPI.getkit(t) == "Viper" && t.getItemInHand().getType() == Material.STONE_SWORD && new Random().nextInt(100) <= 25) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
            }
        }
    }
    
    @EventHandler
    public void pular(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.FIREWORK && KitAPI.getkit(p) == "Kangaroo") {
            event.setCancelled(true);
            final Vector vector = p.getEyeLocation().getDirection();
            if (SubEventos.combate.contains(p)) {
                p.setFallDistance(-0.0f);
                vector.multiply(0.1f);
                vector.setY(0.1);
                p.setVelocity(vector);
                p.sendMessage("§3§lCOMBATE §fVoc\u00ea est\u00e1 em §9§lCOMBATE");
            }
            if (!this.noescape.contains(p.getName())) {
                if (!this.timer.contains(p.getName())) {
                    this.timer.add(p.getName());
                    if (!p.isSneaking()) {
                        p.setFallDistance(-1.0f);
                        vector.multiply(0.5f);
                        vector.setY(1.0);
                        p.setVelocity(vector);
                    }
                    else {
                        p.setFallDistance(-1.0f);
                        vector.multiply(1.5f);
                        vector.setY(0.5);
                        p.setVelocity(vector);
                    }
                }
            }
            else if (!this.timer.contains(p.getName())) {
                this.timer.add(p.getName());
                p.setFallDistance(0.0f);
                vector.multiply(0.0f);
                vector.setY(0.0);
                p.setVelocity(vector);
            }
        }
    }
    
    @EventHandler
    public void removertimer(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (this.timer.contains(p.getName())) {
            final Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                this.timer.remove(p.getName());
            }
        }
    }
    
    @EventHandler
    public void getCriticalDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitAPI.getkit(d) == "Critical") {
                final Random r = new Random();
                final int c = r.nextInt(100);
                if (c <= 30) {
                    e.setDamage(e.getDamage() + 1.8);
                    p.sendMessage("§3§lCRITICAL §fVoc\u00ea recebeu um golpe §c§lCRITICO §fde §c" + d.getName());
                    d.sendMessage("§3§lCRITICAL §fVoc\u00ea deu um golpe §9§lCRITICO §fno jogador §e" + p.getName());
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerStomp(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (KitAPI.getkit(p) == "Stomper") {
            for (final Entity ent : p.getNearbyEntities(3.0, 3.0, 3.0)) {
                if (!(ent instanceof Player)) {
                    continue;
                }
                final Player plr = (Player)ent;
                if (e.getDamage() <= 4.0) {
                    e.setCancelled(true);
                    return;
                }
                if (plr.isSneaking()) {
                    plr.damage(6.0, (Entity)p);
                }
                if (KitAPI.getkit(plr) == "AntiStomper") {
                    plr.damage(2.0, (Entity)p);
                    plr.sendMessage("§3§lANTISTOMPER §fVoc\u00ea recebeu dano reduzido do §9§lSTOMPER");
                }
                else {
                    plr.damage(800.0, (Entity)p);
                    plr.sendMessage("§3§lSTOMPER §fVoc\u00ea foi §c§lSTOMPADO §fpor §c" + p.getName());
                    plr.getKiller();
                }
            }
            e.setDamage(4.0);
        }
    }
    
    @EventHandler
    public void aoIronMan(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "IronMan" && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.WORKBENCH) {
            p.openWorkbench(p.getLocation(), true);
        }
    }
    
    @EventHandler
    public void aoMatar(final PlayerDeathEvent e) {
        final Player matou = e.getEntity().getKiller();
        if (!(e.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (KitAPI.getkit(matou) == "IronMan" && e.getEntity().getKiller() instanceof Player) {
            final ItemStack ferro = new ItemStack(Material.IRON_INGOT);
            matou.getInventory().addItem(new ItemStack[] { ferro });
            matou.updateInventory();
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && KitAPI.getkit(player) == "Kangaroo" && event.getDamage() >= 12.0) {
                event.setDamage(12.0);
            }
        }
    }
    
    @EventHandler
    public void onTurtleDamage(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (KitAPI.getkit(p) == "Turtle" && p.isSneaking() && (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.CONTACT || e.getCause() == EntityDamageEvent.DamageCause.CUSTOM || e.getCause() == EntityDamageEvent.DamageCause.DROWNING || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.FALL || e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING || e.getCause() == EntityDamageEvent.DamageCause.MAGIC || e.getCause() == EntityDamageEvent.DamageCause.MELTING || e.getCause() == EntityDamageEvent.DamageCause.POISON || e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE || e.getCause() == EntityDamageEvent.DamageCause.STARVATION || e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION || e.getCause() == EntityDamageEvent.DamageCause.THORNS || e.getCause() == EntityDamageEvent.DamageCause.VOID || e.getCause() == EntityDamageEvent.DamageCause.WITHER)) {
            e.setDamage(1.1);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerTurtleDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getDamager();
        if (!p.isSneaking()) {
            return;
        }
        if (KitAPI.getkit(p) == "Turtle") {
            e.setCancelled(true);
            p.sendMessage("§3§lTURTLE §fVoc\u00ea n\u00e3o pode hitar enquanto estiver agachado(shift)");
        }
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
        if (paramEntityDamageByEntityEvent.getDamager() instanceof Player && paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
            final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
            final Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
            if (KitAPI.getkit(localPlayer1) == "Ninja") {
                this.a.put(localPlayer1, localPlayer2);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Kits.cooldownbk.remove(localPlayer1);
                    }
                }, 200L);
            }
        }
    }
    
    @EventHandler
    public void onSlow(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitAPI.getkit(d) == "Snail") {
                final Random r = new Random();
                final int rand = r.nextInt(100);
                if (rand >= 67) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
                }
            }
        }
    }
    
    @EventHandler
    public void az(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
        if (paramEntityDamageByEntityEvent.getDamager() instanceof Player && paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
            final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
            final Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
            if (KitAPI.getkit(localPlayer1) == "Ajnin") {
                this.a.put(localPlayer1, localPlayer2);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Thor" && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            final ItemStack hand = p.getItemInHand();
            if (hand.getType() == Material.WOOD_AXE) {
                if (CooldownAPI.pCooldown.containsKey(p.getName())) {
                    p.sendMessage("§3§lTHOR §fVoc\u00ea est\u00e1 em §c§lCOOLDOWN §fde §c§l" + CooldownAPI.getCooldown(p) + "s");
                }
                else {
                    final Location loc = p.getTargetBlock((HashSet)null, 20).getLocation();
                    p.getWorld().strikeLightning(loc);
                    CooldownAPI.addCooldown(p, 8);
                }
            }
        }
    }
    
    @EventHandler
    public void onIasnteract(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.getkit(p) == "Specialist" && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.BOOK) {
            p.openEnchanting((Location)null, true);
        }
    }
    
    @EventHandler
    public void onVampire(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player killed = (Player)event.getEntity();
            if (killed.getKiller() instanceof Player) {
                final Player player = event.getEntity().getKiller();
                if (KitAPI.getkit(player) == "Specialist") {
                    player.setLevel(1);
                }
            }
        }
    }
}
