import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int pages;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // toString
    @Override
    public String toString() {
        return title + " by " + author + " - " + pages + " pages";
    }
}

public class Ex3Sorting {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Clean Code", "Robert Martin", 450));
        books.add(new Book("Effective Java", "Joshua Bloch", 416));
        books.add(new Book("Java Basics", "Robert Martin", 300));
        books.add(new Book("Algorithms", "Sedgewick", 700));
        books.add(new Book("Data Structures", "Sedgewick", 500));

        // -----------------------------
        // TASK A: Sort by author (alphabetically)
        // -----------------------------

        // Lambda version
        books.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));

        // Comparator + method reference version
        books.sort(Comparator.comparing(Book::getAuthor));

        System.out.println("Sorted by author:");
        for (Book b : books) {
            System.out.println(b);
        }

        // -----------------------------
        // TASK B: Sort by pages (descending)
        // -----------------------------
        books.sort((b1, b2) -> b2.getPages() - b1.getPages());

        System.out.println("\nSorted by pages (descending):");
        for (Book b : books) {
            System.out.println(b);
        }

        // -----------------------------
        // TASK C: Complex sort (author then pages)
        // -----------------------------
        books.sort(
                Comparator.comparing(Book::getAuthor)
                        .thenComparing(Book::getPages)
        );

        System.out.println("\nSorted by author, then pages:");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}