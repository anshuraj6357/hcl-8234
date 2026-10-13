package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model;

public class Book extends libraryItem {
    public  String tite;
    public  String name;
    public double price;
    public  String author;
    @Override
    public double lateFee(int daysLate) {
        return Math.max(0, daysLate) * 2;
    }
    public Book(String tite, String name, String author) {
        this.tite = tite;
        this.name = name;
        this.author = author;
    }
    public String getTire() {
        return tite;
    }
    public void setTite(String tite) {}
    public String getName() {
        return name;
    }
    public void setName(String name) {}
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {}
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {}
}

