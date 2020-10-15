package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {

    private final Scanner scanner = new Scanner(System.in);

    private final List<Content> contents;
    private final List<Product> products;

    public Machine(List<Content> contents, List<Product> products) {
        this.contents = contents;
        this.products = products;
    }

    public void buy() {
        System.out.println("What do you want to buy? "
                + products.stream().
                map(Product::displaySerialAndName).
                collect(Collectors.joining(", "))
                + ", back - to main menu: ");
        String demand = scanner.next();
        int productNumber;
        if (demand.equals("back") || !isInteger(demand)) {
            return;
        } else {
            productNumber = Integer.parseInt(demand) - 1;
        }
        if (verifyProductNumber(productNumber)) {
            System.out.println("Wrong product number, please input again.");
            return;
        }
        Product product = products.get(productNumber);
        if (checkStock(product)) {
            System.out.println("I have enough resources, making you a coffee!");
            makeCoffeeAndSellOne(product);
        }
    }

    /**
     * inspired by
     * https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java
     * @param str
     * @return
     */
    private static boolean isInteger(String str) {
        return str != null && str.length() > 0 &&
                IntStream.range(0, str.length()).allMatch(i -> i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')
                        || Character.isDigit(str.charAt(i)));
    }

    private boolean verifyProductNumber(int productNumber) {
        return (productNumber < 0 || productNumber >= products.size());
    }

    private boolean checkStock(Product product) {
        boolean enough = true;
        List<String> notEnoughMessages = new ArrayList<>();
        int stockWaterAmount = getContentByName("water").getAmount();
        int stockMilkAmount = getContentByName("milk").getAmount();
        int stockBeansAmount = getContentByName("coffee beans").getAmount();
        int stockDisposableCups = getContentByName("disposable cups").getAmount();
        if (product.getRequiredWater() > 0 && stockWaterAmount / product.getRequiredWater() < 1) {
            enough = false;
            notEnoughMessages.add("water");
        }
        if (product.getRequiredMilk() > 0 && stockMilkAmount / product.getRequiredMilk() < 1) {
            enough = false;
            notEnoughMessages.add("milk");
        }
        if (product.getRequiredBeans() > 0 && stockBeansAmount / product.getRequiredBeans() < 1) {
            enough = false;
            notEnoughMessages.add("coffee beans");
        }
        if (stockDisposableCups < 1) {
            enough = false;
            notEnoughMessages.add("disposable cups");
        }
        if (notEnoughMessages.size() > 0) {
            System.out.println("Sorry, not enough "
                    + notEnoughMessages.stream().map(Objects::toString).collect(Collectors.joining(", "))
                    + "!");
        }
        return enough;
    }

    private void makeCoffeeAndSellOne(Product product) {
        getContentByName("water").consume(product.getRequiredWater());
        getContentByName("milk").consume(product.getRequiredMilk());
        getContentByName("coffee beans").consume(product.getRequiredBeans());
        getContentByName("disposable cups").consume(1);
        getContentByName("money").put(product.getCost());
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        getContentByName("water").put(askForInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        getContentByName("milk").put(askForInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        getContentByName("coffee beans").put(askForInt());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        getContentByName("disposable cups").put(askForInt());
    }

    public void take() {
        int currentMoney = getContentByName("money").getAmount();
        System.out.println("I gave you $" + currentMoney);
        getContentByName("money").consume(currentMoney);
    }

    public void displayMachineStatus() {
        System.out.println("The coffee machine has:");
        contents.forEach(content -> System.out.println(content.displayAmount()));
    }

    private Content getContentByName(String name) {
        return contents.stream().filter(it -> it.getName().equals(name)).findFirst().orElseThrow();
    }

    private int findMaxOrderQuantity(List<Integer> cupsByAvailableContents) {
        Collections.sort(cupsByAvailableContents);
        return cupsByAvailableContents.get(0);
    }

    private int askForInt() {
        return scanner.nextInt();
    }
}
