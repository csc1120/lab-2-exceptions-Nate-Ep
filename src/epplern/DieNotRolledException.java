/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Nathan Eppler
 * Last Updated: 9/13/24
 */
package epplern;

/**
 * This class creates an exception called DieNotRolledException
 * this is thrown if you try to get the current value of a die and it has not been rolled yet
 */
public class DieNotRolledException extends Exception  {
    public DieNotRolledException(String message) {
        super(message);
    }
    public DieNotRolledException(String message, Throwable cause) {
        super(message, cause);
    }
}
