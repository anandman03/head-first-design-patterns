import java.util.*;
import java.lang.*;
import java.io.*;

abstract class Beverage {
    public String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend";
    }

    public double cost() {
        return 0.89;
    }
}

class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return 0.2 + this.beverage.cost();
    }
}

class Main {
	public static void main (String[] args) throws java.lang.Exception {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription());

        espresso = new Mocha(espresso);
        System.out.println(espresso.getDescription() + " | " + espresso.cost());
	}
}
