class Solution:
    def removeElement(self, nums: 'List[int]', val: 'int') -> 'int':
        cur_index = 0
        for index,n in enumerate(nums):
            if n != val:
                nums[cur_index] = n
                cur_index += 1
        return cur_index
