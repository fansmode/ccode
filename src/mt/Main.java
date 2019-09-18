package mt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] arr = new int[n][m];
        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        int t;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t = input.nextInt();
                arr[i][j] = t;
                if ((i + j) % 2 == 1) {
                    ji.add(t);
                } else {
                    ou.add(t);
                }
            }
        }
        Collections.sort(ji);
        Collections.sort(ou);
        PriorityQueue<NumCount> heapJi = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        PriorityQueue<NumCount> heapOu = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);

        if (ji.size() > 0) {
            int lastNum = ji.get(0);
            NumCount lastNumCount = new NumCount(lastNum,1);
            buildHeap(ji, (PriorityQueue<NumCount>) heapJi, lastNumCount);
            if (heapJi.size() == 0) {
                heapJi.add(lastNumCount);
            }
        }

        if (ou.size() > 0) {
            int lastNum = ou.get(0);
            NumCount lastNumCount = new NumCount(lastNum,1);
            buildHeap(ou, (PriorityQueue<NumCount>) heapOu, lastNumCount);
            if (heapOu.size() == 0) {
                heapOu.add(lastNumCount);
            }
        }

        if (heapJi.size() == 0) {
            heapJi.add(new NumCount(-1,0));
        }
        if (heapOu.size() == 0) {
            heapOu.add(new NumCount(-1, 0));
        }
        int topji = heapJi.peek().num;
        int topOu = heapOu.peek().num;
        if (topji != topOu) {
            int ret = n * m - heapJi.peek().count - heapOu.peek().count;
            System.out.println(ret);
            return;
        }
        heapJi.poll();
        int topji2Count = heapJi.peek().count;
        heapOu.poll();
        int topou2 = heapOu.peek().num;


    }

    private static void buildHeap(ArrayList<Integer> ji, PriorityQueue<NumCount> heapJi, NumCount lastNumCount) {
        int lastNum;
        for (int i = 1; i < ji.size(); i++) {
            lastNum = ji.get(i - 1);
            if (lastNum == ji.get(i)) {
                lastNumCount.count++;
            } else {
                heapJi.add(lastNumCount);
                lastNum = ji.get(i);
                lastNumCount = new NumCount(lastNum,1);
                if (i == ji.size() - 1) {
                    heapJi.add(lastNumCount);
                }
            }
        }
    }

}
class NumCount{
    int num;
    int count = 0;

    NumCount(int num,int count) {
        this.num = num;
        this.count = count;
    }
}
