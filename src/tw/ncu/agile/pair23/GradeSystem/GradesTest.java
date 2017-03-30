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
	/*
	 * Public class GradesTest
	 * 	Variables:
	 * 		private Grades aGrades
	 * 		private Double weights = {0.1, 0.1, 0.1, 0.3, 0.4}
	 * 	Functions:
	 * 		public void testGrades()
	 * 		public void testGradesStringStringIntIntIntIntInt()
	 * 		public void testCalculateTotalGrade
	 * 		public void testToString()
	 * 		public void testDoubleRoundToInteger1()
	 * 		public void testDoubleRoundToInteger2()
	 * 		public void testDoubleRoundToInteger3()
	 */
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
	
	@Test
	public void testGrades() {
		/*
		 * public void testGrades()
		 * 	建立另一個 Grades 變數
		 * 	要有東西存在才對
		 * End testGrades()
		 */
		Grades bGrades = new Grades();
		assertNotNull("bGrades should be created!", bGrades);
	}
	
	@Test
	public void testGradesStringStringIntIntIntIntInt() {
		/*
		 * public void testGradesStringStringIntIntIntIntInt()
		 * 	要有東西存在才對
		 * End testGradesStringStringIntIntIntIntInt()
		 */
		assertNotNull("aGrades should be created!", aGrades);
	}

	@Test
	public void testCalculateTotalGrade() {
		/*
		 * public void testCalculateTotalGrade()
		 * 	和手算對比 值要一樣才對
		 * End testCalculateTotalGrade()
		 */
		double total_hand_cal_double = aGrades.getLab1()*weights[0] + aGrades.getLab2()*weights[1]+ 
				aGrades.getLab3()*weights[2]+ aGrades.getMidterm()*weights[3] +
				aGrades.getfinalExam()*weights[4];
		int total_hand_cal_int = aGrades.DoubleRoundToInteger(total_hand_cal_double);
		aGrades.calculateTotalGrade(weights);
		assertEquals(total_hand_cal_int, aGrades.getTotalGrade());
	}
	
	@Test
	public void testPrintGrades() {
		/*
		 * public void testToString()
		 * 	複寫 object 的 toString method
		 * 	和手排版對比 值要一樣才對
		 * End testToString()
		 */
		String s = "lab1:\t" + aGrades.getLab1() + "\nlab2:\t" + aGrades.getLab2() + "\nlab3:\t" + aGrades.getLab3() + 
				"\nmid-term:\t" + aGrades.getMidterm() + "\nfinal exam:\t" + aGrades.getfinalExam() +
				"\ntotal grade:\t" + aGrades.getTotalGrade();
		assertEquals(s, aGrades.printGrades());
	}
	
	@Test
	public void testDoubleRoundToInteger1() {
		/*
		 * public void testDoubleRoundToInteger1()
		 * 	四捨五入到整數位 - 進位
		 * 	和手算版對比 值要一樣才對
		 * End testDoubleRoundToInteger1()
		 */
		int test1_int = aGrades.DoubleRoundToInteger(94.87);
		int expected = 95;
		assertEquals(expected, test1_int);	
	}
	
	@Test
	public void testDoubleRoundToInteger2() {
		/*
		 * public void testDoubleRoundToInteger2()
		 * 	四捨五入到整數位 - 捨去
		 * 	和手算版對比 值要一樣才對
		 * End testDoubleRoundToInteger2()
		 */
		int test1_int = aGrades.DoubleRoundToInteger(94.47);
		int expected = 94;
		assertEquals(expected, test1_int);	
	}
	
	@Test
	public void testDoubleRoundToInteger3() {
		/*
		 * public void testDoubleRoundToInteger3()
		 * 	四捨五入到整數位 - 捨去
		 * 	和手算版對比 值要一樣才對
		 * End testDoubleRoundToInteger3()
		 */
		int test1_int = aGrades.DoubleRoundToInteger(87.087);
		int expected = 87;
		assertEquals(expected, test1_int);	
	}

}
