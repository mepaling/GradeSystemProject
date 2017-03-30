package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* ---
 * test case:
 * ID			name	lab1	lab2	lab3	mid-term	final	total
 * 105522000	C8763	94		87		94		66			98 		86.5 -> 87
 * weights = {0.1, 0.1, 0.1, 0.3, 0.4};
   --- */

public class Test_calculateTotalGrade {
	
	/*
	 * Public class Test_calculateTotalGrade
	 *  Variables:
	 *  	private Grades aGrades
	 *  	static String ID, Name
	 *  	static int Lab1, Lab2, Lab3, Midterm, finalExam, totalGrade
	 *  Methods:
	 * 		public void testCalculateTotalGrade()
	 * End class Test_calculateTotalGrade
	 */
	
	private Grades aGrades;
	static String ID = "105522000", Name = "C8763";
	static int Lab1 = 94, Lab2 = 87, Lab3 = 94,
				MidTerm = 66, finalExam = 98;
	Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aGrades = new Grades(ID, Name, Lab1, Lab2, Lab3, MidTerm, finalExam);
	}

	@After
	public void tearDown() throws Exception {
		aGrades = null;
	}

	@Test
	public void testCalculateTotalGrade() {
		/* 
		 * Public testCalculateTotalGrade()
		 * 	Check Grades.calculateTotalGrade(Double[] weights) is correctly calculated
		 *  Call aGrades.calculateTotalGrade(weights)
		 * 	Count by hand, then use BigDecimal.setScale to round Double, finally convert back to Integer
		 * 	Compare two value, must be equal
		 * End testCalculateTotalGrade()
		 */
		aGrades.calculateTotalGrade(weights);
		int actual = aGrades.getTotalGrade();
		
		Double totalGradeD = Lab1*weights[0] + Lab2*weights[1] + Lab3*weights[2] +
							 MidTerm*weights[3] + finalExam*weights[4];
		BigDecimal aBigDecimal = new BigDecimal(totalGradeD.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int expected = Integer.parseInt(aBigDecimal.toString());
		
		
		assertEquals(expected, actual);
	}

}
