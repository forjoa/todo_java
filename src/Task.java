enum Priority {
    HIGH, MEDIUM, LOW
}

public class Task {
    private String name;
    private Priority priority;
    private boolean isCompleted;

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isCompleted() { return isCompleted; }
    public void toggleStatus() { this.isCompleted = !this.isCompleted; }
}

