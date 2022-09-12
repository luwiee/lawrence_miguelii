/**
 * Name: Lawrence T. Miguel II
 * Date: 8/25/2022
 * Class Description:
 * An implementation of an Array List that has a fixed max capacity and implements the MyList Interface
 */

package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<E> implements MyList<E> {

    // Variable Initialization
    private final E[] eArray; // The E array of the list
    public int maxCapacity = 5; // Constant for max amount of elements in the list
    private int size = 0; // Number of elements currently in the list

    /**
     * Public Constructor for the MyFixedArrayList
     * Initializes the e_array variable with a new E list of size MAX_CAPACITY (5)
     * Then fills the array with null.
     */
    public MyFixedSizeArrayList() {
        eArray = (E[]) new Object[maxCapacity];
        Arrays.fill(eArray, null);
    }

    /**
     * Public Constructor for the MyFixedArrayList
     * Initializes the e_array variable with a new E list of size max_capacity variable
     * Then fills the array with null.
     *
     */
    public MyFixedSizeArrayList(int max_capacity) {
        maxCapacity = max_capacity;
        eArray = (E[]) new Object[maxCapacity];

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
     * 1. Check if the list is MAX_CAPACITY
     * 1.1 Throw ListOverflowException if the list will be overloaded
     * 2. Increase the size by 1
     * 3. Insert the data at e_array index size
     *
     * @param data data to insert in the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */

    @Override
    public void insert(E data) throws ListOverflowException {
        if (size == maxCapacity)
            throw new ListOverflowException("Inserting new data will exceed " + "defined maximum length: " + maxCapacity);
        eArray[size] = data;
        size += 1;
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
    public E getElement(E data) throws NoSuchElementException{


        for (int i = 0; i < eArray.length; i++){
            if (eArray[i] == data ){
                return eArray[i];
            }
        }
        throw new NoSuchElementException(data.toString() + " not in list.");

    }
    /**
     * Method for getting the element at of the specified data
     * Algorithm:
     * 1. Check if index is within bounds else throw NoSuchElementException
     * 2. Return the element at that index
     *
     * @param index index of the data to get
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    public E getElementAtIndex(int index) throws NoSuchElementException{
        if (index < 0 || index >= size){
            throw new NoSuchElementException();
        }
        return eArray[index];
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
     *
     * 0 1 2 3 4
     * a b c - f
     *
     * 0 1 2 3 4 5 6
     * a b c e f g -
     *
     */
    @Override
    public boolean delete(E data) {
        for (int i = 0; i < size; i++) {
            if (eArray[i].equals(data)) {
                if (eArray.length - 1 - i >= 0) System.arraycopy(eArray, i + 1, eArray, i, eArray.length - 1 - i);
                /*
                    for (int j = i; j < eArray.length-1;j++){
                        eArray[j] = eArray[j+1];
                    }
                */
                eArray[size -= 1] = null;

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