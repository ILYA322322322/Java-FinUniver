import java.util.Date;

public class Task {
    // Класс задания
    private int id;
    private String name;
    private Date createdDate;
    private Date completedDate;
    private String description;
    private boolean isCompleted;
    private Date planningDate;
    public int getId() {
        return id;
    }

    public void setId(int value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCompletedDate() {
        if (completedDate == null)
            return null;
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean completed) {
        isCompleted = completed;
        if (isCompleted)
            setCompletedDate(new Date());
        else
            setCompletedDate(null);

    }

    public Date getPlanningDate() {
        return planningDate;
    }

    public void setPlanningDate(Date planningDate) {
        this.planningDate = planningDate;
    }

}
