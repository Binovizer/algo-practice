package algo.practice.v2.design.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    // Method to increment the counter
    public void increment() {
        lock.lock();  // Acquire the lock
        try {
            count++;
            System.out.println("Current count after incrementing: " + count);
        } finally {
            lock.unlock();  // Always unlock in a finally block to ensure the lock is released
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Join threads to ensure they finish before the main thread continues
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Output the final count
        System.out.println("Final count: " + counter.count);
    }
}
