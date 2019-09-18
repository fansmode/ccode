package ds;

import java.util.PriorityQueue;

public class Prim {
    public static void main(String[] args) {
        char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'}; //顶点数组
        int[][] ad_matrix = new int[7][];        //邻接矩阵
        final int N = 65535;
        ad_matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        ad_matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        ad_matrix[2] = new int[]{7, N, N, N, 8, N, N};
        ad_matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        ad_matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        ad_matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        ad_matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        Graph G = new Graph(vertex, ad_matrix);  //构建图对象
        //上述为测试用例
        G.minimal();//最小生成树
    }
}

class Graph {
    private char[] vertex;  //顶点数组
    private int[][] ad_matrix;        //邻接矩阵
    private Vi_vertex vi;//已访问顶点集合

    public Graph(char[] vertex, int[][] ad_matrix) {
        this.vertex = vertex;
        this.ad_matrix = ad_matrix;
        this.vi = new Vi_vertex(vertex.length);
    }

    public void minimal() {//最小生成树
        vi.add(0);//选择下标为0的顶点作为出发顶点
        while (!vi.done()) {
            prim();
        }
    }

    private void prim() {//普利姆算法
        int min = 65535, index_x = 0, index_y = 0;
        for (int i = 0; i < vi.length(); i++) {
            index_x = vi.get(i);
            for (int j = 0; j < ad_matrix[index_x].length; j++) {
                if (!vi.in(j) && ad_matrix[index_x][j] < min) {//顶点未被访问且边长较小
                    min = ad_matrix[index_x][j];//这里没有统计最小生成树的权值
                    index_y = j;//记录最小边位置
                }
            }
        }
        vi.add(index_y);
        System.out.println(vertex[index_y]);
    }
}

class Vi_vertex {    //已访问顶点集合
    private int[] visited;//已经存在的顶点集合
    private int index = 0;//顶点集合容量下标

    public Vi_vertex(int length) {
        visited = new int[length];
    }

    public int length() {
        return index;
    }

    public boolean in(int f) {//判断顶点是否在已存在集合中
        int i = 0;
        while (i < index) {
            if (visited[i] == f) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void add(int f) {//添加顶点到集合中
        visited[index++] = f;
    }

    public boolean done() {//判断是否操作结束
        return index == visited.length;//集合中保存所有顶点
    }

    public int get(int i) {
        return visited[i];
    }
}