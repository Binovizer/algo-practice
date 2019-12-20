package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type SequencePrint
 *
 * @author Mohd Nadeem
 */
public class SequencePrint implements Runnable {

  private static AtomicInteger atomicInteger = new AtomicInteger(1);

  public static void main(String[] args) {
    Thread t1 = new Thread(new SequencePrint(), "T1");
    Thread t2 = new Thread(new SequencePrint(), "T2");
    Thread t3 = new Thread(new SequencePrint(), "T3");
    t1.start();
    t2.start();
    t3.start();
  }

  @Override
  public void run() {
    while (atomicInteger.get() <= 10) {
      System.out.println(atomicInteger.getAndIncrement() + " " + Thread.currentThread().getName());
    }
  }
}
