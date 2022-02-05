package chapter2;

/**
 * 说明final修饰static方法时的作用
 */
public class Car {

    public static final void run(){
        System.out.println("Car is running");
    }

    public String getColor(final int i) {
        // i ++; final param can't be assigned
        return i + "";
    }

}
