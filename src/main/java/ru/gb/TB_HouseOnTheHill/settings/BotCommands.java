package ru.gb.TB_HouseOnTheHill.settings;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    List<BotCommand> LIST_OF_COMMAND = List.of(
            new BotCommand("/start", "запуск бота \uD83E\uDD16"),
            new BotCommand("/contacts", "связаться с нами ☎\uFE0F"),
            new BotCommand("/info", "о проекте \uD83D\uDCC3")

    );
}
