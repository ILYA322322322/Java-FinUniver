package Task2;

public class Cheri extends Car{
    private final int year;
    public Cheri(String color, int maxSpeed, int currentSpeed, String box, int price, int year,String model) {
        super(color, box, maxSpeed, currentSpeed, price,model);
        this.year = year;
    }
    @Override
    public  String getName(){
        return "Cheri";
    }
    public int getYear(){
        return this.year;
    }
}