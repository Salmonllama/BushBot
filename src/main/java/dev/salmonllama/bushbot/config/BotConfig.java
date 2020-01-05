package dev.salmonllama.bushbot.config;

import com.kaaz.configuration.ConfigurationOption;

public class BotConfig {
    @ConfigurationOption
    public static String TOKEN = "token-goes-here";

    @ConfigurationOption
    public static String DB_HOST = "localhost";

    @ConfigurationOption
    public static int DB_PORT = 28015;
}
