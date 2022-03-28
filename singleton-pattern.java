import java.util.*;
import java.lang.*;
import java.io.*;

class Singleton {
    private static int counter = 0;
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        counter += 1;
        return instance;
    }

    public void objectCounter() {
        System.out.println(counter);
    }
}

class Main {
	public static void main (String[] args) {
		Singleton ob1 = Singleton.getInstance();
    ob1.objectCounter();

    Singleton ob2 = Singleton.getInstance();
    ob2.objectCounter();
	}
}
