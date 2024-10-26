import java.util.*;
public class RangeBST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data> val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void printRnage(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data<= k2){
            printRnage(root.left,k1,k2);
            System.out.print(root.data + " ");
            printRnage(root.right,k1,k2);
        }
        else if(root.data > k1){
            printRnage(root.left,k1,k2);
        }else{
            printRnage(root.right,k1,k2);
        }
    }

    public static void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {2,4,5,1,3,10,9,8,7,6};
        Node root = null;

        for(int i = 0; i<values.length;i++){
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();

        printRnage(root,5,10);



    }
}