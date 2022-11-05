package Task2;

public class Haval extends Car{
    private final int year;
    public Haval(String color, int maxSpeed, int currentSpeed, String box, int price, int year, String model) {
        super(color, box, maxSpeed, currentSpeed, price, model);
        this.year = year;
    }
    @Override
    public  String getName(){
        return "Haval";
    }
    public int getYear(){
        return this.year;
    }
}