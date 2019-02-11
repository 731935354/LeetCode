class Solution:
    def isValid(self, s: 'str') -> 'bool':
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
            elif c == "[":
                stack.append("]")
            elif c == "{":
                stack.append("}")
            elif c == ")":
                if len(stack) < 1:
                    return False
                if stack[-1] == c:
                    stack = stack[:-1]
                else:
                    return False
            elif c == "]":
                if len(stack) < 1:
                    return False
                if stack[-1] == c:
                    stack = stack[:-1]
                else:
                    return False
            elif c == "}":
                if len(stack) < 1:
                    return False
                if stack[-1] == c:
                    stack = stack[:-1]
                else:
                    return False
        return len(stack) == 0
