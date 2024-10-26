import java.util.*;
public class MirrorInBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data= data;
            this.right=  null;
            this.left = null;
        }
    }

    public static Node Mirror(Node root){
        if(root == null){
            return null;
        }
        Node lefttree = Mirror(root.left);
        Node righttree = Mirror(root.right);

        root.left = righttree;
        root.right = lefttree;

        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        root = Mirror(root);
        preorder(root);


    }
}
