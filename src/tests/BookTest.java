package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.Book;

import org.junit.Assert.*;

public class BookTest {

    @Test
    public void testValidBookCreation() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        assertEquals("12345", book.getIsbn());
        assertEquals("Test Book", book.getTitle());
        assertEquals(5, book.getCopiesAvailable());
    }

    @Test
    public void testBorrowBookSuccess() {
        Book book = new Book("12345", "Test Book", "Author Name", 3);
        book.borrowBook();
        assertEquals(2, book.getCopiesAvailable());
    }

    @Test
    public void testBorrowBookFailure() {
        Book book = new Book("12345", "Test Book", "Author Name", 0);
        assertThrows(IllegalStateException.class, () -> {
            book.borrowBook();
        });
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("12345", "Test Book", "Author Name", 2);
        book.returnBook();
        assertEquals(3, book.getCopiesAvailable());
    }
}
