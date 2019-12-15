package discord.data.mining.core;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.update.*;

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
                        .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
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
                        .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
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
                        .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                        .build()).queue();
            }
        } else if (event instanceof MessageReactionRemoveEvent) {
            MessageReactionRemoveEvent revent = (MessageReactionRemoveEvent) event;
            if (!revent.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(DataMining.ReactionLog).sendMessage(new EmbedBuilder()
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .setThumbnail(revent.getGuild().getIconUrl())
                        .setAuthor(revent.getMember().getUser().getAsTag(), revent.getMember().getUser().getAvatarUrl(), revent.getMember().getUser().getAvatarUrl())
                        .setTitle("Reaction removed")
                        .addField("Guild Name", revent.getGuild().getName(), true)
                        .addField("Guild ID", revent.getGuild().getId(), true)
                        .addField("Guild Owner", revent.getGuild().getOwner().getUser().getAsTag(), true)
                        .addField("Reaction", revent.getReaction().toString(), false)
                        .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                        .build()).queue();
            }
        } else if (event instanceof UserUpdateNameEvent) {
            UserUpdateNameEvent uevent = (UserUpdateNameEvent) event;
            BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(uevent.getUser().getAvatarUrl())
                    .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                    .setTitle("User updated name")
                    .addField("Old name", uevent.getOldName(), true)
                    .addField("New name", uevent.getNewName(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof UserUpdateDiscriminatorEvent) {
            UserUpdateDiscriminatorEvent uevent = (UserUpdateDiscriminatorEvent) event;
            BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(uevent.getUser().getAvatarUrl())
                    .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                    .setTitle("User updated discriminator")
                    .addField("Old discriminator", uevent.getOldDiscriminator(), true)
                    .addField("New discriminator", uevent.getNewDiscriminator(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof UserUpdateAvatarEvent) {
            UserUpdateAvatarEvent uevent = (UserUpdateAvatarEvent) event;
            try {
                BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .setImage(uevent.getNewAvatarUrl())
                        .setThumbnail(uevent.getOldAvatarUrl())
                        .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                        .setTitle("User updated avatar")
                        .addField("New avatar ID", uevent.getNewAvatarId(), true)
                        .addField("Old avatar ID", uevent.getOldAvatarId(), true)
                        .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                        .build()).queue();
            } catch (Exception ignore){}
        } else if (event instanceof UserUpdateOnlineStatusEvent) {
            UserUpdateOnlineStatusEvent uevent = (UserUpdateOnlineStatusEvent) event;
            BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(uevent.getUser().getAvatarUrl())
                    .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                    .setTitle("User updated online status")
                    .addField("New online status", uevent.getNewOnlineStatus().toString(), true)
                    .addField("Old online status", uevent.getOldOnlineStatus().toString(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof UserActivityStartEvent) {
            UserActivityStartEvent uevent = (UserActivityStartEvent) event;
            BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(uevent.getUser().getAvatarUrl())
                    .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                    .setTitle("User started playing")
                    .addField("New activity", uevent.getNewActivity().toString(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof UserActivityEndEvent) {
            UserActivityEndEvent uevent = (UserActivityEndEvent) event;
            BOT.getTextChannelById(DataMining.UserLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .setThumbnail(uevent.getUser().getAvatarUrl())
                    .setAuthor(uevent.getUser().getAsTag(), uevent.getUser().getAvatarUrl(), uevent.getUser().getAvatarUrl())
                    .setTitle("User ended playing")
                    .addField("Old activity", uevent.getOldActivity().toString(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof StoreChannelCreateEvent) {
            StoreChannelCreateEvent cevent = (StoreChannelCreateEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Store channel created")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Channel name", cevent.getChannel().getName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof StoreChannelDeleteEvent) {
            StoreChannelDeleteEvent cevent = (StoreChannelDeleteEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Store channel deleted")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Channel name", cevent.getChannel().getName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof StoreChannelUpdateNameEvent) {
            StoreChannelUpdateNameEvent cevent = (StoreChannelUpdateNameEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.YELLOW)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Store channel name updated")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Old name", cevent.getOldName(), true)
                    .addField("New name", cevent.getNewName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof TextChannelCreateEvent) {
            TextChannelCreateEvent cevent = (TextChannelCreateEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Text channel created")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Channel name", cevent.getChannel().getName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof TextChannelDeleteEvent) {
            TextChannelDeleteEvent cevent = (TextChannelDeleteEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Text channel deleted")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Channel name", cevent.getChannel().getName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        } else if (event instanceof TextChannelUpdateNameEvent) {
            TextChannelUpdateNameEvent cevent = (TextChannelUpdateNameEvent) event;
            BOT.getTextChannelById(DataMining.ChannelLog).sendMessage(new EmbedBuilder()
                    .setColor(Color.YELLOW)
                    .setTimestamp(Instant.now())
                    .setThumbnail(cevent.getChannel().getGuild().getIconUrl())
                    .setAuthor(cevent.getChannel().getGuild().getName(), cevent.getChannel().getGuild().getIconUrl(), cevent.getChannel().getGuild().getIconUrl())
                    .setTitle("Text channel name updated")
                    .addField("Guild Name", cevent.getChannel().getGuild().getName(), true)
                    .addField("Guild ID", cevent.getChannel().getGuild().getId(), true)
                    .addField("Guild Owner", cevent.getChannel().getGuild().getOwner().getUser().getAsTag(), true)
                    .addField("Old name", cevent.getOldName(), true)
                    .addField("New name", cevent.getNewName(), true)
                    .addField("Channel ID", cevent.getChannel().getId(), true)
                    .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png")
                    .build()).queue();
        }
    }
}
