
package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj;

import Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model.Book;
import Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model.member;
import Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.service.libraryService;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        libraryService ls = new libraryService();

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Item");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. GetMember");
            System.out.println("6. List Items");
            System.out.println("7. Search Item");
            System.out.println("8. Export Report");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter a valid number");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            System.out.println(choice);
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Publication Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                   Book book=new Book(
                           title,
                           year,
                           true
                   );
                    ls.AddItems(book);
                    break;
                }

                case 2: {
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Member Email: ");
                    String email = sc.nextLine();

                    // Assumes member(String, String)
                    member m = new member(name, email);

                    ls.addMember(m);
                    break;
                }

                case 3: {
                    System.out.print("Enter Item ID: ");
                    int itemId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    ls.getBorrowedItems(memberId,itemId);
                    break;
                }

                case 4: {
                    System.out.print("Enter Item ID: ");
                    int itemId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    ls.RemoveBorrowedItem(itemId,memberId);
                    break;
                }
                case 5:{
                    System.out.println("Get All Members ");
                    ls.getMember();
                    break;
                }

//                case 5: {
//                    System.out.print("Enter Item ID: ");
//                    int itemId = sc.nextInt();
//
//                    System.out.print("Enter Member ID: ");
//                    int memberId = sc.nextInt();
//                    sc.nextLine();
//
//                    ls.addToWaitlist(itemId, memberId);
//                    break;
//                }

                case 6: {
                    ls.getItems();
                    break;
                }

                case 7: {
                    System.out.print("Enter Item Name: ");
                    String itemname = sc.nextLine();
                   ls.SearchedItem(itemname);
                    break;
                }

//                case 8: {
//                    ls.exportReport();
//                    break;
//                }

                case 0: {
                    System.out.println("Exiting Library System...");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
