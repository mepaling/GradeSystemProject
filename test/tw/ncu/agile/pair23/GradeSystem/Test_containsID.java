package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*******************************************************************************
test case (gradeInput_less.txt):
#	ID			ExpectedOutput
id1	962001044	true
id2	962001051	true
id3	105522000	false
*******************************************************************************/

public class Test_containsID {
	
	/*
	 * Public class Test_containsID
	 *  Variables:
	 *  	private GradeSystems aGradeSystems
	 *  	static String id1, id2, id3
	 *  Methods:
	 * 		public void testContainsID()
	 * 		public void testContainsID2()
	 * 		public void testContainsID3()
	 * End class Test_containsID
	 */
	
	private GradeSystems aGradeSystems;
	static String id1 = "962001044";
	static String id2 = "962001051";
	static String id3 = "105522000";

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
	public void testContainsID() {
		/* 
		 * Public testContainsID()
		 * 	Check GradeSystems.containsID(id)
		 *  Check if aGradeSystems actually has this id(962001044)
		 *  must return TRUE
		 * End testContainsID()
		 */
		boolean actual = aGradeSystems.containsID(id1);
		assertEquals(true, actual);
	}
	
	@Test
	public void testContainsID2() {
		/* 
		 * Public testContainsID2()
		 * 	Check GradeSystems.containsID(id)
		 *  Check if aGradeSystems actually has this id(962001051)
		 *  must return TRUE
		 * End testContainsID2()
		 */
		boolean actual = aGradeSystems.containsID(id2);
		assertEquals(true, actual);
	}
	
	@Test
	public void testContainsID3() {
		/* 
		 * Public testContainsID3()
		 * 	Check GradeSystems.containsID(id)
		 *  Check if aGradeSystems actually don't have this id(105522000)
		 *  must return FALSE
		 * End testContainsID3()
		 */
		boolean actual = aGradeSystems.containsID(id3);
		assertEquals(false, actual);
	}

}