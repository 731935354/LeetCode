class Solution:
    def solveNQueens(self, n: 'int') -> 'List[List[str]]':
        self.n = n
        # 列
        self.col_occupied = [0 for i in range(n)]
        # 斜率为1的对角线
        self.diag_occupied_1 = [0 for _ in range(2 * n - 1)]
        # 斜率为-1的对角线
        self.diag_occupied_2 = [0 for _ in range(2 * n - 1)]
        
        self.answer = [['.' for _ in range(n)] for _ in range(n)]
        self.output = []
        
        for i in range(n):
            self.dfs_solver(0, i)
        
        return self.output
        
    def dfs_solver(self, row, col):
        if row >= self.n:
            return
        
        if self.valid(row, col):
            self.answer[row][col] = 'Q'
            self.occupy(row, col, 1)

            if row >= self.n - 1:
                answer = [''.join(row) for row in self.answer]
                self.output.append(answer)
            else:
                for i in range(self.n):
                    self.dfs_solver(row + 1, i)

            self.occupy(row, col, 0)
            self.answer[row][col] = '.'
        
    def valid(self, row, col):
        if row >= self.n or col >= self.n:
            return False
        # 检查列是否已有棋子
        if self.col_occupied[col] == 1:
            return False
        # 检查斜率为1的对角线是否有棋子
        if self.diag_occupied_1[row + col] == 1:
            return False
        # 检查斜率为-1的对角线是否有棋子
        if self.diag_occupied_2[row + self.n - col - 1] == 1:
            return False
        return True

    def occupy(self, row, col, fill):
        # 标记列
        self.col_occupied[col] = fill
        # 标记斜率为1的对角线
        self.diag_occupied_1[row + col] = fill
        # 标记斜率为-1的对角线
        self.diag_occupied_2[row + self.n - col - 1] = fill
