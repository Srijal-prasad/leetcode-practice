
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean check(ListNode head, TreeNode root){
        if(head.next==null&&head.val==root.val) return true;
        if(root==null) return false;
        boolean x=false,y=false;
        if(root.left!=null&&head.next!=null&&root.left.val==head.next.val) 
            x= check(head.next,root.left);
        if(root.right!=null&&head.next!=null&&root.right.val==head.next.val) 
            y= check(head.next,root.right);
        return x||y;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        boolean ans=false;
        if(root.val==head.val) ans= check(head,root);
        if(ans) return ans;
        boolean x=isSubPath(head,root.left);
        if(x) return x;
        boolean y=isSubPath(head,root.right);
       if(y) return y;
        return false;
    }
}