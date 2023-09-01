class Solution {
    boolean[][] seen;
    char[][] board;
    
    public void solve(char[][] board) {
        this.board = board;
        this.seen = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board[0].length; i++)
            if(board[0][i] == 'O')
                dfs(0, i, board);
        // printSeen();
        for(int i = 0; i < board[0].length; i++)
            if(board[board.length-1][i] == 'O')
                dfs(board.length-1, i, board);
        // printSeen();
        for(int i = 0; i < board.length; i++)
            if(board[i][0] == 'O')
                dfs(i, 0, board);
        // printSeen();
        for(int i = 0; i < board.length; i++)
            if(board[i][board[0].length-1] == 'O')
                dfs(i, board[0].length-1, board);
        // printSeen();
        
        for(int i = 0; i < seen.length; i++){
            for(int j = 0; j < seen[0].length; j++){
                if(board[i][j] == 'O' && !seen[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    
    // public void printSeen(){
    //     for(int i = 0; i < seen.length; i++){
    //         for(int j = 0; j < seen[0].length; j++){
    //             System.out.print(seen[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    
    public void dfs(int i, int j, char[][] board){
        seen[i][j] = true;
        for(int[] dir: new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}}){
            int newI = i + dir[0], newJ = j + dir[1];
            if(isValid(newI, newJ, board) && !seen[newI][newJ]){
                dfs(newI, newJ, board);
            }
        }
    }
    private boolean isValid(int i, int j, char[][] board){
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length && board[i][j] == 'O';
    }
}