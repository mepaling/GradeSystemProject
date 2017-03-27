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
		 * ��������JQ�Ӹ��X�j��A�H�K���զU��method
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
		 * UI()�|�غcaGradeSystem,�ҥH����Onull
		 */
		assertNotNull(aUI.aGradeSystem);
	}

	@Test
	public void testCheckID() {
		/*
		 * checkID�����G���өMcontainsID���G�ۦP
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
		 * ������J�����G���Ӹ�w���ۦP
		 */
		String expected = "962001044";
		System.setIn(new ByteArrayInputStream(expected.getBytes()));
		aUI.promptID();
		assertEquals(expected, aUI.id);
	}

	@Test
	public void testPromptCommand() {
		/*
		 * ������J�����G���Ӹ�w���ۦP
		 */
		String expected = "G";
		System.setIn(new ByteArrayInputStream(expected.getBytes()));
		aUI.promptCommand();
		assertEquals(expected, aUI.command);
	}

	@Test
	public void testShowWelcomeMsg() {
		/*
		 * ������X�����G���Ӹ�w���ۦP
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
		 * ������X�����G���Ӹ�w���ۦP
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
