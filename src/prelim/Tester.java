package prelim;

public class Tester {

    public static void main(String[] args) throws ListOverflowException {

        MyList<Integer> list = new MyDoublyLinkedCircularList<>();

        list.insert(0);
        System.out.println("Searching for 0: " +list.search(0) + " = 0");
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println("List Size: " + list.getSize() + " = 5");

        System.out.println("Searching for 0: " +list.search(0) + " = 0");
        System.out.println("Searching for 1: " +list.search(1) + " = 1");
        System.out.println("Searching for 2: " +list.search(2) + " = 2");
        System.out.println("Searching for 3: " +list.search(3) + " = 3");
        System.out.println("Searching for 4: " + list.search(4) + " = 4");
        System.out.println("Searching for 5: " + list.search(5) + " = -1");

        System.out.println("Deleting 2, " + list.delete(2) + " = true");


        System.out.println("Searching for 2: " +list.search(2) + " = -1");
        System.out.println("Searching for 0: " +list.search(0) + " = 0");

        System.out.println("List Size: " + list.getSize() + " = 4");
        System.out.println("Searching for 4: " +list.search(4) + " = 3");

        System.out.println("Searching for 1: " +list.search(1) + " = 1");

        System.out.println("Deleting 1, " + list.delete(1) + " = true");

        System.out.println("Searching for 1: " +list.search(1) + " = -1");

        System.out.println("Searching for 2: " +list.search(2) + " = -1");
        System.out.println("Deleting 0, " + list.delete(0) + " = true");

        System.out.println("List Size: " + list.getSize() + " = 2");

        list.insert(5);
        System.out.println("Searching for 0: " +list.search(0) + " = -1");
        System.out.println("Searching for 1: " +list.search(1) + " = -1");
        System.out.println("Searching for 2: " +list.search(2) + " = -1");
        System.out.println("Searching for 3: " +list.search(3) + " = 0");
        System.out.println("Searching for 4: " + list.search(4) + " = 1");
        System.out.println("Searching for 5: " + list.search(5) + " = 2");

        System.out.println("List Size: " + list.getSize() + " = 3");
    }
}
