
package hospital.lab.management;

public class Sample {
private static int counter = 1;
private int sampleId;
private boolean collected;
public Sample() {
this.sampleId = counter++;
this.collected = false;
}public int getSampleId() {
return sampleId;
} public boolean isCollected() {
return collected;
}  public void collect() {
this.collected = true;
}@Override
public String toString() {
return "Sample ID: " + sampleId + ", Collected: " + collected;
}
}
