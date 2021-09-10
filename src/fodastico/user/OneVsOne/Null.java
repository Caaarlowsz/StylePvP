package fodastico.user.OneVsOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Null {
	public static HashMap<ItemStack, String> myitens;

	static {
		Null.myitens = new HashMap<ItemStack, String>();
	}

	public HashMap<ItemStack, String> getItems() {
		return Null.myitens;
	}

	public ItemStack createItem(final Material m, final String id, final String displayName, final String[] lore,
			final int amount, final short data) {
		final ItemStack item = new ItemStack(m, amount, data);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		final ArrayList<String> l = new ArrayList<>();
		if (lore != null) {
			for (int i = 0; i < lore.length; ++i) {
				l.add(lore[i]);
			}
		}
		meta.setLore(l);
		item.setItemMeta(meta);
		if (Null.myitens.containsKey(item)) {
			Null.myitens.remove(item);
		}
		Null.myitens.put(item, id);
		return item;
	}

	public ItemStack getItemByID(final String id) {
		if (this.getItems().containsValue(id)) {
			for (final Map.Entry<ItemStack, String> en : Null.myitens.entrySet()) {
				if (en.getValue().equals(id)) {
					return en.getKey();
				}
			}
		}
		return null;
	}
}
