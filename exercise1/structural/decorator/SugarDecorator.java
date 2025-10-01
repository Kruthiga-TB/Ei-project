package exercise1.structural.decorator;

public class SugarDecorator extends DrinkDecorator {
    public SugarDecorator(Drink drink) { super(drink); }
    public String getDescription() { return drink.getDescription() + " + Sugar"; }
    public double getCost() { return drink.getCost() + 5.00; }
}
