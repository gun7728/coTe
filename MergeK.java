import java.util.*;

public class MergeK {
    public static void main(String[] args) {
        MergeK a = new MergeK();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = a.solve(list);
        while(result !=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode solve(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p=newHead;
        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }


        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next !=null){
                pq.offer(node.next);
            }
        }

        return newHead.next;
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>(){

        @Override
        public int compare(ListNode o1, ListNode o2) {
            // TODO Auto-generated method stub
            return o1.val-o2.val;
        }
        
    };
}
