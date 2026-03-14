package seedu.interntrack;

import java.util.ArrayList;

/**
 * Serves as the main entry point and command handler for InternTrack.
 */
public class InternTrack {

    private static final String ADD_COMMAND = "add";
    private static final String BYE_COMMAND = "bye";
    private static final String EDIT_COMMAND = "edit";
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
     * @param line The raw command string entered by the user.
     * @param userApplications The current list of applications.
     */
    private static void handleCommand(String line, ArrayList<Application> userApplications) {
        try {
            if (line.startsWith(ADD_COMMAND)) {
                Application newApplication = ApplicationList.addApplications(userApplications, line);
                Ui.printAddApplication(newApplication, userApplications);
                Storage.saveApplications(userApplications);
            } else if (line.startsWith(EDIT_COMMAND)) {
                handleEditCommand(line, userApplications);
            } else {
                Ui.printUnknownCommand();
            }
        } catch (InternTrackException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the edit command by updating an application's status.
     *
     * @param line The raw command string entered by the user.
     * @param userApplications The current list of applications.
     * @throws InternTrackException If the command format or index is invalid.
     */
    private static void handleEditCommand(String line, ArrayList<Application> userApplications)
            throws InternTrackException {
        int index = Parser.parseEditIndex(line);
        String status = Parser.parseEditStatus(line);
        Application updatedApplication = ApplicationList.editApplicationStatus(userApplications, index, status);
        Ui.printEditApplication(updatedApplication, index);
        Storage.saveApplications(userApplications);
    }
}
