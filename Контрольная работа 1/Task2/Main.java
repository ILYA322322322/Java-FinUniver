package Task2;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        System.out.println("Task 2");
        Haval h = new Haval ("white", 210, 100, "auto", 2399000, 2,"HAVAL F7X");
        Cheri ch = new Cheri ("white", 180, 80, "auto", 2000000,3,"Chery Tiggo 7 Pro I");
        int max_capacity = 2;
        Car[] my_cars = new Car[max_capacity];
        my_cars[0] = h;
        my_cars[1] = ch;
        try {
            for (int i = 0; i < max_capacity; i++) {
                System.out.println(my_cars[i]);
            }
        }
        catch (Exception e){
            System.out.println("It is impossible to sell a garage in the console");
        }
        Garage garage = new Garage (my_cars, max_capacity);
    }
}