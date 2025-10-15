package hospital.lab.management;

public class Invoice {
private static int counter = 1;
private int invoiceId;
private TestOrder order;
private double taxRate = 0.05;
private boolean paid;
       public Invoice(TestOrder order) {
this.invoiceId = counter++;
this.order = order;
this.paid = false;
} public double getTaxAmount() {
return order.getTotalAmount() * taxRate;
} public double getTotalAmount() {
return order.getTotalAmount() + getTaxAmount();
}public void recordPayment() {
this.paid = true;
} public boolean isPaid() {
return paid;
}
      @Override
public String toString() {
return "Invoice ID: " + invoiceId + "\nOrder ID: " + order.getOrderId() +
"\nSubtotal: ₹" + order.getTotalAmount() +
"\nTax: ₹" + getTaxAmount() +
"\nTotal: ₹" + getTotalAmount() +
"\nPayment Status: " + (paid ? "PAID" : "PENDING");
}
}
