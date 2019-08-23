package discord.data.mining.Listener;

import discord.data.mining.Main;
import discord.data.mining.sendMessage;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author GregTCLTK
 * @time 21:22 29.06.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining.Listener
 * @class onReactionAdd
 **/

public class GenericEventListener extends ListenerAdapter {

    public void onGenericEvent(Event event) {
            Main.Actionperh++;
            sendMessage.sendMessage(event);
    }
}
