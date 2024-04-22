
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaleManagementSystem {

    public static void main(String[] args) {
        BSTree bst = new BSTree();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nProducts:");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & insert data");
            System.out.println("3. In-order traverse");
            System.out.println("4. Breadth-first traverse");
            System.out.println("5. In-order traverse to file");
            System.out.println("6. Search by pcode");
            System.out.println("7. Delete by pcode by copying");
            System.out.println("8. Simply balancing");
            System.out.println("9. Count number of products");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loadFromFile(bst);
                
                    bst.displayFromFile("data.txt");
                    break;
                case 2:
                    inputAndInsert(bst, scanner);
                   
                    bst.displayFromFile("data.txt");
                    break;
                case 3:
                    bst.inorder();
                    break;
                case 4:
                    bst.breadthFirst();
                    break;
                case 5:
                    inOrderTraverseToFile(bst);
                    break;

                case 6:
                    searchByPCode(bst, scanner);
                    break;
                case 7:
                    deleteByPCode(bst, scanner);
                    break;
                case 8:
                    simplyBalance(bst);
                    break;

                case 9:
                    System.out.println("Number of products: " + bst.countProducts(bst.root));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
private static void loadFromFile(BSTree bst) {
    try {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    String pcode = parts[0].trim();
                    String pro_name = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    int saled = Integer.parseInt(parts[3].trim());
                    double price = Double.parseDouble(parts[4].trim());

                    Product product = new Product(pcode, pro_name, quantity, saled, price);
                    bst.insert(product);
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }
        }
        scanner.close();
        System.out.println("Data loaded successfully.");
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
    } catch (Exception e) {
        System.out.println("Error loading data: " + e.getMessage());
    }


    }

    private static void inputAndInsert(BSTree bst, Scanner scanner) {
        System.out.print("Enter pcode: ");
        String pcode = scanner.nextLine();
        System.out.print("Enter product name: ");
        String pro_name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter saled: ");
        int saled = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product(pcode, pro_name, quantity, saled, price);
        bst.insert(product);
        System.out.println("Product inserted successfully!");


             try {
        FileWriter writer = new FileWriter("data.txt", true);
        writer.write(pcode + " | " + pro_name + " | " + quantity + " | " + saled + " | " + price + "\n");
        writer.close();
        System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    private static void searchByPCode(BSTree bst, Scanner scanner) {
        System.out.print("Enter pcode to search: ");
        String pcode = scanner.nextLine();
        Node result = bst.search(bst.root, pcode);
        if (result != null) {
            System.out.println("Product found: " + result.data);
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void deleteByPCode(BSTree bst, Scanner scanner) {
        System.out.print("Enter pcode to delete: ");
        String pcode = scanner.nextLine();
        Node result = bst.search(bst.root, pcode);
        if (result != null) {
            bst.deleteNode(bst.root, pcode);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void inOrderTraverseToFile(BSTree bst) {
        try {
            FileWriter writer = new FileWriter("data.txt");

            bst.inOrderTraverseToFile(bst.root, writer);
            writer.close();
            System.out.println("In-order traverse to file completed.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

 private static void simplyBalance(BSTree bst) {
    // Copy all elements to an array
    ArrayList<Product> products = new ArrayList<>();
    copyInOrder(bst.root, products);

    // Rebuild the BST
    bst.root = bst.buildBalancedBST(products, 0, products.size() - 1);
    System.out.println("Simply balancing completed.");
 // Print the balanced tree
    System.out.println("Balanced BST:");
    bst.printTree(bst.root, 0);
    //bst.printTreePostOrder(bst.root, 0);
    //bst.printTreePreOrder(bst.root, 0);
 }
private static void copyInOrder(Node root, ArrayList<Product> products) {
    if (root != null) {
        copyInOrder(root.left, products);
        products.add(root.data);
        copyInOrder(root.right, products);
    }
}


 

    

   
}

