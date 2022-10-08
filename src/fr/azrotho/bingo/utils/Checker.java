package fr.azrotho.bingo.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Checker extends BukkitRunnable {
    @Override
    public void run() {
        for(Player p : org.bukkit.Bukkit.getOnlinePlayers()){
            for(ItemStack m : fr.azrotho.bingo.Main.materialsIniatial){
                if(p.getInventory().contains(m)){
                    p.getInventory().remove(m);
                    p.sendMessage("§c§lBINGO! §fVous avez trouvé un item !");
                    Bukkit.broadcastMessage("§c§lBINGO! §f" + p.getName() + " a trouvé un item !");
                }
            }
        }

    }
}
