class Solution:
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        
        sample dis_matrix: (# means empty string, necessary)
        / # h o r s e
        # 0 1 2 3 4 5
        r 1 x x x x x
        o 2 x x x x x
        s 3 x x x x x
        """ 
        dis_matrix = [[0] * (len(word2) + 1) for _ in range(len(word1) + 1)]
        
        # 将空串转化为word1(第一列)，编辑距离等于插入次数
        for i in range(1, len(word1) + 1):
            dis_matrix[i][0] = dis_matrix[i-1][0] + 1 
        # 将空串转化为word2(第一行)，编辑距离等于插入次数
        for i in range(1, len(word2) + 1):
            dis_matrix[0][i] = dis_matrix[0][i-1] + 1
        
        # 非空部分，算法核心
        for i in range(1, len(word1)+1):
            for j in range(1, len(word2)+1):
                del_dis = dis_matrix[i][j-1] + 1 # 删除一个字符
                ins_dis = dis_matrix[i-1][j] + 1 # 插入一个字符
                sub_dis = 0 if word1[i-1] == word2[j-1] else 1
                sub_dis = dis_matrix[i-1][j-1] + sub_dis # 替换一个字符
                dis_matrix[i][j] = min(del_dis, ins_dis, sub_dis)
        
        return dis_matrix[len(word1)][len(word2)]
