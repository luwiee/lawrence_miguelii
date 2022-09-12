package prelim;

import java.util.Scanner;

public class ClassmateProgramFixedList {
    static MyFixedSizeArrayList<Classmate> classmatesList = new MyFixedSizeArrayList<>();
    static Scanner kbd = new Scanner(System.in);


    public static void main(String[] args) {
        ClassmateProgramFixedList program;
        try {
            program = new ClassmateProgramFixedList();
            program.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        kbd.close();
        System.exit(0);
    } // end of main method

    //HELPER FUNCTIONS
    static void inputBuffer() {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //HELPER FUNCTIONS
    static int enterChoice(int max) {
        int choice;
        do {
            try {
                System.out.println();
                System.out.print("Input item selection: ");
                choice = Integer.parseInt(kbd.nextLine());
                if (choice < 1 || choice > max)
                    System.out.println("Invalid selection. Valid values range from " + 1 + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("You must input a valid integer.");
                choice = -1;
            }
        } while (choice < 1 || choice > max);
        return choice;
    }

    static int acceptIntInput() {
        do {
            try {
                return Integer.parseInt(kbd.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You must input a valid integer.");
            }
        } while (true);
    }


    // SHOW MENU FUNCTIONS
    static void showIntroduction() {
        System.out.println("\n\n\n");
        System.out.println("----------------------------");
        System.out.println("College of Information and Computing Sciences");
        System.out.println("Saint Louis University");
        System.out.println("Baguio City ");
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Lawrence T. Miguel II ");
        System.out.println("Programmer");
        System.out.println();
    }

    static void showMainMenu() {
        System.out.println("Fixed Array List - Classmate Program ");
        System.out.println("Main Menu ");
        System.out.println("----------------------------");
        System.out.println("1. Show Classmates");
        System.out.println("2. Add A New Classmate");
        System.out.println("3. Remove a Classmate");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
    }
    static void showListMainMenu() {
        System.out.println("Fixed Array List - Classmate Program ");
        System.out.println("Main Menu ");
        System.out.println("----------------------------");
        System.out.println("1. Show Classmates");
        System.out.println("2. Add A New Classmate");
        System.out.println("3. Remove a Classmate");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
    }




    private void addNewClassmate() throws ListOverflowException {
        System.out.println("Add New Classmate ");
        System.out.println("----------------------------");

        System.out.print("First Name: ");
        String fName = kbd.nextLine();

        System.out.print("Last Name: ");
        String lName = kbd.nextLine();

        Classmate.Gender cGender = null;
        System.out.println("Gender:");
        System.out.println("1. Female");
        System.out.println("2. Male");

        int myChoice = enterChoice(2);
        switch (myChoice) {
            case 1 -> cGender = Classmate.Gender.FEMALE;
            case 2 -> cGender = Classmate.Gender.MALE;
        } //end switch

        System.out.print("Age: ");
        int age = acceptIntInput();

        Classmate classmate = new Classmate(fName, lName, age, cGender);
        classmatesList.insert(classmate);
        System.out.println(classmate);


        System.out.println("------------------------------");
    }

    private void deleteClassmate() throws ListOverflowException {
        System.out.println("Delete a Classmate ");
        System.out.println("----------------------------");
        if (classmatesList.getSize() == 0) {
            System.out.println("List is empty!");
            return;
        }
        classmatesList.showData();
        System.out.println("At what index is the Classmate you want to delete? (-1 to cancel)");
        int index = acceptIntInput();
        if (index == -1){
            System.out.println("------------------------------");
            return;
        }
        Classmate classmate = classmatesList.getElementAtIndex(index);
        System.out.println("Trying to delete classmate: " + classmate.getFirstName() + ": "+classmatesList.delete(classmate));
        System.out.println("------------------------------");
    }
    public void run() throws Exception {
        int myChoice;
        showIntroduction();
        inputBuffer();
        do {
            showMainMenu();
            myChoice = enterChoice(4);
            switch (myChoice) {
                case 1 -> classmatesList.showData();
                case 2 -> addNewClassmate();
                case 3 -> deleteClassmate();
                case 4 -> {
                    System.out.println("Thank you for using my program.");
                    System.out.println("Enjoy the rest of your day.");
                }
            } //end switch
        } while (myChoice != 4);
        System.exit(0);
    } // end of run method
} // end of class TestFixedSizeArray
