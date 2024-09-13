/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Nathan Eppler
 * Last Updated: 9/13/24
 */
package epplern;

import java.util.Random;

/**
 *The Die class creates a die that can have 2-100 sides
 * The die can be rolled, and the current/last rolled value of the die can be obtained by
 * the getCurrentValue() method.
 */
public class Die {
    final static int MIN_SIDES = 2;
    final public static int MAX_SIDES = 100;
    final public static int MIN_NUMBER = 1;
    private int currentValue;
    private int numSides;
    private Random random = new Random();

    /**
     * The Die constructor takes in # of sides for the given dice
     * if the # of sides is > 100 or < 2 then it will throw and exception
     * otherwise, it will set the number of sides on the die
     * @param numSides the number of sides on the dice
     * @throws IllegalArgumentException thrown if too many sides or less than 2 sides
     */
    public Die(int numSides) throws IllegalArgumentException {
        if (numSides > MAX_SIDES || numSides < MIN_SIDES) {
            throw new IllegalArgumentException("Invalid number of sides.");
        } else {
            this.numSides = numSides;
        }
    }

    /**
     * getCurrentValue() returns the value of the last roll, resetting current value to zero
     * @return currentValue returns the last rolled value of the die
     * and resets current value to zero
     * @throws DieNotRolledException thrown if the current value is not in the range
     * of possible values
     */
    public int getCurrentValue() throws DieNotRolledException {
        if (currentValue > MAX_SIDES || currentValue < MIN_NUMBER) {
            throw new DieNotRolledException("Die not rolled");
        } else {
            int temp = currentValue;
            currentValue = 0;
            return temp;
        }
    }

    /**
     * roll() sets currentValue to a random integer in the range of 1 to the number
     * of sides on the die
     */
    public void roll() {
        currentValue = random.nextInt(1, numSides + 1);
    }

}