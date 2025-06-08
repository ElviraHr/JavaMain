package hw_45;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Hw45_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        File temp = new File("./temp");
        File input = new File("./temp/input.txt");
        String inputStr = "";
        temp.mkdirs();

        try (BufferedWriter fos = new BufferedWriter(new FileWriter(input));
             BufferedReader fis = new BufferedReader(new FileReader(input));
        ) {
            while (true) {

                System.out.println("Enter a new line (to terminate the program, enter \"-exit\" ):");
                inputStr = scanner.nextLine();
                if (inputStr.equals("-exit")) break;
                fos.write(inputStr + "\n");
                fos.flush();
            };

            try {
                showFle(input);
            }catch (FileNotFoundException e){};

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scanner.close();

    }

    private static void showFle(File input) throws IOException {

        Path filePath = input.toPath();

        try (InputStream in = Files.newInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
        }
    }
}

/*1
С помощью методов File создайте папку \temp
Напишите метод который, позволяет пользователю вводить строки со сканнера и записывать их в файл \temp\input.txt
Как только пользователь введет "-exit" ваша программа должна вывести на экран весь введенный пользователем текст.

2
Допустим, дан текстовый файл. Ваша задача, вывести содержимое этого файла на экран. - решено в первой задаче функцией showFile();
*/