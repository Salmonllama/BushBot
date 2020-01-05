package dev.salmonllama.bushbot;

import com.kaaz.configuration.ConfigurationBuilder;
import dev.salmonllama.bushbot.config.BotConfig;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            new ConfigurationBuilder(BotConfig.class, new File("bot.config")).build(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        new DiscordApiBuilder().setToken(BotConfig.TOKEN).login().thenAccept(api -> {
            System.out.println(generateInvite(api));

            
        });
    }

    private static String generateInvite(DiscordApi api) {
        PermissionsBuilder builder = new PermissionsBuilder();
        builder.setAllowed(
                PermissionType.SEND_MESSAGES,
                PermissionType.EMBED_LINKS,
                PermissionType.READ_MESSAGES,
                PermissionType.ADD_REACTIONS
        );

        return api.createBotInvite(builder.build());
    }
}
