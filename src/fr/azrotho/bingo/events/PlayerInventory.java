package fr.azrotho.bingo.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerInventory implements Listener {
    @EventHandler
    public static void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event){
        if(event.getView().getTitle().equals("§c§lItems à trouver")){
            event.setCancelled(true);
        }
    }
}
