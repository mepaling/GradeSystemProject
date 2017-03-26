package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UITest {
	UI aUI;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aUI = new UI();
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
	}

	@Test
	public void testUI() {
		assertNotNull(aUI.aGradeSystem);
	}

	@Test
	public void testCheckID() {

	}

	@Test
	public void testPromptID() {

	}

	@Test
	public void testPromptCommand() {

	}

	@Test
	public void testShowWelcomeMsg() {

	}

	@Test
	public void testShowFinishMsg() {

	}
}
