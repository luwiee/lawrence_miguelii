/**
 * Name: Lawrence T. Miguel II
 * Date: 8/27/2022*
 * Class Description:
 * A Class for a Classmate
 */
package prelim;

public class Classmate {
    // Variable Initialization
    private String firstName = "";
    private String lastName = "";
    private int age;
    private Gender gender;

    /**
     * Constructs a Classmate with attributes set to default values
     */
    public Classmate() {
        setFirstName(null);
        setLastName(null);
        setAge(0);
        setGender(Gender.NOT_SPECIFIED);
    }

    /**
     * Constructs a Classmate with given values of all attributes
     */
    public Classmate(String fN, String lN, int a, Gender g) {
        setFirstName(fN);
        setLastName(lN);
        setAge(a);
        setGender(g);
    }

    /**
     * Returns the gender of the Classmate
     * @return
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the Classmate
     * @param gender Gender of the Classmate
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Returns the age of the Classmate
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age to a given integer
     */
    public void setAge(int q) {
        age = q;
    }

    /**
     * Returns the First Name of the Classmate
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the First Name of the Classmate
     */
    public void setFirstName(String c) {
        firstName = c;
    }

    /**
     * Returns the Last Name of the Classmate
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Last Name of the Classmate
     */
    public void setLastName(String n) {
        lastName = n;
    }

    /**
     * Returns a string showing the Full Name and Age of the Classmate
     */
    @Override
    public String toString() {
        return (lastName + ", " + firstName + ", " + age + ", " +gender);
    }

    // Enumerator for the Gender
    public enum Gender {
        MALE, FEMALE, NOT_SPECIFIED,
    }
} // end of class Classmate