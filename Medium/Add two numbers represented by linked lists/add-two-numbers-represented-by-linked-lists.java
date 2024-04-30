//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverseList(Node head)
    {
        Node p = head, pre = null;
        
        while(p != null)
        {
            Node nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        
        return pre;
    }

    static Node addTwoLists(Node num1, Node num2)
    {
        if(num1 == null)
            return num2;
            
        if(num2 == null)
            return num1;
            
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        Node dummy = new Node(-1);
        Node p = dummy;
        
        int carry = 0;
        while(num1 != null || num2 != null || carry == 1) 
        {
            int sum = 0;
            if(num1 != null) 
            {
                sum += num1.data;
                num1 = num1.next;
            }
                
            if(num2 != null) 
            {
                sum += num2.data;
                num2 = num2.next;
            }
                
            if(carry == 1)
                sum += carry;
                
            int val = sum % 10;
            carry = sum / 10;
            
            p.next = new Node(val);
            p = p.next;
        }
        
        dummy.next = reverseList(dummy.next);
        p = dummy.next;
        
        while(p != null && p.data == 0)
            p = p.next;
        
        return p == null ? new Node(0) : p;
    }
}