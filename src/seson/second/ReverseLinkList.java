package seson.second;

public class ReverseLinkList {




    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        Node link = reverseLink(node);
        while (link!=null){
            System.out.println(link.value);
            link=link.next;
        }


    }


    public static Node reverseLink(Node node){

        Node pre=null;
        Node next=null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }

    public static Node reverseLinkD(Node node){
        Node pre=null;
        Node next=null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            node.pre=next;
            pre=node;
            node=next;
        }
        return pre;
    }

}
