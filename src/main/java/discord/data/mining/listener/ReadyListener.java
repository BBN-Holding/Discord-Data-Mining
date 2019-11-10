package discord.data.mining.listener;

import discord.data.mining.DataMining;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class ReadyListener extends ListenerAdapter {
    public void onReady(ReadyEvent event) {
        event.getJDA().getTextChannelById(DataMining.ConsoleLog).sendMessage(new EmbedBuilder()
                .setTitle("Client started!")
                .setThumbnail(event.getJDA().getSelfUser().getAvatarUrl())
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .addField("As Mention", event.getJDA().getSelfUser().getAsTag(), true)
                .addField("ID", event.getJDA().getSelfUser().getId(), true)
                .addField("Guilds", String.valueOf(event.getJDA().getGuilds().size()), true)
                .build()).queue();
    }
}
