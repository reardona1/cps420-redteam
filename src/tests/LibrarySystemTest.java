package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.Book;
import com.example.LibrarySystem;
import com.example.Member;

import org.junit.Assert.*;
public class LibrarySystemTest {

    @Test
    public void testAddBook() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testIssueLoan() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        library.addBook(book);
        library.registerMember(member);
        library.issueLoan(book, member);
        
        assertEquals(1, library.getLoans().size());
    }
}
