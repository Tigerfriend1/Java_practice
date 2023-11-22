import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    private static int orderCounter = 1;
    private int orderNo ;

    ... // your code here

    private Order.PickUp delivery;

    public static interface PickUp {
        public abstract void handle(Order o);
    }
 	...
}