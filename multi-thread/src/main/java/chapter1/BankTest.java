package chapter1;

public class BankTest {
    public static void main(String[] args) {

        // bankTest1();

        // bankTest2();
        bankTest3();
    }

    /**
     * test synchornized method
     */
    public static void bankTest1(){
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setMoney(2000);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    bank1.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 withdraw 1000, money is " + bank1.getMoney());
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    bank1.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 withdraw 1000, money is " + bank1.getMoney());

            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * test synchornized method
     */
    public static void bankTest2() {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setMoney(2000);
        bank2.setMoney(2000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    bank1.withdraw(1000);

                    System.out.println("thread1 withdraw 1000, bank1 money is " + bank1.getMoney());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    bank2.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 withdraw 1000, bank2 money is " + bank2.getMoney());

            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * test synchornized method
     */
    public static void bankTest3() {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setMoney(500);
        // bank2.setMoney(2000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 10; i ++) {
                        bank1.withdraw1(1000);
                        System.out.println("thread1 withdraw 1000, bank1 money is " + bank1.getMoney());

                    }
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i ++) {
                    bank1.deposit(1000);
                    System.out.println("thread2 deposit 1000, bank1 money is " + bank1.getMoney());

                }

            }
        });

        thread1.start();
        thread2.start();

        System.out.println(bank1.getMoney());
    }
}
