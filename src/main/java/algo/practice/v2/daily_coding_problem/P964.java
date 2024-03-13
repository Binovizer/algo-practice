package algo.practice.v2.daily_coding_problem;

public class P964 {
    private final int[] orderIds; // Array to store order IDs
    private int currentIndex; // Current index for the next order ID
    private int size; // Size of the log

    public P964(int capacity) {
        this.orderIds = new int[capacity];
        this.currentIndex = 0;
        this.size = 0;
    }

    public void record(int orderId) {
        // Record an order ID at the current index
        orderIds[currentIndex] = orderId;
        // Increment the current index and wrap around if necessary
        currentIndex = (currentIndex + 1) % orderIds.length;
        // Update the size, but ensure it does not exceed the capacity
        if (size < orderIds.length) {
            size++;
        }
    }

    public int getLast(int i) {
        // Validate i
        if (i <= 0 || i > size) {
            throw new IllegalArgumentException("Invalid argument: i must be between 1 and " + size);
        }
        // Calculate the index of the ith last element
        int index = (currentIndex - i + orderIds.length) % orderIds.length;
        return orderIds[index];
    }

    public static void main(String[] args) {
        P964 log = new P964(5); // Initialize log with capacity N

        // Simulate recording orders
        log.record(100);
        log.record(101);
        log.record(102);
        log.record(103);
        log.record(104);
        log.record(105); // Overwrites the oldest order (100)

        // Retrieve the last ith order
        System.out.println(log.getLast(1)); // Should return 105
        System.out.println(log.getLast(5)); // Should return 101 (the oldest order in the log)
    }
}
