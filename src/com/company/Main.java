/*
Date:
Author:
Task: Create a program that reads and writes to a .txt file. Currently, all our programs have not had any of its memory persist past runtime. This will give you an idea of what it takes to save data. In the future, we will save data to a database.

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

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Goals start = new Goals();
        start.goal();
    }
}
