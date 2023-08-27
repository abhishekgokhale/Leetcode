class State{
    int i;
    int j;
    int steps;
    boolean goingLeft;
    int num;
    State(int i, int j, int steps, boolean goingLeft, int num){
        this.i = i;
        this.j = j;
        this.steps = steps;
        this.goingLeft = goingLeft;
        this.num = num;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][n];
        queue.add(new State(n - 1, 0, 0, true, 1));
        seen[n-1][0] = true;
        int nextNum, nextI, nextJ;
        boolean goingLeft;
        while(!queue.isEmpty()){
            State node = queue.remove();
            if(node.num == n*n)
                return node.steps;
            
            for(int dieRoll = 1; dieRoll <= 6; dieRoll++){
                nextNum = node.num + dieRoll;
                nextI = n - (int)Math.ceil((double)nextNum / n);
                
                if((nextI + 1) % 2 == n % 2)
                    goingLeft = true;
                else
                    goingLeft = false;
                
                if(goingLeft)
                    nextJ = nextNum - (n*n) + (nextI+1)*n - 1;
                else
                    nextJ = (n*n) - (nextI+1)*n + n - nextNum;
                
                
                if(0 <= nextI && nextI < n && 0 <= nextJ && nextJ < n){
                    if(board[nextI][nextJ] != -1){
                        nextNum = board[nextI][nextJ];
                        nextI = n - (int)Math.ceil((double)nextNum / n);
                        if((nextI + 1) % 2 == n % 2)
                            goingLeft = true;
                        else
                            goingLeft = false;
                        
                        if(goingLeft)
                            nextJ = nextNum - (n*n) + (nextI+1)*n - 1;
                        else
                            nextJ = (n*n) - (nextI+1)*n + n - nextNum;
                        
                        if(!seen[nextI][nextJ]){
                            seen[nextI][nextJ] = true;
                            queue.add(new State(nextI, nextJ, node.steps + 1, goingLeft, nextNum));
                        }
                    }
                    else{
                        if(!seen[nextI][nextJ]){
                            seen[nextI][nextJ] = true;
                            queue.add(new State(nextI, nextJ, node.steps + 1, goingLeft, nextNum));
                        }
                    }
                }
                // i = n - Math.ceil(num / n)
                // if left -> j = num - (n*n) + (i+1)*n - 1
                // else -> j = (n*n) - (i + 1)*n + n - num
            }
        }
        
        return -1;
    }
}