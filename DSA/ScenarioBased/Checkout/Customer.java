package ScenarioBased.Checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private int customerId;
    private List<Map.Entry<String, Integer>> items;

    public Customer(int customerId, List<Map.Entry<String, Integer>> items) {
        this.customerId = customerId;
        this.items = new ArrayList<>(items);
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Map.Entry<String, Integer>> getItems() {
        return items;
    }
}
