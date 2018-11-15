package TwitchChatApi.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {
    private static final String CONFIG_FILE_PATH_TEMPLATE = "%s/deploy/resources/%s";
    private static final String CONFIG_FILE_NAME = "twitch_api.properties";
    private static final String TWITCH_APP_KEY = "twitch_app";
    private static final String CLIENT_ID_KEY = "client_id";
    private static final String CLIENT_SECRET_KEY = "client_secret";

    public Configuration() {
        String configFilePath = String.format(
                CONFIG_FILE_PATH_TEMPLATE, System.getProperty("user.dir"), CONFIG_FILE_NAME);
        Map<String, String> configProperties = getPropertyValues(configFilePath);
        ServiceConfiguration serviceConfiguration = loadServiceConfiguration(configProperties);
    }

    private ServiceConfiguration loadServiceConfiguration(Map<String, String> configProperties) {
        ServiceConfiguration serviceConfiguration = null;
        return serviceConfiguration;
    }

    private Map<String, String> getPropertyValues(String configFilePath) {
        Map<String, String> propertyMap = new HashMap<>();
        InputStream inputStream;

        try {
            Properties properties = new Properties();
            inputStream = new FileInputStream(new File(configFilePath));

            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException(String.format("Config File: %s not found", configFilePath));
            }

            propertyMap.put(TWITCH_APP_KEY, properties.getProperty(TWITCH_APP_KEY));
            propertyMap.put(CLIENT_ID_KEY, properties.getProperty(CLIENT_ID_KEY));
            propertyMap.put(CLIENT_SECRET_KEY, properties.getProperty(CLIENT_SECRET_KEY));
        } catch (IOException e) {
        }
        return propertyMap;
    }
}
