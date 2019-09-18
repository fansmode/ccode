package other;
/**
 * 给定一个M*N的矩阵（二维数组），
 * 分别用0和1表示通路和障碍物。即 0 表示 通路；1 表示 障碍物。
 * 从矩阵的左上角开始，每次只能向右，下，左，上移动位置，不能斜着走。请给出从入口到出口的路线。
 */
public class MiGuang {

    static String path = "";
    static String shortestPath = "";

    static void dfsMaze(int x,int y, int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        //结束条件
        if (x < 0 || y < 0) {
            return;
        }
        if (x > m - 1 || y > n - 1 || maze[x][y] == 1) {
            return;
        }
        if (x == m - 1 && y == n - 1) { // 判断是否抵达出口
            path = path + "(" + x + "," + y + ")";
            if (shortestPath.length() == 0 || shortestPath.length() > shortestPath.length())
                shortestPath = path;
            System.out.println("找到路线:" + path);
            return;
        }

        String temp = path;
        path = path + "(" + x + "," + y + ")" + "-"; // 记录路线
        maze[x][y] = 1; // 将走过的路标记
        // 向四个方向搜索
        dfsMaze(x + 1, y, maze);  //向右搜索
        dfsMaze(x, y + 1, maze);  //向下搜索
        dfsMaze(x, y - 1, maze);  //向上搜索
        dfsMaze(x - 1, y, maze);  //向左搜索
        // 将路线和标记恢复成上一次的状态
        maze[x][y] = 0;
        //清除
        path = temp;

    }

}
