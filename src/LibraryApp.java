import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    private ArrayList<Book> books;
    private Scanner sc;

    public LibraryApp() {
        books = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void run() {
        int choice;

        do {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");

            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBookById();
                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option");
            }

        } while (choice != 7);
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();

        Book book = new Book(title, author, year);
        books.add(book);

        System.out.println("Book added with ID: " + book.getId());
    }

    private void searchByTitle() {
        System.out.print("Enter part of title: ");
        String part = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(part)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found");
        }
    }

    private void borrowBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book book = findById(id);

        if (book == null) {
            System.out.println("Book not found");
        } else if (book.isAvailable()) {
            book.markAsBorrowed();
            System.out.println("Book borrowed");
        } else {
            System.out.println("Book is already borrowed");
        }
    }

    private void returnBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book book = findById(id);

        if (book == null) {
            System.out.println("Book not found");
        } else if (!book.isAvailable()) {
            book.markAsReturned();
            System.out.println("Book returned");
        } else {
            System.out.println("Book was not borrowed");
        }
    }

    private void deleteBookById() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book book = findById(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted");
        } else {
            System.out.println("Book not found");
        }
    }

    private Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}

