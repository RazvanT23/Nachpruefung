import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Aufgabe1 {
    private static final String TSV_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.tsv";
    private static final String OUTPUT_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\output.txt";
    private static final String XML_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\ninja_events.xml";

    private static final String JSON_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.json";
    private static List<Ninja> ninjas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            loadNinjasFromXml();


            System.out.println("Wähle eine Option:");
            System.out.println("1. Ninja mit min punkte");
            System.out.println("2. Display Stufe");
            System.out.println("3. speichere");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Geben Sie die minimale Kapazität ein:");
                    int minCapacity = Integer.parseInt(scanner.nextLine());
                    displayNinjasByCapacity(minCapacity);
                    break;
                case 2:
                    displayStufe();
                    break;
                case 3:
                    //saveIntoCSV();
                    saveGamesPerCity2();
                    break;
                default:
                    System.out.println("Ungültige Option, bitte erneut versuchen.");
            }
        }
    }

    private static void loadNinjasFromXml() {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            // Read XML file and map it to a List of Ninja objects
            List<Ninja> ninjaList = xmlMapper.readValue(new File(XML_FILE), xmlMapper.getTypeFactory().constructCollectionType(List.class, Ninja.class));

            ninjas.clear(); // Clear the existing list before adding new Ninjas
            ninjas.addAll(ninjaList); // Add the newly loaded Ninjas to the Ninjas list
            System.out.println(ninjas.size() + " Spiele erfolgreich aus XML geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der XML-Datei: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void displayNinjasByCapacity(int minCapacity) {
//        for (Ninja ninja : ninjas) {
//            if (ninja.getPunkte() >= minCapacity) {
//                System.out.println(ninja.getCharaktername()+" "+ninja.getPunkte());
//            }
//        }
        ninjas.stream()
                .filter(n -> n.getPunkte() > minCapacity)
                .distinct()
                .forEach(n -> System.out.println(n.getCharaktername() + "  " + n.getPunkte()));


    }

    private static void displayStufe() {
        ninjas.stream()
                .filter(ereignis -> ereignis.getStufe().equals("Jonin"))
                .sorted(Comparator.comparing(Ninja::getDatum).reversed())
                .forEach(ereignis -> System.out.println(ereignis.getDatum() + ": " + ereignis.getStufe()));

    }


    private static void saveIntoCSV() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Ninja ninja : ninjas) {
                writer.write(ninja.getStufe() + "******" + ninja.getDatum());
                writer.newLine();
            }
            System.out.println("Daten erfolgreich in " + OUTPUT_FILE + " gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }


    private static void saveGamesPerCity2() {
        Map<String, Integer> cityCounts = new HashMap<>();
        for (Ninja game : ninjas) {
            cityCounts.put(game.getStufe(), cityCounts.getOrDefault(game.getStufe(), 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(cityCounts.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()) != 0 ? b.getValue().compareTo(a.getValue()) : a.getKey().compareTo(b.getKey()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Map.Entry<String, Integer> entry : sortedList) {
                writer.write(entry.getKey() + "%" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Daten erfolgreich in " + OUTPUT_FILE + " gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }




}