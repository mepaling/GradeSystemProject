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
weights = {0.1, 0.1, 0.1, 0.3, 0.4}
#		ID			name	lab1	lab2	lab3	mid-term	final	total
case1	962001044	凌宗廷	87		86		98		88			87		88(88.3)
expectedOutput:
"凌宗廷成績：lab1:\t87\nlab2:\t86\nlab3:\t98\nmid-term:\t88\nfinal exam:\t87\ntotal grade:\t88\r\n"
case2	962001051	李威廷	81		98		84		90			93		91(90.5)
expectedOutput:
"李威廷成績：lab1:\t81\nlab2:\t98\nlab3:\t84\nmid-term:\t90\nfinal exam:\t93\ntotal grade:\t91\r\n"
*******************************************************************************/

public class Test_showGrade {
	
	/*
	 * Public class Test_showGrade
	 *  Variables:
	 *  	private GradeSystems aGradeSystems;
	 *  	private static Grades case1, case2;
	 *  	private static Double[] weights;
	 *  Methods:
	 * 		public void testShowGrade()
	 * 		public void testShowGrade2()
	 * End class Test_showGrade
	 */
	
	private GradeSystems aGradeSystems;
	private static Grades case1, case2;
	private static Double[] weights;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aGradeSystems = new GradeSystems("gradeInput_less.txt");
		case1 = new Grades("962001044", "凌宗廷", 87, 86, 98, 88, 87);
		case2 = new Grades("962001051", "李威廷", 81, 98, 84, 90, 93);
		weights = new Double[]{0.1, 0.1, 0.1, 0.3, 0.4};
		case1.calculateTotalGrade(weights);
		case2.calculateTotalGrade(weights);
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystems = null;
		case1 = null;
		case2 = null;
		weights = null;
	}

	@Test
	public void testShowGrade() {
		/* 
		 * Public testShowGrade()
		 * 	Check GradeSystems.showGrade(id)
		 * 	PS. id = 962001044
		 *  first get expected string by hand
		 *  then change system.out to custom.out to receive string on the console
		 *  call aGradeSystems.showGrade to get the actual string
		 *  finally change custom.out back to system.out
		 * End testShowGrade()
		 */
		
		//注意 System.out.println() 是吐出 "\r\n" 而非 "\n"
		String expected = case1.getName() + "成績：" + case1.printGrades() + "\r\n";
		//System.out.print(expected);
		
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
	public void testShowGrade2() {
		/* 
		 * Public testShowGrade2()
		 * 	Check GradeSystems.showGrade(id) 
		 * 	PS. id = 962001051
		 *  first get expected string by hand
		 *  then change system.out to custom.out to receive string on the console
		 *  call aGradeSystems.showGrade to get the actual string
		 *  finally change custom.out back to system.out
		 * End testShowGrade2()
		 */
		
		//注意 System.out.println() 是吐出 "\r\n" 而非 "\n"
		String expected = case2.getName() + "成績：" + case2.printGrades() + "\r\n";
		//System.out.print(expected);
		
		//使用 ByteArrayOutputStream 獲得 本來該顯示在Console的字串 (把System.out換掉)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showGrade("962001051");
		String actual = opS.toString();
		//記得要把  System 的 output 改回 System.out 才能看到字串顯示在 console 中
		System.setOut(sysOut);
		
		assertEquals(expected, actual);
	}

}