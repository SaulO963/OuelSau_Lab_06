/**
 * Version of Orchestra that uses an ArrayList
 */
package Lab;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * GenOrchestra class keeps track of an ArrayList of Instrument objects
 */
public class GenOrchestra {

    private ArrayList<Instrument> instruments;

    /**
     * GenOrchestra constructor initializes its ArrayList with a size of 1
     */
    public GenOrchestra(){
        this.instruments = new ArrayList<Instrument>(1);
    }

    /**
     * method adds an instrument object to instruments ArrayList
     * @param instrument supplies method with instrument object
     */
    public void addInstrument(Instrument instrument){
        instruments.add(instrument); //ArrayLists take care of resizing themselves.
    }

    /**
     * method removes an instrument object from instruments ArrayList
     * @param instrument supplies instrument to find and remove
     */
    public void removeInstrument(Instrument instrument){
        instruments.remove(instrument);
    }

    /**
     * method supplies an iterator going over instruments ArrayList - private as to
     * not be accessible by main.
     * @return returns iterator pointing to first object in instruments ArrayList
     */
    private Iterator<Instrument> iterator(){
        return instruments.iterator();
    }

    /**
     * method uses iterator to go through all instruments object in ArrayList and call
     * their play() methods.
     */
    public void playAll(){
        Iterator<Instrument> iterator = this.iterator();
        while(iterator.hasNext()){
            Instrument i = iterator.next();
            i.play();
        }
    }

    /**
     * method uses iterator to go through all instruments object in ArrayList and tunes all
     * instruments to given note
     * @param c supplies note to tune all the instruments with
     */
    public void tuneAll(char c){
        Iterator<Instrument> iterator = this.iterator();
        while(iterator.hasNext()){
            Instrument i = iterator.next();
            i.tune(c);
        }
    }




}
