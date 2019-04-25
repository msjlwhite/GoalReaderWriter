/*
Date:
Author:
Task: Create a program that reads and writes to a .txt file. Currently, all our programs have not had any of its
memory persist past runtime. This will give you an idea of what it takes to save data. In the future, we will
save data to a database.

For now, create a program that creates a prompt
- What would you like to do?
  - Create a goal
  - Print past goals

Create a goal allows you to input goals and adds a new line after each entry.
Creating a new goal should not overwrite past goals. The goals should persist after runtime.

Print past goals reads in goals from your text file.

Classes you may want to use:
FileWriter
BufferedWriter
*/

package com.company;

//import the following classes to help run the program
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Goals{

    // Object & variable declaration
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // display date and time in the following format
    Scanner scanner = new Scanner(System.in);               //
    String opt;                                             //
    String contd;
    String updt;
    String goalType;                                        //
    String goal;                                            //
    String name;                                            //
    int count = 0;
    int loop = 0;
    String goalStatus;

    public void goal() throws IOException{
        // add greeting
        System.out.println("Welcome to the Goal-O-Matic 3000 -- the World Renown tool for viewing, creating and printing personal/" +
                "professional goals! ");
        System.out.println("");

        System.out.print("Please enter your name: ");
        name = scanner.nextLine().toUpperCase();

        // add some code to find name file . . .

        // display date and time

        // add menu
//        System.out.println(java.time.LocalDate.now() + " " + java.time.LocalTime.now());

        // do ... while loop
        do {

            System.out.println(name + ", what would you like to do? Please choose from the following options: ");
            System.out.println("1 - Create A Goal");
            System.out.println("2 - Update A Goal");
            System.out.println("3 - View/Print Past Goals");
            System.out.println("0 - Save & Exit");
            System.out.println("");

            System.out.print("Please enter your choice here: ");
            opt = scanner.nextLine();
            System.out.println("");

            // include a switch
            switch (Integer.parseInt(opt)) {
                case 1:
                    createGoals(name);
                    break;
                case 2:
                    updateGoals(name);
                    break;
                case 3:
                    viewGoals(name);
                    break;
                case 0:
                default:
                    System.out.println(name + ", thank you. goodbye!");
                    break;

            } // end of switch

            loop++;

        } while (Integer.parseInt(opt) != 0);

//        // add loop to allow user to continue adding or printing goals
//        while (Integer.parseInt(opt) != 0){
//            System.out.println("");
//            goal();
//        }// end of while

    }// end of goal() Method

    public void createGoals(String a) throws IOException {

        // Object & variable declaration
        FileWriter writer = new FileWriter(name +".txt");   // creates a FileWriter Object to create a new file to write to
        BufferedWriter buffer = new BufferedWriter(writer);         // writes text to a file

        /**
         *
         */

        count++;
//        System.out.println("Count = " + count);
        System.out.print("Is this a <Short> or <Long> -term goal? ");
        goalType = scanner.nextLine().toUpperCase();

        //while loop to TRY and stop bad input
        while (!(goalType.equals("SHORT") && !(goalType.equals("LONG")))) {

            System.out.println("Invalid Response. Please enter 'Short' or 'Long' for goal type.");
            System.out.print("Is this a <Short> or <Long> -term goal? ");
            goalType = scanner.nextLine().toUpperCase();

        }

        System.out.println("Please enter your goal below.");
        goal = scanner.nextLine();
        goalStatus = "Ongoing ...";

//        if (loop >= 1){
//            addMoreGoals(name);
//        }

        //Prints the information that user entered into a text file
        buffer.write("Goal Created: " + formatter.format(date));
//        buffer.write("Goal Created: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        buffer.newLine();

        buffer.write("Goal Type: ");
        buffer.write(goalType);
        buffer.newLine();

        buffer.write("Goal Status: ");
        buffer.write(goalStatus);
        buffer.newLine();

        buffer.write(count + "). Goal: ");
        buffer.write(goal);
        buffer.newLine();
        buffer.newLine();

        buffer.flush();
        buffer.close();

        System.out.println("Would you like to add another goal? Please enter 'Y' for yes or 'N' for No. Y/N");
        contd = scanner.nextLine().toUpperCase();

        while (!contd.toString().equals("N")){
            addMoreGoals(name);
        }

    }// end of createGoal() Method

    public void addMoreGoals(String a) throws IOException{

        BufferedWriter buffer = new BufferedWriter(new FileWriter(name +".txt",true));

        count++;
//        System.out.println("Count = " + count);
        System.out.print("Is this a <Short> or <Long> -term goal? ");
        goalType = scanner.nextLine().toUpperCase();

        //while loop to TRY and stop bad input
        while (!(goalType.equals("SHORT") && !(goalType.equals("LONG")))) {

            System.out.println("Invalid Response. Please enter 'Short' or 'Long' for goal type.");
            System.out.print("Is this a <Short> or <Long> -term goal? ");
            goalType = scanner.nextLine().toUpperCase();

        }

        System.out.println("Please enter your goal below.");
        goal = scanner.nextLine();

        //Prints the information that user entered into a text file
        buffer.write("Goal Created: " + formatter.format(date));
        buffer.newLine();

        buffer.write("Goal Type: ");
        buffer.write(goalType);
        buffer.newLine();

        goalStatus = "Ongoing ...";

        buffer.write("Goal Status: ");
        buffer.write(goalStatus);
        buffer.newLine();

        buffer.write(count + "). Goal: ");
        buffer.write(goal);
        buffer.newLine();
        buffer.newLine();

        buffer.flush();
        buffer.close();

        System.out.println("Would you like to add another goal? Please enter 'Y' for yes or 'N' for No. Y/N");
        contd = scanner.nextLine().toUpperCase();

        while (!contd.toString().equals("N")){
            addMoreGoals(name);
        }

    }// end of addMoreGoals()

    public void updateGoals(String a) throws IOException {
//        FileWriter writer = new FileWriter("jTest.txt");   // creates a FileWriter Object to create a new file to write to
        BufferedWriter buffer = new BufferedWriter(new FileWriter(name +".txt",true));

        //ask user whether they would like to update
            // find goal
            // options will be
                // update -- add to goal or change goal status
                // DELETE/REMOVE Goal ... dun dun DUH!!
        System.out.println(name + ", please chose how you would like to update your goals?");


        System.out.print("Is this a <Short> or <Long> -term goal? ");
        goalType = scanner.nextLine();

        System.out.println("Please enter your goal below.");
        goal = scanner.nextLine();

        buffer.write("Goal Created: " + date);
        buffer.newLine();

        buffer.write("Is this a <Short> or <Long> -term goal?");
        buffer.write(goalType);
        buffer.newLine();

        buffer.write("Please enter your goal: ");
        buffer.write(goal);
        buffer.newLine();

        buffer.flush();
        buffer.close();

        System.out.println("No Additional goals to update yet?");

    }

    public void viewGoals(String a) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(name +".txt"));
        String text;

        // allow to view past goals
        while ((text = reader.readLine()) != null) {
            System.out.println(text);
        }

        System.out.println("");
        System.out.println("No goals here, just us crickets!");

        
        // view goal file or give goal file location for future access/viewing

    }// end of goal() Method


}// end of Goals {} Class
