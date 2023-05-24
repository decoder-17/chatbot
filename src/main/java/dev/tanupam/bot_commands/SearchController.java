package dev.tanupam.bot_commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import dev.tanupam.model.ChatGPTReq;
import dev.tanupam.model.ChatGPTRes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchController {
    public static void searchQuestion(TelegramBot bot, Message message, Chat chat, String query) throws IOException, InterruptedException {

        SendResponse sendResponse = bot.execute(new SendMessage(chat.id(), "Fetching results, please wait.").replyToMessageId(message.messageId()));
        ObjectMapper objectMapper = new ObjectMapper();
        ChatGPTReq chatGPTReq = new ChatGPTReq("text-davinci-003", query, 0, 3996);
        String input = objectMapper.writeValueAsString(chatGPTReq);
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openai.com/v1/completions")).header("Content-Type", "application/json").header("Authorization", ("Bearer %s").formatted(System.getenv("OPENAI_TOKEN"))).POST(HttpRequest.BodyPublishers.ofString(input)).build();
            HttpClient client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ChatGPTRes chatGPTRes = objectMapper.readValue(response.body(), ChatGPTRes.class);
                String answer = chatGPTRes.choices()[chatGPTRes.choices().length - 1].text();
                StringBuffer questionResponse = new StringBuffer();
                if(answer == null) {
                    EditMessageText editMessageText = new EditMessageText(chat.id(), sendResponse.message().messageId(), "Sorry, could not understand the question. Please try rephrasing your question.");
                    bot.execute(editMessageText);
                }
                else {
                    if (!answer.isEmpty())
                        for(var i:answer.split(" ")) {
                            questionResponse.append(i).append(" ");
                            EditMessageText editMessageText = new EditMessageText(chat.id(), sendResponse.message().messageId(), questionResponse.toString());
                            System.out.println(questionResponse);
                            bot.execute(editMessageText);
                        }

                    else {
                        EditMessageText editMessageText = new EditMessageText(chat.id(), sendResponse.message().messageId(), "Sorry, could not understand the question. Please try rephrasing your question.");
                        bot.execute(editMessageText);
                    }
                }
            }



    }
}