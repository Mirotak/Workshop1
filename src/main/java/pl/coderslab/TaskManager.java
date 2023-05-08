package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
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
        while (isRunMenu) {                 //repeat until the condition 'isRunMenu' is true
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
                    System.out.println(ConsoleColors.CYAN_BOLD + "See you next time." + ConsoleColors.RESET);
                    isRunMenu = false;
                    break;

                case "add":
                      addTask();
                    break;

                case "remove":
                    removeTask();
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

    public static void removeTask() {

        // list of the array with the index to be deleted
        /*for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + ": " + Arrays.toString(tasks[i]) + "\n");

        }*/
        listTasks();
        //checking if both conditions are met if an integer is being entered and if it is within the range of the array
        int nrTaskToDelete = -1;
        boolean validation = false;
        while (!validation){
            //enter the index number of the task to be deleted
            System.out.println("Please select number to remove. ( 0 - " + (tasks.length - 1) + " )");
            Scanner scan = new Scanner(System.in);

            while (!scan.hasNextInt()) {                                          //check if the entered text is an integer
                scan.next();                                                     //read the entered text
                System.out.print("Incorrect data. Try again.");
            }

            nrTaskToDelete = scan.nextInt();                                    // assigning the entered value to the variable

            if ((nrTaskToDelete >= 0) && (nrTaskToDelete < (tasks.length))) {   //check if there is a task with the given index
                validation = true;                                              //the specified job index is valid
            } else {
                validation = false;                                             //the specified job index is outside the available range

            }

        }
        tasks = ArrayUtils.remove(tasks, nrTaskToDelete);                       //delete the task with the selected index
        System.out.println(ConsoleColors.GREEN_BOLD + "Value was successfully deleted." + ConsoleColors.RESET);

        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
            for (int i = 0; i < tasks.length; i++){
                printWriter.println(StringUtils.join(tasks[i], ", "));
            }
        }
        catch(FileNotFoundException exception){
            exception.printStackTrace();
        }

        // optional - display array after delete task
        /*for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + ": " + Arrays.toString(tasks[i]) + "\n");

        }*/
    }


    public static String[][] fileDataToArray(){

        Scanner scanNr = new Scanner(System.in);
        Path file = Paths.get(FILE_NAME);

        try {
            int lineCount = (int) Files.lines(Paths.get(FILE_NAME)).count();
            Scanner scan = new Scanner(file);
            tasks = new String[lineCount][3];
            for (int i = 0; i < lineCount; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(", ");
                for (int j = 0; j < 3; j++){
                    tasks[i][j] = parts[j];

                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return tasks;

    }


    public static void addTask(){

        Scanner scanner = new Scanner(System.in);
            System.out.println(ConsoleColors.YELLOW_BOLD + "task data: desriptions, due date, important:(true/false) (data separate : comma + space ', ')" + ConsoleColors.RESET);
            String sentance = scanner.nextLine();

            try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
                fileWriter.append(sentance + "\n");

            } catch (IOException exception) {
                exception.printStackTrace();

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
