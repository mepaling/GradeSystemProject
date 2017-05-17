package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*******************************************************************************
test case (gradeInput_less.txt):
#		ID			name	lab1	lab2	lab3	mid-term	final	total		rank
case1	962001044	凌宗廷	87		86		98		88			87		88(88.3)	2
expectedOutput:
"凌宗廷排名第2\r\n"
case2	962001051	李威廷	81		98		84		90			93		91(90.5)	1
expectedOutput:
"李威廷排名第1\r\n"
*******************************************************************************/

public class Test_showRank {

	/*
	 * Public class Test_showRank
	 *  Variables:
	 *  	private GradeSystems aGradeSystems;
	 *  Methods:
	 * 		public void testShowRank()
	 * 		public void testShowRank2()
	 * End class Test_showRank
	 */
	
	private GradeSystems aGradeSystems;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aGradeSystems = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystems = null;
	}

	@Test
	public void testShowRank() {

		/*
		 * Public testShowRank()
		 * 	改掉System.out去收本來顯示在console的字, 記得改回來!
		 * 	比對與預期的Rank是否相同
		 * 	凌宗廷 rank=2
		 * End testShowRank()
		 */
		
		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		aGradeSystems.showRank("962001044");
		String actual = opS.toString();
		//記得要把  System 的 output 改回 System.out 才能看到字串顯示在 console 中
		System.setOut(sysOut);
		
		// "\r\n" not "\n"
		String expected = "凌宗廷排名第2\r\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testShowRank2() {
		/*
		 * Public testShowRank2()
		 * 	改掉System.out去收本來顯示在console的字, 記得改回來!
		 * 	比對與預期的Rank是否相同
		 * 	李威廷 rank=1
		 * End testShowRank2()
		 */
		
		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		aGradeSystems.showRank("962001051");
		String actual = opS.toString();
		//記得要把  System 的 output 改回 System.out 才能看到字串顯示在 console 中
		System.setOut(sysOut);

		// "\r\n" not "\n"
		String expected = "李威廷排名第1\r\n";
		assertEquals(expected, actual);
	}

}