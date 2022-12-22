import java.text.MessageFormat;
import java.util.HashMap;

public class TaskController {
    // Базовый класс обработки заданий
    private TaskManager taskManager;

    private HashMap<Integer, Object> allActions;
    private ActionHandler actionHandler;

    public TaskController() {
        taskManager = new TaskManager();
        actionHandler = new ActionHandler(taskManager);
        setAllActions();
    }

    private void setAllActions() {
        // задает все события из главного меню и их обработчики
        allActions = new HashMap<>();
        allActions.put(1, new MenuActionInfo("Создать задание", actionHandler::createTask));
        allActions.put(2, new MenuActionInfo("Удалить задание", actionHandler::deleteTask));
        allActions.put(3, new MenuActionInfo("Отредактировать задание", actionHandler::editTask));
        allActions.put(4, new MenuActionInfo("Просмотреть список всех заданий", actionHandler::showAllTasks));
        allActions.put(5, new MenuActionInfo("Просмотреть список выполненных заданий ", actionHandler::showCompletedTasks));
        allActions.put(6, new MenuActionInfo("Просмотреть список невыполненных заданий", actionHandler::showUncompletedTasks));
        allActions.put(7, new MenuActionInfo("Просмотреть список всех заданий на определенную дату планирования", actionHandler::showAllTasksByDateOfPlanning));
        allActions.put(8, new MenuActionInfo("Просмотреть список выполненных заданий на определенную дату планирования", actionHandler::showCompletedTasksByDateOfPlanning));
        allActions.put(9, new MenuActionInfo("Просмотреть список невыполненных заданий на определенную дату планирования", actionHandler::showUncompletedTasksByDateOfPlanning));
        allActions.put(10, new MenuActionInfo("Просмотреть список всех заданий на определенную дату создания", actionHandler::showAllTasksByDateOfCreation));
        allActions.put(11, new MenuActionInfo("Просмотреть список выполненных заданий на определенную дату создания", actionHandler::showCompletedTasksByDateOfCreation));
        allActions.put(12, new MenuActionInfo("Просмотреть список невыполненных заданий на определенную дату создания", actionHandler::showUncompletedTasksByDateOfCreation));
        allActions.put(13, new MenuActionInfo("Просмотреть детальную информацию о задании", actionHandler::showDetailInfo));
        allActions.put(14, new MenuActionInfo("Отметить задание выполненным", actionHandler::markTaskCompleted));
        allActions.put(15, new MenuActionInfo("Выход из планировщика задач", actionHandler::printExitString));
    }

    private int getActionFromMainMenu() {
        // ожидает ввода действия из главного меню с клавиатуры
        PrintMainMenu();
        return ConsoleUtils.<Integer>getValueFromConsole(s -> {
            if (Utils.isInteger(s)) {
                var num = Integer.parseInt(s);
                if (num > 0 && num <= allActions.size())
                    return num;
            }
            return null;
        }, "Вы ввели неверный индекс!,  повторите еще раз", false);
    }


    private void PrintMainMenu() {
        // выводит главное меню
        System.out.println("Введите номер интересующего вас действия и нажмите enter,\n" +
                "чтобы выполнить его");
        allActions.forEach((i, s) -> System.out.println(MessageFormat.format("{0}. {1}", i, ((MenuActionInfo) s).getDisplayText())));

    }

    public void Start() {
        // запуск программы
        System.out.println("Вас приветствует супер-пупер планировщик заданий!");
        while (true) {
            var actionId = getActionFromMainMenu();
            ((MenuActionInfo) allActions.get(actionId)).getAction().run();
            if (actionId == 15)
                break;
            System.out.println("Чтобы вернутся в главное меню, нажмите enter");
            ConsoleUtils.getAnyKeyFromConsole();
        }
    }
}
