package discord.data.mining;

import discord.data.mining.Listener.MessageReceivedListener;
import discord.data.mining.Listener.ReadyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import java.util.*;

import static discord.data.mining.SECRETS.botTokens;
import static discord.data.mining.SECRETS.clienttokens;
import static discord.data.mining.SECRETS.managerTokens;

public class Main {

    public static long MessageLog = 462507170383134720L;
    public static long ReactionLog = 462524422713245696L;
    public static long ConsoleLog = 462556910206320640L;
    public static ArrayList<JDA> clients = new ArrayList<>();
    public static ArrayList<JDA> bots = new ArrayList<>();
    public static ArrayList<JDA> manager = new ArrayList<>();
    public static int currentBot =0;
    public static ArrayList<String> onlineclients = new ArrayList<>();
    public static long Actionperh = 0;
    public static ArrayList<Guild> guilds = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Database.connect();
            for (String Token : managerTokens) {
                manager.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).addEventListeners(new MessageReceivedListener()).build());
            }

            Thread.sleep(1500);

            onlinethread.main();
            for (String Token : clienttokens) {
                clients.add(new JDABuilder(AccountType.CLIENT).setToken(Token).addEventListeners(new ReadyListener()).setAutoReconnect(true).build());
            }
            for (String Token : botTokens) {
                bots.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).build());
            }
            Stats.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}