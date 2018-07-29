package com.morrisje;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by jmorris on 7/29/18
 */
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @PostConstruct
    public void init() {
        log.info("game = {}", game );
    }
    @Override
    public String getMainMessage() {
        return "getMainMessage called";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage called";
    }
}
