package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.Book;
import com.example.Loan;
import com.example.Member;

import java.time.LocalDate;
import org.junit.Assert.*;
public class LoanTest {

    @Test
    public void testLoanCreation() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        Loan loan = new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        
        assertEquals(book, loan.getBook());
        assertEquals(member, loan.getMember());
        assertFalse(loan.isOverdue());
    }

    @Test
    public void testIsOverdue() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        Loan loan = new Loan(book, member, LocalDate.now().minusDays(16), LocalDate.now().minusDays(1));
        
        assertTrue(loan.isOverdue());
    }
}
