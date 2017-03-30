package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_promptCommand {
	static UI aUI;
	static ByteArrayInputStream in;
	static String expected = "G";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		in = new ByteArrayInputStream(("Q"+"\r\n"+expected).getBytes());
		System.setIn(in);
		aUI = new UI();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		aUI = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPromptCommand() {
		aUI.promptCommand();
		assertEquals(expected, aUI.command);
	}

}
