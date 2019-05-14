package Problem;


import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈两个节点的最低公共祖先〉
 *
 * @author Chenpeng
 * @create 2019/4/22
 * @since 1.0.0
 */
public class LowestCommonAncestor {



    public static TreeNode getLowestCommonAncestor(TreeNode root,TreeNode node1,TreeNode node2){


        if(root==null||node1==null||node2==null||root==node1||root==node2)
            return null;

        Stack<TreeNode> path1=new Stack<>();
        boolean flag1=getPath(root,node1,path1);
        if(!flag1)
            return null;

        Stack<TreeNode> path2=new Stack<>();
        boolean flag2=getPath(root,node2,path2);
        if(!flag2)
            return null;

        if(path1.size()>path2.size()){
            while(path1.size()!=path2.size()){
                path1.pop();
            }
        }else{
            while(path1.size()!=path2.size()){
                path2.pop();
            }
        }

        if(path1.peek()==path2.peek()){
            path1.pop();
            return path1.pop();
        }else{
            TreeNode p=path1.pop();
            TreeNode q=path2.pop();
            while(q!=p){
                path1.pop();
                path2.pop();
            }
            return p;
        }

    }

    public static boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> path){

        path.push(root);
        if(root==node)
            return true;

        boolean found=false;
        if(root.left!=null)
            found=getPath(root.left,node,path);
        if(root.right!=null)
            found=getPath(root.right,node,path);

        if(!found)
            path.pop();

        return found;

    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
