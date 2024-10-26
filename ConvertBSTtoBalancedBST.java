import java.util.*;

public class ConvertBSTtoBalancedBST {

    // Static Node class so it can be used in static methods
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Preorder traversal to print the tree
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder traversal to collect elements in a list
    public static void Inorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        Inorder(root.left, inorder);
        inorder.add(root.data);
        Inorder(root.right, inorder);
    }

    // Create a balanced BST from the inorder list
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    // Function to balance the BST by converting it to an inorder list and then rebuilding the tree
    public static Node balanced(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        Inorder(root, inorder);  // Get inorder traversal of the tree
        root = createBST(inorder, 0, inorder.size() - 1);  // Rebuild the tree
        return root;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Creating an unbalanced BST
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        System.out.println("Original Tree (Preorder Traversal): ");
        preorder(root);
        System.out.println();

        // Balancing the BST
        root = balanced(root);

        System.out.println("Balanced Tree (Preorder Traversal): ");
        preorder(root);
    }
}

