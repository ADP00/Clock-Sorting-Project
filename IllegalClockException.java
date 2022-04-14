/**
 * 
 * @author Alex Perinetti
 * Exception for when clock values are incorrect.
 */
public class IllegalClockException extends IllegalArgumentException {
    /**
     * Invokes super class's constructor.
     */
    public IllegalClockException () {
        super("The hour, minute, or second value is invalid.");
    }
}
