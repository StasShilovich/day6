package test.shilovich.day6.model.entity;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.entity.CustomBookStorage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.shilovich.day6.creator.TestStorageCreator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class CustomBookStorageTest {
    CustomBookStorage storage;
    CustomBook book;

    @BeforeClass
    public void setUp() {
        storage = new TestStorageCreator().addBooks();
        book = new CustomBook(96942, "Albert Camus", "The Plague",
                1947, new BigDecimal("12.49"));
    }

    @Test
    public void testGetBookPositive() {
        CustomBook actual = storage.getBook(1);
        CustomBook expected = book;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetBookNegative() {
        CustomBook actual = storage.getBook(2);
        CustomBook expected = book;
        assertNotEquals(actual, expected);
    }

    @Test
    public void testSetBookPositive() {
        boolean condition = storage.setBook(book);
        assertTrue(condition);
    }

    @Test
    public void testSetBookNegative() {
        boolean condition = storage.setBook(null);
        assertFalse(condition);
    }

    @Test
    public void testSetBooksPositive() {
        List<CustomBook> books = new ArrayList<>();
        books.add(book);
        boolean condition = storage.setBooks(books);
        assertTrue(condition);
    }

    @Test
    public void testSetBooksNegative() {
        List<CustomBook> books = new ArrayList<>();
        boolean condition = storage.setBooks(books);
        assertFalse(condition);
    }

    @Test
    public void testDeleteBookPositive() {
        boolean condition = storage.deleteBook(1);
        assertTrue(condition);
    }

    @Test
    public void testSizePositive() {
        int actual = storage.size();
        int expected = 10;
        assertEquals(actual, expected);
    }

    @Test
    public void testSizeNegative() {
        int actual = storage.size();
        int expected = 9;
        assertNotEquals(actual, expected);
    }
}
