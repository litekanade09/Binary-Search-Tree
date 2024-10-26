import java.util.*;
public class RoottoleafPath {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printpath(ArrayList<Integer> path){
        for(int  i = 0;i < path.size();i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void printrootleaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printpath(path);
        }
        printrootleaf(root.left , path);
        printrootleaf(root.right, path);
        path.remove(path.size() - 1);
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
        int valuse[] = {8,5,6,3,10,11,14};
        Node root = null;

        for(int i = 0;i < valuse.length;i++){
            root = insert(root,valuse[i]);
        }
        inorder(root);
        System.out.println();

        printrootleaf(root,new ArrayList<>());

    }
}
