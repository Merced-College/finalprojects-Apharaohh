import java.util.*;

public class TaskManager {
    // array list initializer
    private ArrayList<Task> allTasks = new ArrayList<>();
    // hash table initializer
    private HashMap<String, ArrayList<Task>> categoryMap = new HashMap<>();
    // linked list initializer
    private Queue<Task> priorityQueue = new LinkedList<>();

    // Add tasks for the basic functionality for it
    public void addTask(Task task) {
        allTasks.add(task);

        // Used CHATGPT to help add this line of code that allows the user to ge
        categoryMap.putIfAbsent(task.getCategory(), new ArrayList<>());
        categoryMap.get(task.getCategory()).add(task);

        // Add high priority tasks to the queue
        if (task.getPriority() == 1) {
            priorityQueue.offer(task);
        }
    }

    // Calls the recursive function 
    public boolean searchTaskByTitle(String keyword, int index) {
        if (index >= allTasks.size()) return false;
        if (allTasks.get(index).getTitle().equalsIgnoreCase(keyword)) {
            System.out.println("Task found:");
            allTasks.get(index).printTask();
            return true;
        }
        // Call the recursive function
        return searchTaskByTitle(keyword, index + 1);
    }

    // Show all tasks in a category with the logic to handle if no tasks exist in the category
    public void showTasksInCategory(String category) {
        ArrayList<Task> list = categoryMap.get(category);
        if (list == null || list.isEmpty()) {
            System.out.println("No tasks in this category.");
            return;
        }
        for (Task task : list) {
            task.printTask();
        }
    }

    // Class to be able to print the higher priority tasks
    public void showPriorityReminders() {
        System.out.println("Priority Task Reminders:");
        for (Task task : priorityQueue) {
            task.printTask();
        }
    }
    // Main class that includes the basic logic for the functionality of the application. Use if-else logic to determine the user input and then adjuss accordingly. 
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int option;

        // While true it will keep going until the user inputs the exit command which in this case is 5
        while (true) {
            System.out.println("\nTask Tracker Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by Title");
            System.out.println("3. Show Tasks by Category");
            System.out.println("4. Show Priority Reminders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            if (option == 1) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter priority (1=High, 2=Med, 3=Low): ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter due date: ");
                String dueDate = sc.nextLine();
                tm.addTask(new Task(title, category, priority, dueDate));

            } else if (option == 2) {
                System.out.print("Enter task title to search: ");
                String keyword = sc.nextLine();
                if (!tm.searchTaskByTitle(keyword, 0)) {
                    System.out.println("Task not found.");
                }

            } else if (option == 3) {
                System.out.print("Enter category: ");
                String cat = sc.nextLine();
                tm.showTasksInCategory(cat);

            } else if (option == 4) {
                tm.showPriorityReminders();

            } else if (option == 5) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
