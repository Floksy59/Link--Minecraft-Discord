package listener;
import fr.floksy.linkmcdiscord.Main;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordListener extends ListenerAdapter
{
    private final Main main;
    public DiscordListener(final Main main) {this.main = main;}
    public void onReady(final ReadyEvent event) {
//        System.out.println("Discord and Minecraft are now linked.");
//        event.getJDA().getPresence().setGame(Game.of(getConfig().getString("game")));
        super.onReady(event);
    }
    public void onMessageReceived(final MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {return;}
        if (event.getGuild() == null) {return;}
        if (event.getTextChannel().getIdLong() != this.main.getChannelId()) {return;}
        this.main.sendMessageToMinecraft(event.getMessage());
        super.onMessageReceived(event);
    }
}