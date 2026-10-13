package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model;

public class magazine extends libraryItem {

    private int magazineId;
    private String title;
    private String publisher;
    private String category;
    private int issueNumber;
    private String publicationDate;
    private double price;
    private boolean available;

    // Default Constructor
    public magazine() {
    }

    public double lateFee(int daysLate) {
        return Math.max(0, daysLate) * 1;
    }

    // Parameterized Constructor
    public magazine(int magazineId, String title,
                    String publisher, String category,
                    int issueNumber, String publicationDate,
                    double price, boolean available) {

        this.magazineId = magazineId;
        this.title = title;
        this.publisher = publisher;
        this.category = category;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.price = price;
        this.available = available;
    }

    // Getters and Setters

    public int getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(int magazineId) {
        this.magazineId = magazineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "magazineId=" + magazineId +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", issueNumber=" + issueNumber +
                ", publicationDate='" + publicationDate + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}