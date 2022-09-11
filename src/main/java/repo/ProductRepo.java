package repo;

import model.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    private Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> list(){
        return products;
    }

    public Product get(int id) {
        return products.get(id);
    }

    public Product add(Product product){
        products.put(product.getId(), product);
        return product;
    }

}
