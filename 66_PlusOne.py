class Solution:
    def plusOne(self, digits: 'List[int]') -> 'List[int]':
        output = []
        index = len(digits) - 1
        tmp = (digits[index] + 1) % 10
        flag = (digits[index] + 1) // 10
        output.append(tmp)
        index -= 1
        while index >= 0:
            tmp = (digits[index] + flag) % 10
            flag = (digits[index] + flag) // 10
            index -= 1
            output.append(tmp)
        if flag > 0:
            output.append(1)
        output.reverse()
        return output
