package com.telegrambot.test.api;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telegrambot.test.utils.TelegramMessageBot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TelegramSendTest {
	@Operation(summary = "�ڷ��׷� �׽�Ʈ", description = "�ڷ��׷� �׽�Ʈ")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
		@ApiResponse(responseCode = "404", description = "NOT FOUND"),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@RequestMapping("/telegramSend")
	public String telegramSend(@Parameter(description = "send �޽���", required = true, example = "�޽���") @RequestParam String message) {
		
		TelegramMessageBot bot = new TelegramMessageBot();
		Date dateTime = new Date();
        String startMsg = "�޽��� �߼�\n\n"
        		+ "[�޽���] : " + message
                + "\n[�ð�] : " + dateTime;

		bot.sendMessage(startMsg);
		
		return "";
	}
}
