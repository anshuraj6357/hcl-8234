//package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model;
//
//import java.sql.Struct;
//
//public class Book extends libraryItem {
//
//    private String Booktitle;
//    private String name;
//    private double price;
//    private String author;
//
//    public Book(String Booktitle, String name,
//                double price, String author) {
//
//       this.Booktitle = Booktitle;
//
//        this.name = name;
//
//        setPrice(price);
//        this.author = author;
//    }
//
//    @Override
//    public double lateFee(int daysLate) {
//        return Math.max(0, daysLate) * 2;
//    }
//
//    // Getters
//    public String getName() {
//        return name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public String getTitle() {
//        return Booktitle;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    // Setters
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setTitle(String Booktitle) {
//        this.Booktitle=Booktitle;
//    }
//
//    public void setPrice(double price) {
//        if (price < 0) {
//            throw new IllegalArgumentException("Invalid price");
//        }
//        this.price = price;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//}