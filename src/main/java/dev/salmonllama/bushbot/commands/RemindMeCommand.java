package dev.salmonllama.bushbot.commands;

import com.vdurmont.emoji.EmojiParser;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import dev.salmonllama.bushbot.utilities.MessageUtilities;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import java.util.concurrent.TimeUnit;

public class RemindMeCommand implements CommandExecutor {
    @Command(
            aliases = {"remindme", "rmme"},
            description = "Sets a reminder. Example: remindme 7h bush run",
            usage = "remindme <time> [reason]",
            category = "Timers"
    )
    public void onCommand(String[] args, TextChannel channel, Message message, DiscordApi api) {
        int delay = Integer.parseInt(args[0]);
        String reason = args[1];

        channel.sendMessage("reminder created");

        api.getThreadPool().getScheduler().schedule((Runnable) channel.sendMessage(reason), delay, TimeUnit.SECONDS);
    }
}
