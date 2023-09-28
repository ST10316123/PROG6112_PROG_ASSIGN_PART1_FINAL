/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_assign_part1scanner;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Prog_Assign_Part1Scanner {

    /**
     * @param args the command line arguments
     */
    
    /*
    References
    https://www.youtube.com/watch?v=ceGnVDrMy1A
    https://www.youtube.com/watch?v=xNVlq9IEBEg
    https://www.youtube.com/watch?v=pTAda7qU4LY
    */
    
    public static void main(String[] args) {
        
        Student stu = new Student(); //object for student class
        Scanner kb = new Scanner(System.in);
        
        System.out.println(stu.WELCOME_MSG);
        String programChoice = kb.nextLine(); //input where user can continue program or wuit
        
        String menuChoice; //input to select different options from menu
        boolean exit=false;
        
        //user selects option whether to run program or not
        switch (programChoice) {
            case ("1"):
            
             //loop runs such that user is displayed with the menu options after executing each function
             //loop runs until user selects option 5 to quit program or when the ExitStudentApplication() method is executed   
             while (!exit) {
                 
                  System.out.println(stu.MENU);
                  menuChoice = kb.nextLine();
                  
            switch (menuChoice) {
                
            case "1":
                System.out.println("Enter the student's ID>>>");
                String id = kb.nextLine();
                
                //verifies whether the ID inputted is numeric and loop continuously runs until a valid ID is entered
                while (!stu.isIDNumeric(id)) {
                    System.out.println("\nPlease re-enter a valid student ID>>>");
                    id = kb.nextLine();
                }
                //String ID converted to an integer
                int ID = Integer.parseInt(id);
                
                System.out.println("Enter the student's age>>>");
                String age = kb.nextLine();
                //loop runs for as long as a numerical value is entered for age AND the age is 16 or above
                while (true) {
                    if (!stu.isAgeNumeric(age)) {
                        System.out.println("\nPlease re-enter a numerical value for student age>>>");
                        age = kb.nextLine();
                    }
                    
                   else if (!stu.isAgeValid(Integer.parseInt(age))) {
                        System.out.println("\nPlease re-enter a valid student age (16 or above)>>>");
                        age = kb.nextLine();
                    }
                    
                    //loop ends when age fits the requiements
                    if (stu.isAgeNumeric(age) && stu.isAgeValid(Integer.parseInt(age))) {
                        break;
                    }
                }
                //String Age converted to integer
                int studentAge = Integer.parseInt(age);
                
                System.out.println("Enter the student's name>>>");
                String name = kb.nextLine();
                
                System.out.println("Enter the student's email>>>");
                String email = kb.nextLine();
                
                System.out.println("Enter the student's course>>>");
                String course = kb.nextLine();
                
                //Student details saved by implementing the SaveStudent() method
                stu.SaveStudent(ID, name, studentAge, email, course);
                System.out.println("Student details have been successfully saved");
                break;
               
                
            case "2":
                System.out.println("Enter the Student ID to search>>>");
                int search = Integer.parseInt(kb.nextLine()); //.nextLine() function used instead of .nextInt() to avoid unexpected behaviour regarding the newline Character 
                System.out.println(stu.SearchStudent(search));
                String input = kb.nextLine();
                stu.ExitStudentApplication(input); //allows user to quit program by selecting any value except "1"
                break;
                
                
            case "3":
                boolean deleteConfirm; //boolean variable to hold user decision on deletion confirmation
                System.out.println("Enter the Student ID to delete>>> ");
                int IdDelete = Integer.parseInt(kb.nextLine());
                
                //checks if ID has been found in system for deletion
                if (stu.DeleteStudentFound(IdDelete) != -1) {
                    System.out.println(stu.DeleteStudentFoundMessage(IdDelete));
                    System.out.println("Are you sure you want to delete Student "
                        + IdDelete + " from the system? \nEnter \"Y\" to confirm or any other key to deny>>>");
                    String deleteConfirmation = kb.nextLine();
                    if (deleteConfirmation.equalsIgnoreCase("Y")) {
                        deleteConfirm = true; //student details will be deleted, as confirmed by user
                    }
                    else{
                        deleteConfirm = false; //student details will not be deleted, as confirmed by user
                    }
                    System.out.println(stu.DeleteStudent(IdDelete, deleteConfirm));
                }
                
                //returns message if student ID was not found
                else{
                    System.out.println(stu.DeleteStudentFoundMessage(IdDelete));
                }
                    
                input = kb.nextLine();
                stu.ExitStudentApplication(input); //allows user to quit program by selecting any value except "1"
                
                break;
                
                
            case "4": 
                System.out.println(stu.StudentReport()); //entire student report printed
                input = kb.nextLine();
                stu.ExitStudentApplication(input); //allows user to quit program by selecting any value except "1"
                break;
            
            case "5":
                exit = true; //breaks condition of loop and ends program
                break;
                
            default: System.out.println("\nInvalid Option Selected!"); //prints "Invalid" message when user does not choose from the selected menu
             break;
            }//end of inner switch case
             
             }//end of menu loop
             
        }//end of outer switch
        
    }//end of main method  
    
}//end of main class

