/**
 * Name: Lawrence T. Miguel II
 * Date: 8/27/2022
 * Class Description:
 * An implementation of a Doubly Linked Circular List that implements the MyList interface
 */
package prelim;

import java.util.NoSuchElementException;

public class MyDoublyLinkedCircularList<E> implements MyList<E> {


    // Instance fields
    private DLNode<E> tail = null;
    private int size = 0;

    /**
     * Construct an empty list
     */
    public MyDoublyLinkedCircularList() { }
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
     * Checks if the list is empty
     * @return if the list is empty
     */
    private boolean isEmpty() { return getSize() == 0; }

    /**
     * Method for inserting data in the list
     *
     * @param data data to insert in the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    @Override
    public void insert(E data) {
        addAtTail(data);
    }

    /**
     * Method for getting the element index of the specified data
     *  Algorithm:
     *  1. Return Null if empty
     *  2. Traverse while checking if we didn't finished circulating the list by checking if the current is not
     *      equal to the tail as we started from the tail, and also if there is more than 1 element
     *  3. If the current is equal to the data return the data of the current
     *  4. If element not found throw exception
     * @param data data to get in the list
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    @Override
    public E getElement(E data) throws NoSuchElementException {
        if (isEmpty()) return null;
        DLNode<E> current = tail;
        while (!current.getNext().equals(tail)
                || getSize() == 1) {
            if (current.getData().equals(data)) return current.getData();
            current = current.getNext();
        }
        throw new NoSuchElementException(data.toString() + " not found in list.");
    }

    /**
     * Method for deleting the specified data in the list if it exists
     * Algorithm:
     * 1. Check if the list is empty return false
     * 2. Start from the tail and check if the tail is the data if so set the next element as the new tail and decrement
     * 3. Traverse from the tail and find the element
     * 4. If found get the previous element next to the element next
     * 5. Decrement and return true if deleted
     * 6. Return False if not found
     * @param data data to delete
     * @return boolean if data was deleted
     */
    @Override
    public boolean delete(E data) {
        DLNode<E> current;
        if (isEmpty()) return false;
        current = tail;

        // Special case, delete tail
        if (tail.getData().equals(data)) {
            // iF element is the only thing on the list
            if (getSize() == 1) {
                tail = null;
                return true;
            }
            tail.setPrevious(tail.getPrevious());
            tail.setNext(tail.getNext().getNext());
            tail = tail.getNext();
            --size;
            return true;
        }
        while (!current.getNext().equals(tail)) {
            if (current.getData().equals(data)) {
                DLNode<E> prevNode = current.getPrevious();

                prevNode.setNext(current.getNext());
                current.getNext().setPrevious(prevNode);

                --size;
                return true;
            }
            current = current.getNext();

        }
        return false;
    }

    /**
     * Method for checking if there is an element of E data
     * Algorithm:
     * 1. If empty return -1
     * 2. Initialize index as 0
     * 3. In a do while loop traverse through the nodes while the current is not equal to the tail
     * 4. Increment Index
     * 5. If data is found return the index
     * 6. Else return -1
     * @param data data to search in the list
     * @return index of the data if in the list else -1
     */
    @Override
    public int search(E data) {
        if (isEmpty()) return -1;
        int index = 0;
        DLNode<E> current = tail;
        do {
            if (current.getData().equals(data)) return index;
            current = current.getNext();
            index++;
        }while(!current.getNext().equals(tail)|| getSize() == 1);
        return -1;
    }

    /**
     * Method for inserting data at the tail
     * Algorithm:
     *      1. Check if Size is equal to Integer Max Value if so Throw ListOverflowException
     *      2. Create a temp node using the data to insert
     *      3. Check if empty if so set the tail as the temp node
     *      4. Else set the tails next node as the temp
     *      5. Increment the size
     * @param item new element to the list
     */
    public void addAtTail(E item)  {
        DLNode<E> temp = new DLNode<>(item);
        if (isEmpty()) {
            addAtEmpty(item);
            return;
        }

        temp.setNext(tail.getNext());
        temp.setPrevious(tail);

        if (tail.getNext() != null) {
            tail.getNext().setPrevious(temp);
        }
        tail.setNext(temp);
        tail = temp;

        ++size;
    }

    /**
     * Method for adding to an empty list
     * Algorithm:
     *      1. Make sure the tail is null
     *      2. Create a temp node using the data
     *      3. Set the tail as the temp
     *      4. Set the tail's next as itself
     *      5. Set the tail's previous as itself
     *      5. Increment size
     * @param data to add at the empty list
     */
    public void addAtEmpty(E data){
        tail = new DLNode<>(data);
        tail.setPrevious(tail);
        tail.setNext(tail);
        size++;
    }

    /**
     * Method for inserting data at the head
     * Algorithm:
     *      1. Check if Size is equal to Integer Max Value if so Throw ListOverflowException
     *      2. Check if empty if so set the tail as the temp node
     *      3. Create a temp node from the data
     *      4. Set the temp next as the next of the tail and set temp previous as the tail
     *      5. Set the tail next as the temp and the tail's next's previous as the temp
     *      6. Increment the size
     * @param item new element to the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    public void addAtHead(E item) throws ListOverflowException {
        if (isEmpty()) {
            addAtEmpty(item);
            return;
        }
        if (getSize() == Integer.MAX_VALUE) throw new ListOverflowException("List is full of defined " +
                "maximum length: " + Integer.MAX_VALUE);

        DLNode<E> temp = new DLNode<>(item);
        temp.setNext(tail.getNext());
        temp.setPrevious(tail);

        tail.getNext().setPrevious(temp);
        tail.setNext(temp);

        size++;
    }

    /**
     * Method for deleting from the head
     * Algorithm:
     *      1. Check if the list is empty and if so return
     *      2. Get the 2nd element by getting the next of the head (next of the tail)
     *      3. Set the old head's (next of the tail) next as null
     *      4. Set the tail's next as the 2nd element
     *      5. Set the new head's previous as the tail
     *      6. Decrement the size
     */
    public void deleteFromHead() {
        if (isEmpty()) return;
        DLNode<E> newHead = tail.getNext().getNext();
        tail.getNext().setNext(null);
        tail.setNext(newHead);
        newHead.setPrevious(tail);
        --size;
    }

    /**
     * Method for deleting the tail
     * Algorithm:
     *      1. Check if the list is empty if so return
     *      2. Check if the tail and the tail next is the same if so set the tail to null , decrement size and return
     *      3. In a do while loop traverse until we get to the second to the last element
     *       by checking if the next equals to the tail
     *      4. Set the new tail's next as the old tail's next and set the previous as the old tail's previous
     *      5. Set the old tail's next's previous as the new tail
     *      6. Set the old tail's next and previous as null
     *      5. Set the tail to the new tail
     *      6. Decrement size
     */
    public void deleteFromTail() {
        if (isEmpty()) return;
        if (tail == tail.getNext()){
            tail = null;
            --size;
            return;
        }

        DLNode<E> newTail = tail.getPrevious();


        newTail.setNext(tail.getNext());
        newTail.setPrevious(tail.getPrevious());
        tail.getNext().setPrevious(newTail);

        tail.setNext(null);
        tail.setPrevious(null);

        tail = newTail;
        --size;
    }

    /**
     * Method for showing the elements of the List
     * Algorithm:
     * 1. Iterate through the list
     * 2. Output each element by calling its toString function
     */
    public void showData() {
        System.out.println("----------------------------");
        if (isEmpty()) {
            System.out.println("----------------------------");
            return;
        }
        int index = 0;
        DLNode<E> current = tail.getNext();
        do {
            System.out.println("[" + index + "] " + current.toString() + ",");
            current = current.getNext();
            index++;

        } while (!current.equals(tail));

        System.out.println("----------------------------");
    }
}
