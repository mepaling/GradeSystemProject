package tw.ncu.agile.pair23.GradeSystem;

/** ##################################################################
��	Grade system ���ϥΪ�(�ǥ�)���o�L���`���Z total grade �αƦW rank.
	Total grade ���t�� weights �Ӻ� �� weights �i�H update.
	Rank ��ܦ� total grade �b���Z�ǥͪ����ƱƧ�

Input file: ���Z�ǥͪ����� �Ҧp
			962001044 ��v�� 87 86 98 88 87
			962001051 ���§� 81 98 84 90 93
�`�N data field names �p�U: 
				ID name lab1 lab2 lab3 midTerm finalExam
#################################################################### */

public class Main {

	public static void main(String[] args) {
		/* 	try {
		 		call UI() �غc  aUI
		 	}
		 	end try
		 	catch (NoSuchIDExceptions       e1) {print msg1} //ex ID���F!
			catch (NoSuchCommandExceptions e2) {print msg2}//ex���O���F!
			end class Main

		 */
		//try{
			new UI();
		//}
		/*catch (NoSuchIDExceptions e1) {
			e1.printStackTrace();
        }
		catch (NoSuchCommandExceptions e2) {
			e2.printStackTrace();
		}*/
	}
}
