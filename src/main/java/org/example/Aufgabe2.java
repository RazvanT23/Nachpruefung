package org.example;

import org.example.Charakter;
import org.example.Product;

import java.util.*;

class qAufgabe2 {
    private static List<Product> products = new ArrayList<>();
    private static List<Charakter> charakters = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Wählen Sie eine Option:");
            System.out.println("1. medi CRUD");
            System.out.println("2. patentie CRUD");
            System.out.println("3. Patienten nach Diagnose");
            System.out.println("4. Medikamente eines Patienten");
            System.out.println("5. Medikamente nach Preis sortieren");
            System.out.println("6. Beenden");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    mediCRUD();
                    break;
                case 2:
                    patienteCRUD();
                    break;
                case 3:
                    filterByDiagnose();
                    break;
                case 4:
                    showPatietenMed();
                    break;
                case 5:
                    sortMeds();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Bitte wählen Sie eine gültige Option");
            }
        }
    }

    private static void mediCRUD() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Erstellen");
        System.out.println("2. Aktualisieren");
        System.out.println("3. Anzeigen");
        System.out.println("4. Löschen");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createMed();
                break;
            case 2:
                updateMed();
                break;
            case 3:
                readMed();
                break;
            case 4:
                deleteMed();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void createMed() {
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        System.out.println("Preis eingeben:");
        int preis = Integer.parseInt(scanner.nextLine());
        System.out.println("herkunft region eingeben:");
        String krankheit = scanner.nextLine();


        Product medikament = new Product(name, preis, krankheit);
        products.add(medikament);
        System.out.println("Med erstellt: " + medikament);
    }

    private static void updateMed() {
        System.out.println("Name des zu aktualisierenden Med:");
        String name = scanner.nextLine();
        for (Product product:products) {
            if (product.getName().equals(name)) {
                System.out.println("Neuen Namen eingeben:");
                product.setName(scanner.nextLine());
                System.out.println("Neues preis eingeben:");
                product.setPreis(Integer.parseInt(scanner.nextLine()));
                System.out.println("Neue her eingeben:");
                product.setHerkunftsregion(scanner.nextLine());

                System.out.println("Med aktualisiert: " + product.getName()+" "+product.getPreis()+" "+product.getHerkunftsregion());
                return;
            }
        }
        System.out.println("Med nicht gefunden");
    }

    private static void readMed() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle prod anzeigen");
        System.out.println("2. Bestimmten prod suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllMed();
                break;
            case 2:
                findSpecificMed();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllMed() {
        if (products.isEmpty()) {
            System.out.println("Keine Spieler vorhanden");
            return;
        }
        System.out.println("Alle Spieler:");
        for (Product medikament : products) {
            System.out.println(medikament);
        }
    }

    private static void findSpecificMed() {
        System.out.println("Name des Meds eingeben:");
        String name = scanner.nextLine();
        boolean found = false;

        for (Product medikament : products) {
            if (medikament.getName().equals(name)) {
                System.out.println("Gefundener Med: " + medikament);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Med nicht gefunden");
        }
    }


    private static void deleteMed() {
        System.out.println("Name des zu löschenden Spielers:");
        String name = scanner.nextLine();
        products.removeIf(med -> med.getName().equals(name));
    }

    private static void patienteCRUD() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Erstellen");
        System.out.println("2. Aktualisieren");
        System.out.println("3. Anzeigen");
        System.out.println("4. Löschen");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createPatient();
                break;
            case 2:
                updatePatient();
                break;
            case 3:
                readPatient();
                break;
            case 4:
                deletePatient();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void createPatient() {
        System.out.println("ID eingeben:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        System.out.println("herkunft eingeben:");
        String her = scanner.nextLine();



        Charakter charakter=new Charakter(id,name,her);

        // Add players to the team
        boolean addMoreMeds = true;
        while (addMoreMeds) {
            System.out.println("Möchten Sie einen Med hinzufügen? (Ja/Nein)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Ja")) {
                System.out.println("Patientname eingeben:");
                String name1 = scanner.nextLine();
                System.out.println("Preis des Meds eingeben:");
                int preis = Integer.parseInt(scanner.nextLine());
                System.out.println("her des Meds eingeben:");
                String her2 = scanner.nextLine();


                Product product=new Product(name1,preis,her2);
                charakter.addProd(product);


                System.out.println("Med hinzugefügt: " + product);
            } else {
                addMoreMeds = false;
            }
        }

        charakters.add(charakter);
        System.out.println("Patient erstellt: " + charakter);
    }


    private static void updatePatient() {
        System.out.println("ID des zu aktualisierenden Patient:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Charakter patienten : charakters) {
            if (patienten.getId() == id) {
                System.out.println("Neuen Namen eingeben:");
                patienten.setName(scanner.nextLine());
                System.out.println("Neue her eingeben:");
                patienten.setHerkunftsregion(scanner.nextLine());


                System.out.println("Patient aktualisiert: " + patienten.getId()+" "+patienten.getName()+" "+patienten.getHerkunftsregion());
                return;
            }
        }
        System.out.println("Patient nicht gefunden");
    }

    private static void readPatient() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle Patient anzeigen");
        System.out.println("2. Bestimmten Patient suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllPatient();
                break;
            case 2:
                findSpecificPatient();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllPatient() {
        if (charakters.isEmpty()) {
            System.out.println("Keine Patient vorhanden");
            return;
        }
        System.out.println("Alle Patient:");
        for (Charakter patienten : charakters) {
            System.out.println(patienten);
        }
    }

    private static void findSpecificPatient() {
        System.out.println("Geben Sie die Suchkriterien ein:");
        System.out.println("1. Nach ID suchen");
        System.out.println("2. Nach Name suchen");

        int searchChoice = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        switch (searchChoice) {
            case 1:
                System.out.println("ID eingeben:");
                int id = Integer.parseInt(scanner.nextLine());
                for (Charakter patienten : charakters) {
                    if (patienten.getId() == id) {
                        System.out.println("Gefundener Patient: " + patienten);
                        found = true;
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("Name eingeben:");
                String name = scanner.nextLine();
                    for (Charakter patienten : charakters) {
                    if (patienten.getName().equals(name)) {
                        System.out.println("Gefundener Patient: " + patienten);
                        found = true;
                        break;
                    }
                }
                break;

            default:
                System.out.println("Ungültige Option");
                return;
        }

        if (!found) {
            System.out.println("Patient nicht gefunden");
        }
    }

    private static void deletePatient() {
        System.out.println("ID des zu löschenden Patient:");
        int id = Integer.parseInt(scanner.nextLine());
        charakters.removeIf(pat -> pat.getId() == id);
    }

    private static void filterByDiagnose() {
        System.out.println("region eingeben:");
        String diagnose = scanner.nextLine();
        List<Charakter> filteredPatienten = new ArrayList<>();

        for (Charakter patienten:charakters) {
            if (patienten.getHerkunftsregion().equals(diagnose)) {
                filteredPatienten.add(patienten);
            }
        }

        System.out.println("charakter " + diagnose + ":");
        for (Charakter patienten:charakters) {
            System.out.println(patienten);
        }
    }
//
//
    private static void showPatietenMed() {
        System.out.println("prod region eingeben:");
        String medName = scanner.nextLine();

        for (Charakter patienten:charakters) {
            if (patienten.getName().equals(medName)) {
                System.out.println("Patienten mit " + medName + ":");
                for (Product medikament : patienten.getProducts()) {
                    System.out.println(medikament);
                }
                return;
            }
        }
        System.out.println("Medikament nicht gefunden");
    }
//
    private static void sortMeds() {
        System.out.println("Patienten  eingeben:");
        String name = scanner.nextLine();
        System.out.println("Sortiermodus (1 = aufsteigend, 2 = absteigend):");
        int mode = Integer.parseInt(scanner.nextLine());

        for (Charakter patienten:charakters) {
            if (patienten.getName().equalsIgnoreCase(name)) {
                List<Product> sortedProducts = new ArrayList<>(patienten.getProducts());
                sortedProducts.sort(Comparator.comparing(Product::getName));
                if (mode == 2) Collections.reverse(sortedProducts);
                sortedProducts.forEach(System.out::println);
                return;
            }
        }
        System.out.println("Patient nicht gefunden");
    }

}
