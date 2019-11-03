package discord.data.mining;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import java.util.ArrayList;

import static discord.data.mining.SECRETS.*;

public class DataMining {

    public String MessageLog = "462507170383134720";
    public String ReactionLog = "462524422713245696";
    public String ConsoleLog = "462556910206320640";
    public static ArrayList<JDA> clients = new ArrayList<>();
    public static ArrayList<JDA> bots = new ArrayList<>();
    public static ArrayList<JDA> manager = new ArrayList<>();

    public static void main(String[] args) {
        try {
            for (String Token : managerTokens) {
                manager.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).build());
            }

            Thread.sleep(1500);

            for (String Token : clienttokens) {
                clients.add(new JDABuilder(AccountType.CLIENT).setToken(Token).setAutoReconnect(true).build());
            }

            for (String Token : botTokens) {
                bots.add(new JDABuilder(AccountType.BOT).setAutoReconnect(true).setToken(Token).build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
