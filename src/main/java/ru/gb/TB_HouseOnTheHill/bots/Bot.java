package ru.gb.TB_HouseOnTheHill.bots;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.TB_HouseOnTheHill.config.BotConfig;

@Component
public class Bot extends TelegramLongPollingBot {
    final BotConfig botConfig;
    String messageText;
    String chatId;


    public Bot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }



    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            System.out.println("Hello");
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}
