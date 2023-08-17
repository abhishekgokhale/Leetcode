class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ans = [[0]*len(mat[0]) for _ in range(len(mat))]
        queue = collections.deque()
        seen = set()
        
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    queue.append((i,j,0))
                    seen.add((i,j))
                    
        def isValid(i, j, mat):
            return 0 <= i < len(mat) and 0 <= j < len(mat[0])
        
        directions = [(0,1), (1,0), (-1,0), (0,-1)]
        while queue:
            levelLen = len(queue)
            for _ in range(levelLen):
                i, j, steps = queue.popleft()
                for di, dj in directions:
                    newI, newJ = i + di, j + dj
                    if isValid(newI, newJ, mat) and (newI, newJ) not in seen:
                        seen.add((newI, newJ))
                        ans[newI][newJ] = steps + 1
                        queue.append((newI, newJ, steps+1))
                        
        return ans