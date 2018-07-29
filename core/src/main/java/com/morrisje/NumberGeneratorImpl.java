package com.morrisje;

import java.util.Random;

/**
 * Created by jmorris on 7/28/18
 */

public class NumberGeneratorImpl implements NumberGenerator {

    // == Fields ==
    private final Random random = new Random();

    private int maxNumber = 100;

    // == Public Methods ==

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
