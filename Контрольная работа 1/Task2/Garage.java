package Task2;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    //private Map<Car,Integer> map = new HashMap<>();
    private Car[] cars;
    private int max_capacity;
    private int is_enough_place;
    public Garage(Car[] cars, int max_capacity){
        this.max_capacity = max_capacity;
        int size = 0;
        for(int i=0; i<=cars.length-1; i++) {size+=i;}
        if (size <= this.max_capacity) {this.cars = cars; this.is_enough_place = 1;} else {this.is_enough_place = 0;}
    }

    public void cars() {}
}