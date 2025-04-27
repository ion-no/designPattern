package designPatterns;

interface Coffee {
    void prepare();
}

class Espresso implements Coffee {
    public void prepare() {
        System.out.println("Preparing Espresso");
    }
}

class Latte implements Coffee {
    public void prepare() {
        System.out.println("Preparing Latte");
    }
}

class CoffeeFactory {
    public Coffee getCoffee(String coffee) {
        if(coffee == null)
            return null;
        else if(coffee == "Espresso")
            return new Espresso();
        else
            return new Latte();
    }
}


public class Main4 {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee coffee = coffeeFactory.getCoffee("Espresso");
        coffee.prepare();
    }
}
