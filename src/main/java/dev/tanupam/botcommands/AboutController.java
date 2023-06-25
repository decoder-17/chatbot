package dev.tanupam.botcommands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;

public class AboutController {
    public static void about(TelegramBot bot, Message message, Chat chat, String uptimeString) throws IOException {
        bot.execute(new SendMessage(chat.id(),
                "Hello <b>" + message.from().firstName() + "</b>!"
                        + "\nWelcome to <b>ChatBot</b>\n\nThis project has been developed as part of the Java Module and as a submission for the ChatBot Project.\n\nThis project has been developed by Tanupam Saha.\n\n"+"This bot is running for: "+uptimeString+"\n\nUse command <i>/help</i> - to see available commands")
                .parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
    }
}
