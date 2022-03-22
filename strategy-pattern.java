import java.util.*;
import java.lang.*;
import java.io.*;

interface FlyBehaviour {
    void fly();
}

class FlyWithWings implements FlyBehaviour {
    public void fly() {
        System.out.println("Fly with wings");
    }
}

class NoFly implements FlyBehaviour {
    public void fly() {
        System.out.println("No Fly");
    }
}

interface QuackBehaviour {
    void quack();
}

class Quack implements QuackBehaviour {
    public void quack() {
        System.out.println("Quack");
    }
}

class Squeak implements QuackBehaviour {
    public void quack() {
        System.out.println("Squeak");
    }
}

class MuteQuack implements QuackBehaviour {
    public void quack() {
        System.out.println("Mute");
    }
}

abstract class Duck {
    protected FlyBehaviour flyBehaviour;
    protected QuackBehaviour quackBehaviour;

    public void swim() {}
    public void display() {}

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}

class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehaviour = new FlyWithWings();
        this.quackBehaviour = new Quack();
    }

    public void display() {
        System.out.println("Mallard Duck");
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Main {
	public static void main (String[] args) {
		Duck duck = new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
	}
}
