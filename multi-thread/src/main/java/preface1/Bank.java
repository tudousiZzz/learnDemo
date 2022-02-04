package preface1;

import lombok.Data;

@Data
public class Bank {
    private int money;
    private String name;
    private int maxMoney;

    /**
     * deposit money
     *
     * @param m money
     */
    public synchronized void deposit(int m) {
        try {
            Thread.sleep(500);
            money += m;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * withdraw money
     *
     * @param m money
     * @return true or false
     */
    public synchronized boolean withdraw(int m) throws InterruptedException {
        Thread.sleep(2000);
        if (money >= m) {
            money -= m;
            return true;
        } else {
            return false;
        }

    }

    public synchronized void withdraw1(int m) {
        try {
            Thread.sleep(500);
            if (money <= 0) {
                wait();
            }
            if (money - m < 0) {
                wait();
            }
            money -= m;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
