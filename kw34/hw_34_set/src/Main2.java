import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {

        List<Person> team1 = new ArrayList<>(List.of(new Person("Vasia", "Pupkin"), new Person("Lena", " Ivanova"),
                new Person("Ostap", "Fedorovich"), new Person("Taras", " Bulba")));
        System.out.println("Front-End team: " + team1);


        List<Person> team2 = new ArrayList<>(List.of(new Person("Max", "Wolf"), new Person("Olha", " Grichin"),
                new Person("Ostap", "Fedorovich"), new Person("Taras", " Bulba")));
        System.out.println("Back-End team: " + team2);

        List<Person> team3 = new ArrayList<>(List.of(new Person("Vasia", "Pupkin"), new Person("Alex", " Holz"),
                new Person("Olaf", "Frosen"), new Person("Anna", "Prinzessin")));
        System.out.println("QA-team: " + team3);

        List<Person> allTeams = new ArrayList<>(team1);

        for (Person person:team2){
            allTeams.add(person);
        }

        for (Person person:team3){
            allTeams.add(person);
        }

        Set listOfEmployees = new HashSet<>(allTeams);

        System.out.println("--------List of employees for the award: ------- ");
        System.out.println(listOfEmployees);

    }
}


/*
Руководство компании решило премировать сотрудников. Каждый team lead подал список сотрудников для получения премии.
Но получилось так, что некоторые сотрудники работают на нескольких проектах и попали в списки несколько раз.
Итак, у вас есть несколько списков Person.
Ваша задача помочь получить один общий список сотрудников, но без повторов */