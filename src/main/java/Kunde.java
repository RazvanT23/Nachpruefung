import java.util.ArrayList;
import java.util.List;

public class Kunde {
    int id;
    String name;
    String ort;
    List<Product> products;

    public Kunde(int id, String name, String ort) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.products = new ArrayList<>();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
