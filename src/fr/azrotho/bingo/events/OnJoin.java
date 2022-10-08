package fr.azrotho.bingo.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public static void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        p.sendMessage("Bienvenue sur le serveur !");
        event.setJoinMessage("Bienvenue " + p.getName() + " sur le serveur !");
        for (int x = -5; x < 5; x++) {
            for (int y = 195; y < 200; y++) {
                for (int z = -5; z < 5; z++) {
                    p.getWorld().getBlockAt(x, y, z).setType(Material.BARRIER);
                }
            }
        }
        for (int x = -4; x < 4; x++) {
            for (int y = 196; y < 199; y++) {
                for (int z = -4; z < 4; z++) {
                    p.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
                }
            }
        }
        p.teleport(new org.bukkit.Location(p.getWorld(), 0, 196, 0));
    }
}
