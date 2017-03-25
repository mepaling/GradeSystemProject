package tw.ncu.agile.pair23.GradeSystem;

import java.math.BigDecimal;

/*
 * Grades class
 * �ܼ�
 * ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
 * �榡�p�U:
 * case 1: 962001044 ��v�� 87 86 98 88 87
 * case 2: 962001051 ���§� 81 98 84 90 93
 * 
 * ���tpublic function�p�U:
 * Grades()											//�Ū��غc�l
 * Grades(String, String, int, int, int, int, int)	//�i�H���w��l�Ȫ��غc�l
 * calculateTotalGrade()							//���x�s�����Z�P��J���v���p�� totalGrade
 * toString()										//�� toString() ���Ƽg�H�ۭq print �X�Ӫ��榡
 * 
 * ���tprotected function�p�U:
 * DoubleRoundToInteger	//��JDouble, ��X Integer �ù�ƭȰ��|�ˤ��J���Ʀ�
 */

public class Grades {
	String ID, name;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
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
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
		this.totalGrade = 0;
	}
	
	public void calculateTotalGrade(Double[] weights) {
		Double total = this.lab1*weights[0] + this.lab2*weights[1] + this.lab3*weights[2]+
				  		this.midTerm*weights[3] + this.finalExam*weights[4];
		this.totalGrade = DoubleRoundToInteger(total);
	}
	
	public String toString() {
		return "lab1:\t" + this.lab1 + "\nlab2:\t" + this.lab2 + "\nlab3:\t" + this.lab3 + 
				"\nmid-term:\t" + this.midTerm + "\nfinal exam:\t" + this.finalExam +
				"\ntotal grade:\t" + this.totalGrade;
	}
	
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}
}
