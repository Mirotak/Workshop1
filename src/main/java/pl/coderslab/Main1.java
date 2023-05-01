package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main1 {
    static final String FILE_NAME = "tasks1.csv";
    static String[][] tasks = null;
    public static void main(String[] args) {




            File file = new File("tasks1.csv");
            try {
                Scanner scan = new Scanner(file);
                String str = "";

                while (scan.hasNextLine()) {
                    str += scan.nextLine() + ",";

                }
                String[] strArr = str.split(","); //change String on array

                System.out.println("strArr = " + Arrays.toString(strArr));

                String strFile = Arrays.toString(strArr);   //change Array to String File
                Path path1 = Paths.get("text5a.txt");   //create file
                Files.writeString(path1,strFile);           // copy String text to File

            } catch (FileNotFoundException e) {
                System.out.println("File not found !");

              } catch (IOException ex){
                System.out.println("File cannot be saved !");

                }


    }

    /*public static String[][] readData(String fileName) {
        String[][] tab = null;
        File file = new File(fileName);
        Path path = Paths.get(fileName);
        try {
            int lineCount = (int) Files.lines(path).count();
            Scanner scan = new Scanner(file);
            tab = new String[lineCount][3];
            for (int i = 0; i < lineCount; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(", ");
                for (int j = 0; j < 3; j++){
                    tab[i][j] = parts[j];
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return tab;
    }*/

    /*public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }*/
}