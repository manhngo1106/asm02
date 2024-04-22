
package Manager;

import static Manager.Validate.checkInputLimited;

public class MenuChilds {

    public static int menuP() {
        System.out.println("    --Product menu--");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the end\n"
                + "3. Display data\n"
                + "4. Save product list to file\n"
                + "5. Search by pcode\n"
                + "6. Delete by pcode\n"
                + "7. Sort by pcode\n"
                + "8. Add after position  k\n"
                + "9. Delete the node after the node having code = xCode\n"
                + "11. Load data and display\n"
                + "12. Delete the record with code = 1 and display\n"
                + "13. Delete the record with code = 4 , edit quantity = 77 and display\n"
                + "14. Do not enter data, add records and display\n"
                + "15. Sort ascending by saled and display\n"
                + "0. Exit to main menu\n");

        int choise = Validate.checkInputLimited(0, 15);
        return choise;
    }

    public static int menuO() {
        System.out.println("    --Order menu--");
        System.out.println("1. Input data\n"
                + "2. Display data with total value\n"
                + "3. Sort  by pcode + ccode\n"
                + "0. Exit to main menu\n");

        int choise = Validate.checkInputLimited(0, 3);
        return choise;
    }

    public static int menuC() {
        System.out.println("    --Customer menu--");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the end\n"
                + "3. Display data\n"
                + "4. Save customer list to file\n"
                + "5. Search by ccode\n"
                + "6. Delete by ccode\n"
                + "0. Exit to main menu\n");
        
        int choise = checkInputLimited(0, 6);
        return choise;
    }

}