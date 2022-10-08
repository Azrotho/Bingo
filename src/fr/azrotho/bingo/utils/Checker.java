package fr.azrotho.bingo.utils;

import fr.azrotho.bingo.Main;
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
                    Main.materialsIniatial.remove(m);
                    Main.materialsIniatial.add(new ItemStack(Material.BARRIER));
                    p.sendMessage("§c§lBINGO! §fVous avez trouvé un item !");
                    Main.getScore().put(p.getUniqueId(), Main.getScore().get(p.getUniqueId()) + 1);
                    Bukkit.broadcastMessage("§c§lBINGO! §f" + p.getName() + " a trouvé un item ! §7(" + Main.getScore().get(p.getUniqueId()) + "/10)");
                }
            }
            if(Main.getScore().get(p.getUniqueId()).equals(10)){
                Bukkit.broadcastMessage("§c§lBINGO! §f" + p.getName() + " a gagné !");
                Main.isStarted = false;
                for(Player p2 : Bukkit.getOnlinePlayers()){
                    p2.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    p2.sendMessage("fVotre score: " + Main.getScore().get(p2.getUniqueId()));
                    Main.getScore().put(p2.getUniqueId(), 0);
                }
            }
        }
    }
}
