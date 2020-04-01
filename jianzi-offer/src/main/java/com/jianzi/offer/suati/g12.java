package com.jianzi.offer.suati;

/**
 * 官方
 * <p>
 * 面试题12. 矩阵中的路径
 */
public class g12 {
    private int len;
    private int row;
    private int col;

    /**
     * 精雕细琢的代码
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        len = word.length();
        if (len == 0) {
            return false;
        }
        row = board.length;
        col = board[0].length;
        //搜索word起点
        char c = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //起点相等才递归
                //在这里判断当前坐标
                if (board[i][j] == c) {
                    board[i][j] = 0;
                    //只需要找到一条可行路径即可
                    if (check(board, word, 1, i, j)) {
                        return true;
                    }
                    board[i][j] = c;
                }
            }
        }
        return false;
    }

    /**
     * 只需要找到一条可行路径即可
     *
     * @param board 矩阵
     * @param word  搜索word
     * @param pos   当前word位置
     * @param i     当前横坐标
     * @param j     当前纵坐标
     * @return
     */
    public boolean check(char[][] board, String word, int pos, int i, int j) {
        if (pos >= len) {
            return true;
        }
        char c = word.charAt(pos);

        //剪枝
        //递归条件
        //向上。最上行不用向上递归
        if (i > 0 && board[i - 1][j] == c) {
            board[i - 1][j] = 0;
            if (check(board, word, pos + 1, i - 1, j)) {
                return true;
            }
            board[i - 1][j] = c;
        }
        //向下。最下行不用向下递归
        if (i < row - 1 && board[i + 1][j] == c) {
            board[i + 1][j] = 0;
            if (check(board, word, pos + 1, i + 1, j)) {
                return true;
            }
            board[i + 1][j] = c;
        }
        //向左。最左行不用向左递归
        if (j > 0 && board[i][j - 1] == c) {
            board[i][j - 1] = 0;
            if (check(board, word, pos + 1, i, j - 1)) {
                return true;
            }
            board[i][j - 1] = c;
        }
        //向右。最右行不用向右递归
        if (j < col - 1 && board[i][j + 1] == c) {
            board[i][j + 1] = 0;
            if (check(board, word, pos + 1, i, j + 1)) {
                return true;
            }
            board[i][j + 1] = c;
        }

        return false;
    }
}
