/**
 * Name: Lawrence T. Miguel II
 * Date: 8/28/2022
 * Class Description:
 * An implementation of a Doubly Linked List that has a list of nodes with a previous and a next node that
 * implements the MyList Interface
 */
package prelim;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> implements MyList<E> {



    // Variable Initialization
    private DLNode<E> head = null;
    private DLNode<E> tail = null;
    private int size = 0;

    /**
     * Construct an empty list
     */
    public MyDoublyLinkedList() { }
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
     */
    @Override
    public void insert(E data) {
        DLNode<E> temp = new DLNode<>(data);

        if (isEmpty()){
            head = tail = temp;
            head.setPrevious(null);
            tail.setNext(null);
        } else {
            tail.setNext(temp);
            temp.setPrevious(tail);
            tail = temp;
            tail.setNext(null);
        }
        size++;
    }

    /**
     * Method for getting the element index of the specified data
     *
     * @param data data to get in the list
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    @Override
    public E getElement(E data) throws NoSuchElementException {
        if (isEmpty()) return null;
        DLNode<E> current = head;
        while (true) {
            if (current.getData().equals(data)) return current.getData();
            if (current.getNext() != null) current = current.getNext();
            else throw new NoSuchElementException(data.toString() + " not found in list.");
        }
    }

    /**
     * Method for deleting the specified data in the list if it exists
     *
     * @param data data to delete
     * @return boolean if data was deleted
     */
    @Override
    public boolean delete(E data) {
        if (isEmpty()) return false;
        DLNode<E> current;
        if (data == head.getData()) {
            current = head.getNext();
            head = current;

            --size;
            return true;
        } else {
            DLNode<E> prevNode = head;
            while (prevNode.getNext() != null) {
                if (prevNode.getNext().getData().equals(data)) {
                    current = prevNode.getNext();

                    prevNode.setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrevious(prevNode);
                    }
                    --size;
                    return true;
                }else {
                    prevNode = prevNode.getNext();
                }
            }
        }
        return false;
    }

    /**
     * Method for checking if there is an element of E data
     *
     * @param data data to search in the list
     * @return index of the data if in the list else -1
     */
    @Override
    public int search(E data) {

        if (isEmpty()) return -1;
        int index = 0;
        DLNode<E> current = head;
        do {
            if (current.getData().equals(data)) return index;
            current = current.getNext();
            index++;
        } while (current != null);
        return -1;
    }

    /**
     * Method for inserting data at the tail
     * Algorithm:
     *      1. Check if Size is equal to Integer Max Value if so Throw ListOverflowException
     *      2. Create a temp node using the data to insert
     *      3. Check if empty if so set the head as the temp node
     *      4. Else set the tails next node as the temp
     *      5. Increment the size
     * @param item new element to the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    public void addAtTail(E item) throws ListOverflowException {
        if (getSize() == Integer.MAX_VALUE) throw new ListOverflowException("List is full of defined " +
                "maximum length: " + Integer.MAX_VALUE);
        DLNode<E> temp = new DLNode<>(item);

        if (isEmpty()) head = temp;
        else tail.setNext(temp);
        tail = temp;
        size++;
    }

    /**
     * Method for inserting data at the head
     * Algorithm:
     *      1. Check if Size is equal to Integer Max Value if so Throw ListOverflowException
     *      2. Create a temp node using the data to insert
     *      3. Check if empty if so set the tail as the temp node
     *      4. Else set the current head next as null
     *      5. Set the temp as the new head
     *      5. Increment the size
     * @param item new element to the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    public void addAtHead(E item) throws ListOverflowException {
        if (getSize() == Integer.MAX_VALUE) throw new ListOverflowException("List is full of defined " +
                "maximum length: " + Integer.MAX_VALUE);
        DLNode<E> temp = new DLNode<>(item);

        if (isEmpty()) tail = temp;

        temp.setNext(head.getNext());
        head.setNext(null);
        head = temp;

        size++;
    }

    /**
     * Method for deleting from the head
     * Algorithm:
     *      1. Check if the list is empty and if so return
     *      2. Get the oldHead
     *      3. Set the next of the current head as the new head
     *      4. Set the oldHead next as null
     *      5. Decrement the size
     */
    public void deleteFromHead() {
        if (isEmpty()) return;
        DLNode<E> oldHead = head;
        head = head.getNext();
        oldHead.setNext(null);
        --size;
    }

    /**
     * Method for deleting the tail
     * Algorithm:
     *      1. Check if the list is empty if so return
     *      2. Check if the tail and the head is the same if so set them both to null, decrement size and return
     *      3. Find the second to the last element by getting the previous of the current tail
     *      4. Set the second to the last next as null and make it the new tail
     *      5. Decrement the size
     */
    public void deleteFromTail() {
        if (isEmpty()) return;
        if (tail == head){
            head = null;
            tail = null;
            --size;
            return;
        }
        DLNode<E> newTail = tail.getPrevious();

        newTail.setNext(null);
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
        DLNode<E> current = head;
        do {
            System.out.println("[" + index + "] " + current.toString() + ",");
            current = current.getNext();
            index++;

        } while (current != null);

        System.out.println("----------------------------");
    }
}
