package chapter1;

public class Gate {

    // 临界区资源
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
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
