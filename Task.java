public class Task {
    private String title;
    private String category;
    private int priority;
    private String dueDate;

    public Task(String title, String category, int priority, String dueDate) {
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getPriority() { return priority; }
    public String getDueDate() { return dueDate; }

    public void printTask() {
        System.out.println("[" + category + "] " + title + " (Priority: " + priority + ", Due: " + dueDate + ")");
    }
}
