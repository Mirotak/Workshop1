package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main1 {
    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;
    public static void main(String[] args) {


     /*   Scanner scanner = new Scanner(System.in);
        //   boolean isWorking = true;

        //    while (isWorking) {
        System.out.println("task data: desriptions, due date, important:(true/false) (data separate : comma + space ', ')");
        String sentance = scanner.nextLine();
        //       if (sentance.equals("quit")) {
        //           isWorking = false;
        //     } else {
        // zapis do pliku sentance
        try (FileWriter fileWriter = new FileWriter("tasks.csv", true)) {
            fileWriter.append(sentance + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //     }
        //   }

        ///////////////////////////////////////wczytanie z pliku
        File file = new File("tasks.csv");
        StringBuilder sbReading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                sbReading.append(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println(sbReading);*/

      /*  ///////////wpisanie do pliku
        Scanner scanner = new Scanner(System.in);
        boolean isWorking = true;

        while (isWorking) {
            System.out.print("Wprowadz: Nazwisko Imie RokUrodzenia Płeć: (dane oddziel spacją ) ( quit - wyjście)");
            String sentance = scanner.nextLine();
            if (sentance.equals("quit")) {
                isWorking = false;
            } else {
                // zapis do pliku sentance
                try (FileWriter fileWriter = new FileWriter("text1.csv", true)) {
                    fileWriter.append(sentance + "\n");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        }

        ///////////////////////////////////////wczytanie z pliku
        File file = new File("text1.csv");
        StringBuilder sbReading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                sbReading.append(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println(sbReading);
*/
       // fileDataToArray();

    }

   /* public static void fileDataToArray()  {

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


    }*/



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
            for(String s : Files.readAllLines(Path.of("tasks.csv"))) {
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

    /*   ////////////////////////////////////// wprowadzenie danych w linii do stringa[]

        Scanner scan = new Scanner(System.in);
        Boolean isWork = false;

        String data = "";

        while (!isWork == true) {

            System.out.println("Wprowadz: Nazwisko Imie RokUrodzenia Płeć: (dane oddziel spacją ) ( quit - wyjście)");

            if (data.equals("quit")) {
                System.out.println("data = " + data);
                isWork = true;
            } else {
                data += scan.nextLine() + "\n";
                // data = scan.nextLine() + "\n";
                String[] arrData = data.split(" \n");
                System.out.println(data);
                System.out.println(Arrays.toString(arrData));
            }
        }
        //System.out.println(data);*/


}