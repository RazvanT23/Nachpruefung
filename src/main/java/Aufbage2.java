
import java.util.*;

class Aufgabe2 {

    private static List<Product> products = new ArrayList<>();
    private static List<Charakter> charakters = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> Producte = new ArrayList<>();
        Producte.add(new Product("Kunai", 50.0, "Konoha"));
        Producte.add(new Product("Shuriken", 30.0, "Konoha"));
        Producte.add(new Product("Schwert", 200.0, "Kirigakure"));
        Producte.add(new Product("Heiltrank", 100.0, "Sunagakure"));
        Producte.add(new Product("Sprengsiegel", 75.0, "Iwagakure"));
        Producte.add(new Product("Riesenfächer", 300.0, "Sunagakure"));
        Producte.add(new Product("Giftklinge", 150.0, "Kirigakure"));
        Producte.add(new Product("Explosionskugel", 250.0, "Iwagakure"));
        Producte.add(new Product("Schattendolch", 180.0, "Konoha"));
        Producte.add(new Product("Wasserperle", 90.0, "Kirigakure"));




        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha");
        c1.addProd(Producte.get(0)); // Kunai
        c1.addProd(Producte.get(3)); // Heiltrank
        c1.addProd(Producte.get(8)); // Schattendolch
        c1.addProd(Producte.get(5)); // Riesenfächer

        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure");
        c2.addProd(Producte.get(2)); // Schwert
        c2.addProd(Producte.get(4)); // Sprengsiegel
        c2.addProd(Producte.get(6)); // Giftklinge
        c2.addProd(Producte.get(1)); // Shuriken

        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure");
        c3.addProd(Producte.get(1)); // Shuriken
        c3.addProd(Producte.get(2)); // Schwert
        c3.addProd(Producte.get(3)); // Heiltrank
        c3.addProd(Producte.get(7)); // Explosionskugel
        c3.addProd(Producte.get(9)); // Wasserperle

        Charakter c4 = new Charakter(4, "Deidara", "Iwagakure");
        c4.addProd(Producte.get(0)); // Kunai
        c4.addProd(Producte.get(4)); // Sprengsiegel
        c4.addProd(Producte.get(7)); // Explosionskugel
        c4.addProd(Producte.get(9)); // Wasserperle

        Charakter c5 = new Charakter(5, "Itachi Uchiha", "Konoha");
        c5.addProd(Producte.get(8)); // Schattendolch
        c5.addProd(Producte.get(6)); // Giftklinge
        c5.addProd(Producte.get(2)); // Schwert
        c5.addProd(Producte.get(7)); // Explosionskugel


        while (true) {

            System.out.println("Alege ce vrei sa faci");
            System.out.println("Product CRUD");
            System.out.println("Charakter CRUD");
            System.out.println("Filter in functie de Dorf");
            System.out.println("Filter Charakter Products in functie de dorf");
            System.out.println("Sorteaza produsele");

            int response = Integer.parseInt(scanner.nextLine());



            switch (response) {
                case 1:
                    productCRUD();
                    break;
                case 2:
                    CharakterCRUD();
                    break;
                case 3:
                    filterByDorf();
                    break;
                case 4:
                    showDorfProd();
                    break;
                case 5:
                    sortProducts();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Alege o optiune din cele de mai sus");
            }
        }


    }

    // Sortiere Producte für einen bestimmten Kunden
    private static void sortProducts() {
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        System.out.println("Sortiermodus (1 = aufsteigend, 2 = absteigend):");
        int mode = Integer.parseInt(scanner.nextLine());

        for (Charakter Charakter:charakters) {
            if (Charakter.getName().equalsIgnoreCase(name)) {
                List<Product> sortedProducts = new ArrayList<>(Charakter.getProducts());
                sortedProducts.sort(Comparator.comparing(Product::getPreis));
                if (mode == 2) Collections.reverse(sortedProducts);
                sortedProducts.forEach(System.out::println);
                return;
            }
        }
        System.out.println("Kunde nicht gefunden");
    }




    private static void CharakterCRUD() {
        System.out.println("Alege ce vrei");
        System.out.println("Create");
        System.out.println("Update");
        System.out.println("Read");
        System.out.println("Delete");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createCharakter();
                break;
            case 2:
                updateCharakter();
                break;
            case 3:
                readCharakter();
                break;
            case 4:
                deleteCharakter2();
            default:
                System.out.println("Pick a valid option");
        }

    }

    private static void deleteCharakter2() {
        System.out.println("ID des zu löschenden Charakter:");
        int id = Integer.parseInt(scanner.nextLine());
        charakters.removeIf(Charakter -> Charakter.getId() == id);
    }



    private static void readCharakter() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle Charakter anzeigen");
        System.out.println("2. Bestimmten Charakter suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllCharakter();
                break;
            case 2:
                findSpecificCharakter();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllCharakter() {
        if (charakters.isEmpty()) {
            System.out.println("Keine Charakter vorhanden");
            return;
        }
        System.out.println("Alle Charakter:");
        for (Charakter Charakter:charakters) {
            System.out.println(Charakter);
        }
    }

    private static void findSpecificCharakter() {
        System.out.println("Name des Charakter eingeben:");
        String name = scanner.nextLine();
        boolean found = false;

        for (Charakter Charakter:charakters) {
            if (Charakter.getName().equals(name)) {
                System.out.println("Gefundener Charakter: " + Charakter.getName()+""+ Charakter.getHerkunftsdorf());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Charakter nicht gefunden");
        }
    }

    private static void updateCharakter() {
        System.out.println("ID des zu aktualisierenden Charakter eingeben:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Charakter Charakter : charakters) {
            if (Charakter.getId() == id) {
                System.out.println("Neuen Namen eingeben:");
                Charakter.setName(scanner.nextLine());
                System.out.println("Neuen Ort eingeben:");
                Charakter.setHerkunftsdorf(scanner.nextLine());
                System.out.println("Charakter aktualisiert: " + Charakter.getName()+" "+Charakter.getHerkunftsdorf());
                return;
            }
        }
        System.out.println("Charakter nicht gefunden");
    }

    private static void createCharakter() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter ort");
        String ort = scanner.nextLine();

        // Create Charakter
        Charakter Charakter = new Charakter(id, name, ort);

        // Ask if they want to add products
        List<Product> CharakterProducts = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to add a product? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter product name:");
            String productName = scanner.nextLine();
            System.out.println("Enter product price:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter product herkunft:");
            String season = scanner.nextLine();

            // Create product and add to list
            Product product = new Product(productName, price, season);
            CharakterProducts.add(product);
        }

        // Attach products to Charakter
        Charakter.setProducts(CharakterProducts);
        charakters.add(Charakter);

        System.out.println("Charakter created successfully with products!");
    }


    private static void productCRUD() {
        System.out.println("Alege ce vrei");
        System.out.println("Create");
        System.out.println("Update");
        System.out.println("Read");
        System.out.println("Delete");

        int response = Integer.parseInt(scanner.nextLine());

        switch (response) {
            case 1:
                createProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                readProd();
                break;
            case 4:
                deleteProduct2();
            default:
                System.out.println("Pick a valid option");
        }


    }

    private static void deleteProduct2() {
        System.out.println("Productname eingeben:");
        String name = scanner.nextLine();
        products.removeIf(product -> product.getName().equals(name));
    }
    private static void readProd() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Alle prod  anzeigen");
        System.out.println("2. Bestimmten prod suchen");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showAllProd();
                break;
            case 2:
                findSpecificProd();
                break;
            default:
                System.out.println("Ungültige Option");
        }
    }

    private static void showAllProd() {
        if (products.isEmpty()) {
            System.out.println("Keine prod vorhanden");
            return;
        }
        System.out.println("Alle prod:");
        for (Product product:products) {
            System.out.println(product);
        }
    }

    private static void findSpecificProd() {
        System.out.println("Name des Prod eingeben:");
        String name = scanner.nextLine();
        boolean found = false;

        for (Product product:products) {
            if (product.getName().equals(name)) {
                System.out.println("Gefundener Prod: " + product.getName()+" "+product.getHerkinftregion());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Prod nicht gefunden");
        }
    }


    private static void updateProduct() {
        System.out.println("Productname eingeben:");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println("Neuen Preis eingeben:");
                product.setPreis((int) Double.parseDouble(scanner.nextLine()));
                System.out.println("Neue herkunft eingeben:");
                product.setHerkinftregion(scanner.nextLine());
                System.out.println("Product aktualisiert: " + product.getName()+" "+product.getHerkinftregion()+" "+product.getPreis());
                return;
            }
        }
        System.out.println("Product nicht gefunden");
    }

    private static void createProduct() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter preis");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter herkunft");
        String jahreszeit = scanner.nextLine();
        Product product = new Product(name, price, jahreszeit);
        System.out.println("Your prod " + product.getName() + product.getHerkinftregion() + product.getPreis());

        products.add(product);
    }


    private static void filterByDorf() {
        System.out.println("Dorf eingeben:");
        String dorf = scanner.nextLine();
        List<Charakter> filteredCharakter = new ArrayList<>();

        for (Charakter charakter:charakters) {
            if (charakter.getHerkunftsdorf().equals(dorf)) {
                filteredCharakter.add(charakter);
            }
        }

        System.out.println("Charakter " + dorf + ":");
        for (Charakter charakter:charakters) {
            System.out.println(charakter.getName());
        }
    }

    private static void showDorfProd() {
        System.out.println("Enter ort");
        String jahreszeit = scanner.nextLine();

        List<Charakter> customersWithSeasonalProducts = new ArrayList<>();

        for (Charakter charakter : charakters) {
            for (Product product : charakter.getProducts()) {
                if (product.getHerkinftregion().equalsIgnoreCase(jahreszeit)) {
                    customersWithSeasonalProducts.add(charakter);
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


}