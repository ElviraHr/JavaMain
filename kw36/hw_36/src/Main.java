/*Дан список  BankAccount {Person owner, String IBAN, double balance). Класс Person состоит из {String fName, String lName String email)
1. Используя stream необходимо получить List всех аккаунтов, баланс которых составляет менее 100.
2. Используя stream необходимо получить List всех владельцев счетов
3. Используя stream,  сформировать лист строк вида “Lennon J.;IBAN: DE199988643;lennon@gmail.com”    (т.е. ФИО; счет, email)  для всех клиентов, чей баланс более 100_000*/


import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<BankAccount> bankAccounts = List.of(new BankAccount(new Person("john", "jonson", "jjonson@gmail.com"), "DE 2854368888", 10),
                new BankAccount(new Person("Hermione", "Granger", "granger@gmail.com"), "DE 2854368888", 8_000_000),
                new BankAccount(new Person("Ron", "Weasley", "weasley@gmail.com"), "DE 2854368888", 10000),
                new BankAccount(new Person("Harry", "Potter", "potter@gmail.com"), "DE 2854368888", 50_000),
                new BankAccount(new Person("Tom", "Riddle", "riddle@gmail.com"), "DE 2854368888", 250_000),
                new BankAccount(new Person("Jack", "Sparrow", "sparrow@gmail.com"), "DE 2854368888", 99),
                new BankAccount(new Person("John", "Lennon", "lennon@gmail.com"), "DE 2854368888", 100_000_000)
        );

        List<BankAccount> balanceLess100 = bankAccounts.stream()
                .filter(b -> b.getBalance() < 100)
                .toList();
        System.out.println("----------balance less than 100--------------");
        System.out.println(balanceLess100);

        List<Person> owners = bankAccounts.stream().map(b -> b.getOwner()).toList();

        System.out.println("---------- all owners ---------");
        System.out.println(owners);

        System.out.println("----------- formated output-----------");
        List<String> list = bankAccounts.stream().filter(b -> b.getBalance() > 100_000).map(b -> String.format("%s %s; IBAN:%s;%s ",
                 b.getOwner().getlName(), b.getOwner().getfName().substring(0, 1), b.getIBAN(), b.getOwner().getEmail()))
                .toList();

        System.out.println(list);
    }
}