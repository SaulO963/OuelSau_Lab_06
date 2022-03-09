/**
 * Refer to Main
 */
package Lab;

/**
 * Cello instrument class
 */
public class Cello implements Instrument{

    private String song;
    private char tune;

    /**
     * Constructor
     * @param song supplies song String to constructor
     */
    public Cello(String song){
        this.song = song;
    }

    /**
     * song Getter - Prints which song the Cello was constructed with
     */
    @Override
    public void play() {
        System.out.println("Cello is playing " + this.song);
    }

    /**
     * tune Setter - sets which note the Cello should be tuned to
     * @param note supplies expected note to function
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuning Cello to note " + note);
        this.tune = note;
    }
}