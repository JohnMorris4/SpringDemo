package com.morrisje;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jmorris on 7/29/18
 */
@Configuration
@ComponentScan(basePackages = "com.morrisje")
public class AppConfig {
//    == BEAN METHODS ==
    @Bean
    public NumberGenerator numberGenerator () {
        return new NumberGeneratorImpl();

    }
    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }

}
