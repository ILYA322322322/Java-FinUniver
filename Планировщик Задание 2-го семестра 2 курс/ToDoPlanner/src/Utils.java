public class Utils {
    // Базовые утилиты
    public static boolean isInteger(String num){
        if (num == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
