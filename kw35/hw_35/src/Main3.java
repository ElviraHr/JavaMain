/*Дан список Person. Необходимо написать метод, который вернет Set из пользователей,
которые в данном списке встречаются более одного раза*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(List.of(new Person("Anna", 20),
                                                          new Person("Nick", 16),
                                                          new Person("Maria", 18),
                                                          new Person("Alex",22),
                                                          new Person("Alex",22),
                                                          new Person("Alex",22),
                                                          new Person("Anna", 20)   ));

        Set<Person>  users = new HashSet<>();
        Set<Person>  temp = new HashSet<>();

        for(Person person : personList){
            if(!temp.add(person)){
                users.add(person);
            }
        }
        System.out.println(users);
    }
}
