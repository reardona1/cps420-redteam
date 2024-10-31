package tests;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    /*
    @Test
    public void newBookNoISBNTest() {
        Book book1 = new Book("Test Book", "Red Team", null, 100);
        
        Assert.assertNull("ISBN should be null", book1.getIsbn());
    }
    */
   
    @Test
    public void failingTest() {
        Assert.assertEquals("This should fail", "expected", "actual");
    }
    
}