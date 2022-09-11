import model.Order;
import service.ShopService;
import model.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String input = "";
        int orderId;

        Scanner scanner = new Scanner(System.in);

        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        Product product3 = new Product(3, "Product3");

        ShopService shopService = new ShopService();
        shopService.addProduct(product1);
        shopService.addProduct(product2);
        shopService.addProduct(product3);

        System.out.println(shopService.listProducts());


        System.out.println(" --------------");
        System.out.println("| Shop Service |");
        System.out.println(" --------------");
        System.out.println();

        while (!Objects.equals(input, "X")) {

            System.out.println("1. get product");
            System.out.println("2. list all products");
            System.out.println("3. get order");
            System.out.println("4. list all orders");
            System.out.println("5. add order  ");
            System.out.println();
            System.out.println("select item or 'x' for exit");
            input = scanner.next().toUpperCase();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter product ID: ");
                    input = scanner.next();
                    System.out.println(shopService.getProduct(Integer.parseInt(input)));
                    System.out.println();
                }
                case "2" ->
                    System.out.println(shopService.listProducts());
                case "3" -> {
                    System.out.print("Enter order ID: ");
                    input = scanner.next();
                    System.out.println(shopService.getOrder(Integer.parseInt(input)));
                    System.out.println();
                }
                case "4" -> {
                    System.out.println(shopService.listOrders());
                    System.out.println();
                }
                case "5" -> {
                    System.out.println("Enter new order ID: ");
                    orderId = scanner.nextInt();
                    ArrayList<Product> newProducts = new ArrayList<>();

                    while (!input.equals("p")) {
                        System.out.println(shopService.listProducts());
                        System.out.println("Enter model.Product ID to add or 'p' to proceed: ");

                        input= scanner.next();

                        if (!Objects.equals(input, "p")) {
                            try {
                                newProducts.add(shopService.getProduct(Integer.parseInt(input)));
                            } catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("ID does not exists!");
                            }
                        }
                    }
                    shopService.addOrder(new Order(orderId, newProducts));

                    System.out.println(shopService.getOrder(orderId));
                    System.out.println();
                }

            }
        }
    }
}
