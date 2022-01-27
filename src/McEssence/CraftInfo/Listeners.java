package McEssence.CraftInfo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Listeners implements Listener {
    @EventHandler
    public void onCraft(PrepareItemCraftEvent event){
        if (event.getRecipe() != null && !event.isRepair()) {
            ItemStack newItem = event.getInventory().getResult();
            if (newItem.getMaxStackSize() <= 1) {
                List<String> Lore = new ArrayList<>();
                Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Lore.add("§7Made By: " + event.getView().getPlayer().getName());
                Lore.add("§7" + format.format(now));

                ItemMeta meta = newItem.getItemMeta();
                meta.setLore(Lore);
                newItem.setItemMeta(meta);

                event.getInventory().setResult(newItem);
            }
        }
    }
}
