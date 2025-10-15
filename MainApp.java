package hospital.lab.management;

import java.util.*;

public class MainApp {
private static List<Patient> patients = new ArrayList<>();
private static List<LabTest> tests = new ArrayList<>();
private static List<TestOrder> orders = new ArrayList<>();
private static List<Invoice> invoices = new ArrayList<>();
private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
while (true) {
System.out.println("\n=== Hospital Lab Test Management System ===");
System.out.println("1. Add Patient");
System.out.println("2. Add Lab Test");
System.out.println("3. Create Test Order");
System.out.println("4. Collect Sample");
System.out.println("5. Record Result");
System.out.println("6. Generate Invoice");
System.out.println("7. Record Payment");
System.out.println("8. Display Orders");
System.out.println("9. Exit");
System.out.print("Choice: ");
int choice = sc.nextInt();
sc.nextLine();

switch (choice) {
case 1 -> addPatient();
case 2 -> addLabTest();
case 3 -> createOrder();
case 4 -> collectSample();
case 5 -> recordResult();
case 6 -> generateInvoice();
case 7 -> recordPayment();
case 8 -> displayOrders();
case 9 -> {
System.out.println("Exiting...");
return;
}
default -> System.out.println("Invalid choice!");
}
}
}

private static void addPatient() {
System.out.print("Name: ");
String name = sc.nextLine();
System.out.print("DOB (yyyy-mm-dd): ");
String dob = sc.nextLine();
System.out.print("Phone: ");
String phone = sc.nextLine();
patients.add(new Patient(name, dob, phone));
System.out.println("Patient added successfully!");
}

private static void addLabTest() {
System.out.print("Test name: ");
String name = sc.nextLine();
System.out.print("Price: ");
double price = sc.nextDouble();
sc.nextLine();
tests.add(new RoutineLabTest(name, price));
System.out.println("Lab test added successfully!");
}

private static void createOrder() {
if (patients.isEmpty() || tests.isEmpty()) {
System.out.println("Add patient and tests first.");
return;
}
System.out.println("Select patient:");
for (Patient p : patients) {
System.out.println(p.getPatientId() + ". " + p.getName());
}
int pid = sc.nextInt();
sc.nextLine();
Patient patient = patients.stream().filter(p -> p.getPatientId() == pid).findFirst().orElse(null);
if (patient == null) {
System.out.println("Invalid patient!");
return;
}

TestOrder order = new TestOrder(patient);
System.out.println("Select test (0 to finish):");
for (LabTest t : tests) {
System.out.println(t);
}
while (true) {
int tid = sc.nextInt();
if (tid == 0) break;
LabTest test = tests.stream().filter(t -> t.getTestId() == tid).findFirst().orElse(null);
if (test == null) {
System.out.println("Invalid test!");
continue;
}
System.out.print("Quantity: ");
int qty = sc.nextInt();
sc.nextLine();
order.addItem(new TestOrderItem(test, qty));
}
orders.add(order);
System.out.println("Order created successfully! ID: " + order.getOrderId());
}

private static void collectSample() {
System.out.print("Enter Order ID: ");
int oid = sc.nextInt();
sc.nextLine();
TestOrder order = findOrder(oid);
if (order == null) return;
for (TestOrderItem item : order.getItems()) {
Sample s = new Sample();
s.collect();
item.setSample(s);
}
order.setStatus(OrderStatus.SAMPLE_COLLECTED);
System.out.println("Samples collected!");
}

private static void recordResult() {
System.out.print("Enter Order ID: ");
int oid = sc.nextInt();
sc.nextLine();
TestOrder order = findOrder(oid);
if (order == null) return;
for (TestOrderItem item : order.getItems()) {
if (item.getSample() != null && item.getSample().isCollected()) {
System.out.print("Enter result for " + item.getTest().getTestName() + ": ");
String res = sc.nextLine();
item.setResult(new TestResult(res));
}
}
order.setStatus(OrderStatus.RESULT_RECORDED);
System.out.println("Results recorded!");
}

private static void generateInvoice() {
System.out.print("Enter Order ID: ");
int oid = sc.nextInt();
sc.nextLine();
TestOrder order = findOrder(oid);
if (order == null) return;
Invoice inv = new Invoice(order);
invoices.add(inv);
order.setStatus(OrderStatus.INVOICED);
System.out.println(inv);
}

private static void recordPayment() {
System.out.print("Enter Order ID: ");
int oid = sc.nextInt();
sc.nextLine();
Invoice inv = invoices.stream().filter(i -> i.toString().contains("Order ID: " + oid)).findFirst().orElse(null);
if (inv == null) {
System.out.println("Invoice not found!");
return;
}
inv.recordPayment();
TestOrder order = findOrder(oid);
if (order != null) order.setStatus(OrderStatus.PAID);
System.out.println("Payment recorded!");
}

private static void displayOrders() {
for (TestOrder order : orders) {
System.out.println(order);
for (TestOrderItem item : order.getItems()) {
System.out.println("  " + item);
if (item.getResult() != null) {
System.out.println("    " + item.getResult());
}
}
}
}

private static TestOrder findOrder(int id) {
return orders.stream().filter(o -> o.getOrderId() == id).findFirst().orElse(null);
}
}

