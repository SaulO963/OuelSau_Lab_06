/**
 * Refer to Main
 */
package Lab;

/**
 * Tuba instrument class
 */
public class Tuba implements Instrument{

    private String song;
    private char tune;
    private int oompas;

    /**
     * tuba Constructor
     * @param song supplies constructor with song String
     * @param oompas supplies constructor with amount of oompas to be played after song
     */
    public Tuba(String song, int oompas){
        this.song = song;
        this.oompas = oompas;
    }

    /**
     * song Getter - prints which song the Tuba was constructed with and prints
     * the given number of oompas afterwards
     */
    @Override
    public void play() {
        System.out.println("Tuba is playing " + this.song);
        for(int i = 0; i<oompas;i++){
            System.out.print("Oom pa pa ~ ");
        }
        System.out.println("");
    }

    /**
     * tune Setter - sets which note the Tuba should be tuned to
     * @param note supplies expected note to function
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuning Tuba to note " + note);
        this.tune = note;
    }
}