import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {

        Student s1 = new Student("John", "Jonson");
        Student s2 = new Student("Jana", "Nelson");
        Student s3 = new Student("Jan", "Mihelson");
        Student s4 = new Student("Sara", "Svenson");
        Student s5 = new Student("Ivan", "Ivanov");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s1);
        students.add(s1);
        students.add(s3);
        students.add(s3);
        students.add(s2);
        students.add(s4);
        students.add(s4);
        students.add(s5);

        Map<Student, Integer> studentIntegerMap = listToMap(students);
        System.out.println(studentIntegerMap.toString());

        System.out.println("Top 3 truant students: " + top3Truant(studentIntegerMap));
    }

    private static List<Student> top3Truant(Map<Student, Integer> studentIntegerMap) {
        List<Student> result = new ArrayList<>();
        Set<Map.Entry<Student, Integer>> entries = studentIntegerMap.entrySet();
        List<Integer> countDay = (studentIntegerMap
                .values()
                .stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(2)
                .toList());

        countDay.forEach(i -> {
            for (Map.Entry<Student, Integer> entry : entries) {
                if (entry.getValue() == i) {
                    result.add(entry.getKey());
                }
                ;

            }
        });


//решение при разборе ДЗ
//        List<Student> listTop3 = studentIntegerMap.entrySet().stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
//                .limit(3)
//                .map(e -> e.getKey())
//                .toList();

        return result;

        //более изящное но мы еще так не учили:
        //        List<Student> top3 = studentIntegerMap.entrySet().stream()
//                .sorted(Map.Entry.<Student, Integer>comparingByValue().reversed())  // сортировка по убыванию
//                .limit(3)                                                    // берём топ-3
//                .map(Map.Entry::getKey)                                              // возвращаем студентов
//                .collect(Collectors.toList());
    }

    private static Map<Student, Integer> listToMap(List<Student> students) {

        Map<Student, Integer> result = new HashMap<>();
        Integer value;
        for (Student student : students) {
            value = result.getOrDefault(student, 0);
            result.put(student, ++value);
        }
        return result;
    }
}


/*a)
Допустим, каждый раз, когда студент не приходит на лекцию, преподаватель заносит его в список.
Таким образом, у вас есть список студентов, т.е. List<Student>, в котором одно и то же имя может встречаться несколько раз.
Напишите метод, который сформирует Map<Student, Integer> где ключ - это студент из списка,
а значение - сколько раз данный студент встретился в списке

b) сформируйте список из 3 студентов, которые прогуляли больше всего занятий
*/