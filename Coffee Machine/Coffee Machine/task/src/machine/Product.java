package machine;

public class Product {
    private int serialNumber;
    private String name;
    private int requiredWater;
    private int requiredMilk;
    private int requiredBeans;
    private int cost;

    public Product(int serialNumber,
                   String name,
                   int requiredWater,
                   int requiredMilk,
                   int requiredBeans,
                   int cost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredBeans = requiredBeans;
        this.cost = cost;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(int requiredWater) {
        this.requiredWater = requiredWater;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }

    public void setRequiredMilk(int requiredMilk) {
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans() {
        return requiredBeans;
    }

    public void setRequiredBeans(int requiredBeans) {
        this.requiredBeans = requiredBeans;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String displaySerialAndName() {
        return serialNumber + " - " + name;
    }
}
