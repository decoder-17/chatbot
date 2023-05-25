<p align="center">
<a href="#"><img title="Whatsapp-Bot" src="https://github.com/decoder-17/chatbot/blob/master/logo.png"></a>
</p>
<h1 align="center">
  ChatBot 
  </h1>

<p align="center">
ChatBot powered by OpenAI, the leading artificial intelligence platform.
</p>

## Local Deployment Guide

This guide will walk you through the steps to run a Telegram bot locally using Java, system environment variables, and the OpenAI API.

### Prerequisites

To successfully run the Telegram bot locally, make sure you have the following:
  - Java Development Kit (JDK) installed on your machine.
  - Telegram Bot Token obtained from the [BotFather](https://telegram.me/BotFather) on Telegram.
  - [OpenAI API](https://platform.openai.com/) credentials (API key or access token) to access the OpenAI services.
  - An Integrated Development Environment (IDE) such as IntelliJ or Eclipse.

### Setup Instructions

Follow the steps below to set up and run the Telegram bot locally:
- Clone or download the ChatBot project to your local machine. <br/>
`$ git clone https://github.com/decoder-17/chatbot` 
- Open your preferred IDE and import the project.
- Set up system environment variables for your Telegram Bot Token and OpenAI API credentials:

  
  - **Windows**: Open the command prompt and execute the following command:
    ```bash
    setx CHAT_BOT_TOKEN "YOUR_TELEGRAM_BOT_TOKEN"
    setx OPENAI_TOKEN "YOUR_OPENAI_TOKEN"
    ```
  - **Linux/macOS**: Open the terminal and execute the following command:
    ```bash
    export CHAT_BOT_TOKEN="YOUR_TELEGRAM_BOT_TOKEN"
    export OPENAI_TOKEN="YOUR_OPENAI_TOKEN"
    ```
- In your IDE, locate the `Main` class and run it.

- Congratulations! Your Telegram bot is now running locally and ready to respond to user queries.

## Docker Deployment Guide

This guide will walk you through the steps to run a Telegram bot locally using Docker, Java, system environment variables, and the OpenAI API.

### Prerequisites

To successfully run the Telegram bot locally, make sure you have the following:
  - Docker installed on your machine. 
  - Java Development Kit (JDK) installed on your machine.
  - Telegram Bot Token obtained from the [BotFather](https://telegram.me/BotFather) on Telegram.
  - [OpenAI API](https://platform.openai.com/) credentials (API key or access token) to access the OpenAI services.

### Setup Instructions

Follow the steps below to set up and run the Telegram bot using Docker:
- Clone or download the ChatBot project to your local machine. <br/>
`$ git clone https://github.com/decoder-17/chatbot` 
- Open your preferred IDE and import the project.
- Build the Docker image using docker compose :
  ```bash
  docker compose build
  ```
- Set up system environment variables for your Telegram Bot Token:
  
  - **Windows**: Open the command prompt and execute the following command:
    ```bash
    setx CHAT_BOT_TOKEN "YOUR_TELEGRAM_BOT_TOKEN"
    setx OPENAI_TOKEN "YOUR_OPENAI_TOKEN"
    ```
  - **Linux/macOS**: Open the terminal and execute the following command:
    ```bash
    export CHAT_BOT_TOKEN="YOUR_TELEGRAM_BOT_TOKEN"
    export OPENAI_TOKEN="YOUR_OPENAI_TOKEN"
    ```
- Run the Docker container using the built image:
  ```bash
  docker compose up
  ```

- Congratulations! Your Telegram bot is now running inside a Docker container and ready to respond to user queries.





## Usage/Examples

To start the bot:
```telegram
/start
```

To get help or to learn about the different commands available:
  ```bash
  /help
  ```

To search your query:
```bash
/search <type_your_query>
```

To learn about the bot and it's creator:
```bash
/about
```
## Support

> For support, email tanupamsaha26@gmail.com or raise an issue.

