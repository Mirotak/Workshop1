package pl.coderslab;

import org.apache.commons.lang3.*; //zastepuje 'import org.apache.commons.lang3.StringUtils;' oraz 'import org.apache.commons.lang3.math.NumberUtils;'
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks1.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;

    

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println(ConsoleColors.BLUE_BOLD + "Please select an option:" + ConsoleColors.RESET);
        for (int i = 0; i < OPTIONS.length; i++) {
            System.out.println();
            System.out.print(ConsoleColors.GREEN + OPTIONS[i] + ConsoleColors.RESET);

        }
        String selectWithMenu = scan.nextLine();
        System.out.println();

        switch (selectWithMenu) {
//            case 'e':
//                selectWithMenu = "exit";
//                //
//                break;
//            case 'a':
//                selectWithMenu = "add";
//              //  addTask;
//                break;
//            case 'r':
//                selectWithMenu = "remove";
//                // removeTask;
//                break;
            case "list":
                selectWithMenu = "list";
                // listTasks;
                break;
            default:
                selectWithMenu = "Please select a correct option . ";
                break;
        }
        System.out.println(selectWithMenu);



       /* File file = new File("tasks1.csv");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                reading.append(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
        System.out.println(reading);
        System.out.println();*/
    }

   /* private static listTasks(String[][]){


    }*/




}
