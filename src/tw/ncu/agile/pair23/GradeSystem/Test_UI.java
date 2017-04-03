package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_UI {/*
Public class Test_UI
	Variables:
		static UI aUI
		static ByteArrayInputStream in
	Methods:
		public static void setUpBeforeClass()
		public static void tearDownAfterClass()
		public void testUI()
End class Test_UI
*/
	
	static UI aUI;
	static ByteArrayInputStream in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {/*
	public static setUpBeforeClass()
		�b�غcaUI�e��������JQ(quit)�A�ϥL���Xloop�H�K����
	End setUpBeforeClass
	*/
	
		in = new ByteArrayInputStream("Q".getBytes());
		System.setIn(in);
		aUI = new UI();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {/*
	public static tearDownAfterClass()
		�NaUI�]��null
	End tearDownAfterClass
	*/
		
		aUI = null;
	}

	@Test
	public void testUI() {/*
	public testUI
		UI()�|�Ы�aGradeSystem�A�ҥHaUI.aGradSystem������null
	End testUI
	*/
		assertNotNull(aUI.aGradeSystem);
	}

}
