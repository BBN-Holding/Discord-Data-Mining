package discord.data.mining.listener;

import discord.data.mining.core.DataLog;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class BotMessageListener extends ListenerAdapter {

    @Override
    public void onGenericEvent(@Nonnull GenericEvent event) {
             DataLog.log(event);
    }
}
