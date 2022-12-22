import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TaskManager {
    // Класс для управления всеми заданиями
    private final String tasksFileName = "tasks.json";
    private final String parameteresFimeName = "parameteres.json";


    public List<Task> getAllTasks() {
        var tasks = getTasksFromFile();
        if (tasks == null)
            return new ArrayList<>();
        else
            return new ArrayList<>(tasks.stream().map(i -> getTaskFromJson((JsonObject) i)).toList());
    }

    public List<Task> getCompletedTask() {
        return getAllTasks().stream().filter(Task::isCompleted).toList();
    }

    public List<Task> getUncompletedTask() {
        return getAllTasks().stream().filter(it -> !it.isCompleted()).toList();
    }

    private Task getTaskFromJson(JsonObject jObj) {
        // преобразует объект JsonObject в класс Task
        var task = new Task();
        task.setId(Integer.parseInt(jObj.get("id").toString()));
        task.setName((String) jObj.get("name"));
        task.setCreatedDate(DateUtils.parseDate((String) jObj.get("creation_date"), true));
        task.setPlanningDate(DateUtils.parseDate((String) jObj.get("planning_date"), true));
        task.setCompletedDate(DateUtils.parseDate((String) jObj.get("completed_date"), true));
        task.setDescription((String) jObj.get("description"));
        task.setCompleted((Boolean) jObj.get("is_completed"));
        return task;
    }

    private JsonArray getTasksFromFile() {
        // получает задания из json

        return JsonUtils.getJsonFromFile(tasksFileName);
    }

    private void saveTask(Task task) {
        var tasksJson = getTasksFromFile();
        if (tasksJson == null)
            tasksJson = new JsonArray();
        var matched = tasksJson.stream().filter(i -> Integer.parseInt(((JsonObject) i).get("id").toString()) == task.getId()).toArray();
        JsonObject jObj;
        if (matched.length > 0)
            jObj = (JsonObject) matched[0];
        else {
            jObj = new JsonObject();
            tasksJson.add(jObj);
        }
        jObj.put("id", task.getId());
        jObj.put("name", task.getName());
        jObj.put("creation_date", DateUtils.dateToString(task.getCreatedDate(), true));
        jObj.put("completed_date", DateUtils.dateToString(task.getCompletedDate(),true));
        jObj.put("planning_date", DateUtils.dateToString(task.getPlanningDate(),true));
        jObj.put("description", task.getDescription());
        jObj.put("is_completed", task.isCompleted());
        JsonUtils.saveJsonToFile(tasksFileName, tasksJson.toJson());
    }


    private void UpdateIdCounter(int i) {
        // обновляет id в файле
        var jObj = new JsonObject();
        jObj.put("currentId", i);
        JsonUtils.saveJsonToFile(parameteresFimeName, jObj.toJson());
    }

    private int GetIdCounter() {
        // получает id из файла
        var result = JsonUtils.<JsonObject>getJsonFromFile(parameteresFimeName);
        if (result == null) {
            var id = 0;
            UpdateIdCounter(id);
            return id;
        }
        return Integer.parseInt(result.get("currentId").toString());
    }

    public void createTask(Task task) {
        // задает дату создания и id заданию и сохраняет его
        task.setCreatedDate(new Date());
        var id = GetIdCounter();
        task.setId(id);
        UpdateIdCounter(id + 1);
        saveTask(task);
    }

    public void editTask(Task task) {
        // сохраняет отредактированное задание
        saveTask(task);
    }
    public void setTaskCompleted(Task task, boolean completed){
        // отмечает задание правильным

        task.setCompleted(completed);
        saveTask(task);
    }
    public void deleteTask(Task task) {
        // удаляет задание
        var tasksJson = getTasksFromFile();
        tasksJson.removeIf(i -> Objects.equals(((JsonObject) i).get("id").toString(), Integer.toString(task.getId())));
        JsonUtils.saveJsonToFile(tasksFileName, tasksJson.toJson());

    }

}
