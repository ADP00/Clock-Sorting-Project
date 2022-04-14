/**
 * 
 * @author Alex Perinetti 
 * A class that holds the hour, minute, and second values of a given time.
 */
public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    /**
     * The constructor that accepts the values of hours, minutes, and seconds.
     * @param h Number of hours
     * @param m Number of minutes
     * @param s Number of seconds
     */
    public Clock (int h, int m, int s) {
        if (h > 23 || m > 59 || s > 59)
            throw new IllegalClockException();
        hours = h;
        minutes = m;
        seconds = s;
    }
    /**
     * Sets the desired hours value.
     * @param h Number of hours
     */
    public void setHours (int h) {
        hours = h;
    }
    /**
     * Gets the current value of hours.
     * @return Current value of hours
     */
    public int getHours () {
        return hours;
    }
    /**
     * Sets the desired value of minutes.
     * @param m Number of minutes
     */
    public void setMinutes (int m) {
        minutes = m;
    }
    /**
     * Gets the current value of minutes.
     * @return Current value of minutes
     */
    public int getMinutes () {
        return minutes;
    }
    /**
     * Sets the desired value of seconds.
     * @param s Number of seconds
     */
    public void setSeconds (int s) {
        seconds = s;
    }
    /**
     * Gets the current value of seconds.
     * @return Current values of seconds
     */
    public int getSeconds () {
        return seconds;
    }
    /**
     * Converts the values of hours, minutes, and seconds
     * into a readable format.
     * @return Readable format of the data as a String
     */
    public String toString () {
        String h = Integer.toString(hours);
        String m = Integer.toString(minutes);
        String s = Integer.toString(seconds);
        if (hours < 10)
            h = "0" + h;
        if (minutes < 10)
            m = "0" + m;
        if (seconds < 10)
            s = "0" + s;
        return h + ":" + m + ":" + s;
    }
    /**
     * Compares one Clock to another
     * @param other Clock object
     * @return integer value based on whether the first Clock is greater, lesser, or equal to the second.
     */
    public int compareTo(Clock other) {
        if (this.getHours() > other.getHours())
            return 1;
        else if (this.getHours() < other.getHours())
            return -1;
        else {
            if (this.getMinutes() > other.getMinutes())
                return 1;
            else if (this.getMinutes() < other.getMinutes())
                return -1;
            else {
                if (this.getSeconds() > other.getSeconds())
                    return 1;
                else if (this.getSeconds() < other.getSeconds())
                    return -1;
                else
                    return 0;
            }
        }
    }
}
