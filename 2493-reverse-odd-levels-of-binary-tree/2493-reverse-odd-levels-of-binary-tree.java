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
public void Swap(TreeNode root,TreeNode root1){
    if(root!=null && root1!=null){
    int temp=root1.val;
    root1.val=root.val;
    root.val=temp;
    }
}
    public void recur(TreeNode root,TreeNode root1,int odd){
        if(root==null){
            return;
        }
        
        if(odd%2==1){
           
            Swap(root,root1);
           
        }
        
        recur(root.left,root1.right,odd+1);
        recur(root.right,root1.left,odd+1);
    
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        recur(root.left,root.right,1);
        return root;
        
    }
}