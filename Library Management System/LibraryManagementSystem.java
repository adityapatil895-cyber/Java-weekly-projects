import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println("Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Status: " + (isIssued ? "Issued" : "Available"));
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.bookId == id) {
                return b;
            }
        }
        return null;
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println(" Book Added Successfully!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        Book b = findBook(id);
        if (b != null) {
            if (!b.isIssued) {
                b.isIssued = true;
                System.out.println(" Book Issued Successfully!");
            } else {
                System.out.println(" Book is already issued!");
            }
        } else {
            System.out.println(" Book Not Found!");
        }
    }

    static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        Book b = findBook(id);
        if (b != null) {
            if (b.isIssued) {
                b.isIssued = false;
                System.out.println(" Book Returned Successfully!");
            } else {
                System.out.println(" Book was not issued!");
            }
        } else {
            System.out.println(" Book Not Found!");
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available.");
        } else {
            for (Book b : books) {
                b.display();
            }
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: issueBook(); break;
                case 3: returnBook(); break;
                case 4: viewBooks(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}