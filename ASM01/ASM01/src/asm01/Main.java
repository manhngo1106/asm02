package asm01;

import Entity.*;
import LinkedList.MyList;
import Manager.MenuChilds;
import Manager.MenuManager;

public class Main {

    public static void main(String[] args) {

        MyList<Customer> lc = new MyList<>();
        MyList<Ordering> lo = new MyList<>();
        MyList<Product> lp = new MyList<>();
        MenuManager m = new MenuManager();

        runMenu(lc, lo, lp, m);

    }

    public static void runMenu(MyList<Customer> lc, MyList<Ordering> lo, MyList<Product> lp, Manager.MenuManager m) {
        while (true) {
            int choise = MenuManager.menu();

            if (choise == 0) {
                System.out.println("THANK YOU SO MUCH!!! ");
                break;
            }
            switch (choise) {
                //Product-------------------------------------------------------
                case 1:
                    while (true) {
                        int choiseP = MenuChilds.menuP();

                        if (choiseP == 0) {
                            break;
                        }
                        switch (choiseP) {
                            case 1:
                                MenuManager.loadFromFileProducts(lp);
                                break;
                            case 2:
                                MenuManager.inputProToTail(lp);   
                                break;
                            case 3:
                                MenuManager.printPro(lp);
                                break;
                            case 4:
                              //MenuManager.saveToFile(0b1);
                        
                            case 5:
                                MenuManager.searchByPCode(lp);    
                                break;
                            case 7:
                                MenuManager.sortByPCode(lp);
                                break;
                            case 8:
                                MenuManager.addProductAfter(lp);
                                break;
                            
                            case 11:
                                MenuManager.loadDataAndDisplayProducts(lp);
                                break;
                            case 12:
                                MenuManager.deleteRecordWithCode1AndDisplay(lp);
                                break;
                            case 13:
                                MenuManager.deleteRecordAndUpdateQuantityAndDisplay(lp);
                                break;
                            case 14:
                                MenuManager.addRecordsAndDisplay(lp);
                                break;



                        }
                    }
                    break;
                //Customer------------------------------------------------------    
                case 2:
                    while (true) {
                        int choiseC = MenuChilds.menuC();

                        if (choiseC == 0) {
                            break;
                        }
                        switch (choiseC) {
                            case 1:
                                MenuManager.loadFromFileCustomers(lc);
                                break;
                            case 2:
                                MenuManager.inputCusToTail(lc);
                                break;
                            case 3:
                                MenuManager.printCus(lc);
                                break;
                            case 4:
                            //chua lam duoc
                            case 5:
                                MenuManager.searchByCCode(lc);
                                break;
                            case 6:
                                MenuManager.delectByCCode(lc);    
                                break;
                        }
                    }
                    break;
                //Order---------------------------------------------------------
                case 3:
                    while (true) {
                        int choiseO = MenuChilds.menuO();

                        if (choiseO == 0) {
                            break;
                        }
                        switch (choiseO) {
                            case 1:
                                MenuManager.addOrder(lo);
                                break;
                            case 2:
                                MenuManager.printOrder(lo);
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
            }
        }
    }

    public static void demoCustomer() {
        MyList<Customer> listCustomer = new MyList<>();
        listCustomer.addToHead(new Customer("C03", "Hoa", "1902"));
        listCustomer.addToTail(new Customer("C02", "Canh", "1903"));
        listCustomer.addToHead(new Customer("C01", "La", "1901"));
        Customer result = listCustomer.search(new Customer("C04", "", ""));
        System.out.println(result);
    }

}
