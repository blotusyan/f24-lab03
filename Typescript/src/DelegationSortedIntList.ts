import { SortedIntList } from './hidden/SortedIntListLibrary.js'
import { IntegerList } from './IntegerList.js'
/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
class DelegationSortedIntList implements IntegerList {
  private mySortedIntList: SortedIntList = new SortedIntList();
  private totalAdded: number = 0;

  /**
   * Adds the specified number to the list.
   * @param num a number to be added to the list
   * @return true if the list is changed as a result of the call
   */
  public add(num: number): boolean {
      this.totalAdded++;
      return this.mySortedIntList.add(num);
  }

  /**
   * Adds all of the elements from another IntegerList to the list.
   * @param list IntegerList containing elements to be added
   * @return true if the list changed as a result of the call
   */
  public addAll(list: IntegerList): boolean {
      this.totalAdded += list.size();
      return this.mySortedIntList.addAll(list);
  }

  /**
   * Returns the element at the specified position in the list.
   * @param index index of the element to return
   * @return the element at the specified position in the list
   */
  public get(index: number): number {
      return this.mySortedIntList.get(index);
  }

  /**
   * Removes the first occurrence of the specified element from the list.
   * @param num a number to be removed from the list, if present
   * @return true if an element was removed as a result of this call
   */
  public remove(num: number): boolean {
      return this.mySortedIntList.remove(num);
  }

  /**
   * Removes all elements that are present in the specified IntegerList.
   * @param list IntegerList containing elements to be removed
   * @return true if the list changed as a result of the call
   */
  public removeAll(list: IntegerList): boolean {
      return this.mySortedIntList.removeAll(list);
  }

  /**
   * Returns the number of elements in the list.
   * @return the number of elements in the list
   */
  public size(): number {
      return this.mySortedIntList.size();
  }

  /**
   * Returns the total number of attempted insertions.
   * @return the total number of added elements
   */
  public getTotalAdded(): number {
      return this.totalAdded;
  }
}


export { DelegationSortedIntList }
