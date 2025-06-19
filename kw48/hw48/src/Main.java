import java.io.File;

public class Main {
    public static void main(String[] args) {

        System.out.println(exponentiation(2, 3));
        printFiles("G:\\flehatel",1);

    }


    public static void printFiles(String strDir, int level) {
        File directory = new File(strDir);

        if (directory == null || !directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return;

        String indent = "   ".repeat(level); // отступ в зависимости от уровня вложенности

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(indent + "[Папка] " + file.getName());
                printFiles(file.getAbsolutePath(), level + 1); // рекурсивный вызов с увеличением уровня
            } else {
                System.out.println(indent + "- " + file.getName());
            }
        }
    }


    public static int exponentiation(int n, int y) {

        if (n <= 1 || y <= 0) {
            return 1;
        }else
          return n* exponentiation(n, --y) ;
        }

    }
/*1
Реализуйте рекурсивный метод возведения в степень заданного числа

2
С помощью методов класса File, реализуйте метод,
который выводит информацию о всех файлах и папках на дичке начиная с заданной папки.
Т.е. ваш метод, должен показывать все вложенные папки и файлы.
 */