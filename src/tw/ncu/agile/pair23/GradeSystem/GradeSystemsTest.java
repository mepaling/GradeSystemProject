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

/*
 * test case (gradeInput_less.txt):
 * 962001044 凌宗廷 87 86 98 88 87 -> 88.3, 89.2
 * 962001051 李威廷 81 98 84 90 93 -> 90.5, 89.2
 * weights = {0.1, 0.1, 0.1, 0.3, 0.4}
 * newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
 */

public class GradeSystemsTest {
	GradeSystems aGradeSystems;
	static Grades grades1;
	static Grades grades2;
	Double[] oldWeights = {0.1, 0.1, 0.1, 0.3, 0.4};
	Double[] newWeights = {0.2, 0.2, 0.2, 0.2, 0.2};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		grades1 = new Grades("962001044", "凌宗廷", 87, 86, 98, 88, 87);
		grades2 = new Grades("962001051", "李威廷", 81, 98, 84, 90, 93);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		grades1 = null;
		grades2 = null;
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
	public void testGradeSystems() {
		//應該要有東西而非null
		assertNotNull("aGradeSystems should be created!", aGradeSystems);
	}

	@Test
	public void testContainsID_NO() {
		assertFalse(aGradeSystems.containsID("105522000"));
	}
	
	@Test
	public void testContainsID_YES() {
		assertTrue(aGradeSystems.containsID("962001044"));
	}

	@Test
	public void testShowGrade() {
		grades1.calculateTotalGrade(oldWeights);
		//注意 System.out.println() 是吐出 "\r\n" 而非 "\n"
		String expected = grades1.name + "成績：" + grades1.toString() + "\r\n";

		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showGrade("962001044");
		String actual = opS.toString();
		//記得要把  System 的 output 改回 System.out 才能看到字串顯示在 console 中
		System.setOut(sysOut);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testShowRank() {
		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		aGradeSystems.showRank("962001044");
		String actual = opS.toString();
		//記得要把  System 的 output 改回 System.out 才能看到字串顯示在 console 中
		System.setOut(sysOut);
		
		String expected = "凌宗廷排名第2\r\n";
		assertEquals(expected, actual);
		
	}
	
	//調權重為 newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
	@Test
	public void testShowRank2() {
		//利用 ByteArrayInputStream 模擬 System.in (鍵盤的輸入動作)
		ByteArrayInputStream in = new ByteArrayInputStream("20\n20\n20\n20\n20\nY\n".getBytes());
		System.setIn(in);
		aGradeSystems.updateWeights();
		//最後記得把 System 的 input 改回 System.in
		System.setIn(System.in);
		
		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showRank("962001044");
		String actual = opS.toString();
		//一樣記得要把  System 的 output 改回 System.out
		System.setOut(sysOut);
		
		String expected = "凌宗廷排名第1\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateWeights() {
		//利用 ByteArrayInputStream 模擬 System.in (鍵盤的輸入動作)
		ByteArrayInputStream in = new ByteArrayInputStream("20\n20\n20\n20\n20\nY\n".getBytes());
		System.setIn(in);

		//Do something you need here
		aGradeSystems.updateWeights();

		//最後記得把 System 的 input 改回 System.in
		System.setIn(System.in);
		
		Double[] actual = aGradeSystems.weights;
		boolean ans = true;
		for (int i=0; i<5; i++) {
			if (!newWeights[i].equals(actual[i])) {
				ans = false;
				break;
			}
		}
		assertTrue(ans);
	}

}
