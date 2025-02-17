package org.example;

import java.util.ArrayList;
import java.util.List;

public class Charakter {
    int id;
    String name;
    String herkunftsregion;
    List<Product> products;

    public Charakter(int id, String name, String herkunftsregion) {
        this.id = id;
        this.name = name;
        this.herkunftsregion = herkunftsregion;
        this.products=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void addProd(Product product){
        products.add(product);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
