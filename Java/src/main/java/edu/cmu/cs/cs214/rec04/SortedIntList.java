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

public class SortedIntList extends AbstractIntList {

    // Write your implementation below with API documentation
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
        return added;
    }


    /**
     * Adds all of the elements of the IntegerList to the list.
     * Calls add() on each element of list. Can be overwritten
     * for more specific behavior.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list){
        boolean success = false;

        for (int i = 0; i < list.size(); i++)
        {
            success |= this.add(list.get(i));
        }

        return success;
    }



    

}