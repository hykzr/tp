package seedu.interntrack;

import java.util.ArrayList;

/**
 * Manages the list of internship applications.
 */
public class ApplicationList {

    /**
     * Adds a new application parsed from the given input line to the list.
     *
     * @param userApplications The list to add the application to.
     * @param line             The raw input string containing application details.
     * @return The newly created Application object.
     * @throws InternTrackException If the input is missing required fields or has an invalid date.
     */
    public static Application addApplications(ArrayList<Application> userApplications,
            String line) throws InternTrackException {
        Application newApplication = Parser.createApplication(line);
        userApplications.add(newApplication);
        return newApplication;
    }
}
