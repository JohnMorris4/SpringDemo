package com.morrisje.config;

import com.morrisje.GuessCount;
import com.morrisje.MaxNumber;
import com.morrisje.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.morrisje")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
//    ===Fields==
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;
//     == Bean Methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
