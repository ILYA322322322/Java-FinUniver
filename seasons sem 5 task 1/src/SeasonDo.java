public class SeasonDo {
    public static void main(String[] args) {
        Season season = Season.WINTER;//Season
        System.out.println(season);
        print(season.WINTER);
        FullSeason();
    }

    public static void print(Season season){
        switch (season){
            case AUTUMN -> System.out.println("I love AUTUMN");
            case SPRING -> System.out.println("I love SPRING");
            case SUMMER -> System.out.println("I love SUMMER");
            case WINTER -> System.out.println("I love WINTER");}
    }
    public static void FullSeason(){
        for (Season s : Season.values()){// Massiv Season
            System.out.println(s+" "+s.getTemp()+" "+s.getTermo());//Season + mid temp
        }
    }
}