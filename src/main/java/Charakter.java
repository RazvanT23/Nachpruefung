import java.util.ArrayList;
import java.util.List;

public class Charakter {
    int id;
    String name;
    String herkunftsdorf;
    List<Product> products;

    public Charakter(int id, String name, String herkunftsdorf) {
        this.id = id;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsdorf() {
        return herkunftsdorf;
    }

    public void setHerkunftsdorf(String herkunftsdorf) {
        this.herkunftsdorf = herkunftsdorf;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProd(Product product){
        this.products.add(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
