package exercise1.structural.decorator;

public class MilkDecorator extends DrinkDecorator {
    public MilkDecorator(Drink drink) { super(drink); }
    public String getDescription() { return drink.getDescription() + " + Milk"; }
    public double getCost() { return drink.getCost() + 10.00; }
}