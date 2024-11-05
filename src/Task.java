public class Task {
    private final int id;
    private final String name;
    private boolean done;
    private final String priority;

    public Task(int id, String name, boolean done, String priority) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public String getPriority() {
        return priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
