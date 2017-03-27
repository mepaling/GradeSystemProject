package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UITest {
	static UI aUI;
	static ByteArrayInputStream in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/*
		 * 先模擬輸入Q來跳出迴圈，以便測試各個method
		 */
		in = new ByteArrayInputStream("Q".getBytes());
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
	public void testUI() {
		/*
		 * UI()會建構aGradeSystem,所以不能是null
		 */
		assertNotNull(aUI.aGradeSystem);
	}

	@Test
	public void testCheckID() {
		/*
		 * checkID的結果應該和containsID結果相同
		 */
		String id;
		id = "962001044";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
		id = "000000000";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
	}

	@Test
	public void testPromptID() {
		/*
		 * 模擬輸入的結果應該跟預期相同
		 */
		String expected = "962001044";
		System.setIn(new ByteArrayInputStream(expected.getBytes()));
		aUI.promptID();
		assertEquals(expected, aUI.id);
	}

	@Test
	public void testPromptCommand() {
		/*
		 * 模擬輸入的結果應該跟預期相同
		 */
		String expected = "G";
		System.setIn(new ByteArrayInputStream(expected.getBytes()));
		aUI.promptCommand();
		assertEquals(expected, aUI.command);
	}

	@Test
	public void testShowWelcomeMsg() {
		/*
		 * 模擬輸出的結果應該跟預期相同
		 */
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		aUI.showWelcomeMsg();
		System.out.flush();
		System.setOut(old);
		String expected = "Welcome\r\n";
		String actual = baos.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testShowFinishMsg() {
		/*
		 * 模擬輸出的結果應該跟預期相同
		 */
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		aUI.showFinishMsg();
		System.out.flush();
		System.setOut(old);
		String expected = "End\r\n";
		String actual = baos.toString();
		assertEquals(expected, actual);
	}
}
