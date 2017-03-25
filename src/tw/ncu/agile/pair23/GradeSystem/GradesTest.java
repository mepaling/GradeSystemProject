package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * test case:
 * ID name lab1 lab2 lab3 mid-term final
 * 105522000 C8763 94 87 94 66 98 -> 86.5 -> 87
 * weights = {0.1, 0.1, 0.1, 0.3, 0.4};
 */

public class GradesTest {
	private Grades aGrades;
	private Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aGrades = new Grades("105522000", "C8763", 94, 87, 94, 66, 98);
	}

	@After
	public void tearDown() throws Exception {
		aGrades = null;
	}
	
	/*
	 * The variable aGrades is creates by another constructor
	 * Create another variable to test its function
	 */
	@Test
	public void testGrades() {
		Grades bGrades = new Grades();
		assertNotNull("bGrades should be created!", bGrades);
	}
	
	@Test
	public void testGradesStringStringIntIntIntIntInt() {
		assertNotNull("aGrades should be created!", aGrades);
	}

	@Test
	public void testCalculateTotalGrade() {
		double total_hand_cal_double = aGrades.lab1*weights[0] + aGrades.lab2*weights[1]+ 
				aGrades.lab3*weights[2]+ aGrades.midTerm*weights[3] +
				aGrades.finalExam*weights[4];
		int total_hand_cal_int = aGrades.DoubleRoundToInteger(total_hand_cal_double);
		aGrades.calculateTotalGrade(weights);
		assertEquals(total_hand_cal_int, aGrades.totalGrade);
	}
	
	//複寫 object 的 toString method
	@Test
	public void testToString() {
		String s = "lab1:\t" + aGrades.lab1 + "\nlab2:\t" + aGrades.lab2 + "\nlab3:\t" + aGrades.lab3 + 
				"\nmid-term:\t" + aGrades.midTerm + "\nfinal exam:\t" + aGrades.finalExam +
				"\ntotal grade:\t" + aGrades.totalGrade;
		assertEquals(s, aGrades.toString());
	}
	
	//四捨五入到整數位 - 進位
	@Test
	public void testDoubleRoundToInteger1() {
		int test1_int = aGrades.DoubleRoundToInteger(94.87);
		int expected = 95;
		assertEquals(expected, test1_int);	
	}
	
	//四捨五入到整數位 - 捨去
	@Test
	public void testDoubleRoundToInteger2() {
		int test1_int = aGrades.DoubleRoundToInteger(94.47);
		int expected = 94;
		assertEquals(expected, test1_int);	
	}
	
	//四捨五入到整數位 - 捨去2
	@Test
	public void testDoubleRoundToInteger3() {
		int test1_int = aGrades.DoubleRoundToInteger(87.087);
		int expected = 87;
		assertEquals(expected, test1_int);	
	}

}
