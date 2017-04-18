package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** ----------------------------------------------------------------------------------------------------------------------
ID: 962001044 name: ��v��
ID: 962001051 name: ���§�
------------------------------------------------------------------------------------------------------------------------- */

public class Test_showWelcomeMsg {/*
Public class Test_showWelcomeMsg
	Variables:
		static UI aUI
		static ByteArrayInputStream in
	Methods:
		public static void setUpBeforeClass()
		public static void tearDownAfterClass()
		public void testShowWelcomeMsg1()
End class Test_showWelcomeMsg
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
	public void testShowWelcomeMsg1() {/*
	public testShowWelcomeMsg1
		��X���ӭn��w���ۦP
	End testShowWelcomeMsg1
	*/
		
		aUI.checkID("962001051");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		aUI.showWelcomeMsg();
		System.out.flush();
		System.setOut(old);
		String expected = "Welcome ��v��\r\n";
		String actual = baos.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testShowWelcomeMsg2() {/*
	public testShowWelcomeMsg2
		��X���ӭn��w���ۦP
	End testShowWelcomeMsg2
	*/
		
		aUI.checkID("962001044");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		aUI.showWelcomeMsg();
		System.out.flush();
		System.setOut(old);
		String expected = "Welcome ���§�\r\n";
		String actual = baos.toString();
		assertEquals(expected, actual);
	}

}
