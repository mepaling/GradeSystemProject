package tw.ncu.agile.pair23.GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** ----------------------------------------------------------------------------------------------------------------------
ID: 962001044 name: ��v��
ID: 962001051 name: ���§�
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
	public void testCheckID1() {/*
	public testCheckID1
		aUI.checkID�����G���ӭn��aUI.aGradeSystem.containsID�ۦP(�Ҭ�true)
		�åB���aUI���A���d��ID�P�ǥͩm�W�O�_�۲�
	End testCheckID1
	*/
		
		id = "962001044";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
		assertEquals("��v��",aUI.StdName);
	}
	
	@Test
	public void testCheckID2() {/*
	public testCheckID2
		aUI.checkID�����G���ӭn��aUI.aGradeSystem.containsID�ۦP(�Ҭ�true)
		�åB���aUI���A���d��ID�P�ǥͩm�W�O�_�۲�
	End testCheckID2
	*/
		
		id = "962001051";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
		assertEquals("���§�",aUI.StdName);
	}
	
	@Test
	public void testCheckID3() {/*
	public testCheckID3
		aUI.checkID�����G���ӭn��aUI.aGradeSystem.containsID�ۦP(�Ҭ�false)
	End testCheckID3
	*/
		
		id = "000000000";
		assertEquals(aUI.aGradeSystem.containsID(id), aUI.checkID(id));
	}

}
