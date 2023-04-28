package pl.coderslab;

import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManager {
    /*static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] task;*/

    

    public static void main(String[] args) {
        System.out.println("args = "        );

            String str = "Programuj z CodersLab!";
            System.out.println(StringUtils.deleteWhitespace(str));
            System.out.println(StringUtils.reverse(str));
            System.out.println(StringUtils.swapCase(str));



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