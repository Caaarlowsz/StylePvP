package fodastico.user.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.bukkit.util.Vector;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class Jumps implements Listener
{
    @EventHandler
    public void onSponge(final PlayerMoveEvent e) {
        final Player localPlayer = e.getPlayer();
        final Block localBlock1 = e.getTo().getBlock();
        final Location localLocation = localBlock1.getLocation();
        localLocation.setY(localLocation.getY() - 1.0);
        final Block localBlock2 = localLocation.getBlock();
        if (localBlock2.getType() == Material.SPONGE) {
            localPlayer.setFallDistance(-50.0f);
            localPlayer.setVelocity(new Vector(0, 5, 0));
            localPlayer.setFallDistance(-50.0f);
            localPlayer.playSound(localPlayer.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
    }
}
