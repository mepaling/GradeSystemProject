package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** ----------------------------------------------------------------------------------------------------------------------
ID: 962001044 name: 凌宗廷
ID: 962001051 name: 李威廷
------------------------------------------------------------------------------------------------------------------------- */

public class Test_checkID {/*
Public class Test_checkID
	Variables:
		static UI aUI
		static ByteArrayInputStream in
		String id
	Methods:
		public static void setUpBeforeClass()
		public static void tearDownAfterClass()
		public void testCheckID1()
		public void testCheckID2()
End class Test_checkID
*/
	
	static UI aUI;
	static ByteArrayInputStream in;
	String id;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {/*
	public static setUpBeforeClass()
		在建構aUI前先模擬輸入Q(quit)，使他跳出loop以便測試
	End setUpBeforeClass
	*/
	
		in = new ByteArrayInputStream("Q".getBytes());
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
	public void testCheckID1() throws NoSuchIDExceptions {/*
	public testCheckID1
		aUI.checkID的結果應該要跟aUI.aGradeSystem.containsID相同(皆為true)
		並且比對aUI內，欲查詢ID與學生姓名是否相符
	End testCheckID1
	*/
		
		id = "962001044";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
		assertEquals("凌宗廷",aUI.name);
	}
	
	@Test
	public void testCheckID2() throws NoSuchIDExceptions {/*
	public testCheckID2
		aUI.checkID的結果應該要跟aUI.aGradeSystem.containsID相同(皆為true)
		並且比對aUI內，欲查詢ID與學生姓名是否相符
	End testCheckID2
	*/
		
		id = "962001051";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
		assertEquals("李威廷",aUI.name);
	}
	
	@Test(expected=NoSuchIDExceptions.class)
	public void testCheckID3() throws NoSuchIDExceptions {/*
	public testCheckID3
		因為id不在清單中，所以要丟exception
	End testCheckID3
	*/
		
		id = "000000000";
		aUI.checkID(id);
	}

}