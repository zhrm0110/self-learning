package leetcode;


public class AddTwoNumbersSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        ListNode l1 = new ListNode(2);
        ListNode l1x = l1;
        l1x.next=new ListNode(4);
        l1x= l1x.next;
        l1x.next= new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l2x = l2;
        l2x.next=new ListNode(6);
//        l2x= l2x.next;
//        l2x.next= new ListNode(4);

        ListNode result =  solution.addTwoNumbers(l1,l2);
        System.out.print(result.val);
        while (result.next!= null) {
            System.out.print(result.next.val);
            result=result.next;

        }


    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2){
           ListNode dummyHead = new ListNode(0);
           ListNode p=l1, q=l2, curr=dummyHead;
           int carry = 0;
           while (p!= null || q!=null) {
            int x = (p!=null)? p.val:0;
            int y = (q!=null)? q.val:0;
            int sum = carry+x+y;
            carry = sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if (p!=null) {
                p=p.next;
            }
            if (q!=null) {
                q=q.next;
            }

        }
           if (carry>0) {
            curr.next = new ListNode(carry);
        }
           return dummyHead.next;
        }

}
