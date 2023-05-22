package dev.tanupam.model;

public record ChatGPTRes(
        String id,
        String object,
        int created,
        String model,

        ChatGPTResponseChoice[] choices,
        ChatGPTResponseUsage usage) {

}