package fr.azrotho.bingo.commands;

import fr.azrotho.bingo.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings[0]) {
            case "start":
                Main.isStarted = true;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Location location = new Location(p.getWorld(), 0, 0, 0);

                    location.setX(Math.random() * 1000 * 2 - 1000);
                    location.setZ(Math.random() * 1000 * 2 - 1000);
                    location.setY(p.getWorld().getHighestBlockAt(location.getBlockX(), location.getBlockZ()).getY() + 1);

                    p.teleport(location);

                    p.setHealth(20);
                    p.setFoodLevel(20);
                    Main.getScore().put(p.getUniqueId(), 0);
                }
                int current = 0;
                Material[] materials = Material.values();
                List<Material> materialList = Arrays.asList(materials);
                Collections.shuffle(materialList);

                ArrayList<ItemStack> itms = new ArrayList<ItemStack>();
                for (int i = 0; i < 54; i++) {
                    if(current == 1000){
                        break;
                    }
                    current++;
                    if(new ItemStack(materialList.get(current), 1).getType().isItem()) {
                        if (itms.contains(new ItemStack(materialList.get(current), 1))) {
                            i--;
                        } else {
                            itms.add(new ItemStack(materialList.get(current), 1));
                        }
                    }else{
                        i--;
                    }
                }
                Main.materialsIniatial = itms;
                break;
        }
        return true;
    }
}

