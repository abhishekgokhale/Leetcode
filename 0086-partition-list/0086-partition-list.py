# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        before = ListNode(0)
        after = ListNode(0)
        before_curr, after_curr = before, after
        curr = head
        
        while curr:
            if curr.val < x:
                before_curr.next = ListNode(curr.val)
                before_curr = before_curr.next
            else:
                after_curr.next = ListNode(curr.val)
                after_curr = after_curr.next
            curr = curr.next
        before_curr.next = after.next
        return before.next