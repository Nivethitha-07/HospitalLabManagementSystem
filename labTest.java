package hospital.lab.management;
public class LabTest {
private static int counter = 1;
private int testId;
private String testName;
private double price;
public LabTest(String testName, double price) {
this.testId = counter++;
this.testName = testName;
this.price = price;
}  public int getTestId() {
return testId;
}public String getTestName() {
return testName;
} public double getPrice() {
return price;
} @Override
public String toString() {
return testId + " - " + testName + " (₹" + price + ")";
}}
