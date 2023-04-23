package pl.coderslab;


import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import pl.coderslab.ConsoleColors;

public class TaskManager1 {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;

    public class SampleConsoleColors {


        public static void main(String[] args) {

            System.out.println(ConsoleColors.GREEN_BOLD + " green bold ");
            System.out.println(ConsoleColors.RED + " red ");
            System.out.println(ConsoleColors.BLUE + " blue ");
            System.out.println(ConsoleColors.RESET + " back to default");

        }

    }
  //  private static Object ConsoleColors(BLUE);

   /* public static void printOptions(String[] arrayOpt) {
        System.out.println(ConsoleColors.BLUE);

    }*/
    public static void main(String[] args) {



        File file = new File("tasks.csv");
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
        System.out.println();


    }

}