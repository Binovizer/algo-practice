package algo.arraysandstring;

public class TraceOfMatrixAddition {

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        TraceOfMatrixAddition traceOfMatrixAddition = new TraceOfMatrixAddition();
        int trace = traceOfMatrixAddition.findTrace(m, n);
        System.out.println("trace = " + trace);
    }

    public int findTrace(int m, int n) {
        int trace = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    int rowValue = (n * i + j + 1);
                    System.out.println(i + ", " + j + " : " + rowValue);
                    int colValue = (m * i + j + 1);
                    System.out.println(i + ", " + j + " : " + colValue);
                    trace += rowValue + colValue;
                }
            }
        }
        return trace;
    }
}
