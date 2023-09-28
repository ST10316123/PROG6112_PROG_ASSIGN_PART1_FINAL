/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assign_part1scanner;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Student { 
    
    Scanner kb = new Scanner(System.in);
    
    //constant String variables
    final String CONTINUE = "\nEnter (1) to launch menu or any other key to exit";
    
    final String WELCOME_MSG = "STUDENT MANAGEMENT APPLICATION"
            + "\n*************************************************"
            + "\n"+CONTINUE;
    
    final String MENU = "\nPlease select one of the following menu items:"
            + "\n(1) Capture a new student"
            + "\n(2) Search for a new student"
            + "\n(3) Delete a student"
            + "\n(4) Print student report"
            + "\n(5) Exit application";
    
    //ArrayLists for all student details
    private ArrayList<Integer> studentIDs;
    private ArrayList<String> studentNames;
    private ArrayList<Integer> studentAges;
    private ArrayList<String> studentEmails;
    private ArrayList<String> studentCourses;
    
    //constructor
    //ArrayLists variables are initialised
    public Student() {
        studentIDs = new ArrayList<>();
        studentNames = new ArrayList<>();
        studentAges = new ArrayList<>();
        studentEmails = new ArrayList<>();
        studentCourses = new ArrayList<>();
        
    }

    //getter methods
    public int getStudentID(int index) {
        return studentIDs.get(index);
    }

    public String getStudentName(int index) {
        return studentNames.get(index);
    }
    
    public int getStudentAge(int index) {
        return studentAges.get(index);
    }
    
    public String getStudentEmail(int index) {
        return studentEmails.get(index);
    }
    
    public String getStudentCourse(int index) {
        return studentCourses.get(index);
    }
    
    //checks whether input for Student ID is numeric
    //try and catch implemented to catch any string characters entered instead of numeric values for ID
    public boolean isIDNumeric(String ID) {
        try {
            Integer.valueOf(ID);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //checks whether input for Student Age is numeric
    //try and catch implemented to catch any string characters entered instead of numeric values for age
    public boolean isAgeNumeric(String age){
        try {
            Integer.valueOf(age);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //returns message based on whether is numeric or not
    public String ageNumericMessage(String age){
       if (isAgeNumeric(age)) {
            return "Student age has been saved!";
        }
        else{
            return "Invalid! Age must be numeric!";
        } 
    }
    
    //boolean method to check whether age is numeric AND age is 16 or above
    public boolean isAgeValid(int age){
        return age >= 16 && isAgeNumeric(String.valueOf(age));
    }
    
    //returns message based on whether age fits the requirements i.e. 16 or above
    public String ageValidMessage(int age){
        if (isAgeValid(age)) {
            return "Age is valid and has been accepted!)";
        }
        else{
            return "Age is invalid! (Must be 16 or above)";
        }
    }
    
    //method to save student details
    //adds inputted details into respective ArrayLists
    public void SaveStudent(int ID, String name, int age, String email, String course){
         if (isIDNumeric(String.valueOf(ID))){
          studentIDs.add(ID);
         }
         
         studentNames.add(name);
         
         if (isAgeNumeric(String.valueOf(age))) {
            studentAges.add(age);
        }
         
         studentEmails.add(email);
         
         studentCourses.add(course);
         }
    
    //method searches for a student using its student ID
    public String SearchStudent(int searchID){
        
        boolean found = false;
        int i = 0;
        //loop runs through student ID ArrayList to find the ID searched for
        while (!found && i < studentIDs.size()) {
            
            if (searchID==studentIDs.get(i)) {
                found =true;
        }
        
            else{
                i++;
            }     
        }//loop ends
        
        if (!found) {
            return "Student with Student ID " + searchID + " was not found!"
                        +"\n"+CONTINUE;
        }
        
        else{
            return DisplaySearchedStudent(i) + "\n"+CONTINUE;
        }


    }
    
    //method that displays the student details that was searched for
    public String DisplaySearchedStudent(int i){
       return "Student " + (i + 1)
                + "\n--------------------------------------------"
                + "\nSTUDENT ID: " + studentIDs.get(i)
                + "\nSTUDENT NAME: " + studentNames.get(i)
                + "\nSTUDENT AGE: " + studentAges.get(i)
                + "\nSTUDENT EMAIL: " + studentEmails.get(i)
                + "\nSTUDENT COURSE: " + studentCourses.get(i)
                + "\n--------------------------------------------\n";
    }
    
    //method to find the student you want to delete using its Student ID
    public int DeleteStudentFound(int idToDelete){
        
        boolean found = false;
        int i = 0;
        while (!found && i < studentIDs.size()) {
            
            if (idToDelete == studentIDs.get(i)) {
                found =true;
        }
      
            else{
                i++;
            }     
        }//loop ends
        
        if (found) {
            return i;
        }
        
        else{
           return i = -1;
        }
    }
    
    //methods returns message on whether student id intended to be deleted is found or not
    public String DeleteStudentFoundMessage(int idToDelete){
        if (DeleteStudentFound(idToDelete) != -1) {
            return "Student ID to be deleted has been found!";
        }
        else{
            return "Student ID to be deleted has not been found!" + CONTINUE;
        }
    }
    
    //method deletes the specified student's complete details after its ID has been found
    //an additional parameter is added since user is given an option to confirm the deletion and this variable is a boolean value
    public String DeleteStudent(int idToDelete, boolean confirm){
        
        String deleteMsg = "";

        if (DeleteStudentFound(idToDelete) != -1  && confirm) {
            
                int i = DeleteStudentFound(idToDelete);
                studentIDs.remove(i);
                studentNames.remove(i);
                studentAges.remove(i);
                studentEmails.remove(i);
                studentCourses.remove(i);
                
                deleteMsg = "Student " + idToDelete + " has been deleted!"+"\n" + CONTINUE;
        }
            
      
        else{
            deleteMsg = "Student with Student ID " + idToDelete + " was not deleted!" + "\n" + CONTINUE
                    ;
        }

        return deleteMsg;    
    }
    

    //method displays all the student details that has been added to the system
    public String StudentReport(){
        
         String report = "";
         //loop runs through entire ArrayLists and prints information accordingly
    for (int i = 0; i < studentNames.size(); i++) {
        report += "Student " + (i + 1)
                + "\n--------------------------------------------"
                + "\nSTUDENT ID: " + studentIDs.get(i)
                + "\nSTUDENT NAME: " + studentNames.get(i)
                + "\nSTUDENT AGE: " + studentAges.get(i)
                + "\nSTUDENT EMAIL: " + studentEmails.get(i)
                + "\nSTUDENT COURSE: " + studentCourses.get(i)
                + "\n--------------------------------------------\n";
    }

    report += CONTINUE;
    
        //displays message if no data has been entered to the system
        if (studentNames.isEmpty()) {
           return "No student data to display!\n" + CONTINUE;
        }
        
        else{
            return report;
        }
    }
    
    //method that allows user to quit the program before menu is displayed by selecting any value except "1"
    public void ExitStudentApplication(String input){
        if (!input.equals("1")) {
        System.exit(0);            
        }

    }
    
}// End of class
