package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded = 0;
    
    public InheritanceSortedIntList(){

    }
    /**
     * Adds the specified int to the list.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num){
        Boolean added = false;
        for (int i = 0; i < this.myList.size(); i++){
            if (num <= myList.get(i)){
                myList.add(i, num);
                added = true;
                break;
            }
        }
        if (!added){
            myList.add(num);
            added = true;
        }
        this.listSize++;
        this.totalAdded++;
        return added;
    }

    /**
     * Adds the specified int to the list.
     *
     * @return true if the list is changed as a result of the call
     */
    public int getTotalAdded(){
        return this.totalAdded;
    }
}