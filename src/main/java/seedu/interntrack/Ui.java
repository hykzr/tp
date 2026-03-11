package seedu.interntrack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the user interface for handling input and output.
 */
public class Ui {
    private static final String BORDER = "____________________________________________________________\n";
    private static final String GOODBYE_MESSAGE = BORDER
            + " Bye. Hope to see you again soon!\n"
            + BORDER;
    private static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command. Please try again.";

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads a line of user input from the console.
     *
     * @return The user input as a string.
     */
    public static String readCommand() {
        return scanner.nextLine(); // Used here to return the string
    }

    /**
     * Prints a horizontal border to the console.
     */
    public static void printBorder() {
        System.out.print(BORDER);
    }

    /**
     * Prints the goodbye message to the console.
     */
    public static void printGoodbye() {
        System.out.print(GOODBYE_MESSAGE);
    }

    /**
     * Prints the welcome message to the console.
     */
    public static void printWelcome() {
        System.out.println(BORDER);
        System.out.println(" Hello! I'm InternTrack");
        System.out.println(" What can I do for you?");
        System.out.println(BORDER);
    }
    /**
     * Prints a confirmation message when a new application is added.
     *
     * @param newApplication The application that was added.
     * @param userApplications The current list used to retrieve the total count.
     */
    public static void printAddApplication(Application newApplication, ArrayList<Application> userApplications) {
        System.out.println("Got it. I've added this application:");
        System.out.println("  " + newApplication.toString());
        System.out.println("Now you have " + userApplications.size() + " applications in the list.");
    }

    /**
     * Prints an error message when an unrecognised command is entered.
     */
    public static void printUnknownCommand() {
        System.out.println(UNKNOWN_COMMAND_MESSAGE);
    }
}
