package Manager;

import Entity.Customer;
import Entity.Ordering;
import Entity.Product;
import LinkedList.MyList;
import LinkedList.Node;
import static Manager.Validate.checkInputLimited;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuManager {

    private static final String CUSTOMER_URL = "Customers.txt";
    private static final String PRODUCT_URL = "Products.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void loadFromFileCustomers(MyList<Customer> mlc) {
        try {
            File f = new File(CUSTOMER_URL);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr); 

            String line;
            while ((line = br.readLine()) != null) { 
                String[] detailCus = line.split(":");
                mlc.addToTail(new Customer(detailCus[0], detailCus[1], detailCus[2]));
            }
            System.err.println("Load successful!");
        } catch (IOException e) {
        }
    }
   public static void loadDataAndDisplayProducts(MyList<Product> productList) {
    // Assuming productList is a list containing all products
    // Write code to load data from file
    MenuManager.loadFromFileProducts(productList);
    // Display the loaded data
    MenuManager.printPro(productList);
}


public static void loadDataAndDisplayCustomers(MyList<Customer> customerList) {
    // Assuming customerList is a list containing all customers
    // Write code to load data from file (not provided here)
    // Display the loaded data
    // For example:
    System.out.println("Loading customer data...");
    // Call method to load data from file
    // Display the loaded data
    // For example:
    MenuManager.printCus(customerList);
    System.out.println("Customer data loaded successfully!");
}
public static void deleteRecordWithCode1AndDisplay(MyList<Product> productList) {
    // Assuming productList is a list containing all products
    // Find and delete the product record with code = 1
    // For example:
    Product productToDelete = productList.search(new Product("1", "A", 6, 2, 1.0));
    if (productToDelete != null) {
        productList.delete(productToDelete);
        System.out.println("Record with code 1 deleted successfully.");
        // Display the updated list
        productList.traverse(); // Assuming productList has a traverse method to display all products
    } else {
        System.out.println("Record with code 1 not found.");
    }
}

public static void deleteRecordAndUpdateQuantityAndDisplay(MyList<Product> productList) {
    // Assuming productList is a list containing all products
    // Find the product record with code = 4
    // For example:
    Product productToUpdate = productList.search(new Product("4", "", 0, 0, 0.0));
    if (productToUpdate != null) {
        // Edit the quantity
        productToUpdate.setQuantity(77);
        // Delete the product
        productList.delete(productToUpdate);
        // Add the updated product back to the list
        productList.addToTail(productToUpdate);
        System.out.println("Record with code 4 updated and quantity set to 77 successfully.");
        // Display the updated list
        MenuManager.printPro(productList);
    } else {
        System.out.println("Record with code 4 not found.");
    }
}
public static void addRecordsAndDisplay(MyList<Product> productList) {
    // Load existing data from the file
    MenuManager.loadFromFileProducts(productList);

    // Display the loaded data

    // Add new records
    productList.addToTail(new Product("5", "E", 10, 5, 20.5));
    productList.addToTail(new Product("6", "F", 15, 8, 30.75));

    // Display only the newly added records
    System.out.println("Newly added records:");
    productList.traverse(); // Print all products in the list
}






//------------------------------------------------------------------------------

    public static void loadFromFileProducts(MyList<Product> mlp) {
        try {
            File f = new File(PRODUCT_URL);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] detailPro = line.split(":");             
                mlp.addToTail(new Product(detailPro[0], detailPro[1], Integer.parseInt(detailPro[2]), Integer.parseInt(detailPro[3]), Double.parseDouble(detailPro[4])));
            }
            System.err.println("Load successful!");
        } catch (IOException | NumberFormatException e) {
        }
    }
//------------------------------------------------------------------------------    
    //print info customers

    public static void printCus(MyList<Customer> mc) {
        mc.traverse();
    }
//------------------------------------------------------------------------------  
    //print info product

    public static void printPro(MyList<Product> ml) {
        ml.traverse();
    }
//------------------------------------------------------------------------------  
    //add Customer to the end

    public static void inputCusToTail(MyList<Customer> mc) {
        System.out.print("Enter your code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter your name: ");
        String cName = Validate.checkInputString();
        System.out.print("Enter your number phone: ");
        String cPhone = Validate.checkInputString();

        mc.addToTail(new Customer(cCode, cName, cPhone));

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------ 
    //add Product to the end

    public static void inputProToTail(MyList<Product> mp) {
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter your product name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity of product: ");
        int pQuan = Validate.checkInputInt();
        System.out.print("Enter number product was sale: ");
        int pSale = Validate.checkInputSaled(pQuan);
        System.out.print("Enter price: ");
        double pPrice = Validate.checkInputDouble();

        mp.addToTail(new Product(pCode, pName, pQuan, pSale, pPrice));  

        System.err.println("Add succcessful!");
    }
//------------------------------------------------------------------------------ 
 public static void saveToFile(MyList<Customer> mc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_URL))) {
            Node<Customer> current = mc.getHead(); 
            while (current != null) {
                Customer customer = current.getData();
                writer.write(customer.getCode() + ":" + customer.getName() + ":" + customer.getPhone());
                writer.newLine(); 
                current = current.getNext();
            }
            System.out.println("Customer data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error occurred while saving customer data: " + e.getMessage());
        }
    }
// ------------------

//------------------------------------------------------------------------------
    //search by customer code

    public static void searchByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer Code: ");
        String cCode = Validate.checkInputString();

        Customer c; 
        if ((c = mc.search(new Customer(cCode, "", ""))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(c.toString());
    }
//------------------------------------------------------------------------------  
    //delete by Customer code

    public static void delectByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();
        mc.delete(new Customer(cCode, "", ""));
    }
//------------------------------------------------------------------------------ 
    //search by Product Code

    public static void searchByPCode(MyList<Product> mp) {
        System.out.print("Enter Product code: ");
        String pCode = Validate.checkInputString();

        Product p;  //Define a Product 
        if ((p = mp.search(new Product(pCode, "", 0, 0, 0))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(p.toString());
    }
//------------------------------------------------------------------------------
    //delete by Product Code
public static double checkInputDouble() {
    while (true) {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Please input a valid number!");
        }
    }
}

//------------------------------------------------------------------------------
    //sort Product list by PCode

    public static void sortByPCode(MyList<Product> mp) {
        mp.sort();
        System.err.println("Sorted");
    }
//------------------------------------------------------------------------------
    //add a Product after   

    public static void addProductAfter(MyList<Product> mp) {
        System.out.print("Enter position k: ");
        int k = Validate.checkInputInt();
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter your product name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity of product: ");
        int pQuantity = Validate.checkInputInt();
        System.out.print("Enter number product was sale: ");
        int pSale = Validate.checkInputSaled(pQuantity);
        System.out.print("Enter price: ");
        double pPice = Validate.checkInputDouble();

        mp.addAfterPosition(k, new Product(pCode, pName, pQuantity, pSale, pPice));     //Jesus!! its working !

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------

    public static void addOrder(MyList<Ordering> mo) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter Product code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter Quantity of product: ");
        int pQuantity = Validate.checkInputInt();

        mo.addToTail(new Ordering(pCode, cCode, pQuantity));

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------

    public static void printOrder(MyList<Ordering> mo) {
        mo.traverse();
    }
//------------------------------------------------------------------------------ 

    public static void sortOrder(MyList<Ordering> mo) {
        mo.sort();
    }
//------------------------------------------------------------------------------

    public static int menu() {
        System.out.printf("%-3s%-10s", "", "---MAIN MENU---\n");
        System.out.println("1. Product list");
        System.out.println("2. Customer list");
        System.out.println("3. Order list");
        System.out.println("0. Exit program");

        int choise = checkInputLimited(0, 3);
        return choise;
    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

    public static void loadFromFileproduct1(MyList<Product> lp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void saveToFile(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
