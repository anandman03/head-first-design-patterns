import java.util.*;
import java.lang.*;
import java.io.*;

interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    public void display();
}

class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    public float temperature;
    public float humidity;
    public float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    public void notifyObservers() {
        for (int index = 0 ; index < observers.size() ; ++index) {
            Observer observer = (Observer) observers.get(index);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}

class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    public float temperature;
    public float humidity;
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
    
    public void display() {
        System.out.println("Temp: " + temperature + " Humitidy: " + humidity);
    }
}

class StatsDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    public float temperature;
    public float humidity;
    
    public StatsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
    
    public void display() {
        System.out.println("Effective Temp: " + (temperature + humidity));
    }
}

class Main {
	public static void main (String[] args) {
		WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatsDisplay statsDisplay = new StatsDisplay(weatherData);
        weatherData.setMeasurements(100, 101, 102);
	}
}
