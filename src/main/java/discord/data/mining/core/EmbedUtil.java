package discord.data.mining.core;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.Instant;

public class EmbedUtil {
    public EmbedBuilder add () {
        return new EmbedBuilder()
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png");
    }
    public EmbedBuilder remove () {
        return new EmbedBuilder()
                .setColor(Color.RED)
                .setTimestamp(Instant.now())
                .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png");
    }
    public EmbedBuilder update () {
        return new EmbedBuilder()
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .setFooter("BBN Data Mining", "https://bigbotnetwork.com/images/avatar.png");
    }
}
