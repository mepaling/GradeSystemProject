package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*******************************************************************************
test case (gradeInput_less.txt):
ID			name	lab1	lab2	lab3	mid-term	final	total
962001044	凌宗廷	87		86		98		88			87		88(88.3)
962001051	李威廷	81		98		84		90			93		91(90.5)
oldWeights = {0.1, 0.1, 0.1, 0.3, 0.4}
newWeights = {0.2, 0.2, 0.2, 0.2, 0.2}
expectedOutput:
true (i.e. aGradeSystems.getWeights == newWeights)
*******************************************************************************/

public class Test_updateWeights {
	
	/*
	 * Public class Test_updateWeights
	 *  Variables:
	 *  	private GradeSystems aGradeSystems;
	 *  	private Grades case1, case2;
	 *  	private Double[] oldWeights, newWeights;
	 *  Methods:
	 * 		public void testUpdateWeights()
	 * End class Test_updateWeights
	 */
	
	private GradeSystems aGradeSystems;
	private Grades case1, case2;
	private Double[] oldWeights, newWeights;

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
		oldWeights = new Double[]{0.1, 0.1, 0.1, 0.3, 0.4};
		case1.calculateTotalGrade(oldWeights);
		case2.calculateTotalGrade(oldWeights);
		newWeights = new Double[]{0.2, 0.2, 0.2, 0.2, 0.2};
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystems = null;
		case1 = null;
		case2 = null;
		oldWeights = null;
		newWeights = null;
	}

	@Test
	public void testUpdateWeights() {
		/*
		 * Public testUpdateWeights()
		 *	利用 ByteArrayInputStream 模擬 System.in (鍵盤的輸入動作)
		 * 	將權重改成 {0.2, 0.2, 0.2, 0.2, 0.2}
		 * 	利用 aGradeSystems 的 getWeights() 取得現在的分數權重
		 * 	用迴圈跑 並確定裡面的值(元素)是正確的
		 * End testUpdateWeights()
		 */
		
		//利用 ByteArrayInputStream 模擬 System.in (鍵盤的輸入動作)
		ByteArrayInputStream in = new ByteArrayInputStream("20\n20\n20\n20\n20\nY\n".getBytes());
		System.setIn(in);

		//Do something you need here
		aGradeSystems.updateWeights();

		//最後記得把 System 的 input 改回 System.in
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