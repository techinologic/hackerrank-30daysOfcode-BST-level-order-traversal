import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    //
    private static void levelOrder(Node root) {

        //Queue is an interface
        Queue<Node> queue = new LinkedList();
        // enqueue current root
        queue.add(root);

        // while there are nodes to process
        while (!queue.isEmpty()) {
            // dequeue next node
            Node current = queue.remove();
            System.out.print(current.data + " ");

            // enqueue child elements from next level in order
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }


    private static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}