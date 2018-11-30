package TwitchChatApi.ChatBot;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PingEvent;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TwitchBotListener to record messages in Twitch Chat.
 * Twitch API: https://dev.twitch.tv/docs/irc/guide/
 * */
public class TwitchBotListener extends ListenerAdapter {
    private static final String CHAT_LOG_TEMPLATE = "%s: %s";
    private static final String PONG_EVENT = "PONG :tmi.twitch.tv";

    public TwitchBotListener() {}

    @Override
    public void onMessage(MessageEvent event) throws Exception {
        String channelName = event.getChannelSource();
        String username = event.getUserHostmask().getNick();
        String message = event.getMessage();
        Date now = new Date();

        System.out.println(String.format(CHAT_LOG_TEMPLATE, username, message));
        System.out.println(event.getChannelSource());
    }

    /**
     * Respond to the ping sent by Twitch w/ pong
     *
     * */
    @Override
    public void onPing(PingEvent event) throws Exception {
        System.out.println(event.getPingValue());
        event.respond(PONG_EVENT);
    }

//    /**
//     * We MUST respond to this or else we will get kicked
//     */
//    @Override
//    public void onPing(PingEvent event) throws Exception {
//
//        Main.bot.sendRaw().rawLineNow(String.format("PONG %s\r\n", event.getPingValue()));
//    }
}
