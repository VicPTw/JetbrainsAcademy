package machine;
import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cupsAffordList = new ArrayList<>();
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterAmount = scanner.nextInt();
        cupsAffordList.add(waterAmount / 200);
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkAmount = scanner.nextInt();
        cupsAffordList.add(milkAmount / 50);
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beanAmount = scanner.nextInt();
        cupsAffordList.add(beanAmount / 15);
        System.out.println("Write how many cups of coffee you will need: ");
        int cupsOfCoffee = scanner.nextInt();

        Collections.sort(cupsAffordList);
        int cupsAfford = cupsAffordList.get(0); 
        if (cupsOfCoffee == cupsAfford) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsOfCoffee < cupsAfford) {
            int moreCups = cupsAfford - cupsOfCoffee;
            System.out.println("Yes, I can make that amount of coffee (and even " + moreCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsAfford + " cup(s) of coffee");
        }
    }
}
