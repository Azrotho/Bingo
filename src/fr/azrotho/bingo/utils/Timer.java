package fr.azrotho.bingo.utils;

import fr.azrotho.bingo.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Timer extends BukkitRunnable {
    @Override
    public void run() {
        // Do Scoreboard
        for (Player p : Bukkit.getOnlinePlayers()) {
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("test", "dummy", "§c§lBINGO");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName("§6§lBlockShuffle");
            Score score = objective.getScore("§f");
            score.setScore(1);
            final Score Timeri = objective.getScore("§f" + ((Main.timer - (1200 * (Main.timer / 1200))) / 60 + " §cmin§f " + Main.timer % 60));
            Timeri.setScore(0);
        }
    }
}
