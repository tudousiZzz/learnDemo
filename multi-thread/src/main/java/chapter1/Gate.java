package chapter1;

import java.util.concurrent.Semaphore;


public class Gate {

    // 临界区资源
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private Semaphore semaphore;

    public Gate() {
    }

    public Gate(int permit) {
        if (permit <= 0) {
            throw new IllegalArgumentException("permit should > 0");
        }
        this.semaphore = new Semaphore(permit);
    }

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    /**
     * 使用信号量机制
     * @param name
     * @param address
     */
    public void pass1(String name, String address) {
        try {
            semaphore.acquire();
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }

    }

    public String toString() {
        return "NO." + counter + ":" + name + ", " + address;
    }

    public void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("**** BROKEN ****" + toString());
        }
    }
}
