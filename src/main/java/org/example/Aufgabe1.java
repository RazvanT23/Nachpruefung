package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;

public class Aufgabe1 {
    private static final String TSV_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.tsv";
    private static final String OUTPUT_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\org\\example\\output.txt";
    private static final String XML_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\evenimente.xml";

    private static final String JSON_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.json";
    private static List<Ereignisse> ereignisses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            loadGamesFromXml();

            System.out.println("Wähle eine Option:");
            System.out.println("1. Spiele mit Mindestkapazität anzeigen");
            System.out.println("2. Spiele in München nach dem 30.06.2024 anzeigen");
            System.out.println("3. Spiele pro Stadt speichern");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Enter a char for a filtering purpose");
                    String c = scanner.nextLine();
                    showStudentsByChar(c.charAt(0));
                    break;
                case 2:
                    displayDiagnose();
                    break;
                case 3:
                    saveIntoCSV();
                    break;
                default:
                    System.out.println("Ungültige Option, bitte erneut versuchen.");
            }
        }
    }

    private static void loadGamesFromXml() {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            // Read XML file and map it to a List of Game objects
            List<Ereignisse> ereignisseList = xmlMapper.readValue(new File(XML_FILE), xmlMapper.getTypeFactory().constructCollectionType(List.class, Ereignisse.class));

            ereignisses.clear(); // Clear the existing list before adding new games
            ereignisses.addAll(ereignisseList); // Add the newly loaded games to the games list
            System.out.println(ereignisses.size() + " Spiele erfolgreich aus XML geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der XML-Datei: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayDiagnose() {
        ereignisses.stream()
                .filter(fall -> fall.getHaus().equals("Stark"))
                .sorted(Comparator.comparing(Ereignisse::getDatum))
                .forEach(fall -> System.out.println(fall.getDatum() + ": " + fall.getEreignis()));

    }

    private static void saveIntoCSV() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Ereignisse ereignisse : ereignisses) {
                writer.write(", m" + ereignisse.getEreignis() + "," +
                        ereignisse.getMitgliedsname() + "," + "," +
                        ereignisse.getDatum());
                writer.newLine();
            }
            System.out.println("Data successfully saved into " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    private static void showStudentsByChar(char c) {
        List<String> names = new ArrayList<>();
        for (Ereignisse ereignisse : ereignisses) {
            // Trim in case there are spaces around the name
            names.add(ereignisse.getMitgliedsname().trim());
        }

        // Convert both the name and the filter char to lowercase
        names.stream()
                .filter(name -> name.toLowerCase().startsWith(String.valueOf(c).toLowerCase()))
                .forEach(System.out::println);
    }


}

