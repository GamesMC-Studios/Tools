package gamesmc.tools.commands;

import gamesmc.tools.Settings;
import gamesmc.tools.Tools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class FlyCommand extends CommandBase {

    @Override
    protected boolean onCommand(Player p, Command cmd, String label, String[] args) {
        if (args.length == 0 && p.hasPermission("tools.fly")); {
            if (p.getAllowFlight() == true) {
                p.setAllowFlight(false);
            } else {
                p.setAllowFlight(true);
            }
        }
        if (args.length == 1 && p.hasPermission("tools.fly.others")) {
            Player gracz = Bukkit.getPlayer(args[0]);
            if (gracz == null) {
                p.sendMessage(Tools.getSerializer().deserialize(Settings.IMP.MESSAGES.PLAYER_IS_OFFLINE));
                return false;
            } if  (gracz.getAllowFlight() == true) {
                gracz.setAllowFlight(false);
            } else {
                gracz.setAllowFlight(true);
            }
        }
        return false;
    }
}