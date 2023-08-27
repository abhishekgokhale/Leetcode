class State{
    int i;
    int j;
    int steps;
    
    State(int i, int j, int steps){
        this.i = i;
        this.j = j;
        this.steps = steps;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[maze.length][maze[0].length];
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        queue.add(new State(entrance[0], entrance[1], 0));
        seen[entrance[0]][entrance[1]] = true;
        
        while(!queue.isEmpty()){
            State node = queue.remove();
            System.out.println(node.i + ", " + node.j);
            if((node.i == 0 || node.i == maze.length - 1 || node.j == 0 || node.j == maze[0].length - 1) && (node.i != entrance[0] || node.j != entrance[1]))
                return node.steps;
            
            for(int[] dir: directions){
                int newI = node.i + dir[0], newJ = node.j + dir[1];
                if(isValid(newI, newJ, maze) && !seen[newI][newJ]){
                    seen[newI][newJ] = true;
                    queue.add(new State(newI, newJ, node.steps + 1));
                }
            }
        }
        return -1;
    }
    private boolean isValid(int i, int j, char[][] maze){
        return 0 <= i && i < maze.length && 0 <= j && j < maze[0].length && maze[i][j] == '.';
    }
}