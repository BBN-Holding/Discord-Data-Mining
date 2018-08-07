package discord.data.mining.Listener;

import discord.data.mining.Main;
import discord.data.mining.sendMessage;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;


/**
 * @author GregTCLTK
 * @time 21:22 29.06.2018
 * @project Cryptix-Data-Mining
 * @package discord.data.mining.Listener
 * @class onReactionAdd
 **/


public class eventListener extends ListenerAdapter {

    @Override
    public void onGenericEvent(Event event) {
            Main.Messageperh++;
            sendMessage.sendMessage(event);
    }
}
