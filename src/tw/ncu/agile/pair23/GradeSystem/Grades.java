package tw.ncu.agile.pair23.GradeSystem;

import java.math.BigDecimal;

/*******************************************************************************
class Grades (store Students' Grades)
本類別 Grades 負責儲存各人的 成績
即: ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
並且依照輸入的 權重 來做 平均成績 的 計算 (需 call function 才會計算)

格式:	ID			name	lab1	lab2	lab3	midTerm	finalExam
case 1:	962001044	凌宗廷	87		86		98		88		87
case 2:	962001051	李威廷	81		98		84		90		93
以上變數皆為 private, 僅能透過 getter 與 setter 來 取得/修改 內容

內含public function如下:
Grades()											//空的建構子
Grades(String, String, int, int, int, int, int)		//可以指定初始值的建構子

setGrades(String, String, int, int, int, int, int)	//一次設定全部 value 的 setter

getID(), getName(), getLab1(), getLab2, getLab3,	//各 private 變數
getMidTerm(), getfinalExam(), getTotalGreade()		//的 getter

void calculateTotalGrade(Double[])					//對儲存的成績與輸入的權重計算 totalGrade
String printGrades()								//另一個用來 print 成績的函式
String toString()									//做 toString() 的複寫以自訂 print 出來的格式

內含protected function如下:
int DoubleRoundToInteger							//輸入Double, 回傳 Integer 並將值四捨五入到整數位
*******************************************************************************/

public class Grades {
	private String ID, name;
	private int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	/*--------------------------------------
	 *建構空的成績 Grades instance
	 *並做好空的初始化
	 -------------------------------------*/
	public Grades() {
		/* 初始化 各 private 變數*/
			this.ID = "";
			this.name = "";
			this.lab1 = 0;
			this.lab2 = 0;
			this.lab3 = 0;
			this.midTerm = 0;
			this.finalExam = 0;
			this.totalGrade = 0;
	}
	
	/*-------------------------------------------
	 *建構 Grades instance 後
	 *呼叫 setGrades() 將對應的值初始化
	 -------------------------------------------*/
	public Grades(String ID, String name, int lab1, int lab2, int lab3, 
			      int midTerm, int finalExam) {
		/* 將各參數 丟到 setGrades 來初始化各 private 變數 */
			setGrades(ID, name, lab1, lab2, lab3, midTerm, finalExam);
	}
	
	/*-------------------------------------------
	 * 實際對該 instance 指定 value 的 method
	 -------------------------------------------*/
	public void setGrades(String ID, String name, int lab1, int lab2, int lab3, 
							int midTerm, int finalExam) {
		/* 將 各輸入參數的值  填入到 該 instance 的 private 變數 */
		
			this.ID = ID;
			this.name = name;
			this.lab1 = lab1;
			this.lab2 = lab2;
			this.lab3 = lab3;
			this.midTerm = midTerm;
			this.finalExam = finalExam;
			this.totalGrade = 0;
	}
	
	/*-------------------------------------------
	 * ID 的 getter, 回傳該 instance 的 ID
	 -------------------------------------------*/
	public String getID() {	return this.ID;	}
	
	/*-------------------------------------------
	 * name 的 getter, 回傳該 instance 的 name
	 -------------------------------------------*/
	public String getName() { return this.name;}
	
	/*-------------------------------------------
	 * Lab1 的 getter, 回傳該 instance 的 Lab1 
	 -------------------------------------------*/
	public int getLab1() { return this.lab1; }
	
	/*-------------------------------------------
	 * Lab2 的 getter, 回傳該 instance 的 Lab2
	 -------------------------------------------*/
	public int getLab2() { return this.lab2; }
	
	/*-------------------------------------------
	 * Lab3 的 getter, 回傳該 instance 的 Lab3
	 -------------------------------------------*/
	public int getLab3() { return this.lab3; }
	
	/*-------------------------------------------
	 * midTerm 的 getter, 回傳該 instance 的 midTerm
	 -------------------------------------------*/
	public int getMidterm() { return this.midTerm; }
	
	/*-------------------------------------------
	 * finalExam 的 getter, 回傳該 instance 的 finalExam 
	 -------------------------------------------*/
	public int getfinalExam() { return this.finalExam; }
	
	/*-------------------------------------------
	 * totalGrade 的 getter, 回傳該 instance 的 totalGrade
	 -------------------------------------------*/
	public int getTotalGrade() { return this.totalGrade; }
	
	/*-------------------------------------------
	 * 根據輸入的  weights 的 double array
	 * 計算對應的 totalGrades
	 * 並使用 DoubleRoundToInteger() 轉成整數
	 * 最後將 totalGrades 填入該 instance 的 totalGrade欄位
	 -------------------------------------------*/
	public void calculateTotalGrade(Double[] weights) {
		/* 根據輸入的 weights 計算對應的 totalGrades */
		
			Double total = this.lab1*weights[0] + this.lab2*weights[1] + this.lab3*weights[2]+
					  		this.midTerm*weights[3] + this.finalExam*weights[4];
			this.totalGrade = DoubleRoundToInteger(total);
	}
	
	/*-------------------------------------------
	 * 回傳 指定格式的 Grades 的字串 
	 -------------------------------------------*/
	public String printGrades() {
		return "lab1:\t" + this.lab1 + "\nlab2:\t" + this.lab2 + "\nlab3:\t" + this.lab3 + 
				"\nmid-term:\t" + this.midTerm + "\nfinal exam:\t" + this.finalExam +
				"\ntotal grade:\t" + this.totalGrade;
	}
	
	/*-------------------------------------------
	 * 回傳這個 instance 現在所有的 private variable
	 -------------------------------------------*/
	public String toString(){
		return this.ID + " " + this.name + " " + this.lab1 + " " + this.lab2 + " " + this.lab3 + 
				" " + this.midTerm + " " + this.finalExam + " " + this.totalGrade;
	}
	
	/*-------------------------------------------
	 * 輸入 一個 Double value
	 * 回傳其四捨五入到 "整數位" 的 integer 
	 -------------------------------------------*/
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}

}
