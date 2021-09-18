class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        for(ListNode list : lists) {
            if(list != null)
            q.add(list);
        }
        ListNode out = new ListNode(-1);
        ListNode head = out;
        while(!q.isEmpty()) {
            ListNode n = q.poll();
            head.next = n;
            head = head.next;
            if(n.next != null)  q.add(n.next);            
        }
        return out.next;
    }
}