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



        boolean isRunMenu = true;
        System.out.println(ConsoleColors.BLUE_BOLD + "Please select an option:" + ConsoleColors.RESET);
        while (isRunMenu){

            for (int i = 0; i < OPTIONS.length; i++) {
                System.out.println();
                System.out.print(ConsoleColors.GREEN + OPTIONS[i] + ConsoleColors.RESET);

            }

            String selectWithMenu = scan.next();
            System.out.println();

            switch (selectWithMenu) {
              case "exit":
                selectWithMenu = "exit";
                isRunMenu = false;
                //
                break;
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
                    selectWithMenu = (ConsoleColors.RED_BOLD_BRIGHT + "Please select a correct option . " + ConsoleColors.RESET);
                    break;
              }

            System.out.println(selectWithMenu);
        }



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

   /* public static void listTasks(String[][]){
        for (int i = 0; i < ; i++) {

        }


    }*/




}
