package fr.floksy.linkmcdiscord;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import listener.BukkitListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import javax.security.auth.login.LoginException;
import listener.DiscordListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
//import net.dv8tion.jda.api.exceptions.RateLimitedException;

public class Main extends JavaPlugin
{
	FileConfiguration config = getConfig();
    private net.dv8tion.jda.api.JDA jda;
    public void onLoad() {
        try {this.jda = new JDABuilder(AccountType.BOT).setToken(getConfig().getString("token")).addEventListeners(new Object[] { new DiscordListener(this) }).build();}
        catch (LoginException e) {e.printStackTrace();}
//        catch (RateLimitedException e2) {
//            e2.printStackTrace();
//       }
        super.onLoad();
    }
    
    public void onEnable() {
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents((Listener)new BukkitListener(this), (Plugin)this);
        System.out.println("Discord - Minecraft link started.");
//        if(getConfig().getLong("channel") = XXXXXXXXXXXXXXXXXXL) {
//        	System.out.println(getConfig().getString("noChannelSet"));
//        }
        if(getConfig().getString("token") == "botToken") {
        	System.out.println(getConfig().getString("noTokenSet"));
        }
        getCommand("discord").setExecutor(new commands());
        super.onEnable();
    }
    
    public void onDisable() {
        this.jda.shutdown();
        System.out.println("Discord - Minecraft link stopped.");
        super.onDisable();
    }
    
    public net.dv8tion.jda.api.JDA getJda() {return this.jda;}
    public long getChannelId() {return getConfig().getLong("channel");}
    public void sendMessageToMinecraft(final Message message) {
        Bukkit.broadcastMessage("Discord - <" + message.getAuthor().getName() + "> " + message.getContentDisplay());
    }
    public void sendMessageToDiscord(final Player player, final String message) {
        this.jda.getTextChannelById(getConfig().getLong("channel")).sendMessage("<" + player.getName() + "> " + message).queue();
    }
}