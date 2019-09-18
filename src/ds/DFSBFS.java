package ds;

import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS {

    //顶点集合
    static int[] ver = new int[5];
    //矩阵
    static int[][] graph =
            {
                    {0, 1, 1, 1, 0},
                    {0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0}
            };
    static int[] visited = new int[5];

    public static void main(String[] args) {

        int[] dist = new int[5];
//        bfs(graph,dist,0);
//        for (int j = 0; j < dist.length; j++) {
//            System.out.print(dist[j] + " ");
//        }


        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        dfs(graph,0);
    }

    static void dfs(int[][] graph,int start) {
        System.out.println(start);
        visited[start] = 1;
        for (int i = 0; i < graph[start].length;i++) {
            if (visited[i] == -1 && graph[start][i] == 1) {
                dfs(graph,i);
            }
        }
    }

    //广度优先搜索
    static void bfs(int[][] graph,int[] dist,int start) {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            Integer top = q.poll();
            System.out.println(top);
            int d = dist[top] + 1;
            for (int i = 0; i < graph[top].length;i++) {
                if (dist[i] == -1 && graph[top][i] == 1) {
                    dist[i] = d;
                    q.add(i);
                }
            }
        }

    }


}














