package seedu.interntrack;

/**
 * Represents an exception specific to the InternTrack application.
 */
public class InternTrackException extends Exception {

    /**
     * Constructs an InternTrackException with the specified detail message.
     *
     * @param message The detail message describing the error.
     */
    public InternTrackException(String message) {
        super(message);
    }
}
