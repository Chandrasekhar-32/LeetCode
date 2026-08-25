/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
                    return head;
int length=1;
ListNode temp=head;
while(temp.next != null){

length++;
temp=temp.next;
}

k=k%length;
if(k == 0) return head;
        ListNode tail=head;
for(int i=1;i<length-k;i++){
            tail=tail.next;
}
            temp.next=head;
            head=tail.next;
            tail.next=null;
            return head;
    }
}