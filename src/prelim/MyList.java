/**
 * Name: Lawrence T. Miguel II
 * Date: 8/25/2022
 *
 */
package prelim;

import java.util.NoSuchElementException;
public interface MyList<E> {
    /**
     * Method for returning the size of the list
     *
     * @return number of data in the list
     */
    public int getSize();
    /**
     * Method for inserting data in the list
     *
     * @param data data to insert in the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    public void insert (E data) throws ListOverflowException;
    /**
     * Method for getting the element of the specified data
     *
     * @param data data to get in the list
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    public E getElement(E data) throws NoSuchElementException;
    /**
     * Method for deleting the specified data in the list if it exists
     *
     * @param data data to delete
     * @return boolean if data was deleted
     */
    public boolean delete(E data); // returns false if the data is not deleted in the list
    /**
     * Method for checking if there is an element of E data
     *
     * @param data data to search in the list
     * @return index of the data if in the list else -1
     */
    public int search(E data); // returns index of data, else -1 is return

}
