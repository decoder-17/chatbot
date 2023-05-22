package dev.tanupam.model;

public record ChatGPTResponseChoice(
        String text,
        int index,
        Object logprobs,
        String finish_reason
) {
}