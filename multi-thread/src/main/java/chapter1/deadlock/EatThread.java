package chapter1.deadlock;

public class EatThread extends Thread {

    private Cutlery cutlery1;
    private Cutlery cutlery2;

    public EatThread(Cutlery cutlery1, Cutlery cutlery2) {
        this.cutlery1 = cutlery1;
        this.cutlery2 = cutlery2;
    }

    @Override
    public void run() {
        synchronized (cutlery1) {
            System.out.println(Thread.currentThread().getName() + " take up " + cutlery1.toString());

            synchronized (cutlery2) {
                System.out.println(Thread.currentThread().getName() + " take up " + cutlery2.toString());
                System.out.println(Thread.currentThread().getName() + " eat ... ");
                System.out.println(Thread.currentThread().getName() + " put down " + cutlery2.toString());

            }

            System.out.println(Thread.currentThread().getName() + " put down " + cutlery1.toString());

        }
    }
}
