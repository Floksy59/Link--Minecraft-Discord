package listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import fr.floksy.linkmcdiscord.Main;
import org.bukkit.event.Listener;

public class BukkitListener implements Listener
{
    private final Main main;
    public BukkitListener(final Main main) {this.main = main;}
    @EventHandler
    private void onPlayerChat(final AsyncPlayerChatEvent event) {
        this.main.sendMessageToDiscord(event.getPlayer(), event.getMessage());
    }
}