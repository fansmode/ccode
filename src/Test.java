import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] input = {"abaa", "abab", "ababc", "abc", "abd"};
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
    }


}


class PS {

    ArrayList<Integer> bucket = new ArrayList<>();
    int MAX = 5;

    public static void main(String[] args) {

        PS ps = new PS();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    ps.produce();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    ps.consume();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void produce(){
        synchronized (bucket) {
            while (bucket.size() == MAX) {
                try {
                    bucket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bucket.add(1);
            System.out.println("produce");
            bucket.notifyAll();
        }
    }

    public void consume(){
        synchronized (bucket) {
            while (bucket.size() == 0) {
                try {
                    bucket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bucket.remove(0);
            System.out.println("consume");
            bucket.notifyAll();
        }
    }

}