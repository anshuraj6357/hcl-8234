package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model;

import java.util.ArrayList;
import java.util.List;

public class member {

    private int id;
    private String name;
    private String email;


    // List of borrowed items
    private List<Book> borrowedItems;

    // Default Constructor
    public member() {
        borrowedItems = new ArrayList<>();
    }

    // Parameterized Constructor
    public member( String name, String email) {
        ValidateEmail(email);

        this.name = name;
        this.email = email;


        borrowedItems = new ArrayList<>();
    }

    // Getters and Setters

    public int getMemberId() {
        return id;
    }

    public void setMemberId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Get borrowed items
    public List<Book> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    // Add borrowed item
    public void addBorrowedItem(Book item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (borrowedItems.contains(item)) {
            throw new IllegalStateException("Item already in borrowed list");
        }

        if (!item.isAvailable()) {
            throw new IllegalStateException("Item is not available");
        }

        item.borrow();
        borrowedItems.add(item);
    }

    // Return borrowed item
    public void returnBorrowedItem(Book item) {

        if (!borrowedItems.contains(item)) {
            throw new IllegalArgumentException(
                    "Item was not borrowed by this member"
            );
        }

        item.giveBack();
        borrowedItems.remove(item);
    }

    // Count borrowed items
    public int getBorrowedBooks() {
        return borrowedItems.size();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }

    private void  ValidateEmail(String s){
        if(!s.contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}