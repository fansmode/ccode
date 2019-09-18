package niuke;

import java.util.Arrays;

/**
 * 机器人的运动范围
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class BotRange {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        //计数
        return moveCount(threshold, rows, cols, 0, 0, visited);
    }

    public int moveCount(int threshold, int rows, int cols, int x, int y,boolean[][] visited) {
        int count = 0;
        //(x,y)能走
        if (check(threshold,rows,cols,x,y,visited)) {
            visited[x][y] = true;
            count = 1 + moveCount(threshold, rows, cols, x + 1, y, visited)
                    + moveCount(threshold, rows, cols, x, y + 1, visited)
                    + moveCount(threshold, rows, cols, x -1, y, visited)
                    + moveCount(threshold, rows, cols, x, y -1, visited);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int x, int y,boolean[][] visited) {
        int sum = getDigitSum(x) + getDigitSum(y);
        if (x >= 0 && y >=0 && x < rows && y < cols
                && sum <= threshold && !visited[x][y]) {
            return true;
        }
        return false;
    }

    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
