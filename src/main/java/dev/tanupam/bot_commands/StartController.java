package dev.tanupam.bot_commands;

import java.io.IOException;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class StartController {

  public static void welcomeUser(TelegramBot bot, Message message, Chat chat) throws IOException {
    bot.execute(new SendMessage(chat.id(),
        "Hello <b>" + message.from().firstName() + "</b>!"
            + "\nWelcome to <b>ChatBot</b>\nOne stop solution for all your queries.\nUse command <i>/help</i> - to see available commands")
        .parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
  }
}
