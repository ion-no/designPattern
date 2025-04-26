package designPatterns;

interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", with Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
}


public class Main3 {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
