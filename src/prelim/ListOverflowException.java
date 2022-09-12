/**
 * Name: Lawrence T. Miguel II
 * Date: 8/28/2022
 * Class Description:
 * An implementation of an EXCEPTION for ListOverflow
 */
package prelim;

public class ListOverflowException extends Exception {
    public ListOverflowException(String s) {
        super(s);
    }
    public ListOverflowException() {
        super("The list is now of max size!");
    }
}
