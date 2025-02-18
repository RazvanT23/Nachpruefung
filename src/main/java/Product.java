public class Product {
    String name;
    double preis;
    String herkinftregion;

    public Product(String name, double preis, String herkinftregion) {
        this.name = name;
        this.preis = preis;
        this.herkinftregion = herkinftregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getHerkinftregion() {
        return herkinftregion;
    }

    public void setHerkinftregion(String herkinftregion) {
        this.herkinftregion = herkinftregion;
    }
}
