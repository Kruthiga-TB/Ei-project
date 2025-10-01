package exercise1.structural.decorator;

public abstract class DrinkDecorator implements Drink {
    protected Drink drink;
    public DrinkDecorator(Drink drink) { this.drink = drink; }
    public String getDescription() { return drink.getDescription(); }
    public double getCost() { return drink.getCost(); }
}