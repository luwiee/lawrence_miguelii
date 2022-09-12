/**
 * Implementation of the
 */

package prelim;



public class DLNode <E>{
    // Instance fields
    private final E data;
    private DLNode<E> next;   // reference to the next node
    private DLNode<E> previous;   // reference to the previous node

    /**
     * Constructor for the
     * @param data element to be stored in the node
     */
    public DLNode(E data) {
        this.data = data;
    }

    /**
     * Retrieves the stored element in the node
     * @return the element stored in the node
     */
    public E getData() { return data; }

    /**
     * Returns the next node
     * @return the next node
     */
    public DLNode<E> getNext() { return next; }

    /**
     * Returns the previous node
     * @return reference to the previous node
     */
    public DLNode<E> getPrevious() { return previous; }

    /**
     * Set the reference for the next node
     * @param next the next node
     */
    public void setNext(DLNode<E> next) { this.next = next; }

    /**
     * Set the reference for the previous node
     * @param previous the previous node
     */
    public void setPrevious(DLNode<E> previous) { this.previous = previous; }
}
