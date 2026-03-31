package seedu.interntrack;

import java.time.LocalDate;

/**
 * Represents the set of optional field updates supplied in an edit command.
 */
public class EditDetails {
    private final String company;
    private final String role;
    private final LocalDate deadline;
    private final String contact;
    private final String status;

    /**
     * Creates a new edit payload with zero or more updated fields.
     *
     * @param company  Updated company name, or null if unchanged.
     * @param role     Updated role name, or null if unchanged.
     * @param deadline Updated deadline, or null if unchanged.
     * @param contact  Updated contact, or null if unchanged.
     * @param status   Updated status, or null if unchanged.
     */
    public EditDetails(String company, String role, LocalDate deadline, String contact, String status) {
        this.company = company;
        this.role = role;
        this.deadline = deadline;
        this.contact = contact;
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getContact() {
        return contact;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Returns true if at least one field is being updated.
     *
     * @return Whether this edit payload contains any updates.
     */
    public boolean hasUpdates() {
        return company != null || role != null || deadline != null || contact != null || status != null;
    }
}
