/**
 * Refer to Main
 */
package Lab;

/**
 * Viola instrument class
 */
public class Viola implements Instrument{

    private String song;
    private char tune;

    /**
     * Constructor
     * @param song supplies song String to constructor
     */
    public Viola(String song){
        this.song = song;
    }

    /**
     * song Getter - Prints which song the Viola was constructed with
     */
    @Override
    public void play() {
        System.out.println("Viola is playing " + this.song);
    }

    /**
     * tune Setter - sets which note the Viola should be tuned to
     * @param note supplies expected note to function
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuning Viola to note " + note);
        this.tune = note;
    }
}