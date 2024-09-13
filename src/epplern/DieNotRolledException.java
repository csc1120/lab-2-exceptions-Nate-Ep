/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Nathan Eppler
 * Last Updated: 9/13/24
 */
package epplern;

public class DieNotRolledException extends Exception  {
    public DieNotRolledException(String message) {
        super(message);
    }
    public DieNotRolledException(String message, Throwable cause) {
        super(message, cause);
    }
}
