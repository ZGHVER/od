package Algorithms;

@SuppressWarnings("unused")

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class So {
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        ListNode t=head;
        for(int i=2;i<8;i++){
            t.next=new ListNode(i);
            t=t.next;
        }
        t=head;
        while(t!=null){
            System.out.print(t.val+" ");
            t=t.next;
        }
        head=reverseKGroup(head,3);
        t=head;
        while(t!=null){
            System.out.print(t.val+" ");
            t=t.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k){
        return null;
    }

}