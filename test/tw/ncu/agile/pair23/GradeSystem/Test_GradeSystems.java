package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*******************************************************************************
test case (gradeInput_less.txt): for case1, case2
ID			name	lab1	lab2	lab3	mid-term	final	total
962001044	凌宗廷	87		86		98		88			87		88(88.3)
962001051	李威廷	81		98		84		90			93		91(90.5)

test case (gradeInput_full.txt): for case3, case4 (first and last record in gradeInput_full.txt)
ID			name	lab1	lab2	lab3	mid-term	final	total
955002056	許文馨	88		92		88		98			91		93(92.6)
995002901	舒晨馨	82		90		85		84			93		88(88.1)

weights = {0.1, 0.1, 0.1, 0.3, 0.4}
expectedOutput:
"0.1 0.1 0.1 0.3 0.4\n962001044 凌宗廷 87 86 98 88 87 88\n962001051 李威廷 81 98 84 90 93 91\n"
"0.1 0.1 0.1 0.3 0.4\n955002056 許文馨 88 92 88 98 91 93\n995002901 舒晨馨 82 90 85 84 93 88\n"
********************************************************************************/

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
	
	private GradeSystems aGradeSystems, bGradeSystems;
	private static Grades case1, case2, case3, case4;
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
		
		bGradeSystems = new GradeSystems();
		//first Grade in gradeInput_full.txt
		case3 = new Grades("955002056", "許文馨", 88, 92, 88, 98, 91);
		//last Grade in gradeInput_full.txt
		case4 = new Grades("995002901", "舒晨馨", 82, 90, 85, 84, 93);
		
		weights = new Double[]{0.1, 0.1, 0.1, 0.3, 0.4};
		
		case1.calculateTotalGrade(weights);
		case2.calculateTotalGrade(weights);
		case3.calculateTotalGrade(weights);
		case4.calculateTotalGrade(weights);
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystems = null;
		bGradeSystems = null;
		case1 = null;
		case2 = null;
		case3 = null;
		case4 = null;
		weights = null;
	}

	@Test
	public void testGradeSystems() {
		/* 
		 * Public testGradeSystems()
		 * 	Check constructor GradeSystems(String fileName),
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
	
	@Test
	public void testGradeSystems2() {
		/* 
		 * Public testGradeSystems2()
		 * 	Check constructor GradeSystems(),
		 *	and if bGradeSystems has correct data as cases mentioned
		 *  First get expected string by hand adding (weights and grades string)
		 *  gradeInput_full.txt first and last record as case3 & case4
		 * 	Then get actual string by getting the element(Use LinkedList.getFirst() & LinkedList.getLast())
		 *	convert to string to check its correctness
		 * End testGradeSystems()
		 */
		String expected = doubleArray2String(weights) + "\n" + case3.toString() + "\n" + case4.toString() + "\n";	
		LinkedList<Grades> actualList = bGradeSystems.getGradesList();
		String actual = doubleArray2String(bGradeSystems.getWeights()) + "\n";
		actual += actualList.getFirst().toString() + "\n" + actualList.getLast().toString()+ "\n";
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