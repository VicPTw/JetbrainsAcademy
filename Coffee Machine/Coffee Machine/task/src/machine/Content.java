package machine;

public class Content {
    private String name;
    private String unit = "";
    private int requiredAmount = 0;
    private int amount;

    public Content(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Content(String name, String unit, int requiredAmount) {
        this.name = name;
        this.unit = unit;
        this.requiredAmount = requiredAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void consume(int amount) {
        this.amount = this.amount - amount;
    }

    public void put(int amount) {
        this.amount = this.amount + amount;
    }

    public String displayAmount() {
        return amount + " of " + name;
    }
}
