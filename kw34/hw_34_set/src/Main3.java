import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        String str ="Jack,John,Nick,John";
        System.out.println(checkString(str));
    }

    private static String checkString(String str) {
        String[] words = str.split(",");
        Set<String> result = new HashSet<>();

        for(String word: words){
            result.add(word);
        }

        return result.toString();
    }
}

/*
Дана строка с именами вида Jack,John,Nick,John.
Необходимо написать метод, который удалит из этой строки повторяющиеся имена.
Т.е. например, в случае строки  “Jack,John,Nick,John” вернет строку  с именами  Jack,John,Nick

 */