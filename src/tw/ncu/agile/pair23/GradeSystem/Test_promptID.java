package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_promptID {/*
Public class Test_promptID
	Variables:
		static UI aUI
		static ByteArrayInputStream in
		static String expected = "962001044";
	Methods:
		public static void setUpBeforeClass()
		public static void tearDownAfterClass()
		public void testUI()
End class Test_promptID
*/
	
	static UI aUI;
	static ByteArrayInputStream in;
	static String expected = "962001044";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {/*
	public static setUpBeforeClass()
		在建構aUI前先模擬輸入Q(quit)，使他跳出loop以便測試
		並且預先模擬輸入預期字串("962001044")
	End setUpBeforeClass
	*/
	
		in = new ByteArrayInputStream(("Q"+"\r\n"+expected).getBytes());
		System.setIn(in);
		aUI = new UI();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {/*
	public static tearDownAfterClass()
		將aUI設為null
	End tearDownAfterClass
	*/
		
		aUI = null;
	}

	@Test
	public void testPromptID() {/*
	public testPromptCommand
		aUI收到的command應該要跟預期字串相同("962001044")
	End testPromptCommand
	*/
		
		aUI.promptID();
		assertEquals(expected, aUI.id);
	}

}
