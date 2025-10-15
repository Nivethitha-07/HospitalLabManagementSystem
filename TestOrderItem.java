package hospital.lab.management;

public class TestOrderItem {
private LabTest test;
private int quantity;
private Sample sample;
private TestResult result;
       public TestOrderItem(LabTest test, int quantity) {
this.test = test;
this.quantity = quantity;
}public LabTest getTest() {
return test;
} public int getQuantity() {
return quantity;
} public double getTotalPrice() {
return test.getPrice() * quantity;
} public Sample getSample() {
return sample;
} public void setSample(Sample sample) {
this.sample = sample;
} public TestResult getResult() {
return result;
} public void setResult(TestResult result) {
this.result = result;
}@Override
public String toString() {
return test.getTestName() + " x" + quantity + " - ₹" + getTotalPrice();
}
}
