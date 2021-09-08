package fodastico.user.OneVsOne;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

public class Get1v1Itens implements Listener
{
    private static Null Itens1v1;
    public static ItemStack Blaze;
    public static ItemStack SackFast;
    public static ItemStack Lookingtry1;
    public static ItemStack LookinTry2;
    public static ItemStack Lookingtry3;
    
    static {
        Get1v1Itens.Itens1v1 = new Null();
        Get1v1Itens.Blaze = Get1v1Itens.Itens1v1.createItem(Material.BLAZE_ROD, "BLAZE_ROD", "§3§lDESAFIO", new String[0], 1, (short)0);
        Get1v1Itens.SackFast = Get1v1Itens.Itens1v1.createItem(Material.INK_SACK, "INK_SACK", "§a§lFAST1V1", new String[0], 1, (short)8);
        Get1v1Itens.Lookingtry1 = Get1v1Itens.Itens1v1.createItem(Material.INK_SACK, "INK_SACK", "§b§lPROCURANDO PARTIDAS", new String[0], 1, (short)10);
        Get1v1Itens.LookinTry2 = Get1v1Itens.Itens1v1.createItem(Material.INK_SACK, "INK_SACK", "§b§lPROCURANDO PARTIDAS", new String[0], 1, (short)10);
        Get1v1Itens.Lookingtry3 = Get1v1Itens.Itens1v1.createItem(Material.INK_SACK, "INK_SACK", "§b§lPROCURANDO PARTIDAS", new String[0], 1, (short)10);
    }
}
