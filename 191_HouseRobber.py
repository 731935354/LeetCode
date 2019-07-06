class Solution:
    def rob(self, nums: List[int]) -> int:
        max_with_tail = 0
        max_without_tail = 0
        for n in nums:
            # max value when we decide to rob the current house
            tmp_max_with_tail = max_without_tail + n
            # max value when we don't rob the current house
            tmp_max_without_tail = max_with_tail
            
            if tmp_max_with_tail > max_with_tail:
                max_with_tail = tmp_max_with_tail
            if tmp_max_without_tail > max_without_tail:
                max_without_tail = tmp_max_without_tail
            # print(max_with_tail)
            # print(max_without_tail)
        return max(max_with_tail, max_without_tail)
