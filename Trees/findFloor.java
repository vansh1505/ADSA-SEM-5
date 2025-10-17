// User function Template for Java
package Trees;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                return x;
            }
            if (root.data < x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}