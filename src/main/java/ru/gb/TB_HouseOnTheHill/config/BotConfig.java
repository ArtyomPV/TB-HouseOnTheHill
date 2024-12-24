package ru.gb.TB_HouseOnTheHill.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.yml")
@Getter
public class BotConfig {
    @Value("${bot.name}")
    String botName;
    @Value(("${bot.token}"))
    String token;

}
