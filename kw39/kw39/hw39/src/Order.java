import java.util.Objects;

public class Order {
    private String city;
    private int number;
    private double weight;

    public Order(String city, int number, double weight) {
        this.city = city;
        this.number = number;
        this.weight = weight;
    }

    public String getCity() {
        return city;
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return number == order.number && Double.compare(weight, order.weight) == 0 && Objects.equals(city, order.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, number);
    }

    @Override
    public String toString() {
        return String.format("Order #%d  city=%s, weight=%.2f", number, city, weight);
    }
}
