package com.morrisje;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Slf4j
@Getter
@Component
public class GameImpl implements Game{

//    == fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;
// == LomBok Setters
    @Setter
    private int guess;

    // == init methods ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @PreDestroy
    public void preDestroy(){
        log.info("PreDestroy in GAME");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {

            if(guess > number) {
                biggest = guess -1;
            }
            if(guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    //Private Methods

    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
