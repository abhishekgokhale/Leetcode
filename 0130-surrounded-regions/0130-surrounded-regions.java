class State{
    int i;
    int j;
    State(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    char[][] board;
    boolean[][] seen;
    public void solve(char[][] board) {
        this.board = board;
        this.seen = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!seen[i][j] && board[i][j] == 'O'){
                    seen[i][j] = true;
                    ArrayList<State> capture = getCapturedPlaces(board, i, j);
                    // for(State s: capture){
                    //     System.out.println(s.i + ", " + s.j);
                    // }
                    for(State s: capture){
                        board[s.i][s.j] = 'X';
                    }
                }
            }
        }
    }
    
    private ArrayList<State> getCapturedPlaces(char[][] board, int i, int j) {
        ArrayList<State> capture = new ArrayList<>();
        boolean isCaptured = true;
        if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
            isCaptured = false;
        
        capture.add(new State(i, j));
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(i, j));
        seen[i][j] = true;
        while(!queue.isEmpty()){
            State state = queue.remove();
            for(int[] dir: directions){
                int newI = state.i + dir[0], newJ = state.j + dir[1];
                if(isValid(newI, newJ, board) && !seen[newI][newJ]){
                    seen[newI][newJ] = true;
                    if(newI == 0 || newI == board.length - 1 || newJ == 0 || newJ == board[0].length - 1)
                        isCaptured = false;
                    capture.add(new State(newI, newJ));
                    queue.add(new State(newI, newJ));
                }
            }
        }
        
        return isCaptured ? capture : new ArrayList<>();
    }
    
    private boolean isValid(int i, int j, char[][] board){
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length && board[i][j] == 'O';
    }
}