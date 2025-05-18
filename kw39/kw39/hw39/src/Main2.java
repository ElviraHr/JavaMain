import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        List<Order> orderList = List.of(
                new Order("Berlin", 22, 1.500),
                new Order("Frankfurt", 25, 3.500),
                new Order("Fulda", 33, 50),
                new Order("Wiesbaden", 58, 10),
                new Order("Berlin", 66, 15),
                new Order("Fulda", 99, 2)
        );

        TreeMap<String, Double> map = orderList.stream()
                .collect(Collectors.toMap(
                        o -> o.getCity(),                // ключ — город
                        o -> o.getWeight(),              // значение — вес
                        (w1, w2) -> w1 + w2,            // если ключ совпадает — суммируем веса
                        TreeMap::new                    // поставщик итоговой коллекции — TreeMap
                ));
        System.out.println(map);

     }
}

/*2
Дан список объектов Order (String city - город доставки, int number - номер заказа, double - вес заказа)
Напишите метод, который поможет службе доставки получить отчет: отсортированный список городов - общий вес доставки*/