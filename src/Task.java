public class Task {
    private final String name;
    private final Priority priority;
    private boolean isCompleted;

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void toggleStatus() {
        this.isCompleted = !this.isCompleted;
    }
}

