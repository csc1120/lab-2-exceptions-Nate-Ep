/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Nathan Eppler
 * Last Updated: 9/13/24
 */
package epplern;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is the driver for the dice program.
 * This program will ask the user how many dice to roll, the number of times they should be rolled,
 * and how many sides they should have.
 * The program then outputs this information in the form of a graph.
 * The graph shows the frequency of each number rolled.
 */
public class Driver {

    public static void main(String[] args) throws DieNotRolledException {
        int[] input = getInput();
        Die[] die = createDice(input[0], input[1]);
        int[] frequency = rollDice(die, input[1], input[2]);
        int max = findMax(frequency);
        report(die.length, frequency, max);
    }

    /**
     * The get input method gets the input from the user.
     * It gets the number of dice to roll, the number of sides, and how many rolls to do
     * @return int[] this returns an array of integers in the order [# dice to roll, # sides,
     * #rolls to do]
     */
    private static int[] getInput() {
        String userInput;
        Scanner scnr = new Scanner(System.in);
        int[] values = new int[3];
        int numValues = 0;
        System.out.print("""
                Please enter the number of dice to roll, how many sides the dice have,
                and how many rolls to complete, separating the values by a space.
                Example: "2 6 1000"
                
                Enter configuration:""");

        userInput = scnr.nextLine();
        Scanner getInts = new Scanner(userInput);

        try {
            for (int i = 0; i < 3; ++i) {
                values[i] = getInts.nextInt();
                ++numValues;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input: Expected 3 values but only received " + numValues);
            //if invalid input, try again by recalling the method.
            getInput();
        }
        getInts.close();
        scnr.close();
        return values;
    }

    /**
     * The create dice method creates dice objects for each dice that is to be rolled.
     * @param numDice the number of Die objects to create
     * @param numSides the number of sides each individual object will have
     * @return Die[] returns an array of all of the Die objects created
     * @throws IllegalArgumentException thrown exception if a Die is created with bad input
     */
    private static Die[] createDice(int numDice, int numSides) throws IllegalArgumentException {
        Die[] die = new Die[numDice];

        for (int i = 0; i < numDice; ++i) {
            die[i] = new Die(numSides);
        }
        return die;
    }

    /**
     * rollDice is the method used to roll each dice in the Die[] dice array.
     * This method then calculates and returns in an int[] the frequency of each total.
     * @param dice all the Die objects created in an array
     * @param numSides the number of sides each dice has
     * @param numRolls the number of rolls to complete
     * @return int[] the frequency of each total when a roll in complete
     * @throws DieNotRolledException thrown if attempting to get the current value of a die
     * that hasn't been rolled yet
     */
    private static int[] rollDice(Die[] dice, int numSides, int numRolls)
            throws DieNotRolledException {
        //Stores frequency for each side that is rolled
        /*
        Index: 0 1 2 3 4 5 6 7...
        Value: 2 3 4 5 6 7 8 9...
         */
        int sum = 0;
        //frequency has as many elements as the number of sides * number of dice - number of dice
        //This should have the array start at the min number of a die roll and end at the max
        int[] frequency = new int[((numSides * dice.length) - dice.length) + 1];
        for (int i = 0; i < numRolls; ++i) {
            sum = 0;
            for (Die die : dice) {
                die.roll();
                sum += die.getCurrentValue();
            }
            //store frequency of each number starting at f[0] which is the lowest possible num
            //and ending at numSides*dice.length the highest possible num.
            frequency[sum - dice.length] += 1;

        }
        return frequency;
    }

    /**
     * finds what total was rolled the most frequent
     * @param rolls the frequency of each total
     * @return the most frequent total
     */
    private static int findMax(int[] rolls) {
        int max = 0;
        for (int i = 0; i < rolls.length; ++i) {
            if (max < rolls[i]) {
                max = rolls[i];
            }
        }
        return max;
    }

    /**
     * Displays the graph and the frequencies of each total.
     * @param numDice the total number of dice
     * @param rolls the frequency array for the rolls
     * @param max the most frequent number in the frequency array.
     */
    private static void report(int numDice, int[] rolls, int max) {
        double tenPercent = 0.1;
        int[] numRolled = new int[rolls.length];
        int minNum = numDice;

        for (int i = 0; i < numRolled.length; ++i) {
            numRolled[i] = minNum + i;
        }
        double scale = tenPercent * (double)max;
        double numStars;
        for (int i = 0; i < rolls.length; ++i) {

            System.out.printf("%-2d:%-9d", numRolled[i], rolls[i]);
            numStars = (double)rolls[i] / scale;
            for (int j = 0; j < (int)numStars; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


}