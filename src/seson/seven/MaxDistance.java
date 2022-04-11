package seson.seven;

public class MaxDistance {


    /**
     * 给定一颗二叉树的头节点Head,任何两节点之间都存在距离，返回整棵二叉树的最大距离
     *
     * 对于任一节点X：
     *  1.距离经过X：距离=左侧最大距离+右侧最大距离
     *  2.没有经过X：距离=Max(左侧最大距离，右侧最大距离)
     *  经过X距离：
     *     获取左数高度+右侧高度+1
     *
     *
     */


    static class Info{
        public int height;
        public int max;

        public Info(int height, int max) {
            this.height = height;
            this.max = max;
        }
    }

    public static Info getMaxDistance(Node head){
        if (head==null){
            return new Info(0,0);
        }
        Info leftInfo = getMaxDistance(head.left);
        Info rightInfo = getMaxDistance(head.right);
        int height= Math.max(leftInfo.height,rightInfo.height)+1;
        int max=Math.max(Math.max(leftInfo.max, rightInfo.max), leftInfo.height+rightInfo.height);

        return new Info(height,max);

    }
    public static int max=0;
    public static int getMaxDistance2(Node node){
        if (node==null){
            return 0;
        }
        int left = getMaxDistance2(node.left);
        int right = getMaxDistance2(node.right);

        max=Math.max(left+right,max);

        return Math.max(left,right)+1;

    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.parent=null;
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.parent=node;
        node3.parent=node;
        node.left=node2;
        node.right=node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.parent=node2;
        node5.parent=node2;
        node2.left=node4;
        node2.right=node5;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node6.parent=node3;
        node7.parent=node3;
        node3.left=node6;
        node3.right=node7;
        System.out.println(getMaxDistance(node).max);
        getMaxDistance2(node);
        System.out.println(max);

    }

}
