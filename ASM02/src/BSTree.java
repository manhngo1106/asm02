
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTree {
    Node root;

    // Constructor
    BSTree() {
        root = null;
    }

    // Insert a product into BST
    void insert(Product product) {
        root = insertRec(root, product);
    }

    // Recursive function to insert a product
    private Node insertRec(Node root, Product product) {
        if (root == null) {
            root = new Node(product);
            return root;
        }

        if (product.pcode.compareTo(root.data.pcode) < 0)
            root.left = insertRec(root.left, product);
        else if (product.pcode.compareTo(root.data.pcode) > 0)
            root.right = insertRec(root.right, product);

        return root;
    }


    // In-order traversal of the BST
void inorder() {
    System.out.println("In-order traversal:");
    inorderRec(root);
}

private void inorderRec(Node root) {
    if (root != null) {
        inorderRec(root.left);
        System.out.println(root.data.pcode + " | " + root.data.pro_name + " | " +
                root.data.quantity + " | " + root.data.saled + " | " + root.data.price);
        inorderRec(root.right);
    }
}
static void inOrderTraverseToFile(Node root, FileWriter writer) throws IOException {
    if (root != null) {
        inOrderTraverseToFile(root.left, writer);
        writer.write(root.data.pcode + " | " + root.data.pro_name + " | " +
                root.data.quantity + " | " + root.data.saled + " | " + root.data.price + "\n");
        inOrderTraverseToFile(root.right, writer);
    }
}

// Breadth-first traversal of the BST
void breadthFirst() {
    System.out.println("Breadth-first traversal:");
    if (root == null) {
        System.out.println("Tree is empty");
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node tempNode = queue.poll();
        System.out.println(tempNode.data.pcode + " | " + tempNode.data.pro_name + " | " +
                tempNode.data.quantity + " | " + tempNode.data.saled + " | " + tempNode.data.price);
        if (tempNode.left != null)
            queue.add(tempNode.left);
        if (tempNode.right != null)
            queue.add(tempNode.right);
    }
}







    // Search for a product by pcode
    Node search(Node root, String pcode) {
        if (root == null || root.data.pcode.equals(pcode))
            return root;
        if (root.data.pcode.compareTo(pcode) < 0)
            return search(root.right, pcode);
        return search(root.left, pcode);
    }

    // Delete a product by pcode
    Node deleteNode(Node root, String pcode) {
        if (root == null)
            return root;
        if (pcode.compareTo(root.data.pcode) < 0)
            root.left = deleteNode(root.left, pcode);
        else if (pcode.compareTo(root.data.pcode) > 0)
            root.right = deleteNode(root.right, pcode);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValueNode(root.right).data;
            root.right = deleteNode(root.right, root.data.pcode);
        }
        return root;
    }





public Node buildBalancedBST(ArrayList<Product> products, int start, int end) {
    if (start > end) {
        return null;
    }

    int mid = (start + end) / 2;
    Node node = new Node(products.get(mid));
    node.left = buildBalancedBST(products, start, mid - 1);
    node.right = buildBalancedBST(products, mid + 1, end);
    return node;
}

public void printTree(Node node, int level) {
    if (node != null) {
        printTree(node.left, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.data);
        printTree(node.right, level + 1);
    }
}

//---------
// Duyệt theo thứ tự trước (pre-order traversal):
//Trong phương thức printTree, đảo ngược vị trí gọi đệ quy printTree(node.left, level + 1)
 //       và printTree(node.right, level + 1) để hiển thị nút gốc trước, sau đó đến cây con bên trái và cuối cùng là cây con bên phải.
//public void printTreePreOrder(Node node, int level) {
//    if (node != null) {
//        for (int i = 0; i < level; i++) {
//            System.out.print("   ");
//        }
//        System.out.println(node.data);
//        printTreePreOrder(node.left, level + 1);
//        printTreePreOrder(node.right, level + 1);
//    }
//}

// Duyệt theo thứ tự sau (post-order traversal):
//Trong phương thức printTree, đảo ngược vị trí gọi đệ quy printTree(node.left, level + 1)
 //       và printTree(node.right, level + 1) để hiển thị cây con bên trái trước, sau đó là cây con bên phải và cuối cùng là nút gốc.

//public void printTreePostOrder(Node node, int level) {
//    if (node != null) {
//        printTreePostOrder(node.left, level + 1);
//        printTreePostOrder(node.right, level + 1);
//        for (int i = 0; i < level; i++) {
//            System.out.print("   ");
//        }
//        System.out.println(node.data);
//    }
//}



//
    // Find the node with the smallest value in the BST
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Count the number of products in the BST
    int countProducts(Node root) {
        if (root == null)
            return 0;
        return 1 + countProducts(root.left) + countProducts(root.right);
    }
    
    void insertToFile(Node root, FileWriter writer) throws IOException {
    if (root != null) {
        insertToFile(root.left, writer);
        writer.write(root.data.pcode + " | " + root.data.pro_name + " | " +
                root.data.quantity + " | " + root.data.saled + " | " + root.data.price + "\n");
        insertToFile(root.right, writer);
    }
}

      
// Hiển thị dữ liệu từ tệp tin ra màn hình
void displayFromFile(String filename) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        System.out.println("Data from file " + filename + ":");
        while ((line = reader.readLine()) != null) {
            line = line.trim(); // Loại bỏ khoảng trắng từ đầu và cuối dòng
            if (!line.isEmpty()) { // Kiểm tra dòng không rỗng
                System.out.println(line);
            }
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("An error occurred while reading from the file: " + e.getMessage());
    }
}

    Product searchByPCode(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}