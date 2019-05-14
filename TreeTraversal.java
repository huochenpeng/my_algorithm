package Problem;


import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈树的递归遍历与非递归遍历〉
 *
 * @author Chenpeng
 * @create 2019/4/18
 * @since 1.0.0
 */
public class TreeTraversal {


    /**
     * 非递归前序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode treeNode){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||treeNode!=null){
            while(treeNode!=null){
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            treeNode=stack.pop();
            treeNode=treeNode.right;
        }
        return list;
    }

    /**
     * 非递归前序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> preorderTraversal01(TreeNode treeNode){
        if(treeNode==null)
            return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            list.add(cur.val);
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
        return list;
    }

    /**
     * 非递归中序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode treeNode){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            treeNode=stack.pop();
            list.add(treeNode.val);
            treeNode=treeNode.right;
        }
        return list;
    }

    /**
     * 后序遍历的非递归实现
     * @param treeNode
     * @return
     */
    public List<Integer> postorderTraversal01(TreeNode treeNode){
        if(treeNode==null)
            return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(treeNode);
        while(!stack1.isEmpty()){
            TreeNode temp=stack1.pop();
            stack2.push(temp);
            if(temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack2.push(temp.right);
        }

        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }

        return list;
    }

    /**
     *
     * @param treeNode
     * @return
     */
    public List<Integer> postorderTraversal02(TreeNode treeNode){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||treeNode!=null){
            while(treeNode!=null){
                list.add(0,treeNode.val);
                stack.push(treeNode);
                treeNode=treeNode.right;
            }
            treeNode=stack.pop();
            treeNode=treeNode.left;
        }
        return list;
    }


    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
}
