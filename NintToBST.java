package Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈n个数字能构建的二叉查找树的个数〉
 *
 * @author Chenpeng
 * @create 2019/4/25
 * @since 1.0.0
 */
public class NintToBST {


    public static List<TreeNode> getTree(int n){
        return getTree1(1,n);
    }

    public static List<TreeNode> getTree1(int start,int end){

        List<TreeNode> result=new ArrayList<>();

        if(start>end){
            result.add(null);
            return result;
        }

        if(start==end){
            TreeNode treeNode=new TreeNode(start);
            result.add(treeNode);
            return result;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = getTree1(start, i-1);
            right = getTree1(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    result.add(root);
                }
            }

        }

        return result;

    }



}

