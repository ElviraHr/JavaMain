/*Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
   Task (int Number, String description, String status, int daysInProcessing) .
   Причем, одна задача может быть в списке у нескольких программистов Сформировать лист из всех задач. */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task(77, "description2", "completed", 5);
        Task task2 = new Task(70, "description3", "in progress", 4);
        Task task3 = new Task(90, "description4", "expect", 0);

        List<Task> tasks1 = new ArrayList<>();
        tasks1.add(new Task(100, "description1", "in progress", 3));
        tasks1.add(task1);
        tasks1.add(new Task(85, "description3", "in progress", 14));
        tasks1.add(new Task(120, "description4", "expect", 0));

        List<Task> tasks2 = new ArrayList<>();
        tasks2.add(new Task(102, "description1", "in progress", 1));
        tasks2.add(task1);
        tasks2.add(task2);
        tasks2.add(new Task(99, "description4", "expect", 0));

        List<Task> tasks3 = new ArrayList<>();
        tasks3.add(new Task(101, "description1", "in progress", 2));
        tasks3.add(task1);
        tasks3.add(task2);
        tasks3.add(task3);


        List<Programmer> programmerList = new ArrayList<>();
        programmerList.add(new Programmer("Mickael Schtof","Berlin", tasks1));
        programmerList.add(new Programmer("Svetlana Rebrova","Hessen", tasks2));
        programmerList.add(new Programmer("Ihor Semenov","Kassel", tasks3));

        Set<Task> taskSetset = new HashSet<>();

        for (Programmer programmer: programmerList){
            taskSetset.addAll(programmer.getTasks());
        }
        System.out.println(taskSetset);
    }


}