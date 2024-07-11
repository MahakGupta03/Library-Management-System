import java.util.Scanner;

interface LibraryOperations {
    void addBook(String title, String author);
    void removeBook(String title);
    void listBooks();
}


class Library implements LibraryOperations {
    public Book[] books = new Book[100];
    public int totalBooks = 0;


    
    public void addBook(String title, String author) {
        if (totalBooks < books.length) {
            books[totalBooks++] = new Book(title, author);
            System.out.println("Book added to the library.");
        } else {
            System.out.println("Library is full. You cannot add more books.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle()== title) {
                for (int j = i; j < totalBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--totalBooks] = null; 
                System.out.println("Book removed from the library.");
                return;
            }
        }
        System.out.println("Book not found.");
    }


    public void listBooks() {
        if (totalBooks == 0) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("List of books:");
            for (int i = 0; i < totalBooks; i++) {
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
            }
        }
    }
}

class Book {
    public String title;
    public String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library();

        while (true) {
            System.out.println("Choose an option: \n1. Add Book \n2. Remove Book \n3. List Books \n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();
                    myLibrary.addBook(title, author);
                    break;
                case 2:
                    System.out.println("Enter book title to remove:");
                    title = scanner.nextLine();
                    myLibrary.removeBook(title);
                    break;
                case 3:
                    myLibrary.listBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}