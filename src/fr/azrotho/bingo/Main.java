package fr.azrotho.bingo;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Bingo plugin enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("Bingo plugin disabled");
    }
}
