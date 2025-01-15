import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point of the program.
 * This class is responsible for reading from an input file,
 * processing data, and writing results to an output file.
 */
public class Main {

    /**
     * The main method that initializes the program by reading input from a file, processing the data,
     * and providing a framework for further user input.
     */
    public static void main(String[] args) {
        String fileName = "src/CHANGE_THIS";
        String outputFileName = "src/CHANGE_THIS";

        // Read data from the input file and store it in a list
        List<Integer> changeListNameAndType = readDataFromFile(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Reads data from the specified file and processes it line by line.
     *
     * @param fileName the path to the input file from which data is to be read.
     * @return a list of Domain items processed from the file.
     */
    public static List<Integer> readDataFromFile(String fileName) {
        List<Integer> changeList = new ArrayList<Integer>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("CHANGE THIS");

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return changeList;
    }

    /**
     * Writes data to the specified file.
     *
     * @param fileName the path to the output file where data will be written.
     * @param changeList the list of Domain item that will be written to the file.
     */
    public static void writeDataToFile(String fileName, List<Integer> changeList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}