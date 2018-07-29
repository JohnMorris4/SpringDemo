package com.morrisje;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jmorris on 7/28/18
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);



    public static void main(String[] args) {
        log.info("Guess the number game");

//        Create the context
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

//        Call method next()
        int number = numberGenerator.next();

//        Log generated number
        log.info("number = {}", number);

        //get game bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("getMainMessage >>> {}", messageGenerator.getMainMessage());
        log.info("getResultMessage >>> {}", messageGenerator.getResultMessage());
//        Close context
        context.close();

    }
}
