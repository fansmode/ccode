package ds;

public class Dijkstra {

    //顶点集合
    static int[] ver = new int[5];
    //矩阵
    static int[][] matrix = new int[5][5];

    static final int INF = Integer.MAX_VALUE;

    /**
     * dijkstra
     *
     * @param startVer 开始顶点
     * @param path     前驱节点数组
     * @param dist     最短距离数组
     */
    public static void dijkstra(int startVer, int[] path, int[] dist) {
        //已求得最短路径标记
        boolean visited[] = new boolean[ver.length];

        //初始化
        for (int i = 0; i < ver.length; i++) {
            visited[i] = false;
            path[i] = 0;
            dist[i] = matrix[startVer][i];
        }

        //开始顶点初始化
        visited[startVer] = true;
        dist[startVer] = 0;

        // 遍历；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < ver.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到已访问顶点集最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < ver.length; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            visited[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < ver.length; j++) {
                int tmp = (matrix[k][j] == INF ? INF : (min + matrix[k][j]));
                if (!visited[j] && (tmp < dist[j])) {
                    dist[j] = tmp;
                    path[j] = k;
                }
            }
        }

    }

}
