package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.model;

import java.time.Year;

public  class Book implements Borrowable {

    private static int counter = 1001;

    private final int id;
    private String title;
    private int year;
    private boolean available;

    // Default Constructor
    public Book() {
        this.id = counter++;
        this.available = true;
    }

    // Parameterized Constructor
    public Book(String title, int year, boolean available) {

        validateTitle(title);
        validateYear(year);

        this.id = counter++;
        this.title = title;
        this.year = year;
        this.available = available;
    }

    // Abstract Method

    // Validation Methods
    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Title must not be blank"
            );
        }
    }

    private void validateYear(int year) {
        int currentYear = Year.now().getValue();

        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException(
                    "Year must be between 1900 and " + currentYear
            );
        }
    }

    // Getters
    public int getItemId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return year;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    // Borrowable Interface Methods

    @Override
    public void borrow() {
        if (available) {
            available = false;

            System.out.println(title + " borrowed successfully");
        } else {
            System.out.println(title + " is already borrowed");
        }
    }

    @Override
    public void giveBack() {
        if (!available) {
            available = true;
            System.out.println(title + " returned successfully");
        } else {
            System.out.println(title + " is already available");
        }
    }

    // Setters
    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public void setPublicationYear(int year) {
        validateYear(year);
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}