import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("jack", "qwerty13");
        map.put("john", "poiuy09");
        map.put("jana", "asdf55");
        map.put("johan", "zxcvbb77");

        System.out.println(mapToList(map));
        System.out.println(mapToList2(map));
    }

    private static List<String> mapToList(Map<String, String> map) {

        List<String> result = new ArrayList<>();
        map.forEach((key, value) -> {
            result.add(key + ":" + value);
        });
        return result;
    }


    private static List<String> mapToList2(Map<String, String> map) {//разбор домашки. Еще вариант
        return map.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue())
                .toList();
    }

}
 /*Дана Map<String:String> - получить список строк вида “параметр:значение”

Например:
Map:{
   “jack” = ”qwer13”
   “john” = ”zxc45”
}
Список :
  “jack:qwer13”, “john:zxc45”
*/