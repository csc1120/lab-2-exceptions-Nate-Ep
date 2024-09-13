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
public class DieNotRolledException extends Exception {
    /**
     * This is the constructor for the exception
     * @param message the message the exception should give
     */
    public DieNotRolledException(String message) {
        super(message);
    }

    /**
     * This is another construstor for the exception that allows you to add a cause
     * @param message the message for the exception
     * @param cause the cause of the exception
     */
    public DieNotRolledException(String message, Throwable cause) {
        super(message, cause);
    }
}
