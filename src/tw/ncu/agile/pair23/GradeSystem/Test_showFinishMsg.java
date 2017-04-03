package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_showFinishMsg {/*
Public class Test_showFinishMsg
	Variables:
		static UI aUI
		static ByteArrayInputStream in
	Methods:
		public static void setUpBeforeClass()
		public static void tearDownAfterClass()
		public void testShowFinishMsg()
End class Test_showFinishMsg
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
	public void testShowFinishMsg() {/*
	public testShowFinishMsg
		�w������X����"End"
	End testShowFinishMsg
	*/
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		aUI.showFinishMsg();
		System.out.flush();
		System.setOut(old);
		String expected = "End\r\n";
		String actual = baos.toString();
		assertEquals(expected, actual);
	}

}
