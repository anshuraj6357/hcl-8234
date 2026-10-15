package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.service;

import Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model.Book;
import Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model.member;

import java.util.ArrayList;
import java.util.List;

public class libraryService {
    private List<Book> items = new ArrayList<>();
    private List<member> members = new ArrayList<>();






    public abstract double latefee (int dayslate){

    }



    //AddItems
    public   void AddItems(Book item){
        items.add(item);
        System.out.println("Item Addded Successfully");
    }



    //getItems
    public  void getItems(){
        for(Book item:items){
            System.out.println(item.toString());
        }
        System.out.println("Item Found Successfully");
    }

    //removed the items
    public void removeItem(Book item){
        if(!items.contains(item)){
            System.out.println("Item Not Found");
            return;
        }
        if(!item.isAvailable()){
            System.out.println("Cannot remove the borrowed items");
        }
        items.remove(item);
        System.out.println("Item Removed Successfully");
    }


    //Addmembers
    public void addMember(member item){
        members.add(item);
    }
    //getMembers
    public void getMember(){
        for(member item:members){
            System.out.println(item.toString());
        }
    }

    //SearchItemByTitle
    public void SearchedItem(String item){
     Boolean found = false;
        for(Book a :items){
            if(a.getTitle().equals(item)){
                found =true;
                System.out.println(a);
            }
        }
        if(!found){
            System.out.println("Item not found");
        }
    }

    //BorrowItem

     public void AddBorrowedItem(Book item, member m){
        if(!items.contains(item)){
            System.out.println("Item not found");
            return;
        }
        if(!members.contains(m)){
            System.out.println("Member not found");
            return;
        }
        item.borrow();
        m.addBorrowedItem(item);

     }


     //removeBorrowedItem

    public void RemoveBorrowedItem(int itemId,int  memId){
        Book item=null;
        member membe=null;
        for(Book a:items){
            if(a.getItemId()==itemId){
                item=a;
                System.out.println(a);
            }
        }
        for(member a:members){
            if(a.getMemberId()==memId){
                membe=a;
                System.out.println(a);
            }
        }
        if(membe == null||item == null){
            System.out.println("Item not found");
            return;
        }

        if(!membe.getBorrowedItems().contains(item)){
            System.out.println("Book not borrowed by this member");
            return;
        }

        item.giveBack();
        membe.returnBorrowedItem(item);
    }


    public void getBorrowedItems(int mid,int itemId){
        System.out.println("mid"+mid);
        for(member m :members){
            if(m.getMemberId()==mid){
                for(Book a:items){
                    if(a.getItemId()==itemId){

                        m.addBorrowedItem(a);
                        a.borrow();
                            return;
                    }
                }
            }
        }
        System.out.println("mmber Not Found");
    }
}
