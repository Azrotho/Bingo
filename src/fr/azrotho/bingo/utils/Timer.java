package fr.azrotho.bingo.utils;

import fr.azrotho.bingo.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Timer extends BukkitRunnable {
    @Override
    public void run() {
        if(Main.isStarted){
            Main.timer++;
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("test", "dummy", "§c§lBINGO");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName("§6§lBlockShuffle");
            Score score = objective.getScore("§f");
            score.setScore(1);
            final Score Timeri = objective.getScore( Main.timer / 3600 + "§ch§f " + ((Main.timer - (1200 * (Main.timer / 1200))) / 60 + "§cmin§f " + Main.timer % 60 + "§cs"));
            Timeri.setScore(0);
            p.setScoreboard(scoreboard);
        }
    }
}
