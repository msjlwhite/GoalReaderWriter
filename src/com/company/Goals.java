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
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.getKeyCode;

public class Goals{

    // Object & variable declaration
    Scanner scanner = new Scanner(System.in);               //
//    int opt;                                              //
    String opt;                                             //
    String goalType;                                        //
    String goal;                                            //
    Date date = new Date();
//    String test;
//    String test2;
//    String test3;



    public void goal() throws IOException{
        // add greeting
        System.out.println("Welcome to the Goal-O-Matic 3000 -- the World Reknown tool for viewing, creating and printing personal/" +
                "professional goals! ");
        System.out.println("");

        // add menu
        System.out.println("What would you like to do? Please choose from the following options: ");
        System.out.println("1 - Create A Goal");
        System.out.println("2 - Update A Goal");
        System.out.println("3 - View/Print Past Goals");
        System.out.println("0 - Save & Exit");
        System.out.println("");

        System.out.print("Please enter your choice here: ");
//        opt = scanner.nextInt();
        opt = scanner.nextLine(); //-- will work will scanner.nextLine() in createGoal()

//        do {
            // include a switch
            switch (Integer.parseInt(opt)) {
//        switch (opt){

                case 1:
                    createGoals();
                    break;
                case 2:
                    updateGoals();
                    break;
                case 3:
                    viewGoals();
                    break;
                case 0:
                default:
                    System.out.println("thank you. goodbye!");
                    break;

            } // end of switch

//        }// end of while loop

//        while(Integer.parseInt(opt)0);

//        // add loop to allow user to continue adding or printing goals
////        while (opt != 0){
////            System.out.println("");
////            goal();
////        }// end of while

    }// end of goal() Method

    public void createGoals() throws IOException {

        // Object & variable declaration
        FileWriter writer = new FileWriter("jTest3.txt");   // creates a FileWriter Object to create a new file to write to
        BufferedWriter buffer = new BufferedWriter(writer);            // writes text to a file



//        test = "this is a test ...";
//        System.out.print("Enter a message: ");
//        test2 = scanner.nextLine();

        /**
         *
         */
        System.out.print("Is this a <Short> or <Long> -term goal? ");
        goalType = scanner.nextLine();

        System.out.println("Please enter your goal below.");
        goal = scanner.nextLine();

        buffer.write("Goal Created: " + date);
        buffer.newLine();

        buffer.write("Is this a <Short> or <Long> -term goal? ");
        buffer.write(goalType);
        buffer.newLine();

        buffer.write("Please enter your goal: ");
        buffer.write(goal);
        buffer.newLine();

        buffer.flush();
        buffer.close();

        System.out.println("Would you like to add another goal? Please enter 'Y' for yes or 'N' for No. Y/N");
        opt = scanner.nextLine().toUpperCase();

        while (!opt.toString().equals("N")){
            addMoreGoals();
        }

    }// end of createGoal() Method

    public void addMoreGoals() throws IOException{

        BufferedWriter buffer = new BufferedWriter(new FileWriter("jTest3.txt",true));

        System.out.print("Is this a <Short> or <Long> -term goal? ");
        goalType = scanner.nextLine();

        System.out.println("Please enter your goal below.");
        goal = scanner.nextLine();

        buffer.write("Goal Created: " + date);
        buffer.newLine();

        buffer.write("Is this a <Short> or <Long> -term goal? ");
        buffer.write(goalType);
        buffer.newLine();

        buffer.write("Please enter your goal: ");
        buffer.write(goal);
        buffer.newLine();

        buffer.flush();
        buffer.close();

        System.out.println("Would you like to add another goal? Please enter 'Y' for yes or 'N' for No. Y/N");
        opt = scanner.nextLine().toUpperCase();

        while (!opt.toString().equals("N")){
            addMoreGoals();
        }

    }// end of addMoreGoals()

    public void updateGoals() throws IOException {
//        FileWriter writer = new FileWriter("jTest.txt");   // creates a FileWriter Object to create a new file to write to
        BufferedWriter buffer = new BufferedWriter(new FileWriter("jTest2.txt",true));

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

    public void viewGoals() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("jTest3.txt"));
        String text;
        while ((text = reader.readLine()) != null) {
            System.out.println(text);
        }

        System.out.println("");
        System.out.println("No goals here, just us crickets!");

        // allow to view past goals
        // view goal file or give goal file location for future access/viewing

    }// end of goal() Method




}// end of Goals {} Class
