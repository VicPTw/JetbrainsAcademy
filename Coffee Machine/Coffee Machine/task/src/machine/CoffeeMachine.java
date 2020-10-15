package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static Machine coffeeMachine = initializeMachine();

    public static void main(String[] args) {

        coffeeMachine.displayMachineStatus();

        System.out.println();

        while (!askAndDoAction()) {
            System.out.println("Wrong Action.");
        }

        System.out.println();

        coffeeMachine.displayMachineStatus();

    }

    private static Machine initializeMachine() {
        List<Content> contents = new ArrayList<>();
        contents.add(new Content("water", 400));
        contents.add(new Content("milk", 540));
        contents.add(new Content("coffee beans", 120));
        contents.add(new Content("disposable cups", 9));
        contents.add(new Content("money", 550));
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "espresso",
                250, 0,
                16, 4));
        products.add(new Product(2, "latte",
                350, 75,
                20, 7));
        products.add(new Product(3, "cappuccino",
                200, 100,
                12, 6));
        return new Machine(contents, products);
    }

    private static boolean askAndDoAction() {
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine().trim();
        switch (action) {
            case "buy":
                coffeeMachine.buy();
                return true;
            case "fill":
                coffeeMachine.fill();
                return true;
            case "take":
                coffeeMachine.take();
                return true;
            default:
                System.out.println("Wrong Action.");
                return false;
        }
    }


}
