package service;

import model.Product;
import service.ShopService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        Product product3 = new Product(3, "Product3");

        ShopService shopService = new ShopService();

        //shopService.addProduct(product2);
        //shopService.addProduct(product3);


    @Test
    void getProductExpectTrue() {
        shopService.addProduct(product1);

        Product actual = shopService.getProduct(1);

        assertEquals(product1, actual);

    }

    @Test
    void listProductsExpectTrue() {
        shopService.addProduct(product1);
        shopService.addProduct(product2);

        Map<Integer, Product> products = new HashMap<>();
        products.put(1,product1);
        products.put(2,product2);

        Map<Integer, Product> actual = shopService.listProducts();

        assertEquals(products, actual);
    }

    @Test
    void addProduct() {
    }

    @Test
    void addProductById() {
    }

    @Test
    void addOrder() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void listOrders() {
    }

}