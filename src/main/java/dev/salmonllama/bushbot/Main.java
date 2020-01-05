package dev.salmonllama.bushbot;

import dev.salmonllama.bushbot.config.BotConfig;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args) {
        String token = BotConfig.TOKEN;

        new DiscordApiBuilder().setToken(token).login().thenAccept(api -> {

        });
    }
}
