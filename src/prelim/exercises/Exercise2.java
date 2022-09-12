package prelim.exercises;

import java.util.Scanner;

/**
 * Name: Lawrence T. Miguel II
 * Date: 8/20/2022
 * <p>
 * - The class should have a method that implements the  Linear Search Algorithm. The method should
 * have a 1-dimensional array of string and a searchkey as formal parameters.
 * <p>
 * <p>
 * - The class should have a method that displays elements of a
 * 1-dimensional array
 * <p>
 * <p>
 * - In the code( e.g. in the main method or run method), declare a
 * one-dimensional array of strings. For this exercise, you may assign the
 * elements of the array upon declaring the array (The array should have at least
 * 10 elements)
 * <p>
 * <p>
 * - Let the program show the elements of the array before the sorting
 * happens
 * <p>
 * <p>
 * - Let the program search for a specific element form the array
 * <p>
 * Algorithm:
 * 1. Declare array
 * 2. Display the array
 * 3. Get input from user
 * 4. Linear Search
 * 5. Display the output
 * <p>
 * Sample Output
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Array:
 * Testing cow dog cat real pen pencil computer john air-con
 * Input Search Key: real
 * The index of the search key in the array is 4
 * <p>
 * Array:
 * 56 53 4 3 94 5 234 13 132 57 342 98 999 777
 * Input Search Key: 132
 * The index of the search key in the array is 8
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Process finished with exit code 0
 */
public class Exercise2 {


    /**
     * Searches a search key in an array and returns the index if found and -1 if not
     * Linearly searches for the element by comparing the search key for each element in the array
     *
     * @param arr the array of whom to search in
     * @param key the search key
     * @return index if found else -1
     */
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T key) {
        for (int i = 0; i < arr.length; i++) {
            if (key.equals(arr[i])) {
                return i;
            }
        }
        return -1; // Return an error code if not found
    }

    /**
     * Displays the elements of an array
     *
     * @param arr the array to search
     */
    public static <T extends Comparable<T>> void display(T[] arr) {
        System.out.println("Array: ");
        for (T s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


    /**
     * Searches using the linear search and outputs the index with text.
     *
     * @param arr
     * @param search_key
     */
    private static <T extends Comparable<T>> void search(T[] arr, T search_key) {
        int index = linearSearch(arr, search_key);

        if (index == -1) {
            System.out.println("The search key is not in the array!");
        } else {
            System.out.println("The index of the search key in the array is " + index);
        }
    }

    /**
     * The main method
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner my_scanner = new Scanner(System.in);

        // String Array
        String[] string_array = {"Testing", "cow", "dog", "cat", "real", "pen", "pencil", "computer", "john", "air-con"};
        display(string_array);
        System.out.print("Input Search Key: ");

        String string_search_key = my_scanner.nextLine();
        search(string_array, string_search_key);

        System.out.println();

        // Int Array
        Integer[] int_array = {56, 53, 4, 3, 94, 5, 234, 13, 132, 57, 342, 98, 999, 777};
        display(int_array);
        System.out.print("Input Search Key: ");

        int int_search_key = Integer.parseInt(my_scanner.nextLine());
        search(int_array, int_search_key);

    }

}
