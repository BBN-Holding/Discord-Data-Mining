package discord.data.mining.Listener;

import discord.data.mining.Logger;
import discord.data.mining.Main;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Hax
 * @time 12:04 30.06.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining.Listener
 * @class onready
 **/

public class onready extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Logger.info("Client " + event.getJDA().getSelfUser().getName() + "#" +event.getJDA().getSelfUser().getDiscriminator() + "\nGuilds: " + event.getJDA().getGuilds().size() + "\nUser: " + event.getJDA().getUsers().size());
        Main.onlineclients.add(event.getJDA().getSelfUser().getName());
        Logger.info("Arraylist size " + Main.onlineclients.size() + " " + Main.clients.size());
        for (Guild guild : event.getJDA().getGuilds()) {
            if (!Main.guilds.contains(guild)) {
                Main.guilds.add(guild);
            } else {
                if (!guild.getId().contains("448554629282922527")) {
                    Logger.info("Leave" + guild.getName());
                    guild.leave().queue();
                }
            }
        }
        if (Main.onlineclients.size() == 3) {
            Logger.info("All clients loaded");
            for (JDA jda : Main.clients) {
                jda.addEventListener(new eventListener());
            }
        }
    }

}
