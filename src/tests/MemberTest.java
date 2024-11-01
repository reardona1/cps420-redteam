package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.Book;
import com.example.Member;

import org.junit.Assert.*;
public class MemberTest {

    @Test
    public void testBorrowBookWithinLimit() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        member.borrowBook(book);
        assertEquals(1, member.getBorrowedBooks().size());
    }

    @Test
    public void testBorrowBookExceedingLimit() {
        Member member = new Member("1001", "John Doe");
        member.setMaxLoanLimit(2);  // assuming max loan limit is 2 for testing
        Book book1 = new Book("12345", "Book One", "Author Name", 5);
        Book book2 = new Book("67890", "Book Two", "Author Name", 5);
        Book book3 = new Book("11223", "Book Three", "Author Name", 5);
        
        member.borrowBook(book1);
        member.borrowBook(book2);

        assertThrows(IllegalStateException.class, () -> {
            member.borrowBook(book3);  // should fail since max limit is reached
        });
    }

    @Test
    public void testReturnBook() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        member.borrowBook(book);
        member.returnBook(book);
        assertEquals(0, member.getBorrowedBooks().size());
    }
}
