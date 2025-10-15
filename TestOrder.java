package hospital.lab.management;

import java.util.ArrayList;
import java.util.List;

public class TestOrder {
private static int counter = 1;
private int orderId;
private Patient patient;
private List<TestOrderItem> items;
private OrderStatus status;
       public TestOrder(Patient patient) {
this.orderId = counter++;
this.patient = patient;
this.items = new ArrayList<>();
this.status = OrderStatus.CREATED;
} public int getOrderId() {
return orderId;
} public Patient getPatient() {
return patient;
}  public List<TestOrderItem> getItems() {
return items;
}public void addItem(TestOrderItem item) {
items.add(item);
} public double getTotalAmount() {
double total = 0;
for (TestOrderItem i : items) {
total += i.getTotalPrice();
}
return total;
}  public OrderStatus getStatus() {
return status;
}public void setStatus(OrderStatus status) {
this.status = status;
} @Override
public String toString() {
return "Order ID: " + orderId + ", Patient: " + patient.getName() + ", Total: ₹" + getTotalAmount() + ", Status: " + status;
}
}
