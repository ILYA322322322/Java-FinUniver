import com.github.cliftonlabs.json_simple.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    // Класс утилит для работы с json
    public static <T extends Jsonable> T getJsonFromFile(String file_name) {
        // получает объект T, который реализует Jsonable из указанного файла
        // (получает json из файла)
        try (FileReader reader = new FileReader(file_name)) {
            var sb = new StringBuffer();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
            return (T) Jsoner.deserialize(sb.toString());
        } catch (IOException ex) {
            return (T) null;
        } catch (JsonException ex) {
            saveJsonToFile(file_name, "[]");
            return (T) null;
        }
    }

    public static boolean saveJsonToFile(String file_name, String json) {
        // Сохраняет json строку файле file_name
        try (FileWriter writer = new FileWriter(file_name)) {
            writer.write(json);
            writer.flush();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }


}
