package exercise1.structural.decorator;

public class CreamDecorator extends DrinkDecorator {
    public CreamDecorator(Drink drink) { super(drink); }
    public String getDescription() { return drink.getDescription() + " + Cream"; }
    public double getCost() { return drink.getCost() + 20.00; }
}