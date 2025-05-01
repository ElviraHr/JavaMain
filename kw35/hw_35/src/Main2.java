/*Дано два списка с Person необходимо получить Set с персонами которые присутствуют и в том и в другом списке
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(List.of(new Person("Anna", 20), new Person("Nick", 16), new Person("Maria", 18), new Person("Alex",22)));
        List<Person> personList1 = new ArrayList<>(List.of(new Person("Eva", 25), new Person("Nick", 16), new Person("Maria", 18), new Person("Alex",27)));

        Set<Person> duplicate = new HashSet<>();

        List<Person> intersection = new ArrayList<>(personList1);
        intersection.retainAll(personList);

        duplicate.addAll(intersection);

        System.out.println(duplicate);
    }
}
