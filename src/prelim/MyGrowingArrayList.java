/**
 * Name: Lawrence T. Miguel II
 * Date: 8/25/2022*
 * Class Description:
 * An implementation of an Array List that has a variable sized max capacity and implements the MyList Interface
 */
package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyGrowingArrayList<E> implements MyList<E> {
    // Variable Initialization
    private E[] eArray; // The E array of the list
    private int limit = 5; // The current capacity of the e_array

    private int size = 0; // Number of elements currently in the list

    /**
     * Public Constructor for the MyGrowingArrayList
     * Initializes the e_array variable with a new E list of size limit 5
     * Then fills the array with null.
     */
    public MyGrowingArrayList() {
        eArray = (E[]) new Object[limit];
        Arrays.fill(eArray, null);
    }

    /**
     * Public Constructor for the MyGrowingArrayList
     * Sets the limit to the passed limit_size parameter
     * Initializes the e_array variable with a new E list of size limit
     * Then fills the array with null.
     */
    public MyGrowingArrayList(int limit_size) {
        limit = limit_size;
        eArray = (E[]) new Object[limit];
        Arrays.fill(eArray, null);
    }

    /**
     * Method for returning the size of the list
     *
     * @return number of data in the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Method for inserting data in the list
     * Algorithm:
     * 1. Check if size is equal to the limit
     *      1.1 If equal create a temporary array list of type E
     *      1.2 Copy the data of the current array of size double the current limit
     *      1.3 Insert the new data and increment the size
     *      1.4 Assign the temporary array list to e_array
     *      1.5 return
     * 2. Check if the size is equal the max Integer value
     *      2.1 Throw ListOverflowException
     * 3. Insert the data and increment the size
     *
     * @param data data to insert in the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    @Override
    public void insert(E data) throws ListOverflowException {
        if (size == limit) {
            E[] temporary_list = Arrays.copyOf(eArray, limit*=2);

            temporary_list[size++] = data;
            eArray = temporary_list;
            return;
        }
        if (limit == Integer.MAX_VALUE) throw new ListOverflowException("Inserting new data will exceed " +
                "defined maximum length: " + Integer.MAX_VALUE);
        eArray[size++] = data;
    }

    /**
     * Method for getting the element index of the specified data
     * Algorithm:
     * 1. Loop through the element array
     * 2. Compare each element if it's equal to the data to get
     * 3. Return the element if equal else throw NoSuchElementException
     *
     * @param data data to get in the list
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    @Override
    public E getElement(E data) throws NoSuchElementException {
        for (E e : eArray) if (e.equals(data)) return e;
        throw new NoSuchElementException(data.toString() + " not in list.");
    }

    /**
     * Method for deleting the specified data in the list if it exists
     * Algorithm:
     * 1. Loop through the element array
     * 2. Compare each element to the data to delete
     * 3. If element is equals move all the subsequent elements by one index to the left
     * 3.1 Set the element of index size-1 as null
     * 3.2 Subtract size by 1
     * 4. Return true if element was found and deleted else return false
     *
     * @param data data to delete
     * @return boolean if data was deleted
     */
    @Override
    public boolean delete(E data) {
        for (int i = 0; i < size; i++) {
            if (eArray[i].equals(data)) {
                if (eArray.length - 1 - i >= 0) System.arraycopy(eArray, i + 1, eArray, i, eArray.length - 1 - i);
                eArray[size-=1] = null;

                return true;
            }
        }
        return false;
    }

    /**
     * Method for checking if there is an element of E data
     * Algorithm:
     * 1. Loop through the element array
     * 2. First check if the array at the index of the loop is not null
     * 3. Check if the data is equal to the current element
     * 4. Return the index if it's equal else return -1
     *
     * @param data data to search in the list
     * @return index of the data if in the list else -1
     */
    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            if (eArray[i] != null) {
                if (eArray[i].equals(data)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Method for showing the elements of the List
     * Algorithm:
     * 1. Iterate through the list
     * 2. Output each element by calling its toString function
     */
    public void showData() {
        System.out.println("----------------------------");
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "] " + eArray[i].toString() + ", ");
        }
        System.out.println("----------------------------");
    }
}

