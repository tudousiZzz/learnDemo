package chapter2;

public class TestCar {

    public static void main(String[] args) {
        Car car = new BlueCar();
        car.run();
        int colornumber = 1;
        System.out.println(car.getColor(colornumber));
    }
}
