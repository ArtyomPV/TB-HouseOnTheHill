package ru.gb.TB_HouseOnTheHill.bots.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.TB_HouseOnTheHill.config.BotConfig;

import static ru.gb.TB_HouseOnTheHill.settings.Commands.*;

@Component
public class CommandSelectionHandler extends TelegramLongPollingBot {
    @Autowired
    private  BotConfig botConfig;
    long chatId;
    String messageText;



    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();

            if(messageText.equals(START.getCommandType())){
                System.out.println(" Pressed " + START.getCommandType());
            } else if (messageText.equals(CONTACTS.getCommandType())) {
                System.out.println(" Pressed " + CONTACTS.getCommandType());
            } else if (messageText.equals(INFO.getCommandType())) {
                System.out.println(" Pressed " + INFO.getCommandType());
            }

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
