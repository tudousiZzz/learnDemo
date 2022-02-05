package chapter2.use_lsit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        List<Integer> list  = Collections.synchronizedList(new ArrayList<Integer>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
