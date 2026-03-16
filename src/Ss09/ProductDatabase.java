package Ss09;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            synchronized(ProductDatabase.class) {
                if(instance == null){
                    instance = new ProductDatabase();
                }

            }


        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAll() {
        return products;
    }
    public Product findById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public void delete(String id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}