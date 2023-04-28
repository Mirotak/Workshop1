package pl.coderslab;

import org.apache.commons.lang3.*; //zastepuje 'import org.apache.commons.lang3.StringUtils;' oraz 'import org.apache.commons.lang3.math.NumberUtils;'
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;

    

    public static void main(String[] args) {


     //   Scanner select = new Scanner(System.in);
        String selectWithMenu = "l";
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
            case "l":
                selectWithMenu = "list";
                // listTasks;
                break;
            default:
                selectWithMenu = "Please select a correct option . ";
                break;
        }
        System.out.println(selectWithMenu);







       /* File file = new File("tasks.csv");
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

}
