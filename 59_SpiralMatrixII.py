class Solution:
    def generateMatrix(self, n: 'int') -> 'List[List[int]]':
        self.n = n
        self.done = [[0 for i in range(n)] for j in range(n)]
        self.result = [[0 for i in range(n)] for j in range(n)]
        # right, down, left, up
        self.dir_row = [0, 1, 0, -1]
        self.dir_col = [1, 0, -1, 0]
        
        self.spiral(0, 0, 0, 1)
        return self.result
        
    def spiral(self, row, col, direction, val):
        if val > self.n * self.n:
            return
        self.done[row][col] = 1
        self.result[row][col] = val
        new_row = row + self.dir_row[direction]
        new_col = col + self.dir_col[direction]
        if new_row < 0 or new_row >= self.n or new_col < 0 or new_col >= self.n:
            new_row = row + self.dir_row[(direction + 1) % 4]
            new_col = col + self.dir_col[(direction + 1) % 4]
            self.spiral(new_row, new_col, (direction + 1) % 4, val + 1)
        elif self.done[new_row][new_col] == 1:
            new_row = row + self.dir_row[(direction + 1) % 4]
            new_col = col + self.dir_col[(direction + 1) % 4]
            self.spiral(new_row, new_col, (direction + 1) % 4, val + 1)
        else:
            self.spiral(new_row, new_col, direction, val + 1)
