package algo.arraysandstring;

public class TraceOfMatrixAddition {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        TraceOfMatrixAddition traceOfMatrixAddition = new TraceOfMatrixAddition();
        int trace = traceOfMatrixAddition.findTrace(m, n);
        System.out.println("trace = " + trace);
    }

    public int findTrace(int m, int n) {
        int trace = 0;
        for (int i = 0; i < m; i++) {
            if (i < n) {
                int rowValue = i * (n + 1) + 1;
//                    System.out.println(i + ", " + j + " : " + rowValue);
                int colValue = i * (m + 1) + 1;
//                    System.out.println(i + ", " + j + " : " + colValue);
                trace += rowValue + colValue;
            }
        }
        return trace;
    }
}
