package discord.data.mining.core;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DataLog {

    public static void log(Event event) {
        JDA BOT = DataMining.bots.get(DataMining.bot);
        if (event instanceof MessageReceivedEvent) {
            MessageReceivedEvent msgevent = (MessageReceivedEvent) event;
            BOT.getTextChannelById(DataMining.MessageLog).sendMessage(new EmbedBuilder()
                    .setTitle("New Message")
                    .build()).queue();
        }
    }
}