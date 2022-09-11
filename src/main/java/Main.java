import model.Order;
import service.ShopService;
import model.Product;

import java.util.*;




public class Main {


    public static void main(String[] args) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";

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

        System.out.println(" --------------\n| Shop Service |\n --------------\n");
        while (!Objects.equals(input, "X")) {


            System.out.println("1. get product\n2. list all products\n3. get order\n4. list all orders\n5. add order\n");
            System.out.println("select item or 'x' for exit");
            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter product ID: ");
                    input = scanner.nextLine();
                    try {
                        System.out.println("\n  " + ANSI_YELLOW + shopService.getProduct(Integer.parseInt(input)) + ANSI_RESET +"\n");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\n  " + ANSI_RED + "The Product ID does not exists!" + ANSI_RESET + "\n");
                    }
                }
                case "2" ->
                    System.out.println("\n  " + ANSI_YELLOW + shopService.listProducts() + ANSI_RESET + "\n");
                case "3" -> {
                    System.out.print("Enter order ID: ");
                    input = scanner.nextLine();
                    try {
                        System.out.println("\n  " + ANSI_YELLOW + shopService.getOrder(Integer.parseInt(input)) + ANSI_RESET + "\n");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\n  " + ANSI_RED + "The Order ID does not exists!" + ANSI_RESET + "\n");
                    }
                }
                case "4" ->
                    System.out.println("\n  " + ANSI_YELLOW + shopService.listOrders() + ANSI_RESET + "\n");
                case "5" -> {
                    System.out.print("Enter new order ID: ");
                    input = scanner.nextLine();
                    orderId = Integer.parseInt(input);
                    ArrayList<Product> newProducts = new ArrayList<>();

                    System.out.println("\n  " + shopService.listProducts() + "\n");
                    while (!input.equals("")) {
                        System.out.print("Enter Product ID to add or ENTER to proceed: ");

                        input= scanner.nextLine();

                        if (!Objects.equals(input, "")) {
                            try {
                                newProducts.add(shopService.getProduct(Integer.parseInt(input)));
                            } catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("\n  " + ANSI_RED + "The Product ID does not exists!" + ANSI_RESET + "\n");
                            }
                        }
                    }
                    shopService.addOrder(new Order(orderId, newProducts));

                    System.out.println("\n Added order: " + ANSI_YELLOW + shopService.getOrder(orderId) + ANSI_RESET + "\n");
                }
            }
        }
    }
}
