import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- task 1 ---------");
        String str = "Jeff,jeff@mail.com,23;Jack,jack@mail.com,45;Nick,nick@mail.com,24;Oleg,oleg@mail.com,22";

        try (OutputStream outputStream = new FileOutputStream("example.txt");) {
            for (var b : str.getBytes()) {
                outputStream.write(b);
            }

        } catch (IOException e) {
            System.out.println("ошибка при создании файла");
        }
        System.out.println(" Файл example.txt успешно создан");
        System.out.println("------- task 2 ----------");

        try (InputStream inputStream = new FileInputStream("example.txt");) {
            try (OutputStream outputStream = new FileOutputStream("example2.txt")) {

                int nextByte;

                while ((nextByte = inputStream.read()) != -1) {
                    outputStream.write(nextByte);
                }

            } catch (IOException e) {
                System.out.println("Ошибка записи файла example2.txt");
            }
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла example.txt");
        }
        System.out.println(" Файл example2.txt успешно создан");

        System.out.println("------- task 3 & 4 ----------");
//содержимое "file1.txt: ЭJeff,jeff@mail.com,23;Jack,jackmail.com,45;Nick;Oleg,oleg@mail.com,2s"
        try (InputStream inputStream = new FileInputStream("file1.txt");) {

            StringBuilder stringObjects = new StringBuilder();

            int nextByte;

            while ((nextByte = inputStream.read()) != -1) {
                stringObjects.append((char) nextByte);
            }

            String[] stringPersons = stringObjects.toString().split(";");

            List<Person> personList = new ArrayList<>();

            for (int i = 0; i < stringPersons.length; i++) {

                String[] persStr = stringPersons[i].split(",");

                try {
                    if (checkFields(persStr[1], persStr[2]))
                        personList.add(new Person(persStr[0], persStr[1], Integer.parseInt(persStr[2])));
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }

            System.out.println(personList);
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла example.txt");
        }
        System.out.println();
    }

    public static boolean checkFields(String email, String age) {

        return email.equals("@") || isInt(age);

    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
















/*1
Используя FileOutputStream создать на диске файл example.txt, который должен содержать строку:
Jeff,jeff@mail.com,23;Jack,jack@mail.com,45;Nick,nick@mail.com,24;Oleg,oleg@mail.com,22

2
Используя FileInputStream и FileOutputStream, создайте на диске example2.txt - копию файла example.txt;

3
Напишите программу, которая читает файл example.txt и формирует список Person(String name,String email,int age)
Подсказка 1: в исходной строке поля разделены ',' а объекты ';'
Подсказка 2: преобразование возраста из строки в int - Integer.parseInt() (и кстати, там может быть Exception)

4
Доработайте последнюю задачу таким образом, что бы система пропускала 'некорректных' персонов:

не все поля заданы
не корректно задан возраст
еmail не содержит @*/