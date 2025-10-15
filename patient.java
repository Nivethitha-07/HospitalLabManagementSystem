package hospital.lab.management;
public class Patient {
private static int counter = 1;
private int patientId;
private String name;
private String dob;
private String phone;
        public Patient(String name, String dob, String phone) {
this.patientId = counter++;
this.name = name;
this.dob = dob;
this.phone = phone;
}

public int getPatientId() {
return patientId;
}public String getName() {
return name;
}  public String getDob() {
return dob;
} public String getPhone() {
return phone;
} @Override
public String toString() {
return "Patient ID: " + patientId + ", Name: " + name + ", DOB: " + dob + ", Phone: " + phone;
}
}
