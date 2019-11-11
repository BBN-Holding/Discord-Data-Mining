package discord.data.mining.core;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class DataLog {

    public static void log(Event event) {
        JDA BOT = DataMining.bots.get(DataMining.bot);
        if (event instanceof MessageReceivedEvent) {
            MessageReceivedEvent msgevent = (MessageReceivedEvent) event;
            BOT.getTextChannelById(DataMining.MessageLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(msgevent.getGuild().getIconUrl())
                    .setAuthor(msgevent.getAuthor().getAsTag(), msgevent.getAuthor().getAvatarUrl(), msgevent.getAuthor().getAvatarUrl())
                    .setTitle("New Message")
                    .addField("Guild Name", msgevent.getGuild().getName(), true)
                    .addField("Guild ID", msgevent.getGuild().getId(), true)
                    .addField("Guild Owner", msgevent.getGuild().getOwner().getUser().getAsTag(), true)
                    .build()).queue();
        } else if (event instanceof MessageDeleteEvent) {
            MessageDeleteEvent msgevent = (MessageDeleteEvent) event;
            BOT.getTextChannelById(DataMining.MessageLog).sendMessage(new EmbedBuilder()
                .setColor(Color.RED)
                .setTimestamp(Instant.now())
                .setThumbnail(msgevent.getGuild().getIconUrl())
                .setTitle("Message deleted")
                .addField("Guild Name", msgevent.getGuild().getName(), true)
                .addField("Guild ID", msgevent.getGuild().getId(), true)
                .addField("Guild Owner", msgevent.getGuild().getOwner().getUser().getAsTag(), true)
                .build()).queue();
        }
    }
}