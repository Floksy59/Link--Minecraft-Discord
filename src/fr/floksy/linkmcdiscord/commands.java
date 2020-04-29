package fr.floksy.linkmcdiscord;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String msg, @NotNull String[] arg) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("discord")) {
			if(sender instanceof Player) {
				if(arg.length == 0) {
					player.sendMessage("Use \"/discord help\" to display list of commands.");
				}
				if(arg.length >= 1) {
					if(arg[0].equalsIgnoreCase("help")) {
						player.sendMessage("HEY !! JOKERINI !!");
					}
					if(arg[0].equalsIgnoreCase("reload")) {
						player.sendMessage("Reload in progress...");
					}
					if(arg[0].equalsIgnoreCase("enable")) {
						player.sendMessage("Enabling Discord channel and Minecraft chat link...");
					}
					if(arg[0].equalsIgnoreCase("disable")) {
						player.sendMessage("Disabling Discord channel and Minecraft chat link...");
					}
					if(arg[0].equalsIgnoreCase("set")) {
						if(arg.length == 1){
							player.sendMessage("Usage: /discord set [channel | token | game]");
						}
						else if(arg.length == 2) {
							if(arg[1].equalsIgnoreCase("channel")) {
								if(arg.length == 3) {
									
								}
								else {
									player.sendMessage("Usage: /discord set channel [channel_ID]");
								}
							}
							if(arg[1].equalsIgnoreCase("token")) {
								if(arg.length == 3) {
									
								}
								else {
									player.sendMessage("Usage: /discord set token [bot_token]");
								}
							}
							if(arg[1].equalsIgnoreCase("game")) {
								if(arg.length == 3) {
									
								}
								else {
									player.sendMessage("Usage: /discord set game [text]");
								}
							}
						}
					}
				}
			}
//			else{
//				System.out.println("Commande reçue depuis la console !");
//				if(arg.length == 0) {
//					System.out.println("Use /discord help to display help.");
//				}
//				if(arg.length >= 1) {
//					if(arg[0] == "help") {
//						System.out.println("Display HELP here.");
//					}
//				}
//			}
		}
		return false;
	}
}
