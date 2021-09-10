package fodastico.user.Warp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WarpsManager implements Listener {
	public static ArrayList<String> segundos;

	static {
		WarpsManager.segundos = new ArrayList<String>();
	}

	public static void Set(final Player p, final String Warp) {
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".X", (Object) p.getLocation().getX());
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".Y", (Object) p.getLocation().getY());
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".Z", (Object) p.getLocation().getZ());
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".Pitch", (Object) p.getLocation().getPitch());
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".Yaw", (Object) p.getLocation().getYaw());
		WarpsConfigurations.getConfig().config().set("Warps." + Warp + ".World",
				(Object) p.getLocation().getWorld().getName());
		WarpsConfigurations.getConfig().saveAllWarps();
	}

	public static Location getWarpLocation() {
		final World world = Bukkit.getWorld(WarpsConfigurations.getConfig().config().getString("Warps..World"));
		final double X = WarpsConfigurations.getConfig().config().getInt("Warps..X");
		final double Y = WarpsConfigurations.getConfig().config().getInt("Warps..Y");
		final double Z = WarpsConfigurations.getConfig().config().getInt("Warps..Z");
		final float Yaw = (float) WarpsConfigurations.getConfig().config().getInt("Warps..Yaw");
		final float Pitch = (float) WarpsConfigurations.getConfig().config().getInt("Warps..Pitch");
		final Location location = new Location(world, X, Y, Z, Yaw, Pitch);
		return location;
	}

	public static void Ir(final Player p, final String Warp) {
		if (WarpsConfigurations.getConfig().config().contains("Warps." + Warp)) {
			final double x = WarpsConfigurations.getConfig().config().getDouble("Warps." + Warp + ".X");
			final double y = WarpsConfigurations.getConfig().config().getDouble("Warps." + Warp + ".Y");
			final double z = WarpsConfigurations.getConfig().config().getDouble("Warps." + Warp + ".Z");
			final float Pitch = (float) WarpsConfigurations.getConfig().config().getDouble("Warps." + Warp + ".Pitch");
			final float Yaw = (float) WarpsConfigurations.getConfig().config().getDouble("Warps." + Warp + ".Yaw");
			final World world = Bukkit
					.getWorld(WarpsConfigurations.getConfig().config().getString("Warps." + Warp + ".World"));
			final Location loc = new Location(world, x, y, z, Yaw, Pitch);
			p.teleport(loc);
		} else {
			p.sendMessage(
					"§6§lWARP §fEsta §e§lWARP §fainda n\u00e3o foi §a§lSETADA§f! Avise um §d§lSTAFFER §fpara §a§lSETA-LA§f!");
		}
	}
}
