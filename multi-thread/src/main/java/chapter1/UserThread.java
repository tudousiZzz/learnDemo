package chapter1;

public class UserThread  extends Thread {

    // 线程资源
    private final String name;
    private final String address;
    private final Gate gate;

    public UserThread(Gate gate, String name, String address) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(name + " begin");
        while(true) {
            gate.pass(name, address);

        }
    }
}
