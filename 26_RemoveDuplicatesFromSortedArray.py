class Solution:
    def removeDuplicates(self, nums: 'List[int]') -> 'int':
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 1
        duplicated = False
        duplicate_index = len(nums)
        tmp = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == tmp:
                if not duplicated:
                    duplicate_index = i
                duplicated = True
            else:
                if duplicated:
                    nums[duplicate_index] = nums[i]
                    duplicate_index += 1
            tmp = nums[i]
        return duplicate_index
