package chapter1.deadlock;

public class Cutlery {
    private String name;

    public Cutlery(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cutlery{" +
                "name='" + name + '\'' +
                '}';
    }
}
