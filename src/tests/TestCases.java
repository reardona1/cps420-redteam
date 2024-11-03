package tests;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class TestCases {
    LocalDate today = LocalDate.now();
    /*
    @Test
    public void failingTest() {
        Assert.assertEquals("This should fail", "expected", "actual");
    }
    */
    @Test
    public void testValidBookCreation() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Assert.assertEquals("12345", book.getIsbn());
        Assert.assertEquals("Test Book", book.getTitle());
        Assert.assertEquals(5, book.getCopiesAvailable());
    }

    @Test
    public void testBorrowBookSuccess() {
        Book book = new Book("12345", "Test Book", "Author Name", 3);
        book.borrowBook();
        Assert.assertEquals(2, book.getCopiesAvailable());
    }

    @Test
    public void testBorrowBookFailure() {
        Book book = new Book("12345", "Test Book", "Author Name", 0);
        Assert.assertThrows(IllegalStateException.class, () -> {
            book.borrowBook();
        });
    }
    
    @Test
    public void testAddBook() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        library.addBook(book);
        Assert.assertNotNull(library.searchBooksByTitle("Test Book"));
    }

    @Test
    public void testIssueLoan() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        library.addBook(book);
        library.registerMember(member);
        library.issueLoan(member.getMemberId(), book.getIsbn());
        
        Assert.assertNotNull(library.issueLoan(member.getMemberId(), book.getIsbn()));
    }
    // end LibrarySystemTest.java

    @Test
    public void testLoanCreation() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        Loan loan = new Loan(member, book);
        
        Assert.assertEquals(book, loan.getBook());
        Assert.assertEquals(member, loan.getMember());
        Assert.assertFalse(loan.isOverdue());
    }

    // end LoanTest.java

    @Test
    public void testBorrowBookWithinLimit() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        member.borrowBook(book);
        Assert.assertEquals(1, member.getBorrowedBooks().size());
    }

    @Test
    public void testBorrowBookExceedingLimit() {
        Member member = new Member("1001", "John Doe");
        Book book1 = new Book("12345", "Book One", "Author Name", 5);
        Book book2 = new Book("67890", "Book Two", "Author Name", 5);
        Book book3 = new Book("12343", "Book Three", "Author Name", 5);
        Book book4 = new Book("12355", "Book Four", "Author Name", 5);
        Book book5 = new Book("98758", "Book Five", "Author Name", 5);
        Book book6 = new Book("11239", "Book Six", "Author Name", 5);
        
        member.borrowBook(book1);
        member.borrowBook(book2);
        member.borrowBook(book3);
        member.borrowBook(book4);
        member.borrowBook(book5);

        Assert.assertThrows(java.lang.IllegalStateException.class, () -> {
            member.borrowBook(book6);
        });
    }

    @Test
    public void testReturnBook() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Loan loan = member.borrowBook(book);
        member.returnBook(loan);
        Assert.assertEquals(0, member.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBookFailure() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
    
        // Attempt to return a book that the member hasn't borrowed
        Loan loan = new Loan(member, book);
        Assert.assertThrows(IllegalStateException.class, () -> {
            member.returnBook(loan);
        });
    }
    // end MemberTest.java
}
