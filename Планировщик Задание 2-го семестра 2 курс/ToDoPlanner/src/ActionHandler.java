import java.util.*;
import java.text.MessageFormat;
import java.util.function.Function;
import java.util.function.Predicate;

public class ActionHandler {
    // Класс для обработки функций главного меню

    private final TaskManager taskManager;
    private final Scanner in = new Scanner(System.in);

    public ActionHandler(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    private Integer getIdOfTaskFromConsole(List<Task> tasks) {
        // получает id из консоли
        return ConsoleUtils.<Integer>getValueFromConsole(i -> {
            if (Utils.isInteger(i)) {
                var num = Integer.parseInt(i);
                if (tasks.stream().anyMatch(it -> it.getId() == num))
                    return num;
            }
            return null;

        }, "Вы ввели неверный id! Введите еще раз", true);
    }

    private Date getDateFromConsole(boolean is_planning) {
        // получает дату из консоли с выводом подсказки
        var type = is_planning ? "планирования" : "создания";
        System.out.println(MessageFormat.format("Введите дату {0} задачи в формате день.месяц.год", type));
        System.out.println("Пример 01.01.2000");
        return ConsoleUtils.getValueFromConsole(x -> DateUtils.parseDate(x, false), "Введена неверная дата!\nВведите еще раз:", true);
    }

    private void doSomethingWithTask(Function<Task, Boolean> func, String startMsg, List<Task> tasks) {
        // выполняет функцию func  с переданными tasks, написав в начале startMsg
        System.out.println(startMsg + "\nИли введите \"выход\", если хотите прервать операцию\"");
        showTasks(tasks);
        if (tasks.size() == 0) {
            return;
        }
        var id = getIdOfTaskFromConsole(tasks);
        if (id == null) {
            return;
        }
        var task = tasks.stream().filter(i -> i.getId() == id).findAny();
        task.ifPresent(func::apply);
    }

    private ResultOfOperation setAttribute(Predicate<Object> setter, boolean create) {
        // присваивает значение, введенное с консоли,  аттрибуту. Функция присваивания описана в setter
        var result = in.nextLine();
        if (result.toLowerCase(Locale.ROOT).equals("выход"))
            return ResultOfOperation.EXIT;

        if (result.isEmpty()) {
            if (create)
                return ResultOfOperation.UNSUCCESS;
            return ResultOfOperation.SUCCESS;
        } else {
            var resOp = setter.test(result);
            return resOp ? ResultOfOperation.SUCCESS : ResultOfOperation.UNSUCCESS;
        }
    }

    private ArrayList<List<Object>> getBaseSetAttrsList(Task task) {
        // возвращает базовый набор стартовых сообщений и функций,
        // которые присваивают значение из консоли определенному аттрибуту

        var lsts = new ArrayList<List<Object>>();
        lsts.add(Arrays.asList("Введите название задачи"
                , (Predicate<Object>) o -> {
                    task.setName(o.toString());
                    return true;
                }));
        lsts.add(Arrays.asList("Введите дату планирования задачи в формате день.месяц.год часы:минуты\nПример 01.01.2000 05:05"
                , (Predicate<Object>) o -> {
                    var dateStr = DateUtils.parseDate(o.toString(), true);
                    if (dateStr != null) {
                        task.setPlanningDate(dateStr);
                        return true;
                    }
                    return false;
                }));
        lsts.add(Arrays.asList("Введите описание задачи"
                , (Predicate<Object>) o -> {
                    task.setDescription(o.toString());
                    return true;
                }));
        return lsts;
    }

    private ResultOfOperation setAttributes(ArrayList<List<Object>> lsts, boolean create) {
        // получает список стартовых сообщений и функций,
        // которые присваивают значения определенным аттрибутам
        var prompt = "\nВведите \"выход\", если хотите прервать операцию";
        if (!create)
            prompt += "\nИли нажмите enter, если не хотите менять значение";
        for (List<Object> lst : lsts) {
            System.out.println(lst.get(0) + prompt);
            var result = setAttribute((Predicate<Object>) lst.get(1), create);
            while (result == ResultOfOperation.UNSUCCESS) {
                System.out.println("Введено неверное значение! Повторите еще раз");
                result = setAttribute((Predicate<Object>) lst.get(1), create);
            }
            if (result == ResultOfOperation.EXIT) return result;
        }
        return ResultOfOperation.SUCCESS;
    }
    private void showTasks(List<Task> tasks) {
        // выводит полученные tasks на экран
        var output = System.out;
        if (tasks.size() == 0) {
            System.out.println("Задания не найдены");
            return;
        }
        var format = "%-5s%-60s%-20s%-20s%-20s%n";
        output.printf(format, "id", "Название", "Дата создания", "Завершить до", "Выполнена");
        output.println();
        for (Task task : tasks) {
            String completed;
            if (task.isCompleted())
                completed = Optional.ofNullable(DateUtils.dateToString(task.getCompletedDate(),true)).orElse("-");
            else
                completed = "Нет";
            output.printf(format, Optional.of(Integer.toString(task.getId())).orElse("-"),
                    Optional.ofNullable(task.getName()).orElse("-"),
                    Optional.ofNullable(DateUtils.dateToString(task.getCreatedDate(),true)).orElse("-"),
                    Optional.ofNullable(DateUtils.dateToString(task.getPlanningDate(),true)).orElse("-"),
                    completed);
            output.println();
        }

    }

    private void showTasksByPlanningDate(List<Task> tasks) {
        // выводит полученные tasks на экран по дате планирования

        var date = DateUtils.dateToString(getDateFromConsole(true),false);
        showTasks(tasks.stream().filter(task -> Objects.equals(DateUtils.dateToString(task.getPlanningDate(), false), date))
                .toList());
    }

    private void showTasksByCreationDate(List<Task> tasks) {
        // выводит полученные tasks на экран по дате создания

        var date = DateUtils.dateToString(getDateFromConsole(false),false);
        showTasks(tasks.stream().filter(task -> Objects.equals(DateUtils.dateToString(task.getCreatedDate(), false), date))
                .toList());
    }

    // Дальше идут публичные методы, которые являются функциями программы

    public void createTask() {
        var task = new Task();
        var result = setAttributes(getBaseSetAttrsList(task), true);
        if (result == ResultOfOperation.EXIT) return;
        taskManager.createTask(task);
        System.out.println(MessageFormat.format("Задача \"{0}\" успешно создана!", Optional.ofNullable(task.getName()).orElse("-")));
    }

    public void deleteTask() {
        doSomethingWithTask(task -> {
            taskManager.deleteTask(task);
            System.out.println(MessageFormat.format("Задача \"{0}\" по id {1} успешно удалена!", Optional.ofNullable(task.getName()).orElse("-"),
                    Optional.of(Integer.toString(task.getId())).orElse("-")));
            return true;
        }, "Введите id задания, которое вы хотите удалить", taskManager.getAllTasks());
    }

    public void editTask() {
        doSomethingWithTask(task -> {
            var lsts = getBaseSetAttrsList(task);
            if (task.isCompleted()) {
                lsts.add(Arrays.asList("Отметить задание невыполненным?\nВведите \"да\" если отметить"
                        , (Predicate<Object>) o -> {task.setCompleted(false); return true;}));
            }
            if (setAttributes(lsts, false) == ResultOfOperation.EXIT) return false;
            taskManager.editTask(task);
            System.out.println(MessageFormat.format("Задача \"{0}\" по id {1} успешно сохранена!", Optional.ofNullable(task.getName()).orElse("-"), Optional.of(Integer.toString(task.getId())).orElse("-")));
            return true;
        }, "Введите id задания, которое вы хотите редактировать", taskManager.getAllTasks());
    }

    public void showAllTasks() {
        showTasks(taskManager.getAllTasks());
    }

    public void showCompletedTasks() {
        showTasks(taskManager.getCompletedTask());
    }

    public void showUncompletedTasks() {
        showTasks(taskManager.getUncompletedTask());
    }

    public void showAllTasksByDateOfPlanning() {
        showTasksByPlanningDate(taskManager.getAllTasks());
    }

    public void showCompletedTasksByDateOfPlanning() {
        showTasksByPlanningDate(taskManager.getCompletedTask());
    }

    public void showUncompletedTasksByDateOfPlanning() {
        showTasksByPlanningDate(taskManager.getUncompletedTask());
    }

    public void showAllTasksByDateOfCreation() {
        showTasksByCreationDate(taskManager.getAllTasks());
    }

    public void showCompletedTasksByDateOfCreation() {
        showTasksByCreationDate(taskManager.getCompletedTask());
    }

    public void showUncompletedTasksByDateOfCreation() {
        showTasksByCreationDate(taskManager.getUncompletedTask());
    }

    public void showDetailInfo() {
        System.out.println("Введите id задания, подробности которого вы хотите вывести");
        doSomethingWithTask(task -> {
            System.out.println(MessageFormat.format("id - {0}", Optional.of(Integer.toString(task.getId())).orElse("-")));
            System.out.println(MessageFormat.format("Название - {0}", Optional.ofNullable(task.getName()).orElse("-")));
            System.out.println(MessageFormat.format("Дата создания - {0}",
                    Optional.ofNullable(DateUtils.dateToString(task.getCreatedDate(),true)).orElse("-")));
            System.out.println(MessageFormat.format("Дата планирования - {0}",
                    Optional.ofNullable(DateUtils.dateToString(task.getPlanningDate(),true)).orElse("-")));
            String completed;
            if (task.isCompleted())
                completed = task.getCompletedDate().toString();
            else
                completed = "Нет";
            System.out.println(MessageFormat.format("Выполнена - {0}",
                    completed));
            System.out.println(MessageFormat.format("Описание - {0}", Optional.ofNullable(task.getDescription()).orElse("-")));
            return true;
        }, "Введите id задания, которое вы хотите пометить выполненным", taskManager.getAllTasks());
    }

    public void markTaskCompleted() {
        doSomethingWithTask(task -> {
            taskManager.setTaskCompleted(task,true);
            System.out.println(MessageFormat.format("Задача \"{0}\" по id {1} успешно отмечена выполненной!", Optional.ofNullable(task.getName()).orElse("-"), Optional.of(Integer.toString(task.getId())).orElse("-")));
            return true;
        }, "Введите id задания, которое вы хотите пометить выполненным", taskManager.getUncompletedTask());
    }
    public void printExitString() {
        System.out.println("До скорой встречи!");
    }

}
