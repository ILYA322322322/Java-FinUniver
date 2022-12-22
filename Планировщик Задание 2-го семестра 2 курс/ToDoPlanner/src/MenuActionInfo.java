public class MenuActionInfo {
    // Класс пункта меню
    private String displayText; // текст пункта меню
    private ActionFunc action;// обработчик пунка меню

    public MenuActionInfo(String displayText, ActionFunc action) {
        this.displayText = displayText;
        this.action = action;
    }

    public ActionFunc getAction() {
        return action;
    }

    public void setAction(ActionFunc action) {
        this.action = action;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
