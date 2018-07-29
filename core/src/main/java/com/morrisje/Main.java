package com.morrisje;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jmorris on 7/28/18
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

//        Create the context
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

//        Call method next()
        int number = numberGenerator.next();

//        Log generated number
        log.info("number = {}", number);

        //get game bean
        Game game = context.getBean(Game.class);

//        // Call reset method
//        game.reset();

//        Close context
        context.close();

    }
}
