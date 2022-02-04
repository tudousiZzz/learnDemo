package chapter1;

public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate(1);

        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();

        new UserThread(gate, "Chris", "Canada").start();

    }
}
