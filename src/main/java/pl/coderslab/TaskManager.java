package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks1.csv"; //worked file delete 'tasks1.csv' and please change on 'tasks.csv'
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] tasks;


    public static void main(String[] args) {

        fileDataToArray();
        menu();

    }

    //* 'menu' on display
    public static void menu() {

        Scanner scan = new Scanner(System.in);
        boolean isRunMenu = true;
        while (isRunMenu) {                 //repeat until the condition 'isRuMenu' is true
            System.out.println(ConsoleColors.BLUE_BOLD + "Please select an option:" + ConsoleColors.RESET);
            for (int i = 0; i < OPTIONS.length; i++) {
                System.out.println();
                System.out.print(ConsoleColors.RED + OPTIONS[i] + ConsoleColors.RESET);

            }
            System.out.println();

            String selectWithMenu = scan.next();
            System.out.println();

            switch (selectWithMenu) {
                case "exit":
                    System.out.println("wybrano exit");
                    isRunMenu = false;
                    break;

                case "add":
                      addTask();
                    break;

                case "remove":
                    // removeTask();
                    System.out.println("wybrano remove");
                    break;

                case "list":
                    listTasks();
                    break;

                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Please select a correct option . " + ConsoleColors.RESET);
                    break;
            }

        }
    }

    public static void addTask(){

        Scanner scanner = new Scanner(System.in);
            System.out.println("task data: desriptions, due date, important:(true/false) (data separate : comma + space ', ')");
            String sentance = scanner.nextLine();

            try (FileWriter fileWriter = new FileWriter("tasks1.csv", true)) {
                fileWriter.append(sentance + "\n");

            } catch (IOException exception) {
                exception.printStackTrace();

              }

    }

    public static void fileDataToArray() {

        try {
            StringBuilder reading = new StringBuilder();
            File file = new File(FILE_NAME);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                reading.append(scan.nextLine()).append(", ");

            }

            String sbToString = reading.toString();     //change StringBuilder to String

            String lestComma = sbToString.substring(0, sbToString.length() - 2).trim(); //delete the lest comma = ',' (comm + space) and trim space

            String[] parts = lestComma.split(", ");


            for (int i = 0; i < parts.length; i = i + 3) {     //readind from Array
                System.out.println(parts[i] + " " + parts[i + 1] + " " + parts[i + 2]);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

    }

    // list tasks with file
    public static void listTasks(){

            File file = new File(FILE_NAME);
            StringBuilder reading = new StringBuilder();
            try {
                Scanner scan = new Scanner(file);
                int i = 0;
                while (scan.hasNextLine()) {
                    reading.append(i + ":" + scan.nextLine() + "\n");
                    i++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
            System.out.println(reading);

    }

}
