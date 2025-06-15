package HW_47.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String pathToFile = "C:/Java/file1.txt";
        File file = new File(pathToFile);

        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new FileNotAvailableException("не доступен файл " + file);
        }

        List<Person> personList = getPeople(file);
        System.out.println("---------------- List of Person -------------------");
        System.out.println(personList);

        System.out.println("---------- sorting by age ---------------");
        System.out.println(sortByAge(personList));

        System.out.println("---------- birthday in month ---------------");
        System.out.println(findBirthdaysInMonth(personList, 7));

        System.out.println("---------- max days between people's birthday's: ---------------");
        System.out.println(maxDaysBetweenBirthdays(personList));

        System.out.println("---------- find the nearest birthday: ---------------");
        System.out.println(findNearestBirthday(personList));

    }

    private static LocalDate findNearestBirthday(List<Person> personList) {

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        long result=0;

        List<Long> days = new ArrayList<>();

        for (Person p : personList){
            LocalDate birth = p.getBirthday();
            days.add(ChronoUnit.DAYS.between(now, LocalDate.of(year, birth.getMonthValue() ,birth.getDayOfMonth())));
        }

        days.sort(Long::compareTo);

        for (Long day : days){
            if(day < 0){
                continue;
            }else{
                result = day;
                break;
            }
        }

        return LocalDate.now().plusDays(result);
    }

    private static List<Person> sortByAge(List<Person> personList) {
       List<Person> newPersonList = new ArrayList<>(personList);

       newPersonList.sort((p1,p2) -> p1.getBirthday().compareTo(p2.getBirthday()));
       return newPersonList;
    }

    private static List<Person> getPeople(File file) {

        List<Person> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            result = reader.lines()
                    .filter(s -> !s.isBlank())
                    .map(s -> personOf(s))
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

        } catch (IOException e) {

        }
        return result;
    }

    private static Person personOf(String personString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            String[] arr = personString.trim().split(",");
            return new Person(arr[0], LocalDate.parse(arr[1],formatter),  arr[2]);
        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return null;
    }

    private static List<Person> findBirthdaysInMonth(List<Person> personList, int month){

        List<Person> resultList = new ArrayList<>();
        if (month >12 || month <1 ) {
            return resultList;
        };

        for (Person p : personList){
            if (p.getBirthday().getMonthValue() == month){
                resultList.add(p);
            }
        }

        return resultList;
    }

    private static long maxDaysBetweenBirthdays(List<Person> personList){

        List<Person> sortedPersonList = sortByAge(personList);
        return ChronoUnit.DAYS.between(sortedPersonList.get(0).getBirthday(), sortedPersonList.get(sortedPersonList.size() - 1).getBirthday());
    }

}

