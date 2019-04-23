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
import java.util.Scanner;
import java.io.*;

public class Goals{

    //class variables??
    Scanner scanner = new Scanner(System.in);
    int opt;


    public void goal() throws IOException{

//        File file = new File("gTest.txt"); // creates a file to save the goals to
//        FileWriter writer = new FileWriter(file);   // creates a FileWriter Object

        // add greeting
        System.out.println("Welcome to the Goal-O-Matic 3000 -- the World Renown tool for viewing, creating and printing personal/" +
                "professional goals!  ");
        System.out.println("");

        // add menu
        System.out.println("What would you like to do? Please choose from the following options: ");
        System.out.println("1 - Create A Goal");
        System.out.println("2 - View/Print Past Goals");
        System.out.println("0 - Save & Exit");
        System.out.println("");

        System.out.println("Please enter youre choice here: ");
        opt = scanner.nextInt();

        // include a switch
        switch (opt){

            case 1:
                createGoal();
                break;
            case 2:
                viewGoals();
                break;
            case 0:
                default:
                    System.out.println("thank you. goodbye!");
                    break;

        } // end of switch

        // add loop to allow user to continue adding or printing goals
        while (opt != 0){
            goal();
        }// end of while

    }// end of goal() Method

    public void createGoal() throws IOException {

//        File file = new File("gTest.txt"); // creates a file to save the goals to

        FileWriter writer = new FileWriter("gTest.txt");   // creates a FileWriter Object to create a new file to write to
        BufferedWriter buffer = new BufferedWriter(writer); // writes text to a file

        System.out.println("Create a goal? No? Then thank you, next!");

        buffer.write("Success -- Goal written! \n");
        buffer.write("Goal to gets this to work ... ");

        buffer.close();

        System.out.println("Create a goal? No? Then thank you, next! You did it?!!");

        System.out.println("Is this a long-term or short-term goal?");
        System.out.println("Please enter ");

        // creates the file
//        file.createNewFile();


        // ask for type of goal
        // ask for goal blurb
        // allow for automatic save of goal

    }// end of goal() Method

    public void viewGoals() {

        System.out.println("Create a goal? No? Then thank you, next!");

        // allow to view past goals
        // view goal file or give goal file location for future access/viewing

    }// end of goal() Method


}// end of Goals {} Class
