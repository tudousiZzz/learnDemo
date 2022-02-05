package chapter2.use_lsit;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {

    public static void main(String[] args) {
        // List<Integer> list  = Collections.synchronizedList(new ArrayList<Integer>());

        // copy before read
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
