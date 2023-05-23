package dev.tanupam.bot_commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;

public class HelpController {

    public static void sendHelp(TelegramBot bot, Message message, Chat chat) throws    IOException {
        String displayHelp = "_/start_ - Welcome message.\n" +
                "_/search_ <question> - Search your question." + "\n" +
                "_/help_ - Get some help." + "\n" +
                "_/about_ - Know about the bot." + "\n" +
                "Rules:\n\n" + "While searching your query try to be as specific as possible.\n" + "Please use wh words such as what, when, why to get more speific answer."+ "\n\n" +"Thanks and Regards\nTanupam Saha";
        bot.execute(
                new SendMessage(chat.id(), displayHelp).parseMode(ParseMode.Markdown).replyToMessageId(message.messageId()));
    }
}
