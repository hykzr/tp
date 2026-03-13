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
    /**
     * Edits the status of an existing application.
     *
     * @param userApplications The list containing the application.
     * @param index The 1-based index of the application to edit.
     * @param status The new status value.
     * @return The updated Application object.
     * @throws InternTrackException If the index is invalid.
     */
    public static Application editApplicationStatus(ArrayList<Application> userApplications,
                                                    int index, String status) throws InternTrackException {
        if (index < 1 || index > userApplications.size()) {
            throw new InternTrackException("Application index is out of range.");
        }

        Application application = userApplications.get(index - 1);
        application.setStatus(status);
        return application;
    }
}
