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
case1	962001044	��v��	87		86		98		88			87		88(88.3)	2
expectedOutput:
"��v�ʱƦW��2\r\n"

case2	962001051	���§�	81		98		84		90			93		91(90.5)	1
expectedOutput:
"���§ʱƦW��1\r\n"
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
		 * 	�ﱼSystem.out�h��������ܦbconsole���r, �O�o��^��!
		 * 	���P�w����Rank�O�_�ۦP
		 * 	��v�� rank=2
		 * End testShowRank()
		 */
		
		//�ϥ� ByteArrayOutputStream ��o ���Ӹ���ܦbConsole���r�� (��System.out����)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		aGradeSystems.showRank("962001044");
		String actual = opS.toString();
		//�O�o�n��  System �� output ��^ System.out �~��ݨ�r����ܦb console ��
		System.setOut(sysOut);
		
		// "\r\n" not "\n"
		String expected = "��v�ʱƦW��2\r\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testShowRank2() {
		/*
		 * Public testShowRank2()
		 * 	�ﱼSystem.out�h��������ܦbconsole���r, �O�o��^��!
		 * 	���P�w����Rank�O�_�ۦP
		 * 	���§� rank=1
		 * End testShowRank2()
		 */
		
		//�ϥ� ByteArrayOutputStream ��o ���Ӹ���ܦbConsole���r�� (��System.out����)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		aGradeSystems.showRank("962001051");
		String actual = opS.toString();
		//�O�o�n��  System �� output ��^ System.out �~��ݨ�r����ܦb console ��
		System.setOut(sysOut);

		// "\r\n" not "\n"
		String expected = "���§ʱƦW��1\r\n";
		assertEquals(expected, actual);
	}

}
