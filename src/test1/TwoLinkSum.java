package test1;

import java.util.Arrays;


/*
 * 官方答案
 * ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode preHead(0), *p = &preHead;
    int carry = 0;
    while (l1 || l2 || carry) {
        int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        carry = sum / 10;
        p->next = new ListNode(sum % 10);
        p = p->next;
        l1 = l1 ? l1->next : l1;
        l2 = l2 ? l2->next : l2;
    }
    return preHead.next;
	};

*
*/



/*
 * 
 * 
 * 以下方法可以改为顺序链表相加
 * 
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * 
 * 
 */



public class TwoLinkSum {

	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer sb = new StringBuffer();
			sb.append(val);
			ListNode tmp = next;
			while(tmp!=null) {
				sb.append("->");
				sb.append(tmp.val);
				tmp = tmp.next;
			}
			return sb.toString();
		}
	      
	}
	
	public static ListNode array2link(int[] arr) {
		int size = arr.length;
		ListNode head = new ListNode(arr[0]);
		ListNode tmp = head;
		
		for(int i=1;i<size;i++) {
			tmp.next = new ListNode(arr[i]);
			tmp = tmp.next;
		}
		return head;
	}
	
	public static int[] link2array(ListNode l1) {
		int[] tmp = new int[200];
		int size = 0;
		ListNode head = l1;
		while(head!=null) {
			tmp[size++]=head.val;
			head = head.next;
		}
		return Arrays.copyOf(tmp, size);
	}
	
	public static int[] addArray(int[] a,int[] b) {
		int size_a = a.length;
		int size_b = b.length;
		int max_size = Math.max(size_a, size_b);
		int[] result = new int[max_size+1];
		
		int i=0,j=0,z=0;
		int up=0;
		
		
		while(z<max_size+1) {
			int sum = up;
			if(i<size_a) 
				sum += a[i++];// 处理i
			if(j<size_b) 
				sum += b[j++];// 处理j
			up = sum/10;
			result[z++]=sum%10;
		}
		if (result[max_size]!=0) 
			return result;
		else
			return Arrays.copyOf(result,  max_size);
	}
	
	
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	int[] a = link2array(l1);
    	int[] b = link2array(l2);
    	int[] c = addArray(a,b);
        return array2link(c);
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,7};
		ListNode an = array2link(a);
		int[] b = {0,1,1};
		ListNode bn = array2link(b);		
		

		ListNode c = addTwoNumbers(an, bn);
		System.err.println(c);
	}

}
