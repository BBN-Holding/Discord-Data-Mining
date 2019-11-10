package discord.data.mining.listener;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.time.Instant;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("dm!shutdown") || event.getMessage().getContentRaw().equals("dm!stop")) {
            if (event.getAuthor().getId().equals("477141528981012511") || event.getAuthor().getId().equals("261083609148948488")) {
                try {
                    for (JDA bots : DataMining.bots) {
                        bots.shutdown();
                    }

                    for (JDA clients : DataMining.clients) {
                        clients.shutdown();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("⚠ Error ⚠")
                            .setDescription("⚠ Error ⚠")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                    event.getTextChannel().sendMessage("```java " + e.toString() + "```").queue();
                }
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("✅ Success ✅")
                        .setDescription("✅ Success ✅")
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } else {
                PrivateChannel Skidder = event.getJDA().getUserById("477141528981012511").openPrivateChannel().complete();
                PrivateChannel Hax = event.getJDA().getUserById("261083609148948488").openPrivateChannel().complete();

                EmbedBuilder message = new EmbedBuilder()
                        .setTitle("Command executed by " + event.getAuthor().getAsTag())
                        .setAuthor(event.getAuthor().getName(), event.getAuthor().getAvatarUrl(), event.getAuthor().getAvatarUrl())
                        .setDescription(event.getMessage().getContentRaw())
                        .setTimestamp(Instant.now());

                Skidder.sendMessage(message.build()).queue();
                Hax.sendMessage(message.build()).queue();
            }
        }
    }
}

