package pl.coderslab;

import org.apache.commons.lang3.*; //zastepuje 'import org.apache.commons.lang3.StringUtils;' oraz 'import org.apache.commons.lang3.math.NumberUtils;'
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks1.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;


    public static void main(String[] args) {

        menu();

    }


    public static void menu() {

        Scanner scan = new Scanner(System.in);

        boolean isRunMenu = true;

        while (isRunMenu) {          //repeat until the condition 'isRuMenu' is true

            //* 'menu' on display
            System.out.println(ConsoleColors.BLUE_BOLD + "Please select an option:" + ConsoleColors.RESET);

            for (int i = 0; i < OPTIONS.length; i++) {
                System.out.println();
                System.out.print(ConsoleColors.GREEN + OPTIONS[i] + ConsoleColors.RESET);

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
                    //  addTask;
                    System.out.println("wybrano add");
                    break;

                case "remove":
                    // removeTask;
                    System.out.println("wybrano remove");
                    break;

                case "list":
                    listTasks();
                    break;

                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Please select a correct option . " + ConsoleColors.RESET);
                    break;
            }

            // System.out.println(selectWithMenu);


        }
    }


    public static void listTasks(){

        //    File file = new File("tasks.csv");
            File file = new File("tasks1.csv"); //opction working to delete
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
