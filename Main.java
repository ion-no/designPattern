package designPatterns;
import java.util.ArrayList;

interface Observer {
    void update(float temperate);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperate) {
        this.temperature = temperate;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class Display1 implements Observer {
    private float temperate;

    @Override
    public void update(float temperate) {
        this.temperate = temperate;
        System.out.println("Display1 temperature is" + temperate);
    }
}

class Display2 implements Observer {
    private float temperate;

    @Override
    public void update(float temperate) {
        this.temperate = temperate;
        System.out.println("Display1 temperature is" + temperate);
    }
}


public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        
        Observer display1 = new Display1();
        Observer display2 = new Display2();
        
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);
        
        weatherStation.setTemperature(25.5f);
        weatherStation.setTemperature(26.8f);
    }
}