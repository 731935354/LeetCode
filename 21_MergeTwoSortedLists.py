# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        merged = ListNode("init")
        merged_tmp = merged
        l1_tmp = l1
        l2_tmp = l2
        
        while l1_tmp is not None and l2_tmp is not None:
            if l1_tmp.val < l2_tmp.val:
                merged_tmp.next = l1_tmp
                l1_tmp = l1_tmp.next
            else:
                merged_tmp.next = l2_tmp
                l2_tmp = l2_tmp.next
            if merged_tmp.val == "init":
                merged = merged_tmp.next
            merged_tmp = merged_tmp.next
        
        if l1_tmp is None:
            while l2_tmp is not None:
                merged_tmp.next = l2_tmp
                merged_tmp = merged_tmp.next
                l2_tmp = l2_tmp.next
        
        if l2_tmp is None:
            while l1_tmp is not None:
                merged_tmp.next = l1_tmp
                merged_tmp = merged_tmp.next
                l1_tmp = l1_tmp.next
        
        if merged.val == "init":
            merged = merged.next
        
        return merged
