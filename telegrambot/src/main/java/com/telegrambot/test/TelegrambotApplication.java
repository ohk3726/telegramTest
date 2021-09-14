package com.telegrambot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.telegrambot.test.utils.TelegramMessageBot;

@SpringBootApplication
public class TelegrambotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		
		TelegramBotsApi botsApi = new TelegramBotsApi();
		
		try {
			botsApi.registerBot(new TelegramMessageBot());
		}catch(TelegramApiException e) {
			e.printStackTrace();
		}
		
		SpringApplication.run(TelegrambotApplication.class, args);
	}

}
