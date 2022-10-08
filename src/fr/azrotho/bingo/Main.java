package fr.azrotho.bingo;

import fr.azrotho.bingo.commands.BingoCommand;
import fr.azrotho.bingo.commands.DebugCommand;
import fr.azrotho.bingo.events.OnJoin;
import fr.azrotho.bingo.events.PlayerInventory;
import fr.azrotho.bingo.utils.Timer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin {
    public static ArrayList<ItemStack> materialsIniatial;
    public static int timer = 0;
    public static Boolean isStarted = false;



    @Override
    public void onEnable() {
        System.out.println("Bingo plugin enabled");
        getCommand("debug").setExecutor(new DebugCommand());
        getCommand("bingo").setExecutor(new BingoCommand());
        getServer().getPluginManager().registerEvents(new PlayerInventory(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        Timer timer = new Timer();
        timer.runTaskTimer(this, 0, 20);

    }

    @Override
    public void onDisable() {
        System.out.println("Bingo plugin disabled");
    }
}
