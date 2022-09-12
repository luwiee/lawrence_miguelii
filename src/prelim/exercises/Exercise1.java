package prelim.exercises;

/**
Name: Lawrence T. Miguel II
Date: 8/18/2022

Problem:
 Create an executable class that implements/illustrates the Selection Sort Algorithm
   - The class should have a method that implements the Selection Sort Algorithm.
       The method should have a 1-dimensional array of string as formal parameter
   - The class should have a method that displays elements of a 1-dimensional array
   - In the code( e.g. in the main method), declare a one-dimensional array of strings.
       For this exercise, you may assign the elements of the array upon declaring the array
       (The array should have at least 10 elements)
   - Let the program show the elements of the array before the sorting happens
   - Let the program show the elements of the array after sorting
   - Show that sample output of the program through multiple line comments in the source file
    ( i.e. After running the programming, copy and paste the output within a comment section of the source code).

Algorithm:
      1. Declare elements of the array int the main method
      2. Display the elements of the array using the show elements method
      3. Sort the elements of the array using the sort elements
      4. Display the elements of the sorted array
      5. Close the program


Sample Output:
        String Array:
        Katrina, Dustin, Lawrence, Miguel, Cortona, Xanthe, Alex, Zev, Jonathan, Java,

        String Array:
        Alex, Cortona, Dustin, Java, Jonathan, Katrina, Lawrence, Miguel, Xanthe, Zev,


        Process finished with exit code 0

*/
public class Exercise1 {
    /**
     Sorts an array of String using the Selection Sort
     Algorithm
         Selection Sort:
         1.1 Iterate through the array excluding the last element with index i
         1.1a Iterate through the loop with index j
         1.1a Initialize a variable min (container for the index of minimum) having it's value as the index j
         1.1b Compare this min through all the remaining values through iteration using index k with \\
         The initial value of j+1
         1.1ba If the next string is lesser than the current min value Set min as the value of index k
         1.1c Create a copy of the current element of index j as temp_string
         1.1d Set array of index j value as the value of array of index min
         1.1e Set array of index min value as the value of the temp_string
         3.
     */
    private static void sortArray(String[] array) {

        // Iterate through each element from leftmost to the right most element
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                // Get the index of the temporary min of the array
                int min = j;

                // Iterate through the remaining elements
                for (int k = j + 1; k < array.length; k++) {
                    // Check if the next element is lesser
                    if (array[k].compareTo(array[min]) < 0){
                        min = k;
                    }
                }

                // Swap the two elements
                String temp_string = array[j];
                array[j] = array[min];
                array[min] = temp_string;
            }
        }
    }

    /**
         Show Array:
         1. Initialize length_var of the input array
         2. Iterate through the array while i < length_var
         3. Output the value of the string array on the index i
     */
    private static void showElements(String[] array) {
        System.out.println("String Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +", ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // Initialize an array of 10 elements
        String[] array = {"Katrina","Dustin","Lawrence","Miguel","Cortana", "Xanthe","Alex","Zev","Jonathan", "Java"};

        // Show the array sort and then show again
        showElements(array);
        sortArray(array);
        showElements(array);
    }


}
