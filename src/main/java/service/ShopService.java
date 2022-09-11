package service;

import model.Product;
import model.Order;
import repo.ProductRepo;
import repo.OrderRepo;
import java.util.Map;

public class ShopService {
    private final ProductRepo productRepo = new ProductRepo();
    private final OrderRepo orderRepo = new OrderRepo();

    public Product getProduct(int productId){
            if (productRepo.list().containsKey(productId)) {
                return productRepo.get(productId);
            }
            throw new ArrayIndexOutOfBoundsException();
        }

    public Map<Integer, Product> listProducts(){
        return productRepo.list();
    }

    public Map<Integer, Product> addProduct(Product product){
            return productRepo.add(product);
    }

    public Order getOrder(int orderId){
        if (orderRepo.list().containsKey(orderId)){
            return orderRepo.get(orderId);
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Map<Integer, Order> listOrders(){
        return orderRepo.list();
    }

    public Map<Integer, Order> addOrder(Order order){
        return orderRepo.add(order);
    }




}
