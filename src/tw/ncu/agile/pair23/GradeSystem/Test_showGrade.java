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
test case:
weights = {0.1, 0.1, 0.1, 0.3, 0.4}
#		ID			name	lab1	lab2	lab3	mid-term	final	total
case1	962001044	��v��	87		86		98		88			87		88(88.3)
expectedOutput:
"��v�ʦ��Z�Glab1:\t87\nlab2:\t86\nlab3:\t98\nmid-term:\t88\nfinal exam:\t87\ntotal grade:\t88\r\n"

case2	962001051	���§�	81		98		84		90			93		91(90.5)
expectedOutput:
"���§ʦ��Z�Glab1:\t81\nlab2:\t98\nlab3:\t84\nmid-term:\t90\nfinal exam:\t93\ntotal grade:\t91\r\n"
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
		aGradeSystems = new GradeSystems();
		case1 = new Grades("962001044", "��v��", 87, 86, 98, 88, 87);
		case2 = new Grades("962001051", "���§�", 81, 98, 84, 90, 93);
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
		
		//�`�N System.out.println() �O�R�X "\r\n" �ӫD "\n"
		String expected = case1.getName() + "���Z�G" + case1.printGrades() + "\r\n";
		//System.out.print(expected);
		
		//�ϥ� ByteArrayOutputStream ��o ���Ӹ���ܦbConsole���r�� (��System.out����)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showGrade("962001044");
		String actual = opS.toString();
		//�O�o�n��  System �� output ��^ System.out �~��ݨ�r����ܦb console ��
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
		
		//�`�N System.out.println() �O�R�X "\r\n" �ӫD "\n"
		String expected = case2.getName() + "���Z�G" + case2.printGrades() + "\r\n";
		//System.out.print(expected);
		
		//�ϥ� ByteArrayOutputStream ��o ���Ӹ���ܦbConsole���r�� (��System.out����)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showGrade("962001051");
		String actual = opS.toString();
		//�O�o�n��  System �� output ��^ System.out �~��ݨ�r����ܦb console ��
		System.setOut(sysOut);
		
		assertEquals(expected, actual);
	}

}
