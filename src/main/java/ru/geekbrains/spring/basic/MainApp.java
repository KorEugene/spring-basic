package ru.geekbrains.spring.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.basic.config.AppConfig;
import ru.geekbrains.spring.basic.service.CartService;

import java.util.Scanner;

public class MainApp {

    private static AnnotationConfigApplicationContext context;
    private static CartService cartService;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean interrupt = false;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(AppConfig.class);

        cartService = context.getBean(CartService.class);

        while (true) {
            System.out.println("Type \"help\" for get available commands list. Waiting for command: ");
            String command = scanner.nextLine();
            try {
                processCommand(command.toLowerCase());
            } catch (Exception exception) {
                System.out.println("Error! " + exception.getMessage());
                continue;
            }
            if (interrupt) {
                break;
            }
        }
        context.close();
    }

    private static void processCommand(String command) throws Exception {
        String[] args = command.trim().split("\\s+");
        switch (args[0]) {
            case "":
                break;
            case "help":
                printHelp();
            case "list":
                System.out.println("Cart " + cartService.getCartId() + ":" + cartService.getAll());
                break;
            case "new":
                cartService = context.getBean(CartService.class);
                System.out.println("New cart");
                break;
            case "exit":
                interrupt = true;
                System.out.println("Bye");
                break;
            case "add":
                cartService.addProduct(Long.valueOf(args[1]));
                System.out.println("product with id " + Long.valueOf(args[1]) + " added");
                break;
            case "remove":
                cartService.removeProduct(Long.valueOf(args[1]));
                System.out.println("product with id " + Long.valueOf(args[1]) + " removed");
                break;
            default:
                throw new Exception("Wrong command: " + command);
        }
    }

    private static void printHelp() {
        System.out.println("********************");
        System.out.println("Available commands:");
        System.out.println("list - list all products in a cart");
        System.out.println("add <id> - add new product to cart, where <id> is product id. Available ids: 1, 2, 3, 4, 5");
        System.out.println("remove <id> - remove product from cart, where <id> is product id");
        System.out.println("new - get new cart. Old cart become unavailable");
        System.out.println("exit - close app");
        System.out.println("********************");
    }
}
