class Solution:
    """
    容器高度为min(height[i],height[j])，从最宽的容器开始(i=0, j=len(height)-1)，收缩容器宽度(i增加，j减少)，选择“更高”的容器(跳过那些“矮”的容器)
    """
    def maxArea(self, height: 'List[int]') -> 'int':
        num_wall = len(height)
        max_area = 0
        i = 0
        j = num_wall - 1
        while i < j:
            max_area = max(max_area, min(height[i], height[j]) * (j - i))
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
        return max_area
