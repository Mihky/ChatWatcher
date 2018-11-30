package TwitchChatApi;

import TwitchChatApi.ChatBot.TwitchBotListener;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

/**
 * https://dev.twitch.tv/docs/irc/guide/
 * */
public class BootstrapService {
    private static final String AUTH_TEMPLATE = "oauth:%s";
    public static void main(String[] args) throws IOException, IrcException {
        //Configure what we want our bot to do
        Configuration configuration = new Configuration.Builder()
                .setName("Mihky") //Set the nick of the bot. CHANGE IN YOUR CODE
                .setLogin("Mihky")
                .setAutoNickChange(true)
                .addServer("irc.chat.twitch.tv", 6667) //Join the twitch chat network
                .addAutoJoinChannel("#beyondthesummit") //Join the official #pircbotx channel
                .addListener(new TwitchBotListener()) //Add our listener that will be called on Events
                .setServerPassword("oauth:gmp2tp1yu5obfyfzqrgd1xnnrbve7q")
                .buildConfiguration();

        //Create our bot with the configuration
        PircBotX bot = new PircBotX(configuration);
        //Connect to the server
        bot.startBot();
    }
}
