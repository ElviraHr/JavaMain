import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(3, 5,8,10,12, -55,1000, 74, 0, -3, 34);
        System.out.println(list);

        TreeSet<Integer> treeSetList = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSetList);


        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        Integer x = scanner.nextInt();


        int z = treeSetList.lower(x);
        int y = treeSetList.higher(x);

        System.out.println("Максимально близкое число: "+ ((((int)x-z)<=(y-(int)x))?z:y));

    }
}


/*Дан List<Integer>. Найти значение элемента, максимально близкого к некоторому заданному значению N

т.к в задаче не указано равно, берем методы, где нет равно.
ceiling(e)	>= e (включает e, если есть)
higher(e)	> e (строго больше e)
floor(e)	<= e (включает e, если есть)
lower(e)	< e (строго меньше e)
*/
