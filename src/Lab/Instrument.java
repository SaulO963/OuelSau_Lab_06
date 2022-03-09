/**
 * Refer to Main
 */
package Lab;

/**
 * Interface for Instrument objects
 */
public interface Instrument {

    /**
     * blueprint for play method
     */
    public void play();

    /**
     * blue print for tune method
     * @param note supplies expected note to function
     */
    public void tune(char note);

}