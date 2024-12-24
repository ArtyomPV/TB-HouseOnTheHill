package ru.gb.TB_HouseOnTheHill.config;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.gb.TB_HouseOnTheHill.bots.Bot;

@Component
public class BotInitializer {

private final Bot bot;

    public BotInitializer(Bot bot) {
        this.bot = bot;
    }
    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
