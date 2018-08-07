package discord.data.mining.Listener;

import discord.data.mining.Main;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author GregTCLTK
 * @time 09:42 01.07.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining.Listener
 * @class MessageReceivedListener
 **/

public class MessageReceivedListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().contains("401817301919465482") || event.getAuthor().getId().contains("261083609148948488")) {
            if (event.getMessage().getContentRaw().equals("dm!shutdown") || (event.getMessage().getContentRaw().equals("dm!stop"))) {

                for (JDA Bots : Main.bots) {
                    Bots.shutdown();
                }
                for (JDA Clients : Main.clients) {
                    Clients.shutdown();
                }
            } else if (event.getMessage().getContentRaw().equals("dm!start")) {

            }
        }
    }
}
