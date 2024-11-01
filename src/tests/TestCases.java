package tests;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {
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
    public void testReturnBook() {
        Book book = new Book("12345", "Test Book", "Author Name", 2);
        book.returnBook();
        Assert.assertEquals(3, book.getCopiesAvailable());
    }
    // end BookTest.java
    
    @Test
    public void testAddBook() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        library.addBook(book);
        Assert.assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testIssueLoan() {
        LibrarySystem library = new LibrarySystem();
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        library.addBook(book);
        library.registerMember(member);
        library.issueLoan(book, member);
        
        Assert.assertEquals(1, library.getLoans().size());
    }
    // end LibrarySystemTest.java

    @Test
    public void testLoanCreation() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        Loan loan = new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        
        Assert.assertEquals(book, loan.getBook());
        Assert.assertEquals(member, loan.getMember());
        Assert.assertFalse(loan.isOverdue());
    }

    @Test
    public void testIsOverdue() {
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        Member member = new Member("1001", "John Doe");
        Loan loan = new Loan(book, member, LocalDate.now().minusDays(16), LocalDate.now().minusDays(1));
        
        Assert.assertTrue(loan.isOverdue());
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
        member.setMaxLoanLimit(2);  // assuming max loan limit is 2 for testing
        Book book1 = new Book("12345", "Book One", "Author Name", 5);
        Book book2 = new Book("67890", "Book Two", "Author Name", 5);
        Book book3 = new Book("11223", "Book Three", "Author Name", 5);
        
        member.borrowBook(book1);
        member.borrowBook(book2);

        Assert.assertThrows(IllegalStateException.class, () -> {
            member.borrowBook(book3);  // should fail since max limit is reached
        });
    }

    @Test
    public void testReturnBook() {
        Member member = new Member("1001", "John Doe");
        Book book = new Book("12345", "Test Book", "Author Name", 5);
        member.borrowBook(book);
        member.returnBook(book);
        Assert.assertEquals(0, member.getBorrowedBooks().size());
    }
    // end MemberTest.java
}
