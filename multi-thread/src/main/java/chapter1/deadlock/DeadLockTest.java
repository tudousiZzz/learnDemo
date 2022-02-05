package chapter1.deadlock;

public class DeadLockTest {
    public static void main(String[] args) {
        Cutlery cutlery1 = new Cutlery("knife");
        Cutlery cutlery2 = new Cutlery("fork");


        // 循环申请，导致死锁
        // new EatThread(cutlery1, cutlery2).start();
        // new EatThread(cutlery2, cutlery1).start();

        // 申请资源方式相同，解除死锁
        new EatThread(cutlery1, cutlery2).start();
        new EatThread(cutlery1, cutlery2).start();

    }
}
