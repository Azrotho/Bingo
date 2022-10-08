package fr.azrotho.bingo;

import fr.azrotho.bingo.commands.BingoCommand;
import fr.azrotho.bingo.commands.DebugCommand;
import fr.azrotho.bingo.events.OnJoin;
import fr.azrotho.bingo.events.PlayerInventory;
import fr.azrotho.bingo.utils.Checker;
import fr.azrotho.bingo.utils.Timer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {
    public static ArrayList<ItemStack> materialsIniatial;
    public static int timer = 0;
    public static Boolean isStarted = false;
    private static HashMap<UUID,Integer> score;



    @Override
    public void onEnable() {
        score = new HashMap<>();
        System.out.println("Bingo plugin enabled");
        getCommand("debug").setExecutor(new DebugCommand());
        getCommand("bingo").setExecutor(new BingoCommand());
        getServer().getPluginManager().registerEvents(new PlayerInventory(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        Timer timer = new Timer();
        timer.runTaskTimer(this, 0, 20);
        Checker checker = new Checker();
        checker.runTaskTimer(this, 0, 10);
    }

    @Override
    public void onDisable() {
        System.out.println("Bingo plugin disabled");
    }

    public static HashMap<UUID, Integer> getScore() {
        return score;
    }
}

