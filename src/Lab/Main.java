/**
 * Name: Saul Ouellet
 * Date: Mar 8th 2022
 * Description: Program implements an Instrument interface, then 4 instrument classes that use the interface,
 * one of which is anonymous (trumpet class in main). Implements two types of Orchestras, one of which uses
 * a regular array + a nested InnerIterator class and one that uses an ArrayList + iterator to go through their
 * compilations of instruments.
 */

package Lab;

/**
 * Main class; implements an anonymous trumpet class, identical to other instruments but added
 * an extra song setter
 */
public class Main {

    /**
     * It's a main, what else is there to say?
     * @param args supplies args to main
     */
    public static void main(String[] args){

        Instrument trumpet = new Instrument(){      //creates an anonymous trumpet
            private String song = "Howdy 1";
            private char tune;

            public void setSong(String song){
                this.song = song;
            }

            @Override
            public void play() {
                System.out.println("Trumpet is playing " + this.song);
            }

            @Override
            public void tune(char note) {
                System.out.println("Tuning Trumpet to note " + note);
                this.tune = note;
            }
        };

        Orchestra o1 = new Orchestra();
        GenOrchestra o2 = new GenOrchestra();

        Cello c1 = new Cello("Hello 1");
        Viola v1 = new Viola("Hi 1");
        Cello c2 = new Cello("Hello 2");
        Viola v2 = new Viola("Hi 2");
        Cello c3 = new Cello("Hello 3");
        Viola v3 = new Viola("Hi 3");
        Tuba t1 = new Tuba("Bonjour 1", 1);
        Tuba t2 = new Tuba("Bonjour 2", 2);
        Tuba t3 = new Tuba("Bonjour 3", 3);
        Cello x = new Cello("Old Town Road");

        System.out.println("=========== Regular Array Orchestra Tests ===========");
        System.out.println("Added Pattern of Cellos and Violas");

        o1.addInstrument(c1);
        o1.addInstrument(v1);
        o1.addInstrument(c2);
        o1.addInstrument(v2);
        o1.addInstrument(c3);
        o1.addInstrument(v3);

        o1.playAll();

        System.out.println("\nRemoving First Instrument");

        o1.removeInstrument(c1);

        o1.playAll();

        System.out.println("\nRemoving Last Instrument");

        o1.removeInstrument(v3);

        o1.playAll();

        System.out.println("\nRemoving Middle Instrument");

        o1.removeInstrument(v2);

        o1.playAll();

        System.out.println("\nAdding Tubas and an anonymous Trumpet");

        o1.addInstrument(t1);
        o1.addInstrument(t2);
        o1.addInstrument(t3);
        o1.addInstrument(trumpet);

        o1.playAll();

        System.out.println("\n=========== ArrayList Orchestra Tests ===========");
        System.out.println("Added Pattern of Cellos and Violas");

        o2.addInstrument(c1);
        o2.addInstrument(v1);
        o2.addInstrument(c2);
        o2.addInstrument(v2);
        o2.addInstrument(c3);
        o2.addInstrument(v3);

        o2.playAll();

        System.out.println("\nRemoving First Instrument");

        o2.removeInstrument(c1);

        o2.playAll();

        System.out.println("\nRemoving Last Instrument");

        o2.removeInstrument(v3);

        o2.playAll();

        System.out.println("\nRemoving Middle Instrument");

        o2.removeInstrument(v2);

        o2.playAll();

        System.out.println("\nAdding Tubas and an anonymous Trumpet");

        o2.addInstrument(t1);
        o2.addInstrument(t2);
        o2.addInstrument(t3);
        o2.addInstrument(trumpet);

        o2.playAll();

    }

}