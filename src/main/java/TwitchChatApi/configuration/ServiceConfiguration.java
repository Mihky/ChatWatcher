package TwitchChatApi.configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ServiceConfiguration {
    /**
     * Name of TwitchApp running on this service
     * */
    private String twitchAppName;

    /**
     * Twitch App Client ID
     * */
    private String clientId;

    /**
     * Twitch App Client Secret
     * */
    private String clientSecret;
}
