package discord.data.mining;

import discord.data.mining.listener.BotMessageListener;
import discord.data.mining.listener.MessageListener;
import discord.data.mining.listener.ReadyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.util.ArrayList;

import static discord.data.mining.SECRETS.*;

public class DataMining {

    public static String MessageLog = "462507170383134720";
    public static String ReactionLog = "462524422713245696";
    public static String ConsoleLog = "462556910206320640";
    public static ArrayList<JDA> clients = new ArrayList<>();
    public static ArrayList<JDA> bots = new ArrayList<>();
    private static ArrayList<JDA> manager = new ArrayList<>();
    public static int bot = 0;

    public static void main(String[] args) {
        try {
            for (String Token : managerTokens) {
                manager.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).addEventListeners(new MessageListener()).build());
            }

            Thread.sleep(1500);

            for (String Token : botTokens) {
                bots.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).addEventListeners(new BotMessageListener()).build());
            }

            for (String Token : clientTokens) {
                clients.add(new JDABuilder(AccountType.CLIENT).setAutoReconnect(true).setToken(Token).addEventListeners(new ReadyListener()).build());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
