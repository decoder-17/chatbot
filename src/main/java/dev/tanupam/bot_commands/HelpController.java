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
                "_/help_ - Get some help." + "\n" ;
        bot.execute(
                new SendMessage(chat.id(), displayHelp).parseMode(ParseMode.Markdown).replyToMessageId(message.messageId()));
    }
}
