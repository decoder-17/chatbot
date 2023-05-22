package dev.tanupam.model;

public record ChatGPTResponseUsage(
        int prompt_tokens, int completion_tokens, int total_tokens
) {
}