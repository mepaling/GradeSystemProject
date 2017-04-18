package tw.ncu.agile.pair23.GradeSystem;

public class Grades {
/* class Grades
 * 本 class Grades 負責儲存各人的 成績
 * i.e. ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
 * 並且依照輸入的 權重 來做 平均成績 的計算
 *
 * 格式如下: (注意 input file 內無 totalGrade)
 * case 1: 962001044 凌宗廷 87 86 98 88 87
 * case 2: 962001051 李威廷 81 98 84 90 93
 *
 * 變數皆為 private
 * ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
 * 
 * 內含public function如下:
 * Grades()											//空的建構子
 * Grades(String, String, int, int, int, int, int)	//可以指定初始值的建構子
 * calculateTotalGrade()							//對儲存的成績與輸入的權重計算 totalGrade
 * toString()										//做 toString() 的複寫以自訂 print 出來的格式
 * 
 * 內含protected function如下:
 * DoubleRoundToInteger	//輸入Double, 輸出 Integer 並對數值做四捨五入到整數位
 */

	public Grades() { /*建構空的成績 Grades instance 並做好空的初始化*/	}
	
	public Grades(String ID, String name, int lab1, int lab2, int lab3, 
			      int midTerm, int finalExam) {
		/*建構 Grades instance 並呼叫 setGrades() 將對應的值初始化*/
		setGrades(values);
	}
	
	// Setter method
	public void setGrades(String ID, String name, int lab1, int lab2, int lab3, 
							int midTerm, int finalExam) {
		/*將該 instance 進行初始化*/
		this.value = value;
	}
	
	// Getter methods for private variables
	public String getID() { /*ID 的 getter, 回傳這個 instance 的 ID */ return ID }
	public String getName() { /*name 的 getter, 回傳這個 instance 的 name */ return name }
	public int getLab1() { /*Lab1 的 getter, 回傳這個 instance 的 Lab1 */ return lab1 }
	public int getLab2() { /*Lab2 的 getter, 回傳這個 instance 的 Lab2 */ return lab2 }
	public int getLab3() { /*Lab3 的 getter, 回傳這個 instance 的 Lab3 */ return lab3 }
	public int getMidterm() { /*midTerm 的 getter, 回傳這個 instance 的 midTerm */ return midTerm }
	public int getfinalExam() { /*finalExam 的 getter, 回傳這個 instance 的 finalExam */ return finalExam }
	public int getTotalGrade() { /*totalGrade 的 getter, 回傳這個 instance 的 totalGrade */ return totalGrade }
	

	public void calculateTotalGrade(Double[] weights) {
		/* 根據輸入的 weights 計算對應的 totalGrades */
		totalGrade = lab1 * weights[1] + lab2 * weights[2] + lab3 * weights[3] + ...
	}
	
	public String printGrades() {
		/* 回傳 指定格式的 Grades 的字串 */
		return Grades_string
	}
	
	public String toString(){
		/* 回傳這個 instance 現在的所有 value for debugging */
		return whole_value
	}
	
	int DoubleRoundToInteger(Double aDouble) {
		/* 輸入 一個 Double value, 回傳其四捨五入到 "整數位" 的 int */
		return aInt
	}

}