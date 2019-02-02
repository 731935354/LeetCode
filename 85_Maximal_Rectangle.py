class Solution:
    def offset_feasible(self, matrix, x, y, direction='up'):
        """记录每个元素向左和向上的连续的'1'的个数，包含本身"""
        if matrix[x][y] == '0':
            return 0
        result = 1
        if direction == 'up':
            while y-result >= 0 and matrix[x][y-result] == '1':
                result += 1
        elif direction == 'left':
            while x-result >= 0 and matrix[x-result][y] == '1':
                result += 1
        return result
    
    def max_rec(self, left_m, up_m, x, y):
        """以matrix[x][y]元素为基准，向左上扩展，求出最大的面积"""
        min_left = len(left_m[0]) # 矩形宽度
        max_rec = 0 # 最大面积
        for i in range(int(up_m[x][y])): # 高度为i+1的矩形
            min_left = min(left_m[x-i][y], min_left) # 矩形最大宽度
            max_rec = max((i + 1) * min_left, max_rec) # 最大矩形面积=max(当前矩形面积,历史最大面积)
            
        return max_rec
    
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) < 1:
            return 0
        width = len(matrix[0])
        height = len(matrix)
        left_m = [[0 for i in range(width)] for j in range(height)] 
        up_m = [[0 for i in range(width)] for j in range(height)]
        max_rec_matrix = [[0 for i in range(width)] for j in range(height)]
        max_rectangle = 0
        
        # 记录每个元素向左和向上扩展的最大长度
        for i in range(height):
            for j in range(width):
                left_m[i][j] = self.offset_feasible(matrix, i, j, 'up')
                up_m[i][j] = self.offset_feasible(matrix, i, j, 'left')
    
        # 依次以每个元素为基准，求出其向左上方扩展的最大矩形面积
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                max_rec_matrix[i][j] = self.max_rec(left_m, up_m, i, j)
                if max_rec_matrix[i][j] > max_rectangle:
                    max_rectangle = max_rec_matrix[i][j]
        
        return max_rectangle
    
