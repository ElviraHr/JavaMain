package HW_44;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static java.nio.file.Files.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter Directory whith path:");
        Scanner scanner = new Scanner(System.in);
        String pathStr = scanner.nextLine();
        File source = new File(pathStr);


        if (isDirectory(source.toPath())){

            File target = new File(source + "/photo");

            File[] photoList = source.listFiles(f -> f.isFile() && f.getName().endsWith("jpg"));

            if (photoList.length > 0 &&  target.mkdirs()) {
                try {
                    copyFiles(target.toPath(), photoList);
                    System.out.println("all files copied successfully");
                } catch (Exception e) {
                    System.out.println("error while copying");
                }
            };
        }

    }

         private static void copyFiles(Path pathTo, File[] photoList) {
            for (File file : photoList) {
                if (file.isFile()) {
                    try {
                        Path source = file.toPath();
                        Path target = pathTo.resolve(file.getName());
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Ошибка при копировании файла: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        }

}


/*задача 1.
Пользователь вашей программы задает путь (название папки) после чего программа проверяет, есть ли в этой папке файлы с расширением .jpg.
Если такие файлы есть, программа должна создать папку foto и скопировать все файлы jpg в эту папку.
Если пользователь ввел несуществующую папку, программа должна выводить соответствующее сообщение.
Если в заданной папке нет файлов .jpg программа не должна создавать никаких дополнительных файлов или папок.
*/