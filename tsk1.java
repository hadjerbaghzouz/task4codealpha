import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class tsk1{

}
// Enum for book categories
enum BookCategory {
    FICTION,
    NON_FICTION,
    SCIENCE_FICTION,
    MYSTERY,
    BIOGRAPHY
}

// Class representing a digital resource
class DigitalResource {
    private String title;
    private String link;

    public DigitalResource(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}

// Class representing a book
class Book {
    private String title;
    private String author;
    private BookCategory category;
    private boolean available;

    public Book(String title, String author, BookCategory category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availability) {
        available = availability;
    }
}

// Class representing a user
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Class representing the library system
class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    private List<DigitalResource> digitalResources = new ArrayList<>();

    // Add a book to the library
    public void addBook(String title, String author, BookCategory category) {
        books.add(new Book(title, author, category));
    }

    // Add a user to the library system
    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    // Add a digital resource to the library
    public void addDigitalResource(String title, String link) {
        digitalResources.add(new DigitalResource(title, link));
    }

    // Authenticate a user
    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    // Borrow a book
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book '" + title + "' has been borrowed successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' is not available for borrowing.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book '" + title + "' has been returned successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' cannot be returned.");
    }

    // Display all books in the library
    public void displayBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.print(book.getTitle() + " by " + book.getAuthor() + " - Category: " + book.getCategory());
            System.out.println(book.isAvailable() ? " - Available" : " - Not Available");
        }
    }

    // Display all digital resources in the library
    public void displayDigitalResources() {
        System.out.println("Digital Resources in the Library:");
        for (DigitalResource resource : digitalResources) {
            System.out.println(resource.getTitle() + " - " + resource.getLink());
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", BookCategory.FICTION);
        library.addBook("To Kill a Mockingbird", "Harper Lee", BookCategory.FICTION);
        library.addBook("The Da Vinci Code", "Dan Brown", BookCategory.MYSTERY);

        // Add users to the library system
        library.addUser("user1", "password1");
        library.addUser("user2", "password2");

        // Add digital resources to the library
        library.addDigitalResource("Programming in Java", "www.example.com/java-book");

        // Authenticate users
        System.out.println("User Authentication:");
        System.out.println("User1 authentication: " + (library.authenticateUser("user1", "password1") ? "Successful" : "Failed"));
        System.out.println("User2 authentication: " + (library.authenticateUser("user2", "password3") ? "Successful" : "Failed"));

        // Display books and digital resources in the library
        library.displayBooks();
        System.out.println();
        library.displayDigitalResources();

        // Borrow and return books
        library.borrowBook("The Great Gatsby");
        library.borrowBook("The Da Vinci Code");
        library.returnBook("The Great Gatsby");

        // Display updated book availability
        library.displayBooks();
    }
}
