import java.util.*;

class Task {
    String title;
    String category;

    Task(String title, String category) {
        this.title = title;
        this.category = category;
    }

    void display() {
        System.out.println("[" + category + "] " + title);
    }
}

public class TasksManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Task>> tasks = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Task\n2. Show Tasks\n3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter task title: ");
                String title = sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();

                tasks.putIfAbsent(category, new ArrayList<>());
                tasks.get(category).add(new Task(title, category));

            } else if (choice == 2) {
                for (String cat : tasks.keySet()) {
                    System.out.println("\nCategory: " + cat);
                    for (Task t : tasks.get(cat)) {
                        t.display();
                    }
                }

            } else if (choice == 3) {
                System.out.println("Exiting.");
                break;
            }
        }
    }
}
