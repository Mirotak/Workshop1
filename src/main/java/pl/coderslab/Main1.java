package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main1 {
    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;
    public static void main(String[] args) {

        fileDataToArray();

    //// tablica dwuwymiarowa i usuwanie linii
        /*String[][] firstNames = {
                        {"Abigail", "Alexandra", "Alison", "Amanda"},
                        {"aaaa", "ssssss", "dddddd", "fffff"},
                        {"attt", "stttts", "dtttyd", "rtfgg"}
                };*/

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

                while (!scan.hasNextInt()) { //sprawdzenie czy wprowadzana tekst jest liczba całkowitą
                scan.next();             //odczytanie wprowadzonego tekstu
                System.out.print("Incorrect data. Try again.");
                }

                nrTaskToDelete = scan.nextInt();    // przypisanie zmiennej wprowadzonej warotsci

                if ((nrTaskToDelete >= 0) && (nrTaskToDelete < (tasks.length))) { //sprawdzenie czy istnieje zdaanie o podanym indeksie
                    validation = true; //podany index zadania jest prawidłowy
                } else {
                    validation = false; //podany iondex zadania jest poza dostępnym zakresem

                  }

            }

        String[][] tasks_buf = ArrayUtils.remove(tasks, nrTaskToDelete); //usuniecie zadania o wybranym indexie

      //  System.out.println("tasks = " + tasks_buf);



        try (PrintWriter printWriter = new PrintWriter("printWriter.csv")) {
            for (int i = 0; i < tasks_buf.length; i++){
                printWriter.println(StringUtils.join(tasks_buf[i], ", "));
            }
        }
        catch(FileNotFoundException exception){
            exception.printStackTrace();
        }


            //// utworzenie pliku i zapisanie do niego dwoch linii; opcja append : false - nadpisanie pliku ; true - dopisanie do pliku;
//            try (PrintWriter printWriter = new PrintWriter("printwriter.csv")){

//                for (int i = 0; i < tasks_buf.length; i++) {
//
//                    tasks_buf[i] = tasks[i];
//                    if (i >= nrTaskToDelete){
//                        tasks_buf[i] = tasks[i+1];
//                        //fileWriter.append(sentance + "\n");
//
//
//                    }
//                   // System.out.println("tasks_buf[i] = " + i + " : " + Arrays.toString(tasks_buf[i]));
//                }
//                tasks[][] = Arrays.copyOf(tasks_buf,tasks_buf.length-1);
//
//                for (int i = 0; i < tasks_buf.length; i++) {
//                    System.out.println("tasks_buf[i] = " + tasks_buf[i]);
//                }
//                for (int i = 0; i < tasks.length; i++) {
//                    System.out.println("tasks[i] = " + tasks[i]);
//                }
//
               // System.out.println("Arrays.toString(tasks) = " + Arrays.toString(tasks));

//            } catch (IOException ex) {
//                System.out.println("Błąd zapisu do pliku.");
//
//            }




             //   System.out.println(Arrays.toString(firstNames)); // wyświetlamy testowo jej elementy

               // firstNames = ArrayUtils.remove(firstNames, 0); //

              //  System.out.println(Arrays.toString(firstNames));

/////////////////////////////////////////////////////////////////////////////


        /*//// utworzenie pliku i zapisanie do niego dwoch linii; opcja append : false - nadpisanie pliku ; true - dopisanie do pliku;
        try (FileWriter fileWriter = new FileWriter("writeFile.txt", false)){
            fileWriter.append("first line\n");
            fileWriter.append("second line\n");
        } catch (IOException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }*/



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