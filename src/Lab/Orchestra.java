/**
 * Version of Orchestra that uses a regular array
 */
package Lab;

import java.util.Iterator;

/**
 * Orchestra class keeps an array of Instrument objects, uses a nested InnerIterator class
 * through its elements
 */
public class Orchestra {

    private int MAXSIZE;
    private int sizeIndex;
    private Instrument[] instruments;
    private int modCount;

    /**
     * Orchestra Constructor - sets a beginning MAXSIZE, sizeIndex (amount of instruments),
     * Instrument array, modCount for InnerIterator
     */
    public Orchestra(){
        MAXSIZE = 4;
        sizeIndex = 0;
        instruments = new Instrument[MAXSIZE];
        modCount = 0;
    }

    /**
     * Method adds instrument to instruments array, will increase capacity of array by
     * 50% if we don't have any more nulls in array (aka array is full)
     * @param instrument supplies instrument object to method
     */
    public void addInstrument(Instrument instrument){
        //check if full first
        for(int i = 0; i < instruments.length; i++){
            if(instruments[i] == null){         //if we find a null, there is room
                instruments[i] = instrument;
                sizeIndex++;
                modCount++;
                return; //we still have room somewhere, no need to resize, finish here.
            }
        }
        //if we arrive here, instrument had no room to fit in... resize
        this.MAXSIZE = (int)(MAXSIZE*1.5); //increase capacity by 50%
        System.out.println("Resizing to MAXSIZE: " + this.MAXSIZE);
        Instrument[] newInstruments = new Instrument[MAXSIZE];

        for(int i = 0; i < instruments.length; i++){ //fill new array with old instruments
            newInstruments[i] = this.instruments[i];
        }

        for(int i = 0; i < newInstruments.length; i++) {  //add our new instrument at end
            if (newInstruments[i] == null) {
                newInstruments[i] = instrument;
                sizeIndex++;
                modCount++;
                this.instruments = newInstruments; //finalize by making new array our object's final array
                return;
            }
        }
    }

    /**
     * Method removes instrument from instruments array, uses InnerIterator class to go through
     * objects in array
     * @param instrument supplies instrument object to try and remove from instruments array
     */
    public void removeInstrument(Instrument instrument){
        for(int i = 0; i < sizeIndex; i++){
            if(instruments[i] == instrument){
                //Instrument found! Let's get rid of it
                InnerIterator iterator = new InnerIterator(); //create InnerIterator
                while(iterator.hasNext()){                  //go through all objects
                    if(iterator.next() == instrument){      //when you find it...
                        System.out.println("Instrument found, removing...");
                        iterator.remove();
                        return;
                    }
                }
            }
        }
    }

    /**
     * method uses InnerIterator to call play method from all objects in array
     */
    public void playAll(){
        InnerIterator iterator = new InnerIterator();
        while(iterator.hasNext()){
            Instrument i = (Instrument) iterator.next();
            i.play();
        }
    }

    /**
     * method uses InnerIterator to tune all the objects to a given note
     * @param c supplies note to method
     */
    public void tuneAll(char c){
        InnerIterator iterator = new InnerIterator();
        while(iterator.hasNext()){
            Instrument i = (Instrument) iterator.next();
            i.tune(c);
        }
    }

    /**
     * Nested class to iterate through objects in instruments array
     */
    private class InnerIterator implements Iterator {

        private int curPos, expectedModCount;

        /**
         * private constructor that initializes curPos and our expectedModCount
         */
        private InnerIterator(){
            curPos = 0;
            expectedModCount = modCount;
        }

        /**
         * determines if we have an object next to our current position
         * (aka if we've hit the end of the array or not)
         * @return returns boolean to say if there's object to our right
         */
        @Override
        public boolean hasNext() {
            return curPos < sizeIndex;
        }

        /**
         * returns our next object in line of our array. Will throw an exception if
         * our modCount != expectedModCount (i.e. if instruments array was modified with something
         * besides our iterator) and if there is no next object
         * @return returns instrument object
         */
        @Override
        public Object next() {
            //If modification have been made while iterating throw ex.
            try {
                if (modCount != expectedModCount)
                    throw new Exception("modCount != expectedModCount");
            } catch (Exception e) {
                e.printStackTrace();
            }
            // If there are no more elements in the array throw ex.
            try {
                if (!hasNext())
                    throw new Exception("!hasNext()");
            } catch (Exception e) {
                e.printStackTrace();
            }
            curPos++; 		// increment curPos for next time
            return instruments[curPos-1];  // return the next item

        }

        /**
         * method removes our lastest next() accessed iterator by "shifting" all the items to
         * the right of object to the left by one, then sets last copied object to null to
         * erase the last duplicate.
         */
        @Override
        public void remove(){
            while(hasNext()){
                instruments[curPos-1] = (Instrument) next(); //Copy over curPos instrument with the next instrument
            }
            instruments[curPos-1] = null; //when it doesnt have next, we've reached the end, get rid of last copy
            sizeIndex--;
            modCount--;
        }

    }

}
