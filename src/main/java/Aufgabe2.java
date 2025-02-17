import java.util.*;

class Aufgabe2 {
    private static List<Product> Products = new ArrayList<>();
    private static List<Kunde> Kundes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Wählen Sie eine Option:");
            System.out.println("1. Spieler CRUD");
            System.out.println("2. Verein CRUD");
            System.out.println("3. Vereine nach Stadt filtern");
            System.out.println("4. Spieler eines Vereins anzeigen");
            System.out.println("5. Spieler nach Marktwert sortieren");
            System.out.println("6. Beenden");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    ProductCRUD();
                    break;
                case 2:
                    KundeCRUD();
                    break;
                case 3:
                    filterByCity();
                    break;
                case 4:
                    filterJahreszeit();
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

    private static void ProductCRUD() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Erstellen");
        System.out.println("2. Aktualisieren");
        System.out.println("3. Anzeigen");
        System.out.println("4. Löschen");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                readProduct();
                break;
            case 4:
                deleteProduct();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void createProduct() {
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        System.out.println("Alter eingeben:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Position eingeben:");
        String position = scanner.nextLine();

        Product Product = new Product(name, age, position);
        Products.add(Product);
        System.out.println("Spieler erstellt: " + Product);
    }

    private static void updateProduct() {
        System.out.println("Name des zu aktualisierenden Spielers:");
        String name = scanner.nextLine();
        for (Product Product : Products) {
            if (Product.getName().equals(name)) {
                System.out.println("Neuen Namen eingeben:");
                Product.setName(scanner.nextLine());
                System.out.println("Neues Alter eingeben:");
                Product.setPreis(Integer.parseInt(scanner.nextLine()));
                System.out.println("Neue Position eingeben:");
                Product.setJahreszeit(scanner.nextLine());
                ;
                System.out.println("Spieler aktualisiert: " + Product.getName()+" "+Product.getJahreszeit());
                return;
            }
        }
        System.out.println("Spieler nicht gefunden");
    }

    private static void readProduct() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle Spieler anzeigen");
        System.out.println("2. Bestimmten Spieler suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllProducts();
                break;
            case 2:
                findSpecificProduct();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllProducts() {
        if (Products.isEmpty()) {
            System.out.println("Keine Spieler vorhanden");
            return;
        }
        System.out.println("Alle Spieler:");
        for (Product Product : Products) {
            System.out.println(Product);
        }
    }

    private static void findSpecificProduct() {
        System.out.println("Name des Spielers eingeben:");
        String name = scanner.nextLine();
        boolean found = false;

        for (Product Product : Products) {
            if (Product.getName().equals(name)) {
                System.out.println("Gefundener Spieler: " + Product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Spieler nicht gefunden");
        }
    }


    private static void deleteProduct() {
        System.out.println("Name des zu löschenden Spielers:");
        String name = scanner.nextLine();
        Products.removeIf(Product -> Product.getName().equals(name));
    }

    private static void KundeCRUD() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Erstellen");
        System.out.println("2. Aktualisieren");
        System.out.println("3. Anzeigen");
        System.out.println("4. Löschen");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createKunde();
                break;
            case 2:
                updateKunde();
                break;
            case 3:
                readKunde();
                break;
            case 4:
                deleteKunde();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void createKunde() {
        System.out.println("ID eingeben:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        System.out.println("ort eingeben:");
        String city = scanner.nextLine();

        Kunde Kunde = new Kunde(id, name, city);

        // Add Products to the Kunde
        boolean addMoreProducts = true;
        while (addMoreProducts) {
            System.out.println("Möchten Sie einen Spieler hinzufügen? (Ja/Nein)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Ja")) {
                System.out.println("name eingeben:");
                String ProductName = scanner.nextLine();
                System.out.println("preis des Spielers eingeben:");
                int ProductAge = Integer.parseInt(scanner.nextLine());
                System.out.println("jahreszeit des Spielers eingeben:");
                String ProductPosition = scanner.nextLine();


                Product Product = new Product(ProductName, ProductAge, ProductPosition);
                Kunde.addProduct(Product);
                System.out.println("Spieler hinzugefügt: " + Product);
            } else {
                addMoreProducts = false;
            }
        }

        Kundes.add(Kunde);
        System.out.println("Verein erstellt: " + Kunde);
    }


    private static void updateKunde() {
        System.out.println("ID des zu aktualisierenden Vereins:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Kunde Kunde : Kundes) {
            if (Kunde.getId() == id) {
                System.out.println("Neuen Namen eingeben:");
                Kunde.setName(scanner.nextLine());
                System.out.println("Neue Stadt eingeben:");
                Kunde.setOrt(scanner.nextLine());
                System.out.println("Verein aktualisiert: " + Kunde.getName()+" "+Kunde.getOrt());
                return;
            }
        }
        System.out.println("Verein nicht gefunden");
    }

    private static void readKunde() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle Vereine anzeigen");
        System.out.println("2. Bestimmten Verein suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllKundes();
                break;
            case 2:
                findSpecificKunde();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllKundes() {
        if (Kundes.isEmpty()) {
            System.out.println("Keine Vereine vorhanden");
            return;
        }
        System.out.println("Alle Vereine:");
        for (Kunde Kunde : Kundes) {
            System.out.println(Kunde);
        }
    }

    private static void findSpecificKunde() {
        System.out.println("Geben Sie die Suchkriterien ein:");
        System.out.println("1. Nach ID suchen");
        System.out.println("2. Nach Name suchen");

        int searchChoice = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        switch (searchChoice) {
            case 1:
                System.out.println("ID eingeben:");
                int id = Integer.parseInt(scanner.nextLine());
                for (Kunde Kunde : Kundes) {
                    if (Kunde.getId() == id) {
                        System.out.println("Gefundener Verein: " + Kunde);
                        found = true;
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("Name eingeben:");
                String name = scanner.nextLine();
                for (Kunde Kunde : Kundes) {
                    if (Kunde.getName().equals(name)) {
                        System.out.println("Gefundener Verein: " + Kunde);
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
            System.out.println("Verein nicht gefunden");
        }
    }

    private static void deleteKunde() {
        System.out.println("ID des zu löschenden Vereins:");
        int id = Integer.parseInt(scanner.nextLine());
        Kundes.removeIf(Kunde -> Kunde.getId() == id);
    }

    private static void filterByCity() {
        System.out.println("ort eingeben:");
        String city = scanner.nextLine();
        List<Kunde> filteredKundes = new ArrayList<>();

        for (Kunde Kunde : Kundes) {
            if (Kunde.getOrt().equals(city)) {
                filteredKundes.add(Kunde);
            }
        }

        System.out.println("kunde in " + city + ":");
        for (Kunde Kunde : filteredKundes) {
            System.out.println(Kunde);
        }
    }

    private static void filterJahreszeit() {
        System.out.println("Enter jahreszeit");
        String jahreszeit = scanner.nextLine();

        List<Kunde> customersWithSeasonalProducts = new ArrayList<>();

        for (Kunde customer : Kundes) {
            for (Product product : customer.getProducts()) {
                if (product.getJahreszeit().equalsIgnoreCase(jahreszeit)) {
                    customersWithSeasonalProducts.add(customer);
                    break; // No need to check more products for this customer
                }
            }
        }

        if (customersWithSeasonalProducts.isEmpty()) {
            System.out.println("No customers found for this season.");
        } else {
            System.out.println("Customers who bought products in " + jahreszeit + ":");
            customersWithSeasonalProducts.forEach(System.out::println);
        }
    }


    private static void sortMeds() {
        System.out.println("Patienten  eingeben:");
        String name = scanner.nextLine();
        System.out.println("Sortiermodus (1 = aufsteigend, 2 = absteigend):");
        int mode = Integer.parseInt(scanner.nextLine());

        for (Kunde patienten:Kundes) {
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


