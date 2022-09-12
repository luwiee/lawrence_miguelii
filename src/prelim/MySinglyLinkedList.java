/**
 * Name: Lawrence T. Miguel II
 * Date: 8/25/2022
 * Class Description:
 * An implementation of a Singly Linked Array List that implements the MyList Interface
 */
package prelim;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<E> implements MyList<E> {

    // Variable Initialization
    private LLNode<E> head = null; // The
    private LLNode<E> tail = null;
    private int size = 0;

    /**
     * Constructor for the MySinglyLinkedList Class
     * Creates an empty list
     */
    public MySinglyLinkedList() {
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
     * Checks if the list is empty
     *
     * @return if the list is empty
     */
    private boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Method for inserting data in the list
     * Algorithm:
     * 1. Call addAtTail method
     *
     * @param data data to insert in the list
     * @throws ListOverflowException if after insertion the list exceed the maximum size
     */
    @Override
    public void insert(E data) throws ListOverflowException {
        addAtTail(data);
    }

    /**
     * Method for getting the element index of the specified data
     * Algorithm:
     * 1. Return Null if Empty
     * 2. Iterate through all the nodes and check if the node is the data
     * 3. Return the data if True else Throw NoSuchElementException
     *
     * @param data data to get in the list
     * @return data from the list
     * @throws NoSuchElementException if data is not in the list
     */
    public E getElement(E data) throws NoSuchElementException {
        if (isEmpty()) return null;
        LLNode<E> current = head;
        while (true) {
            if (current.getData().equals(data)) return current.getData();
            if (current.getNext() != null) {
                current = current.getNext();
            }
            else throw new NoSuchElementException(data.toString() + " not found in list.");
        }
    }

    /**
     * Method for deleting the specified data in the list if it exists
     * Algorithm:
     * 1. Check if empty and return false
     * 2. Check the head data
     * 2.1 If head is the data to delete
     * 2.2 Set current ot be the next node
     * 2.3 Set head to be the current
     * 2.3 Decrement size
     * 2.4 Return True
     * 3. Else iterate through the nodes
     * 3.1 Initialize a previous node to the head ( Set previous node as the current for each iteration)
     * 3.2 While there is still a next node check current node if it is the data to delete
     * 3.3 If it is the data then set previousNode next node as the next node of the current node
     * 3.4 Decrement size
     * 3.5 Return True
     * 4. Return False
     *
     * @param data data to delete
     * @return boolean if data was deleted
     */
    public boolean delete(E data) {
        if (isEmpty()) return false;
        LLNode<E> current;

        if (data == head.getData()) {
            deleteFromHead();
        } else {
            LLNode<E> prevNode = head;

            while (prevNode.getNext() != null) {
                if (prevNode.getNext().getData().equals(data)) {
                    current = prevNode.getNext();
                    prevNode.setNext(current.getNext());
                    --size;
                    return true;
                } else {
                    prevNode = prevNode.getNext();
                }
            }

            return false;
        }
        return false;
    }

    /**
     * Method for checking if there is an element of E data
     * Algorithm:
     * 1. Check if empty and return -1 if empty
     * 2. Create a node named current and assign head to
     * 3. Create a variable named index
     * 4. Check if current is equal to the data to search
     * 4.1 If it is equal return index
     * 5. Set the current as the next node of the current node
     * 6. Increment the index
     * 7. Repeat 4-6 until data is found
     * 8. Return -1
     *
     * @param data data to search in the list
     * @return index of the data if in the list else -1
     */
    @Override
    public int search(E data) {

        if (isEmpty()) return -1;
        int index = 0;
        LLNode<E> current = head;
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
        LLNode<E> temp = new LLNode<>(item);
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
        LLNode<E> temp = new LLNode<>(item);

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
        LLNode<E> oldHead = head;
        head = head.getNext();
        oldHead.setNext(null);
        --size;
    }

    /**
     * Method for deleting the tail
     * Algorithm:
     *      1. Check if the list is empty if so return
     *      2. Check if the tail and the head is the same if so set them both to null, decrement size and return
     *      3. Find the second to the last element by checking if it's next is equal to the tail
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
        LLNode<E> newTail = head;

        while (!newTail.getNext().equals(tail)){
            newTail = newTail.getNext();
        }
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
        LLNode<E> current = head;
        do {
            System.out.println("[" + index + "] " + current.toString() + ",");
            current = current.getNext();
            index++;

        } while (current != null);

        System.out.println("----------------------------");
    }
}
