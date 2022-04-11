package seson.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到一个树节点的前驱节点
 * 前驱：中序遍历的前一个元素
 * 后继：中序遍历的后一个元素
 *
 */
public class GetPrecursorNode {


    /**
     * 暴力解法
     * @param node
     * @return
     */
    public static int getPrecursorNodeForce(Node node){
        if (node==null){
            return -1;
        }
        Node head=node;
        while (head.parent!=null){
            head=head.parent;
        }
        List<Integer> list = new ArrayList<>();
        mid(head,list);
        int index = list.indexOf(node.value) - 1;
        if (index>=0){
            return list.get(index);
        }else {
            return -1;
        }

    }


    public static void mid(Node head, List<Integer> nodes){
        if (head==null){
            return;
        }
        mid(head.left,nodes);
        nodes.add(head.value);
        mid(head.right,nodes);
    }


    /**
     * 非暴力
     * @param node
     * @return
     */
    public static int getPrecursorNode(Node node){
        if (node==null){
            return -1;
        }
        if (node.left!=null){
            Node left=node.left;
            while (left.right!=null){
                left=left.right;
            }
            return left.value;
        }else {
            Node parent=node.parent;
            while (parent!=null&&parent.left==node){
                node=parent;
                parent=node.parent;
            }
            if (parent==null){
                return -1;
            }else {
                return parent.value;
            }
        }

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

        System.out.println(getPrecursorNode(node4));
        System.out.println(getPrecursorNodeForce(node4));



    }
}
