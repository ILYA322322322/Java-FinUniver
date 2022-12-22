import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

public class ConsoleUtils {
    // Класс утилит для консоли

    private static final Scanner in = new Scanner(System.in);
    private static final Object exitString = "выход";

    public static <T> T getValueFromConsole(Function<String, T> func, String errorMsg, Boolean isExit) {
        // Получает значение из консоли, преобразует его
        // в тип T с помощью функции func и выводит сообщение errorMsg
        // Пока не будет введено правильное значение
        // isExit указывает, нужно ли при вводе "выход" прерывать итерацию
        while (true) {
            var text = in.nextLine();
            if (isExit){
                if (Objects.equals(text.toLowerCase(Locale.ROOT), exitString)){
                    return null;
                }
            }
            var result = func.apply(text);
            if (result != null)
                return result;
            System.out.println(errorMsg);
        }
    }
    public static void getAnyKeyFromConsole() {
        // Ожидает нажатия enter в консоли
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


}
