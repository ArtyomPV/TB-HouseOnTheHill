package ru.gb.TB_HouseOnTheHill.bots;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.TB_HouseOnTheHill.bots.handlers.CommandSelectionHandler;
import ru.gb.TB_HouseOnTheHill.config.BotConfig;
import ru.gb.TB_HouseOnTheHill.settings.CommandTypes;

@Component
public class Bot extends TelegramLongPollingBot {
    CommandTypes commandTypes = new CommandTypes();
    CommandSelectionHandler commandSelectionHandler = new CommandSelectionHandler();
    final BotConfig botConfig;
    String messageText;
    Long chatId;


    public Bot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }



    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
            if(commandTypes.types().contains(messageText)){
                commandSelectionHandler.onUpdateReceived(update);
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
