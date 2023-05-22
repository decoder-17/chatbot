package dev.tanupam.bot_commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import dev.tanupam.model.ChatGPTReq;
import dev.tanupam.model.ChatGPTRes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchController {
    public static void searchQuestion(TelegramBot bot, Message message, Chat chat, String query) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        ChatGPTReq chatGPTReq = new ChatGPTReq("text-davinci-001", query, 1, 100);
        String input = objectMapper.writeValueAsString(chatGPTReq);

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openai.com/v1/completions")).header("Content-Type", "application/json").header("Authorization", "Bearer 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").POST(HttpRequest.BodyPublishers.ofString(input)).build();

            HttpClient client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ChatGPTRes chatGPTRes = objectMapper.readValue(response.body(), ChatGPTRes.class);
                for(var i:chatGPTRes.choices())
                    System.out.println(i.text());
                String answer = chatGPTRes.choices()[chatGPTRes.choices().length - 1].text();
                if (!answer.isEmpty())
                    bot.execute(new SendMessage(chat.id(), answer.trim()).parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
                else
                    bot.execute(new SendMessage(chat.id(), "Sorry, could not understand the question. Please try rephrasing your question.").parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
            } else {
                bot.execute(new SendMessage(chat.id(), response.body()).parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
                bot.execute(new SendMessage(chat.id(), "Sorry could not fetch result, please try again.").parseMode(ParseMode.HTML).replyToMessageId(message.messageId()));
            }



    }
}