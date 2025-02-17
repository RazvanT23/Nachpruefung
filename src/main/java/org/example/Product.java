package org.example;

public class Product {
    String name;
    int preis;
    String herkunftsregion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    public Product(String name, int preis, String herkunftsregion) {
        this.name = name;
        this.preis = preis;
        this.herkunftsregion = herkunftsregion;
    }
}
