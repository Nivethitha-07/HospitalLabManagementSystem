package hospital.lab.management;
public class TestResult {
private String resultValue;
        public TestResult(String resultValue) {
this.resultValue = resultValue;
}
       public String getResultValue() {
return resultValue;
}
      @Override
public String toString() {
return "Result: " + resultValue;
}
}
