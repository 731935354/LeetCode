class Solution:
    def spiralOrder(self, matrix: 'List[List[int]]') -> 'List[int]':
        if len(matrix) < 1:
            return []
        self.width = len(matrix[0])
        self.height = len(matrix)
        self.done = [[0 for i in range(len(matrix[0]))] for j in range(len(matrix))]
        self.dir2index = {'right': 0, 'down': 1, 'left': 2, 'up': 3}
        self.index2dir = ['right', 'down', 'left', 'up']
        self.dir_row = [0, 1, 0, -1]
        self.dir_col = [1, 0, -1, 0]
        self.matrix = matrix
        self.output = []
        
        self.spiral(0, 0, 'right')
        return self.output
    
    def spiral(self, row, col, direction):
        if len(self.output) == self.height * self.width:
            return
        self.done[row][col] = 1
        self.output.append(self.matrix[row][col])
        next_row = row + self.dir_row[self.dir2index[direction]]
        next_col = col + self.dir_col[self.dir2index[direction]]
        if next_row < 0 or next_row >= self.height or next_col < 0 or next_col >= self.width:
            next_row = row + self.dir_row[(self.dir2index[direction ] + 1) % 4]
            next_col = col + self.dir_col[(self.dir2index[direction ] + 1) % 4]
            direction = self.index2dir[(self.dir2index[direction ] + 1) % 4]
        elif self.done[next_row][next_col] == 1:
            next_row = row + self.dir_row[(self.dir2index[direction ] + 1) % 4]
            next_col = col + self.dir_col[(self.dir2index[direction ] + 1) % 4]
            direction = self.index2dir[(self.dir2index[direction ] + 1) % 4]
        self.spiral(next_row, next_col, direction)
