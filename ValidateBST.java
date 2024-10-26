import java.util.*;
public class ValidateBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left= null;
            this.right = null;
        }
    }

    public static boolean isValidateBst(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidateBst(root.left,min,root) && isValidateBst(root.right,root,max);
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
    public static void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void main(String[] args) {
        int valuse[] = {8,5,6,3,10,11,14}; //Valid
//        int valuse[] = {3,5,2,22,2,2,2}; //Is Not Valid
        Node root = null;

        for(int i = 0;i < valuse.length;i++){
            root = insert(root,valuse[i]);
        }
        inorder(root);
        System.out.println();

        if(isValidateBst(root,null,null)){
            System.out.print("Valid");
        }else{
            System.out.print("is Not Valid");
        }






    }
}
