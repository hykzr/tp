package seedu.interntrack;

import java.util.ArrayList;

/**
 * Serves as the main entry point and command handler for InternTrack.
 */
public class InternTrack {
    private static final String ADD_COMMAND = "add";
    private static final String BYE_COMMAND = "bye";

    /**
     * Starts the InternTrack application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ArrayList<Application> userApplications = new ArrayList<>();
        Storage.loadApplications(userApplications);
        Ui.printWelcome();
        String line = Ui.readCommand();
        while (!line.equals(BYE_COMMAND)) {
            Ui.printBorder();
            handleCommand(line, userApplications);
            Ui.printBorder();
            line = Ui.readCommand();
        }
        Ui.printGoodbye();
    }

    /**
     * Dispatches the given command to the appropriate handler.
     *
     * @param line             The raw command string entered by the user.
     * @param userApplications The current list of applications.
     */
    private static void handleCommand(String line, ArrayList<Application> userApplications) {
        try {
            if (line.startsWith(ADD_COMMAND)) {
                Application newApplication = ApplicationList.addApplications(userApplications, line);
                Ui.printAddApplication(newApplication, userApplications);
                Storage.saveApplications(userApplications);
            } else {
                Ui.printUnknownCommand();
            }
        } catch (InternTrackException e) {
            System.out.println(e.getMessage());
        }
    }
}
