package seson.seven;

import seson.four.Heap;

public class IsBalancedBinaryTree {

    /**
     * 给定一个二叉树的头节点，返回这棵树实不是平衡二叉树
     * 平衡二叉树：
     *      1.左树平衡
     *      2。右树平衡
     *      3.左树高度与右数高度相差不大于1
     */


    static class Info{
       public boolean isBalanced;
       public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalancedTree(Node node){

        return isBalanced(node).isBalanced;

    }

    public static Info isBalanced(Node node){
        if (node==null){
            return new Info(true,0);
        }
        Info leftInfo = isBalanced(node.left);
        Info rightInfo = isBalanced(node.right);
        int height=Math.max(leftInfo.height, rightInfo.height)+1;
        boolean balanced=false;
        if (!leftInfo.isBalanced ||!rightInfo.isBalanced||Math.abs((leftInfo.height-rightInfo.height))<=1 ){
            balanced=true;
        }
        return new Info(balanced,height);

    }

}
