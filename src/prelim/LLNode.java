package prelim;

public class LLNode<E> {
    private final E data; // contains the data
    private LLNode<E> next;   // the next node

    /**
     * Constructor for the Node class
     * @param data data to be stored in the node
     */
    public LLNode(E data) {
        this.data = data;
    }

    /**
     * Returns the data in the node
     * @return data
     */
    public E getData() { return data; }

    /**
     * Set the next node
     * @param next the next node
     */
    public void setNext(LLNode<E> next) { this.next = next; }

    /** Returns the next node
     * @return next
     */
    public LLNode<E> getNext() { return next; }
}
