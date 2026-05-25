import java.io.*;
import java.util.*;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author;
    }
}

public class Library_Management_System {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "books.txt";

    public static void main(String[] args) {
        loadBooks();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    saveBooks();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        boolean removed = books.removeIf(book -> book.id == id);

        if (removed)
            System.out.println("Book removed successfully!");
        else
            System.out.println("Book not found!");
    }

    static void searchBook() {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + book);
                return;
            }
        }

        System.out.println("Book not found!");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    static void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    static void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                books.add(new Book(Integer.parseInt(data[0]), data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("No previous records found.");
        }
    }
}