package com.telegrambot.test.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TelegramMessageBot extends TelegramLongPollingBot{
	private final String BOT_NAME = "fluxus_kakao_bot";
	private final String AUTH_KEY = "1972697731:AAEoaYBhPSvnIA7DHoUxptxIlgxHPKd1xC4";
	private final String CHAT_ID = "1990472804";
	
	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return AUTH_KEY;
	}
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return BOT_NAME;
	}
	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		
	}
	public void sendMessage(String sendMessage) {
		SendMessage message = new SendMessage();
		message.setChatId(CHAT_ID);
		message.setText(sendMessage);
		
		try {
			execute(message);
		}catch(TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
