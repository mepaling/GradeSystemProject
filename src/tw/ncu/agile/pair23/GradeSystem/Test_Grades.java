package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* ---
 * test case:
 * ID			name	lab1	lab2	lab3	mid-term	final
 * 105522000	C8763	94		87		94		66			98
   --- */

public class Test_Grades {

	/*
	 * Public class Test_Grades
	 *  Variables:
	 *  	private Grades aGrades
	 *  	static String ID, Name
	 *  	static int Lab1, Lab2, Lab3, Midterm, finalExam, totalGrade
	 *  Methods:
	 * 		public void testGrades()
	 * End class Test_Grades
	 */
	
	private Grades aGrades;
	static String ID = "105522000", Name = "C8763";
	static int Lab1 = 94, Lab2 = 87, Lab3 = 94,
				MidTerm = 66, finalExam = 98, totalGrade = 0;

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
	public void testGrades() {
		/* 
		 * Public testGrades()
		 * 	Check aGrades is correctly constructed in setUp method
		 *  convert to string by getter method 
		 *  then check info in aGrades's correctness
		 * End testGrades()
		 */
		String actual = aGrades.getID() + " " + aGrades.getName() + " " +
						aGrades.getLab1() + " " + aGrades.getLab2() + " " + aGrades.getLab3() + " " +
						aGrades.getMidterm() + " " + aGrades.getfinalExam() + " " + aGrades.getTotalGrade();
		String expected = ID + " " + Name + " " +
						  Lab1 + " " + Lab2 + " " + Lab3 + " " +
						  MidTerm + " " + finalExam + " " + totalGrade;
		assertEquals(expected, actual);
	}
}
