package dev.tanupam;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import dev.tanupam.bot_commands.HelpController;
import dev.tanupam.bot_commands.SearchController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.kshashov.telegram.api.MessageType;
import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import dev.tanupam.bot_commands.StartController;

@SpringBootApplication
@BotController
public class TgBotApplication implements TelegramMvcController {

	private String token = System.getenv("BOT_TOKEN");

	@Override
	public String getToken() {
		return token;
	}

	@BotRequest(value = "/start", type = { MessageType.CALLBACK_QUERY, MessageType.MESSAGE })
	public void start(Chat chat, Message message, TelegramBot bot) throws IOException {
		StartController.welcomeUser(bot, message, chat);
	}

	@BotRequest("/help")
	public void help(Chat chat, Message message,
					 TelegramBot bot)
			throws IOException {
		HelpController.sendHelp(bot, message, chat);
	}

	@BotRequest("/search{query}")
	public void searchQuestion(@BotPathVariable("query") String query, Chat chat, Message message, TelegramBot bot)
			throws IOException, InterruptedException {
		if(query.isEmpty())
			bot.execute(new SendMessage(chat.id(), "Please enter a valid query.").parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
		else
		SearchController.searchQuestion(bot, message, chat, query);

	}

	public static void main(String[] args) {
		SpringApplication.run(TgBotApplication.class, args);
	}
}