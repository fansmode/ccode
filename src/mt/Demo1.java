package mt;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] data = new int[n][m];

        Map<Integer,Integer> map1 = new TreeMap<>();
        Map<Integer,Integer> map2 = new TreeMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                data[i][j] = cin.nextInt();
                if((i+j)%2==0){
                    if(map1.get(data[i][j])==null){
                        map1.put(data[i][j],1);
                    }else {
                        map1.put(data[i][j],map1.get(data[i][j])+1);
                    }
                }else {
                    if(map2.get(data[i][j])==null){
                        map2.put(data[i][j],1);
                    }else {
                        map2.put(data[i][j],map2.get(data[i][j])+1);
                    }
                }
            }
        }

        Map<Integer,Integer> map11 = new TreeMap<>((o1, o2) -> map1.get(o2)-map1.get(o1));
        Map<Integer,Integer> map22 = new TreeMap<>((o1, o2) -> map1.get(o2)-map1.get(o1));
        map11.putAll(map1);
        map22.putAll(map2);

        int[][] nn1 = new int[2][map11.keySet().size()+1];
        int[][] nn2 = new int[2][map22.keySet().size()+1];
        int count = 0;
        for(Integer it:map11.keySet()){
            nn1[0][count] = it;
            nn1[1][count] = map11.get(it);
            count++;
        }
        count = 0;
        for(Integer it:map22.keySet()){
            nn2[0][count] = it;
            nn2[1][count] = map22.get(it);
            count++;
        }
        count = 0;
        if(nn1[0][0]!=nn2[0][0]){
            count = n*m-nn1[0][1]-nn2[0][1];
        }else {
            if(nn1[0][1]+nn2[1][1]>=nn1[1][1]+nn2[0][1]){
                count = n*m-nn1[0][1]-nn2[1][1];
            }else {
                count = n*m-nn1[1][1]-nn2[0][1];
            }
        }
        System.out.println(count);
    }
}
