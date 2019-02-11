import random

class Solution:

    def __init__(self, nums: 'List[int]'):
        self.nums = nums

    def pick(self, target: 'int') -> 'int':
        num_target = 0
        r = 0
        result = 0
        for index, num in enumerate(self.nums):
            if num == target:
                num_target += 1
                if num_target <= 1:
                    result = index
                r = random.randint(1, num_target)
                if r <= 1:
                    result = index
        return result
