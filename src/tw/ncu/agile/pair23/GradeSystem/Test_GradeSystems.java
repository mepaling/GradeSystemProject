package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* ---
 * test case (gradeInput_less.txt):
 * ID			name	lab1	lab2	lab3	mid-term	final	total
 * 962001044	­â©v§Ê	87		86		98		88			87		88(88.3)
 * 962001051	§õ«Â§Ê	81		98		84		90			93		91(90.5)
   --- */

public class Test_GradeSystems {
	
	/*
	 * Public class Test_GradeSystems
	 *  Variables:
	 *  	private GradeSystems aGradeSystems;
	 *  	private static Grades case1, case2;
	 *  	private static Double[] weights;
	 *  Methods:
	 * 		public void testGradeSystems()
	 * End class Test_GradeSystems
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
		case1 = new Grades("962001044", "­â©v§Ê", 87, 86, 98, 88, 87);
		case2 = new Grades("962001051", "§õ«Â§Ê", 81, 98, 84, 90, 93);
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
	public void testGradeSystems() {
		/* 
		 * Public testGradeSystems()
		 * 	Check constructor GradeSystems(),
		 *	and if aGradeSystems has correct data as cases mentioned
		 *  First get expected string by hand adding (weights and grades string)
		 * 	Then get actual string by getting the element
		 *  (i.e. aGradeSystems.weights & aGradeSystems.gradeList)
		 *	convert to string to check its correctness
		 * End testGradeSystems()
		 */
		String expected = doubleArray2String(weights) + "\n" + case1.toString() + "\n" + case2.toString() + "\n";	
		LinkedList<Grades> actualList = aGradeSystems.getGradesList();
		String actual = doubleArray2String(aGradeSystems.getWeights()) + "\n";
		for (Grades grades : actualList) {
			actual += grades.toString() + "\n";
		}
		assertEquals(expected, actual);
		
	}
	
	String doubleArray2String(Double[] aDoubles) {
		/*
		 * Use string to save the information in the aDoubles array
		 */
		String ret = "";
		for (Double ele : aDoubles) {
			ret += ele + " ";
		}
		// delete the whitespace which is at last character
		return ret.substring(0, ret.length()-1);
	}

}
