/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_assign_part1scanner;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Abdul
 */
public class StudentTest {
    
    //an instance variable of the student class declared and named as "instance"
    private Student instance;
    
    //@Before setUp() method saves the sample details before each test method runs 
    @Before
    public void setUp() {
        instance = new Student(); //instance object initialised
        int ID = 123;
        String name = "Abdul";
        int age = 21;
        String email = "abdul@mail.com";
        String course = "BCAD";
        instance.SaveStudent(ID, name, age, email, course);//sample details saved using SaveStudent() method
    }
    
    

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    //Method tests whether the sample student details have been saved by using getter methods to access student details 
//            and check that the details match
    public void TestSaveStudent() {
        System.out.println("SaveStudent");
        assertEquals(123, instance.getStudentID(0)); //details all saved in first index of ArrayList which is index 0
        assertEquals("Abdul", instance.getStudentName(0));
        assertEquals(21, instance.getStudentAge(0));
        assertEquals("abdul@mail.com", instance.getStudentEmail(0));
        assertEquals("BCAD", instance.getStudentCourse(0));
    }

    

    /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    //Method tests by using a saved student ID and ensuring the correct details are returned
    public void TestSearchStudent() {
        System.out.println("SearchStudent");
        int searchID = 123;
        int i=0; //index number where student details are saved in the setUp() method
        String expResult = instance.DisplaySearchedStudent(i) + "\n"+instance.CONTINUE;
        //displays the full String result that is displayed when searched student is found
        String expResult2 = "Student " + (i + 1)
                + "\n--------------------------------------------"
                + "\nSTUDENT ID: " + 123
                + "\nSTUDENT NAME: " + "Abdul"
                + "\nSTUDENT AGE: " + 21
                + "\nSTUDENT EMAIL: " + "abdul@mail.com"
                + "\nSTUDENT COURSE: " + "BCAD"
                + "\n--------------------------------------------\n"
                + "\n" + "\nEnter (1) to launch menu or any other key to exit";
        String result = instance.SearchStudent(searchID);
        assertEquals(expResult, result);
        assertEquals(expResult2,result);
    }

    @Test
    //Method tests by using an unsaved student ID and ensuring the correct message is returned
    public void TestSearchStudent_StudentNotFound(){
        System.out.println("SearchStudent_NotFound");
        int searchID = 529; //random ID number that is not saved
        String expResult = "Student with Student ID " + searchID + " was not found!"
                        +"\n"+instance.CONTINUE;
        String result = instance.SearchStudent(searchID);
        assertEquals(expResult,result);
    }
    

    /**
     * Test of DeleteStudent method, of class Student.
     */
    @Test
    //Method tests that a specific student details is deleted from the system by providing it with a saved student ID 
    public void TestDeleteStudent() {
        System.out.println("DeleteStudent");
        int idToDelete = 123; //ID number that is already saved in the setUp() method
        String expResult = "Student " + idToDelete + " has been deleted!"+"\n" + instance.CONTINUE;
        boolean confirmDelete = true;
        String result = instance.DeleteStudent(idToDelete,confirmDelete);
        assertEquals(expResult, result); //checks correct message returned after details have been deleted
    }
    
    @Test
    //Method tests that the selected student for deletion has not been found by providing an unsaved ID number
    public void TestDeleteStudent_StudentNotFound(){
        System.out.println("DeleteStudent_StudentNotFound");
        int idToDelete = 432; //random ID number that has not been saved in the system
        String expResult = "Student ID to be deleted has not been found!" + instance.CONTINUE;
        String result = instance.DeleteStudentFoundMessage(idToDelete);
        assertEquals(expResult,result); //checks correct message returned after student ID to delete was not found
    }

    
     /**
     * Test of isAgeValid method, of class Student.
     */
    @Test
    //Method tests that a valid student age has been entered i.e. an age 16 or above
    public void TestStudentAge_StudentAgeValid() {
        System.out.println("StudentAge_StudentAgeValid");
        int age1 = 16;
        int age2 = 20;
        assertTrue(instance.isAgeValid(age1)); //checks that a "true" value is returned for an age of 16
        assertTrue(instance.isAgeValid(age2)); //checks that a "true" value is returned for an age of 20
    }
    
    @Test
    //Method tests that an invalid student age has been entered i.e. an age 15 or below
    public void TestStudentAge_StudentAgeInvalid(){
        System.out.println("StudentAge_StudentAgeInvalid");
        int age1 = 15;
        int age2 = 10;
        assertFalse(instance.isAgeValid(age1)); //checks that a "false" value is returned for an age of 15
        assertFalse(instance.isAgeValid(age2)); //checks that a "false" value is returned for an age of 10
    }
    

    
        /**
     * Test of isAgeNumeric method, of class Student.
     */
    @Test
    //Method tests that an invalid character is supplied for the age i.e. a non-numerical value eg. "16@" or "17e"
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("StudentAge_StudentAgeInvalidCharacter");
        //String values inputted since isAgeNumeric() method requires String input to check for invalid characters
        String age1 = "14f";
        String age2 = "18&";
        String age3 = "$$$";
        assertFalse(instance.isAgeNumeric(age1)); //checks that a "false" value is returned for an invalid age "14f"
        assertFalse(instance.isAgeNumeric(age2)); //checks that a "false" value is returned for an invalid age "18&"
        assertFalse(instance.isAgeNumeric(age3)); //checks that a "false" value is returned for an invalid age "$$$"
    }
    
}