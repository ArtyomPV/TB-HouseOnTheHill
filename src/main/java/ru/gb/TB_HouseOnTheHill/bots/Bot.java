package ru.gb.TB_HouseOnTheHill.bots;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.TB_HouseOnTheHill.bots.handlers.CommandSelectionHandler;
import ru.gb.TB_HouseOnTheHill.config.BotConfig;
import ru.gb.TB_HouseOnTheHill.settings.CommandTypes;

import static ru.gb.TB_HouseOnTheHill.settings.BotCommands.LIST_OF_COMMAND;

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

    public void init() throws TelegramApiException {
        this.execute(new SetMyCommands(LIST_OF_COMMAND, new BotCommandScopeDefault(), null));
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
