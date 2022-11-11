package businessLogicsTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import businessLogics.PublisherBL;
import javaBeans.Publisher;

public class TestBublisherBL {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetPublishers() {
		List<Publisher> ds = PublisherBL.getPublishers();
		assertNotNull(ds);
	}
	
	@Test
	public void testThemPublisher() {
		PublisherBL.them(new Publisher("aaaaa"));
		
	}
	@Test 
	public void testEditPublisher() {
		Publisher p = PublisherBL.getPublisher(7);
		p.setPublisherName("Quoc Bao");
		PublisherBL.sua(p);
		Publisher NewP = PublisherBL.getPublisher(7);
		assertTrue(NewP.getPublisherName().equals("Quoc Bao"));
	}
}
