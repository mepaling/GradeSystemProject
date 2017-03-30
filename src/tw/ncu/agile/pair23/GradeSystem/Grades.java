package tw.ncu.agile.pair23.GradeSystem;

import java.math.BigDecimal;

/*
 * Grades class
 * 變數
 * ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
 * 格式如下:
 * case 1: 962001044 凌宗廷 87 86 98 88 87
 * case 2: 962001051 李威廷 81 98 84 90 93
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

public class Grades {
	private String ID, name;
	private int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	public Grades() {
		this.ID = "";
		this.name = "";
		this.lab1 = 0;
		this.lab2 = 0;
		this.lab3 = 0;
		this.midTerm = 0;
		this.finalExam = 0;
		this.totalGrade = 0;
	}
	
	public Grades(String ID, String name, int lab1, int lab2, int lab3, 
			      int midTerm, int finalExam) {
		setGrades(ID, name, lab1, lab2, lab3, midTerm, finalExam);
	}
	
	// Setter method
	public void setGrades(String ID, String name, int lab1, int lab2, int lab3, 
							int midTerm, int finalExam) {
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
		this.totalGrade = 0;
	}
	
	// Getter methods
	public String getID() {	return this.ID;	}
	public String getName() { return this.name;}
	public int getLab1() { return this.lab1; }
	public int getLab2() { return this.lab2; }
	public int getLab3() { return this.lab3; }
	public int getMidterm() { return this.midTerm; }
	public int getfinalExam() { return this.finalExam; }
	public int getTotalGrade() { return this.totalGrade; }
	
	
	
	public void calculateTotalGrade(Double[] weights) {
		Double total = this.lab1*weights[0] + this.lab2*weights[1] + this.lab3*weights[2]+
				  		this.midTerm*weights[3] + this.finalExam*weights[4];
		this.totalGrade = DoubleRoundToInteger(total);
	}
	
	public String printGrades() {
		return "lab1:\t" + this.lab1 + "\nlab2:\t" + this.lab2 + "\nlab3:\t" + this.lab3 + 
				"\nmid-term:\t" + this.midTerm + "\nfinal exam:\t" + this.finalExam +
				"\ntotal grade:\t" + this.totalGrade;
	}
	
	public String toString(){
		return this.ID + " " + this.name + " " + this.lab1 + " " + this.lab2 + " " + this.lab3 + 
				" " + this.midTerm + " " + this.finalExam + " " + this.totalGrade;
	}
	
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}
}
