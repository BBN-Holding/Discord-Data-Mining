package discord.data.mining;

/**
 * @author Skidder
 * @time 09:11 30.06.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining
 * @class sendMessage
 **/

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;

import java.time.Instant;

public class sendMessage {
    public static void sendMessage(Event inputevent) {
        try {
        JDA BOT = Main.bots.get(Main.currentBot);
        Main.currentBot++;
        if (Main.currentBot == Main.bots.size()) Main.currentBot = 0;
        if (inputevent instanceof MessageReceivedEvent) {
            MessageReceivedEvent event = (MessageReceivedEvent) inputevent;
            if (!event.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(Main.MessageLog)
                        .sendMessage(
                                new EmbedBuilder()
                                        .setAuthor(event.getAuthor().getName(), "https://discordapp.com/channels/@me/" + event.getAuthor().getId() + "/", event.getAuthor().getAvatarUrl()).setColor(65280)
                                        .setTitle("New Message", "https://canary.discordapp.com/channels/" + event.getGuild().getId() + "/")
                                        .setDescription("**Message Content:**\n" + event.getMessage().getContentRaw())
                                        .setThumbnail(event.getGuild().getIconUrl())
                                        .addField("Guild Name", event.getGuild().getName(), true)
                                        .addField("Guild ID", event.getGuild().getId(), true)
                                        .addField("Guild Owner", event.getGuild().getOwner().getUser().getName() + "#" + event.getGuild().getOwner().getUser().getDiscriminator(), true)
                                        .addField("Channel Name", "#" + event.getChannel().getName(), true)
                                        .setFooter(event.getJDA().getSelfUser().getName(), event.getJDA().getSelfUser().getAvatarUrl())
                                        .setTimestamp(Instant.now())
                                        .build()
                        ).queue();
            }
        } else if (inputevent instanceof MessageDeleteEvent) {
            MessageDeleteEvent event = (MessageDeleteEvent) inputevent;
            if (!event.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(Main.MessageLog)
                        .sendMessage(
                                new EmbedBuilder()
                                        .setColor(16711680)
                                        .setTitle("Message deleted", "https://canary.discordapp.com/channels/" + event.getGuild().getId() + "/")
                                        .setThumbnail(event.getGuild().getIconUrl())
                                        .addField("Guild Name", event.getGuild().getName(), true)
                                        .addField("Guild ID", event.getGuild().getId(), true)
                                        .addField("Guild Owner", event.getGuild().getOwner().getUser().getName() + "#" + event.getGuild().getOwner().getUser().getDiscriminator(), true)
                                        .addField("Channel Name", "#" + event.getChannel().getName(), true)
                                        .setFooter(event.getJDA().getSelfUser().getName(), event.getJDA().getSelfUser().getAvatarUrl())
                                        .setTimestamp(Instant.now())
                                        .build()
                        ).queue();
            }
        } else if (inputevent instanceof MessageReactionAddEvent) {
            MessageReactionAddEvent event = (MessageReactionAddEvent) inputevent;
            if (!event.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(Main.ReactionLog)
                        .sendMessage(
                                new EmbedBuilder()
                                        .setAuthor(event.getMember().getUser().getName(), "https://discordapp.com/channels/@me/" + event.getMember().getUser().getId() + "/", event.getMember().getUser().getAvatarUrl()).setColor(65280)
                                        .setTitle("Reaction Add", "https://canary.discordapp.com/channels/" + event.getGuild().getId() + "/")
                                        .setThumbnail(event.getGuild().getIconUrl())
                                        .setDescription("**Emoji:**\n" + event.getReactionEmote().getEmote().getAsMention())
                                        .addField("Guild Name", event.getGuild().getName(), true)
                                        .addField("Guild ID", event.getGuild().getId(), true)
                                        .addField("Guild Owner", event.getGuild().getOwner().getUser().getName() + "#" + event.getGuild().getOwner().getUser().getDiscriminator(), true)
                                        .addField("Channel Name", "#" + event.getChannel().getName(), true)
                                        .setFooter(event.getJDA().getSelfUser().getName(), event.getJDA().getSelfUser().getAvatarUrl())
                                        .setTimestamp(Instant.now())
                                        .build()
                        ).queue();
            }
        } else if (inputevent instanceof MessageReactionRemoveEvent) {
            MessageReactionRemoveEvent event = (MessageReactionRemoveEvent) inputevent;
            if (!event.getGuild().getId().equals("448554629282922527")) {
                BOT.getTextChannelById(Main.ReactionLog)
                        .sendMessage(
                                new EmbedBuilder()
                                        .setAuthor(event.getMember().getUser().getName(), "https://discordapp.com/channels/@me/" + event.getMember().getUser().getId() + "/", event.getMember().getUser().getAvatarUrl()).setColor(16711680)
                                        .setTitle("Reaction Remove", "https://canary.discordapp.com/channels/" + event.getGuild().getId() + "/")
                                        .setThumbnail(event.getGuild().getIconUrl())
                                        .setDescription("**Emoji:**\n" + event.getReactionEmote().getEmote().getAsMention())
                                        .addField("Guild Name", event.getGuild().getName(), true)
                                        .addField("Guild ID", event.getGuild().getId(), true)
                                        .addField("Guild Owner", event.getGuild().getOwner().getUser().getName() + "#" + event.getGuild().getOwner().getUser().getDiscriminator(), true)
                                        .addField("Channel Name", "#" + event.getChannel().getName(), true)
                                        .setFooter(event.getJDA().getSelfUser().getName(), event.getJDA().getSelfUser().getAvatarUrl())
                                        .setTimestamp(Instant.now())
                                        .build()
                        ).queue();
            }
        }
        } catch (Exception ignore) {
        }
    }
}