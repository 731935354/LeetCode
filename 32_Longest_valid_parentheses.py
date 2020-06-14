"""
let s be the string, c be the current char, idx_c be the current index (start from 0)
isolated: char not included in a valid string of length larger than 1.
s[a:b]: substring of s, from index a (included) to index b (included).

case 1: s[idx_c - 1] isolated
  case 1.1 s[idx_c - 1] is "(" -> can be merged, if c is ")"
     need to check whether the current merged sequence s[idx_c-1: idx_c] can be merged with previous sequence s[x, idx_c - 2]
     example: ()( -> ), where idx_c=3, x=0
  case 1.2 s[idx_c - 1] is ")" -> can't be merged
case 2: s[idx_c - 1] not isolated
  assume previous char belongs to span [x, idx_c - 1]. we check if [x-1, idx_c] is valid. If s[x-1] is "(" 
  and s[idx_c] is ")", then [x-1, idx_c] is valid.
    need to check whether [x-1, idx_c] can be merged with [b, x-2], assuming b < x-2.
    example: ()(() -> )
"""

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        max_valid_seq = {}
        max_seq_len = 0
        for i, c in enumerate(s):
            if i == 0:
                max_valid_seq[i] = [i, i]  # begin, end
            else:
                if max_valid_seq[i-1][0] != max_valid_seq[i-1][1]: # previous char not isolated
                    if c == '(':  # current char is "("
                        max_valid_seq[i] = [i, i] # new left parenthesis is isolated
                    elif c == ')':  # current char is ")"
                        # check the char before the valid seq containing s[i-1]
                        idx = max_valid_seq[i-1][0]-1
                        if idx >= 0 and s[idx] == '(':  # far away "(" we can merge
                            max_valid_seq[i] = [idx, i]  # merged seq span
                            # check whether can be merged with prev valid seq
                            if idx - 1 >= 0 and max_valid_seq[idx - 1][0] != max_valid_seq[idx - 1][1]:
                                max_valid_seq[i][0] = max_valid_seq[idx - 1][0]
                            # update max sequence length
                            if max_valid_seq[i][1] - max_valid_seq[i][0] + 1 > max_seq_len:
                                max_seq_len = max_valid_seq[i][1] - max_valid_seq[i][0] + 1
                        else:
                            max_valid_seq[i] = [i, i]
                else:  # previous char isolated
                    if s[i - 1] == '(':  # last char is "("
                        if c == ')':
                            max_valid_seq[i] = [i-1, i]
                            # check if can be merged with previous sequence
                            if i - 2 >= 0:
                                idx = max_valid_seq[i-2][1]
                                if idx >= 0 and max_valid_seq[idx][0] != max_valid_seq[idx][1]:
                                    max_valid_seq[i][0] = max_valid_seq[idx][0]
                            if max_valid_seq[i][1] - max_valid_seq[i][0] + 1 > max_seq_len:
                                # print(max_valid_seq[i], s[max_valid_seq[i][0]: max_valid_seq[i][1]+1])
                                max_seq_len = max_valid_seq[i][1] - max_valid_seq[i][0] + 1
                        else:
                            max_valid_seq[i] = [i, i]
                    else:  # last char is ")"
                        max_valid_seq[i] = [i, i]  # there is no way current char can be merged
        return max_seq_len
