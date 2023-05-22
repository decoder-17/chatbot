package dev.tanupam.model;

public record ChatGPTReq(String model, String prompt, int temperature, int max_tokens) {

}
