import { SortedIntList } from './hidden/SortedIntListLibrary.js'
import { IntegerList } from './IntegerList.js'
/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
class InheritanceSortedIntList extends SortedIntList {
  private totalAdded: number = 0;

  constructor() {
      super();
  }

  /**
   * Adds the specified int to the list.
   * @param num an integer to be added to the list
   * @return true if the list is changed as a result of the call
   */
  public add(num: number): boolean {
      this.totalAdded++;
      return super.add(num);
  }

  /**
   * Adds all of the elements of the IntegerList to the list.
   * Calls add() on each element of list. Can be overwritten
   * for more specific behavior.
   * @param list IntegerList containing elements to be added to the list
   * @return true if the list changed as a result of the call
   */
  // public addAll(list: IntegerList): boolean {
  //     let success = false;
  //     for (let i = 0; i < list.size(); i++) {
  //         success &&= this.add(list.get(i));
  //     }
  //     return success;
  // }
  public addAll(list: IntegerList): boolean {
    let success = false;
    for (let i = 0; i < list.size(); i++) {
        if (this.add(list.get(i))) {
            success = true;
        }
    }
    return success;
}

  /**
   * Returns the total number of attempted element insertions.
   * @return the total number of additions
   */
  public getTotalAdded(): number {
      return this.totalAdded;
  }
}

export { InheritanceSortedIntList }
