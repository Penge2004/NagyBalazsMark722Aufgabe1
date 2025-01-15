import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

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
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String filePath = "src/health.xml";
        String outputFileName = "src/fallanzahl.txt";

        // Read data from the input file and store it in a list
        List<Patient> patients = readDataFromFile(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            //B
            System.out.print("Start letter:");
            Character startLetter = Character.toUpperCase(reader.readLine().charAt(0));
            HashSet<Patient> names = new HashSet<>();
            System.out.println("Names starting with " + startLetter);
            for (Patient patient : patients) {
                if (patient.getPatientName().startsWith(String.valueOf(startLetter)) && !names.contains(patient)) {
                    System.out.println(patient.getPatientName());
                    names.add(patient);
                }
            }

            //C
            List<Patient> fieber = new ArrayList<>();
            for (Patient patient : patients) {
                if (patient.getSymptoms().equals("Fieber"))
                    fieber.add(patient);
            }
            fieber.sort(Comparator.comparing(Patient::getDatum));
            System.out.println("All Fieber Patients: ");
            for (Patient patient : fieber) {
                System.out.println("Datum: " + patient.getDatum() + ":" +
                        patient.getPatientName() + " Symptoms: " + patient.getSymptoms());
            }

            //D

            HashMap<String,Integer> casesProHospital = new HashMap<>();
            for (Patient patient : patients) {
                String hospital = patient.getHospital();

                if(casesProHospital.containsKey(hospital)) {
                    casesProHospital.put(hospital, casesProHospital.get(hospital) + 1);
                }
                else{
                    casesProHospital.put(hospital, 1);
                }
            }
            List<Map.Entry<String,Integer>> sortedCasesProHospital = casesProHospital.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .toList();

//            for (Map.Entry<String,Integer> entry : sortedCasesProHospital) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }

            writeDataToFile(outputFileName,sortedCasesProHospital);
            System.out.println("Results written to " + outputFileName);




        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Reads data from the specified file and processes it line by line.
     *
     * @param filePath the path to the input file from which data is to be read.
     * @return a list of Domain items processed from the file.
     */
    public static List<Patient>readDataFromFile(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));
        List<Patient> patients = new ArrayList<>();

        NodeList logList = doc.getElementsByTagName("log");
        for (int i = 0; i < logList.getLength(); i++) {
            int id = Integer.parseInt(doc.getElementsByTagName("Id").item(i).getTextContent());
            String name = doc.getElementsByTagName("Patient").item(i).getTextContent();
            String symptoms = doc.getElementsByTagName("Symptom").item(i).getTextContent();
            String diagnose = doc.getElementsByTagName("Diagnose").item(i).getTextContent();
            String dateString = doc.getElementsByTagName("Datum").item(i).getTextContent();
            String hospital = doc.getElementsByTagName("Krankenhaus").item(i).getTextContent();

            LocalDate  date = LocalDate.parse(dateString);

            patients.add(new Patient(id,name,symptoms,diagnose,date,hospital));
        }
        return patients;
    }

    /**
     * Writes data to the specified file.
     *
     * @param fileName the path to the output file where data will be written.
     * @param results the list of Domain item that will be written to the file.
     */
    public static void writeDataToFile(String fileName, List<Map.Entry<String, Integer>> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : results) {
                writer.write(entry.getKey() + "$" + entry.getValue());
                writer.newLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}