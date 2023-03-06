package main.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserModelTest {
    private UserModel user;
    private BookModel book1;
    private BookModel book2;
    private List<BookModel> books;
    @Before
    public void setBook(){
        user = new UserModel(1L, "testUser", "testUser@gmail.com", "shippingAddress", "billingAddress", new ShoppingCartModel(), null);
        book1 = new BookModel(1L, "1234567890", "Book 1", "Description of book 1", "Author 1", "Publisher 1", 20.0f);
        book2 = new BookModel(2L, "0987654321", "Book 2", "Description of book 2", "Author 2", "Publisher 2", 25.0f);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        user.getShoppingCart().setBookList(books);
        user.getShoppingCart().calculateTotalPrice();
    }
    @After
    public void tearDown(){
        book1 = null;
        book2 = null;
        books = null;
        user = null;
    }
    @Test
    public void testUserModel() {
        assertEquals(1L, (long)user.getId());
        assertEquals("testUser", user.getUsername());
        assertEquals("testUser@gmail.com", user.getEmail());
        assertEquals("shippingAddress", user.getShippingAddress());
        assertEquals("billingAddress", user.getBillingAddress());
        assertEquals(45.0, user.getShoppingCart().getPriceBeforeTax(), 0.01);
        assertEquals(50.85, user.getShoppingCart().getPriceAfterTax(), 0.01);
    }
}