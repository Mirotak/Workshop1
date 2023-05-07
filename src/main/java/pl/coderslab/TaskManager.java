package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

       // removeTask();

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
                    System.out.println("");
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

        // wyswietlenie listy z tablicy z indeksem do usuniecia
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + ": " + Arrays.toString(tasks[i]) + "\n");

        }
        //sprawdzanie czy oba warunki sa spelnione czy jest wprowadzana liczba całkowita oraz czy mieści sie w zakresie tablicy
        int nrTaskToDelete = -1;
        boolean validation = false;
        while (!validation){
            //wprowadzenie nr indeksu zadania do usuniecia
            System.out.println("Please select number to remove. ( 0 - " + (tasks.length - 1) + " )");
            Scanner scan = new Scanner(System.in);

            while (!scan.hasNextInt()) {                                          //sprawdzenie czy wprowadzana tekst jest liczba całkowitą
                scan.next();                                                     //odczytanie wprowadzonego tekstu
                System.out.print("Incorrect data. Try again.");
            }

            nrTaskToDelete = scan.nextInt();                                    // przypisanie zmiennej wprowadzonej wartości

            if ((nrTaskToDelete >= 0) && (nrTaskToDelete < (tasks.length))) {   //sprawdzenie czy istnieje zadanie o podanym indeksie
                validation = true;                                              //podany indeks zadania jest prawidłowy
            } else {
                validation = false;                                             //podany indeks zadania jest poza dostępnym zakresem

            }

        }
        tasks = ArrayUtils.remove(tasks, nrTaskToDelete);                       //usuniecie zadania o wybranym indeksie

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
            System.out.println("task data: desriptions, due date, important:(true/false) (data separate : comma + space ', ')");
            String sentance = scanner.nextLine();

            try (FileWriter fileWriter = new FileWriter("tasks.csv", true)) {
                fileWriter.append(sentance + "\n");

            } catch (IOException exception) {
                exception.printStackTrace();

              }

    }

   /* public static void fileDataToArray() {

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

    }*/

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
