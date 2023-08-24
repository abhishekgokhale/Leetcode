class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        while(markCandiesToPop(board, m, n)){
            int[][] newBoard = new int[m][n];
            int[] popped = new int[n];
            for(int i = m - 1; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 0)
                        popped[j]++;
                    else{
                        newBoard[i+popped[j]][j] = board[i][j];
                    }
                }
            }
            board = newBoard;
        }
        return board;
    }
    
    private boolean markCandiesToPop(int[][] board, int m, int n){
        int[][] marked = new int[m][n];
        int changes = 0;
        int[] dir = {1, -1};
        boolean[][] seen = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!seen[i][j]){
                    seen[i][j] = true;
                    if(board[i][j] != 0 && isValid(i-1, j, board) && board[i-1][j] == board[i][j] && isValid(i+1, j, board) && board[i+1][j] == board[i][j]){
                        marked[i-1][j] = 1;
                        marked[i+1][j] = 1;
                        marked[i][j] = 1;
                    }
                    if(board[i][j] != 0 && isValid(i, j-1, board) && board[i][j-1] == board[i][j] && isValid(i, j+1, board) && board[i][j+1] == board[i][j]){
                        marked[i][j-1] = 1;
                        marked[i][j+1] = 1;
                        marked[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(marked[i][j] == 1){
                    board[i][j] = 0;
                    changes++;
                }
            }
        }
        return changes != 0;
    }
    private boolean isValid(int i, int j, int[][] board){
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length;
    }
}