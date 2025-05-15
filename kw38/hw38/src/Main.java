import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    List<Task> tasks1 = new ArrayList<>();
        tasks1.add(new Task(100, "description1", "in progress", 3));
      //  tasks1.add(task1);
        tasks1.add(new Task(85, "description3", "in progress", 14));
        tasks1.add(new Task(120, "description4", "expect", 0));

    List<Task> tasks2 = new ArrayList<>();
        tasks2.add(new Task(102, "description1", "in progress", 1));
//        tasks2.add(task1);
//        tasks2.add(task2);
        tasks2.add(new Task(99, "description4", "expect", 0));

    List<Task> tasks3 = new ArrayList<>();
        tasks3.add(new Task(101, "description1", "in progress", 2));
//        tasks3.add(task1);
//        tasks3.add(task2);
//        tasks3.add(task3);


    List<Programmer> programmerList = new ArrayList<>();
        programmerList.add(new Programmer("Mickael Schtof","Berlin", tasks1));
        programmerList.add(new Programmer("Svetlana Rebrova","Hessen", tasks2));
        programmerList.add(new Programmer("Ihor Semenov","Kassel", tasks3));

        Map<String, Integer> tasksByProgrammer = new HashMap<>();
        tasksByProgrammer = programmerList.stream()
                        .collect(Collectors.toMap(p->p.getName(), p-> p.getTasks().size()));
        Map<Integer, Task> tasksByNumber = programmerList.stream()
                .map(p-> p.getTasks())
                .flatMap(t->t.stream())
                .collect(Collectors.toMap(t->t.getNumber(), t->t));




        System.out.println("----1----: ");
        System.out.println(tasksByProgrammer);
        System.out.println("----2----: ");
        System.out.println(tasksByNumber);
        System.out.println("----3----: ");
}
}



/*Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
Task (int Number,Map<Integer, Task> String description, String status, int daysInProcessing) .
Сформировать Map<String, Integer> где ключ, это имя программиста (в данной задаче оно уникально),
а значение количество задач в списке у данного программиста
(в рамках этой задачи, считаем что список не пустой и в нем нет null значений)

2
Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
Task (int Number, String description, String status, int daysInProcessing) .
Сформировать Map<Integer, Task> где ключ, это номер задачи, а значение сама задача

3
Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
 Task (int Number, String description, String status, int daysInProcessing) .
 Сформировать Map<String, List<Task>> где ключ, это статус задачи, а значение список задач в этом статусе
*/