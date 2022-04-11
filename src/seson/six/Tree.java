package seson.six;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Tree {

    public int  value;

    public Tree left;

    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    /**
     * 先序遍历
     */
    public void pre(Tree head){
        if (head==null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历
     */
    public void mid(Tree head){
        if (head==null){
            return;
        }
        mid(head.left);
        System.out.print(head.value+" ");
        mid(head.right);
    }
    /**
     * 后序遍历
     */
    public void back(Tree head){
        if (head==null){
            return;
        }
        back(head.left);
        back(head.right);
        System.out.print(head.value+" ");
    }


    /**
     * 层次遍历
     */
    public void gradation(Tree head){
        if (head==null){
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Tree poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            }
        }

    }


    /**
     * 先序遍历（非递归）
     * @param root
     */
    public void preNonRecursive(Tree root){
        if (root==null){
            return;
        }
        Stack<Tree> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Tree pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right!=null){
                stack.add(pop.right);
            }
            if (pop.left!=null){
                stack.add(pop.left);
            }
        }

        System.out.println();
    }

    /**
     * 中序遍历(非递归)
     * @param root
     */
    public void midNonRecursive(Tree root){

        if (root!=null){
            Stack<Tree> stack = new Stack<>();
            while (!stack.isEmpty() ||root!=null){
                if (root!=null){
                    stack.push(root);
                    root=root.left;
                }else {
                    root=stack.pop();
                    System.out.print(root.value+" ");
                    root=root.right;
                }
            }
        }
        System.out.println();


    }


    /**
     * 后序遍历（非递归）
     * @param root
     */
    public void backNonRecursive(Tree root){
        if (root==null){
            return;
        }
        Stack<Tree> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()){
            Tree pop = stack.pop();
            result.add(pop.value);
            if (pop.left!=null){
                stack.add(pop.left);
            }
            if (pop.right!=null){
                stack.add(pop.right);
            }

        }
        while (!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
        System.out.println();
    }


    /**
     * 找出树的最大宽度
     * @param root
     * @return
     */
    public int findMaxLen(Tree root){
        if (root==null){
            return 0;
        }
        int max=0;
        Tree currEnd=root;
        Tree nextEnd=null;
        int currNodes=0;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Tree cur= queue.poll();
            if (cur.left!=null){
                queue.add(cur.left);
                nextEnd=cur.left;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                nextEnd=cur.right;
            }
            currNodes++;
            if (cur==currEnd){
                max=Math.max(max,currNodes);
                currNodes=0;
                currEnd=nextEnd;
            }
        }


        return max;
    }


    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1,null);

        Tree tree = new Tree(1);
        tree.left=new Tree(2);
        tree.right=new Tree(3);
        tree.left.left=new Tree(4);
        tree.left.right=new Tree(5);
        tree.right.left=new Tree(6);
        tree.right.right=new Tree(7);
        System.out.println(tree.findMaxLen(tree));
        tree.mid(tree);
    }


}
