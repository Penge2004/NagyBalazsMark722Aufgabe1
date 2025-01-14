import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/CHANGE_THIS";
        String outputFileName = "src/CHANGE_THIS";
        List<Integer> changeListNameAndType = readDataFromFile(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Integer> readDataFromFile(String fileName) {
        List<Integer> changeList = new ArrayList<Integer>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("CHANGE THIS");

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return changeList;
    }

    public static void writeDataToFile(String fileName, List<Integer> changeList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}