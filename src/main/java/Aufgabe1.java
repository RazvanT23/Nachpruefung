import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;

public class Aufgabe1 {
    private static final String TSV_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\puncte.tsv";
    private static final String OUTPUT_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\output.txt";
    private static final String XML_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.xml";

    private static final String JSON_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.json";
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {

            loadStudents();
            System.out.println("Wähle eine Option:");
            System.out.println("1. Spiele mit Mindestkapazität anzeigen");
            System.out.println("2. Spiele in München nach dem 30.06.2024 anzeigen");
            System.out.println("3. Spiele pro Stadt speichern");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Geben Sie einen Buchstaben ein:");
                    char c = scanner.nextLine().toUpperCase().charAt(0);
                    showEreignisByChar(c);
                    break;
                case 2:
                    displayEreignise();
                    break;
                case 3:
                    saveIntoCSV();
                    break;
                default:
                    System.out.println("Ungültige Option, bitte erneut versuchen.");
            }
        }
    }


    private static void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TSV_FILE))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split("\t");
                    if (parts.length == 5) {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        String haus = parts[2].trim();
                        String autoritat = parts[3].trim();
                        int capacity = Integer.parseInt(parts[4].trim());

                        students.add(new Student(id, name, haus, autoritat, capacity));
                    } else {
                        System.out.println("Ungültige Anzahl von Feldern in Zeile: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Fehler beim Parsen der Zahlen in Zeile: " + line);
                }
            }
            System.out.println(students.size() + " Spiele erfolgreich geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void showEreignisByChar(char c) {
        students.stream()
                .filter(e -> e.getName().toUpperCase().startsWith(String.valueOf(c)))
                .forEach(e -> System.out.println(e.getName() + ": " + e.getHaus()));
    }

    private static void displayEreignise() {
        students.stream()
                .filter(ereignis -> ereignis.getHaus().equals("Gryffindor"))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(ereignis -> System.out.println(ereignis.getName() + ": " + ereignis.getHaus()));

    }

    private static void saveIntoCSV() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Student ereignis : students) {
                writer.write(ereignis.getHaus() + "******" + ereignis.getAutoritat());
                writer.newLine();
            }
            System.out.println("Daten erfolgreich in " + OUTPUT_FILE + " gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }


}