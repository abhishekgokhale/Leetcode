class Solution {
    public void gameOfLife(int[][] board) {
        int[][] nextState = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                nextState[i][j] = board[i][j];
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int liveNeighbors = getLiveNeighbors(i, j, board);
                if(board[i][j] == 0){
                    if(liveNeighbors == 3)
                        nextState[i][j] = 1;
                }
                else{
                    if(liveNeighbors < 2 || liveNeighbors > 3)
                        nextState[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = nextState[i][j];
            }
        }
    }
    private int getLiveNeighbors(int i, int j, int[][] board){
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        int live = 0;
        for(int[] dir: directions){
            if(isLive(i+dir[0], j+dir[1], board))
                live += 1;
        }
        return live;
    }
    private boolean isLive(int i, int j, int[][] board){
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length && board[i][j] == 1;
    }
}