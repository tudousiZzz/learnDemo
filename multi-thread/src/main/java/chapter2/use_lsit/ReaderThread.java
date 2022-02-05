package chapter2.use_lsit;

import java.util.List;

public class ReaderThread extends Thread{
    private final List<Integer> list;

    public ReaderThread(List<Integer> list) {
        super("ReaderThread!");
        this.list = list;
    }

    public void run() {
        while(true) {
            // 这里存在隐式的修改,读线程多次访问会多次修改造成并发修改冲突
            //synchronized(list){
                for(int i : list) {
                    System.out.println(i);
                }
            //}
        }
    }
}
