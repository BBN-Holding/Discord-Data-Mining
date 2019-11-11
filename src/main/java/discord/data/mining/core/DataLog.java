package discord.data.mining.core;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

import java.awt.*;
import java.time.Instant;

public class DataLog {

    public static void log(GenericEvent event) {
        JDA BOT = DataMining.bots.get(DataMining.bot);
        DataMining.bot++;
        if (DataMining.bot == DataMining.bots.size()) DataMining.bot = 0;
        if (event instanceof MessageReceivedEvent) {
            MessageReceivedEvent msgevent = (MessageReceivedEvent) event;
            if (!msgevent.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(DataMining.MessageLog).sendMessage(new EmbedBuilder()
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .setThumbnail(msgevent.getGuild().getIconUrl())
                        .setAuthor(msgevent.getAuthor().getAsTag(), msgevent.getAuthor().getAvatarUrl(), msgevent.getAuthor().getAvatarUrl())
                        .setTitle("New Message")
                        .addField("Guild Name", msgevent.getGuild().getName(), true)
                        .addField("Guild ID", msgevent.getGuild().getId(), true)
                        .addField("Guild Owner", msgevent.getGuild().getOwner().getUser().getAsTag(), true)
                        .addField("Content", "```" + msgevent.getMessage().getContentDisplay() + "```", false)
                        .build()).queue();
            }
        } else if (event instanceof MessageDeleteEvent) {
            MessageDeleteEvent msgevent = (MessageDeleteEvent) event;
            if (!msgevent.getGuild().getId().equals("448554629282922527")) {
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
        } else if (event instanceof MessageReactionAddEvent) {
            MessageReactionAddEvent revent = (MessageReactionAddEvent) event;
            if (!revent.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(DataMining.ReactionLog).sendMessage(new EmbedBuilder()
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .setThumbnail(revent.getGuild().getIconUrl())
                        .setAuthor(revent.getMember().getUser().getAsTag(), revent.getMember().getUser().getAvatarUrl(), revent.getMember().getUser().getAvatarUrl())
                        .setTitle("Reaction added")
                        .addField("Guild Name", revent.getGuild().getName(), true)
                        .addField("Guild ID", revent.getGuild().getId(), true)
                        .addField("Guild Owner", revent.getGuild().getOwner().getUser().getAsTag(), true)
                        .addField("Reaction", revent.getReaction().toString(), false)
                        .build()).queue();
            }
        }
    }
}