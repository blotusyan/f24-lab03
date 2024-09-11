package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public abstract class SortedIntList extends AbstractIntList {
    protected int listSize = 0;
    protected List<Integer> myList = new ArrayList<>();

    // Write your implementation below with API documentation
    /**
     * Adds the specified int to the list.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    public abstract boolean add(int num);

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index){
        if (index < 0 || index >= listSize){
            System.out.println("This is out of bound");
            return -1;
        }
        return myList.get(index);
    }

    /**
     * Returns the number of elements in this list. If this list contains
     * more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return number of elements in the list
     */
    @Override
    public int size(){
        return this.listSize;
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present (optional operation).
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num){
        boolean removed = false;
        for (int i = 0; i < this.listSize; i++){
            if (myList.get(i) == num){
                myList.remove(i);
                removed = true;
                this.listSize--;
                break;
            }
        }
        return removed;
    }


    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from
     * the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list){
        this.listSize = 0;
        myList = new ArrayList<>();
        return true;
    }

}