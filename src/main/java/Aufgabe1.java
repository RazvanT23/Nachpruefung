import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Aufgabe1 {
    private static final String TSV_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.tsv";
    private static final String OUTPUT_FILE = "C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\java\\output.txt";
    private static final String XML_FILE="C:\\Users\\Legion\\Desktop\\MAP2\\Nachprufung\\src\\main\\ninja_events.xml";

    private static final String JSON_FILE="C:\\Users\\Legion\\Desktop\\MAP2\\untitled1\\src\\main\\java\\spielorte.json";
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
                   saveIntoCSV();
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
                .filter(n->n.getPunkte()>minCapacity)
                .distinct()
                .forEach(n->System.out.println(n.getCharaktername()+"  "+n.getPunkte()));



    }

    private static void displayStufe() {
        ninjas.stream()
                .filter(ereignis ->ereignis.getStufe().equals("Jonin"))
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
//
//
//    private static void saveNinjasPerCity2() {
//        Map<String, Integer> cityCounts = new HashMap<>();
//        for (Ninja Ninja : Ninjas) {
//            cityCounts.put(Ninja.getLocation(), cityCounts.getOrDefault(Ninja.getLocation(), 0) + 1);
//        }
//
//        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(cityCounts.entrySet());
//        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()) != 0 ? b.getValue().compareTo(a.getValue()) : a.getKey().compareTo(b.getKey()));
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
//            for (Map.Entry<String, Integer> entry : sortedList) {
//                writer.write(entry.getKey() + "%" + entry.getValue());
//                writer.newLine();
//            }
//            System.out.println("Daten erfolgreich in " + OUTPUT_FILE + " gespeichert.");
//        } catch (IOException e) {
//            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
//        }
//    }
//
//
//    private static void saveNinjasPerCity() {
//        List<String> cities = new ArrayList<>();
//        List<Integer> counts = new ArrayList<>();
//
//        // Get all unique cities and count Ninjas
//        for (Ninja Ninja : Ninjas) {
//            String location = Ninja.getLocation();
//            int index = cities.indexOf(location);
//
//            if (index == -1) {
//                // New city found
//                cities.add(location);
//                counts.add(1);
//            } else {
//                // Increment count for existing city
//                counts.set(index, counts.get(index) + 1);
//            }
//        }
//
//        // Sort cities based on counts
//        for (int i = 0; i < cities.size() - 1; i++) {
//            for (int j = 0; j < cities.size() - i - 1; j++) {
//                if (counts.get(j) < counts.get(j + 1) ||
//                        (counts.get(j).equals(counts.get(j + 1)) &&
//                                cities.get(j).compareTo(cities.get(j + 1)) > 0)) {
//                    // Swap counts
//                    int tempCount = counts.get(j);
//                    counts.set(j, counts.get(j + 1));
//                    counts.set(j + 1, tempCount);
//
//                    // Swap cities
//                    String tempCity = cities.get(j);
//                    cities.set(j, cities.get(j + 1));
//                    cities.set(j + 1, tempCity);
//                }
//            }
//        }
//
//        // Write to file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
//            for (int i = 0; i < cities.size(); i++) {
//                writer.write(cities.get(i) + "%" + counts.get(i));
//                writer.newLine();
//            }
//            System.out.println("Daten erfolgreich in " + OUTPUT_FILE + " gespeichert.");
//        } catch (IOException e) {
//            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
//        }
//    }




//    private static void saveIntoCSV() throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
//            for (StudentRecord record : records) {
//                writer.write( "," + record.getStudent() + "," +
//                        record.getHouse() + "," +   "," +
//                        record.getPoints());
//                writer.newLine();
//            }
//            System.out.println("Data successfully saved into " + outputFile);
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }


//    private static void loadRecords() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("&");
//                if (parts.length == 5) {
//                    int id = Integer.parseInt(parts[0]);
//                    String student = parts[1];
//                    String house = parts[2];
//                    String authority = parts[3];
//                    int points = Integer.parseInt(parts[4]);
//                    records.add(new StudentRecord(id, student, house, authority, points));
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
//        }
//    }


}

