import java.util.*;

public class SearchBST {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean Search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return Search(root.left,key);
        }else{
            return Search(root.right,key);
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

    public static void main(String[] args) {
        int values[] = {2,4,5,1,3,10,9,8,7,6};
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }


        if(Search(root,14)){
            System.out.println("found");
        }else{
            System.out.print("Not found");
        }


    }
}
