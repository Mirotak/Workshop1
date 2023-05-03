package pl.coderslab;

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
    static String[][] tasks;
    public static void main(String[] args) {


          /*  File file = new File("tasks1.csv");
            try {
                Scanner scan = new Scanner(file);
                String str = "";

                while (scan.hasNextLine()) {
                    str += scan.nextLine() + ",";

                }
                String[] strArr = str.split(","); //change String on array

                System.out.println("strArr = " + Arrays.toString(strArr));

                for (int i = 0; i < 9; i = i + 3) {
                    System.out.println("strArr = " + strArr[i]);

                }

                String strFile = Arrays.toString(strArr);   //change Array to String File
                Path path1 = Paths.get("text5a.txt");   //create file
                Files.writeString(path1,strFile);           // copy String text to File

            } catch (FileNotFoundException e) {
                System.out.println("File not found !");

              } catch (IOException ex){
                System.out.println("File cannot be saved !");

                }*/

        fileDataToArray();

    }

    public static void fileDataToArray()  {

        try {
            StringBuilder reading = new StringBuilder();
            File file = new File(FILE_NAME);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                reading.append(scan.nextLine()).append(", ");

            }

            String sbToString = reading.toString();     //change StringBuilder to String

            String lestComma = sbToString.substring(0, sbToString.length()-2).trim(); //delete the lest comma = ',' (comm + space) and trim space

            String[] parts = lestComma.split(", "); //division String on parts Array 'comma + space'

            for (int i = 0; i < parts.length; i = i + 3) {     //readind from Array
                System.out.println(parts[i] + " " + parts[i + 1] + " " + parts[i + 2]);

            }

//            String[] nameTask = new String[]{""};
//            String[] dataTask = new String[]{""};
//            String[] importantTask = new String[]{""};
//
//            for (int i = 0; i < parts.length; i = i + 3) {     //readind from Array
//                nameTask += parts[i];
//                dataTask += parts[i + 1];
//                importantTask += parts[i + 2];
//
//            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }


    }



    /*String strFile = Arrays.toString(parts);   //change Array to String File

            System.out.println("strFile = " + strFile);

            Path path1 = Paths.get("text5a.csv");   //create file
            Files.writeString(path1,strFile);           // copy String text to File
*/



    /* // read data with file and write to array
    public static String [][] fileDataToArray(){

        try {
            File file = new File(FILE_NAME);
            Path path = Paths.get(FILE_NAME);
            int linesArray = (int) Files.lines(path).count();   // count lines and change on integer
            Scanner scan = new Scanner(file);

            int partsLine = 3 ;
            String[][] tasks = new String[linesArray][partsLine];

            for (int i = 0; i < linesArray; i++) {
                String line = scan.nextLine();            //read line
                String[] parts = line.split(", ");  // cut line on parts

                for (int j = 0; j < partsLine; j++){      // parts of line
                    tasks[i][j] = parts[j];

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
          }
          catch (IOException ex){
            ex.printStackTrace();
          }
    return tasks;

    }*/

    /*private static void getList(){
        tasks = new String[0][3];
        try{
            for(String s : Files.readAllLines(Path.of("tasks1.csv"))) {
                String[] nextTab = s.trim().split(",");
                tasks = Arrays.copyOf(tasks, tasks.length + 1);
                tasks[tasks.length - 1] = nextTab;
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not exist");
        }catch (IOException e){
            System.out.println(e);
        }
    }*/

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