package com.morrisje.console;

import com.morrisje.Game;
import com.morrisje.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess  {

    // ==Fields==

    private final Game game;
    private final MessageGenerator messageGenerator;

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // ==Events==
    @EventListener(ContextRefreshedEvent.class)
    //Event listiner must be in this section
    public void start() {
        log.info("start --> Container ready for use!!!!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("PLay Again y/n?");
                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }

        }
    }
}
