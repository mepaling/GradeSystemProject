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
 * 962001044 ��v�� 87 86 98 88 87 -> 88.3, 89.2
 * 962001051 ���§� 81 98 84 90 93 -> 90.5, 89.2
 * weights = {0.1, 0.1, 0.1, 0.3, 0.4}
 * newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
 */

public class GradeSystemsTest {
	/*
	 * Public class GradeSystemsTest
	 * 	Variables:
	 * 	GradeSystems aGradeSystems
	 * 	static Grades grades1, grades2
	 * 	Double[] oldWeights = {0.1, 0.1, 0.1, 0.3, 0.4}
	 * 	Double[] newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
	 * 	Functions:
	 *	public void testGradeSystems()
	 * 	public void testContainsID_NO()
	 *	public void testContainsID_YES()
	 * 	public void testShowGrade()
	 * 	public void testShowRank()
	 * 	public void testShowRank2()
	 * 	public void testUpdateWeights()
	 * End class GradeSystemsTest
	 */
	GradeSystems aGradeSystems;
	static Grades grades1, grades2;
	Double[] oldWeights = {0.1, 0.1, 0.1, 0.3, 0.4};
	Double[] newWeights = {0.2, 0.2, 0.2, 0.2, 0.2};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		grades1 = new Grades("962001044", "��v��", 87, 86, 98, 88, 87);
		grades2 = new Grades("962001051", "���§�", 81, 98, 84, 90, 93);
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
		/*
		 * Public testGradeSystems()
		 * 	�غcaGradeSystems
		 * 	���ӭn���F��ӫDnull
		 * End testGradeSystems()
		 */
		assertNotNull("aGradeSystems should be created!", aGradeSystems);
	}

	@Test
	public void testContainsID_NO() {
		/*
		 * Public testContainsID_NO()
		 * 	�����ӭn�� "105522000" �o��ID, �ҥH�OFalse
		 * End testContainsID_NO()
		 */
		assertFalse(aGradeSystems.containsID("105522000"));
	}
	
	@Test
	public void testContainsID_YES() {
		/*
		 * Public testContainsID_YES()
		 * 	���ӭn�� "962001044" �o��ID, �ҥH�OTrue
		 * End testContainsID_YES()
		 */
		assertTrue(aGradeSystems.containsID("962001044"));
	}

	@Test
	public void testShowGrade() {
		/*
		 * Public testShowGrade()
		 * 	�ﱼSystem.out�h��������ܦbconsole���r, �O�o��^��!
		 * 	���P�w����Grade(���)�O�_�ۦP
		 * End testShowGrade()
		 */
		grades1.calculateTotalGrade(oldWeights);
		//�`�N System.out.println() �O�R�X "\r\n" �ӫD "\n"
		String expected = grades1.getName() + "���Z�G" + grades1.printGrades() + "\r\n";

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
	public void testShowRank() {
		/*
		 * Public testShowRank()
		 * 	�ﱼSystem.out�h��������ܦbconsole���r, �O�o��^��!
		 * 	���P�w����Rank�O�_�ۦP
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
		
		String expected = "��v�ʱƦW��2\r\n";
		assertEquals(expected, actual);
		
	}
	
	//���v���� newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
	@Test
	public void testShowRank2() {
		/*
		 * Public testShowRank2()
		 * 	�N�v���令 {0.2, 0.2, 0.2, 0.2, 0.2}
		 * 	���P�w����Rank�O�_�ۦP
		 * End testShowRank2()
		 */
		//�Q�� ByteArrayInputStream ���� System.in (��L����J�ʧ@)
		ByteArrayInputStream in = new ByteArrayInputStream("20\n20\n20\n20\n20\nY\n".getBytes());
		System.setIn(in);
		aGradeSystems.updateWeights();
		//�̫�O�o�� System �� input ��^ System.in
		System.setIn(System.in);
		
		//�ϥ� ByteArrayOutputStream ��o ���Ӹ���ܦbConsole���r�� (��System.out����)
		ByteArrayOutputStream opS = new ByteArrayOutputStream();
		PrintStream myOut = new PrintStream(opS);
		PrintStream sysOut = System.out;
		System.setOut(myOut);
		//Do something you need here
		aGradeSystems.showRank("962001044");
		String actual = opS.toString();
		//�@�˰O�o�n��  System �� output ��^ System.out
		System.setOut(sysOut);
		
		String expected = "��v�ʱƦW��1\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateWeights() {
		/*
		 * Public testUpdateWeights()
		 * 	�N�v���令 {0.2, 0.2, 0.2, 0.2, 0.2}
		 * 	�A�h�ݦ��S���令�\ (�ק�System.in & System.out)
		 * End testUpdateWeights()
		 */
		
		//�Q�� ByteArrayInputStream ���� System.in (��L����J�ʧ@)
		ByteArrayInputStream in = new ByteArrayInputStream("20\n20\n20\n20\n20\nY\n".getBytes());
		System.setIn(in);

		//Do something you need here
		aGradeSystems.updateWeights();

		//�̫�O�o�� System �� input ��^ System.in
		System.setIn(System.in);
		
		Double[] actual = aGradeSystems.getWeights();
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
