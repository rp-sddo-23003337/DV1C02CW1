/**
 * 
 */
package com.sddo.dv1c02.cw1.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Admin1
 *
 */
class BookTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getBookID()}.
	 */
	@Test
	void testGetBookID() {
		//fail("Not yet implemented");
		
		// create a new Book object
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		// make sure the book id is 'id 1'
		assertTrue(b.getBookID().equals("id 1"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setBookID(java.lang.String)}.
	 */
	@Test
	void testSetBookID() {
		//fail("Not yet implemented");
		
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setBookID("id 2");
		
		assertTrue(b.getBookID().equals("id 2"));
		
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getTitle()}.
	 */
	@Test
	void testGetTitle() {
		//fail("Not yet implemented");
		
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		assertTrue(b.getTitle().equals("title 1"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setTitle(java.lang.String)}.
	 */
	@Test
	void testSetTitle() {
		//fail("Not yet implemented");
		
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setTitle("title 2");
		
		assertTrue(b.getTitle().equals("title 2"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getAuthor()}.
	 */
	@Test
	void testGetAuthor() {
		//fail("Not yet implemented");
		
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		assertTrue(b.getAuthor().equals("author 1"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setAuthor(java.lang.String)}.
	 */
	@Test
	void testSetAuthor() {
		//fail("Not yet implemented");
		
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setAuthor("author 2");
		
		assertTrue(b.getAuthor().equals("author 2"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getISBN()}.
	 */
	@Test
	void testGetISBN() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		assertTrue(b.getISBN().equals("ISBN 1"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setISBN(java.lang.String)}.
	 */
	@Test
	void testSetISBN() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setISBN("ISBN 2");
		
		assertTrue(b.getISBN().equals("ISBN 2"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getPrice()}.
	 */
	@Test
	void testGetPrice() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		assertEquals(b.getPrice(), (float)9.99);
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setPrice(float)}.
	 */
	@Test
	void testSetPrice() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setPrice((float)8.88);
		
		assertEquals(b.getPrice(), (float)8.88);
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#getCategory()}.
	 */
	@Test
	void testGetCategory() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		
		assertTrue(b.getCategory().equals("category 1"));
	}

	/**
	 * Test method for {@link com.sddo.dv1c02.cw1.dto.Book#setCategory(java.lang.String)}.
	 */
	@Test
	void testSetCategory() {
		//fail("Not yet implemented");
		Book b = new Book("id 1", "title 1", "author 1", "ISBN 1", (float)9.99, "category 1");
		b.setCategory("category 2");
		
		assertTrue(b.getCategory().equals("category 2"));
	}

}