package discord.data.mining.listener;

import discord.data.mining.core.DataLog;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class BotMessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
         if (!event.getGuild().getId().equals("448554629282922527")) {
             DataLog.log(event);
         }
    }
}
