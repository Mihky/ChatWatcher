package TwitchChatApi.HttpHelper;

import TwitchChatApi.ChatBot.TwitchBotListener;
import TwitchChatApi.configuration.ServiceConfiguration;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

public class TwitchHttpClient {
    private static String CHANNEL_ENDPOINT = "https://api.twitch.tv/helix/users?login=";
    private final ServiceConfiguration serviceConfiguration;
    private HttpClient httpClient;

    public TwitchHttpClient(ServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
        httpClient = HttpClientBuilder.create().build();
    }

    public String getChannelId(String username) {
        HttpUriRequest request = new HttpGet(CHANNEL_ENDPOINT + username);
        request.setHeader("Authorization", String.format("Bearer %s", "wfewnz923y7diiwmsvl76xx204jfv2"));

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String responseJson = EntityUtils.toString(httpEntity);
                JSONObject data = new JSONObject(responseJson);
                for (String key : data.toMap().keySet()) {
                    System.out.println(key + ": " + data.toMap().get(key));
                }
            }

            //Configure what we want our bot to do
            Configuration configuration = new Configuration.Builder()
                    .setName("PircBotXUser") //Set the nick of the bot. CHANGE IN YOUR CODE
                    .addServer("irc.chat.twitch.tv", 6697) //Join the freenode network
                    .addAutoJoinChannel("#pircbotx") //Join the official #pircbotx channel
                    .addListener(new TwitchBotListener()) //Add our listener that will be called on Events
                    .buildConfiguration();

            //Create our bot with the configuration
            PircBotX bot = new PircBotX(configuration);
            //Connect to the server
            bot.startBot();
        } catch (IOException|IrcException e) {
        }
        return "";
    }
}
