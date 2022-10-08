package fr.azrotho.bingo.commands;

import fr.azrotho.bingo.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BingoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(Main.isStarted){
            Player p = (Player) commandSender;
                Inventory inv = Bukkit.createInventory(null, 45, "§c§lItems à trouver");
                p.openInventory(inv);
                for(int i = 0; i < 45; i++){
                    inv.setItem(i, Main.materialsIniatial.get(i));
                }

        }else{
            commandSender.sendMessage("§cLe jeu n'a pas encore commencé !");
        }
        return true;
    }
}
