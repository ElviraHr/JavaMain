import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("jack");
        list.add("nick");
        list.add("ann");
        list.add("poul");
        list.add("nickolaus");
        list.add("lena");
        list.add("ira");
        list.add("lena");
        list.add("jack");
        list.add("mark");
        list.add("nick");

        System.out.println(check(list));
        List<Integer> list1= List.of(4, 5, 6, 7, 8);
        System.out.println(check(list1));
    }

    public static <T> boolean check(List<T> list) {
        Set<T> set = new HashSet<>(list);
        return set.size() < list.size();
    }

}



/*
Дан лист String. Необходимо определить,
есть ли в данном листе повторяющиеся объекты.
(данный метод можно реализовать в общем виде, для листа любых объектов)
 */