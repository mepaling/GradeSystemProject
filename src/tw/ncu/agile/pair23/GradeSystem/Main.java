package tw.ncu.agile.pair23.GradeSystem;

/** ##################################################################
本	Grade system 讓使用者(學生)取得他的總成績 total grade 及排名 rank.
	Total grade 基於配分 weights 來算 而 weights 可以 update.
	Rank 表示此 total grade 在全班學生的分數排序
Input file: 全班學生的分數 例如
			962001044 凌宗廷 87 86 98 88 87
			962001051 李威廷 81 98 84 90 93
注意 data field names 如下: 
				ID name lab1 lab2 lab3 midTerm finalExam
#################################################################### */

public class Main {

	public static void main(String[] args) {
		/* 	try {
		 		call UI() 建構  aUI
		 	}
		 	end try
		 	catch (NoSuchIDExceptions       e1) {print msg1} //ex ID錯了!
			catch (NoSuchCommandExceptions e2) {print msg2}//ex指令錯了!
			end class Main
		 */
		try{
			new UI();
		}
		catch (NoSuchIDExceptions e1) {
			e1.printStackTrace();
        }
		catch (NoSuchCommandExceptions e2) {
			e2.printStackTrace();
		}
	}
}