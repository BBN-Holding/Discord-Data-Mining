package discord.data.mining;

import net.dv8tion.jda.core.EmbedBuilder;

import java.time.Instant;

/**
 * @author GregTCLTK
 * @time 21:26 30.06.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining
 * @class Logger
 **/

public class Logger {
    public static void info(String info) {
        Main.manager.get(0).getTextChannelById(Main.ConsoleLog).sendMessage(new EmbedBuilder().setColor(65280).setTimestamp(Instant.now()).setDescription(info).build()).queue();
        System.out.println("[" + Instant.now() + "] " + info);
        // Zeit wird noch gefixt
    }
}
