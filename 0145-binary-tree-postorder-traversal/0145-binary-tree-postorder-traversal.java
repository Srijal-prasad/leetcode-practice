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
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer>ans=new ArrayList<>();
      Stack<TreeNode>st=new Stack<>();
      if(root==null)
        return ans;
        
       TreeNode temp=root;
       TreeNode prev=null;
       while(temp!=null || !st.isEmpty())
       {
        if(temp!=null)
        {
            st.push(temp);
            temp=temp.left;
        }
            else{
                TreeNode temp1=st.peek();
                 if(temp1.right!=null && temp1.right!=prev)
                   temp=temp1.right;
                else
                {
                    st.pop();
                    ans.add(temp1.val);
                    prev=temp1;
                }

            }
       }
       return ans;
    }
}