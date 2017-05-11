package tw.ncu.agile.pair23.GradeSystem;

import java.math.BigDecimal;

/*******************************************************************************
class Grades (store Students' Grades)
�����O Grades �t�d�x�s�U�H�� ���Z
�Y: ID, name, lab1, lab2, lab3, midTerm, finalExam, totalGrade
�åB�̷ӿ�J�� �v�� �Ӱ� �������Z �� �p�� (�� call function �~�|�p��)

�榡:	ID			name	lab1	lab2	lab3	midTerm	finalExam
case 1:	962001044	��v��	87		86		98		88		87
case 2:	962001051	���§�	81		98		84		90		93
�H�W�ܼƬҬ� private, �ȯ�z�L getter �P setter �� ���o/�ק� ���e

���tpublic function�p�U:
Grades()											//�Ū��غc�l
Grades(String, String, int, int, int, int, int)		//�i�H���w��l�Ȫ��غc�l

setGrades(String, String, int, int, int, int, int)	//�@���]�w���� value �� setter

getID(), getName(), getLab1(), getLab2, getLab3,	//�U private �ܼ�
getMidTerm(), getfinalExam(), getTotalGreade()		//�� getter

void calculateTotalGrade(Double[])					//���x�s�����Z�P��J���v���p�� totalGrade
String printGrades()								//�t�@�ӥΨ� print ���Z���禡
String toString()									//�� toString() ���Ƽg�H�ۭq print �X�Ӫ��榡

���tprotected function�p�U:
int DoubleRoundToInteger							//��JDouble, �^�� Integer �ñN�ȥ|�ˤ��J���Ʀ�
*******************************************************************************/

public class Grades {
	private String ID, name;
	private int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	/*--------------------------------------
	 *�غc�Ū����Z Grades instance
	 *�ð��n�Ū���l��
	 -------------------------------------*/
	public Grades() {
		/* ��l�� �U private �ܼ�*/
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
	 *�غc Grades instance ��
	 *�I�s setGrades() �N�������Ȫ�l��
	 -------------------------------------------*/
	public Grades(String ID, String name, int lab1, int lab2, int lab3, 
			      int midTerm, int finalExam) {
		/* �N�U�Ѽ� ��� setGrades �Ӫ�l�ƦU private �ܼ� */
			setGrades(ID, name, lab1, lab2, lab3, midTerm, finalExam);
	}
	
	/*-------------------------------------------
	 * ��ڹ�� instance ���w value �� method
	 -------------------------------------------*/
	public void setGrades(String ID, String name, int lab1, int lab2, int lab3, 
							int midTerm, int finalExam) {
		/* �N �U��J�Ѽƪ���  ��J�� �� instance �� private �ܼ� */
		
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
	 * ID �� getter, �^�Ǹ� instance �� ID
	 -------------------------------------------*/
	public String getID() {	return this.ID;	}
	
	/*-------------------------------------------
	 * name �� getter, �^�Ǹ� instance �� name
	 -------------------------------------------*/
	public String getName() { return this.name;}
	
	/*-------------------------------------------
	 * Lab1 �� getter, �^�Ǹ� instance �� Lab1 
	 -------------------------------------------*/
	public int getLab1() { return this.lab1; }
	
	/*-------------------------------------------
	 * Lab2 �� getter, �^�Ǹ� instance �� Lab2
	 -------------------------------------------*/
	public int getLab2() { return this.lab2; }
	
	/*-------------------------------------------
	 * Lab3 �� getter, �^�Ǹ� instance �� Lab3
	 -------------------------------------------*/
	public int getLab3() { return this.lab3; }
	
	/*-------------------------------------------
	 * midTerm �� getter, �^�Ǹ� instance �� midTerm
	 -------------------------------------------*/
	public int getMidterm() { return this.midTerm; }
	
	/*-------------------------------------------
	 * finalExam �� getter, �^�Ǹ� instance �� finalExam 
	 -------------------------------------------*/
	public int getfinalExam() { return this.finalExam; }
	
	/*-------------------------------------------
	 * totalGrade �� getter, �^�Ǹ� instance �� totalGrade
	 -------------------------------------------*/
	public int getTotalGrade() { return this.totalGrade; }
	
	/*-------------------------------------------
	 * �ھڿ�J��  weights �� double array
	 * �p������� totalGrades
	 * �èϥ� DoubleRoundToInteger() �ন���
	 * �̫�N totalGrades ��J�� instance �� totalGrade���
	 -------------------------------------------*/
	public void calculateTotalGrade(Double[] weights) {
		/* �ھڿ�J�� weights �p������� totalGrades */
		
			Double total = this.lab1*weights[0] + this.lab2*weights[1] + this.lab3*weights[2]+
					  		this.midTerm*weights[3] + this.finalExam*weights[4];
			this.totalGrade = DoubleRoundToInteger(total);
	}
	
	/*-------------------------------------------
	 * �^�� ���w�榡�� Grades ���r�� 
	 -------------------------------------------*/
	public String printGrades() {
		return "lab1:\t" + this.lab1 + "\nlab2:\t" + this.lab2 + "\nlab3:\t" + this.lab3 + 
				"\nmid-term:\t" + this.midTerm + "\nfinal exam:\t" + this.finalExam +
				"\ntotal grade:\t" + this.totalGrade;
	}
	
	/*-------------------------------------------
	 * �^�ǳo�� instance �{�b�Ҧ��� private variable
	 -------------------------------------------*/
	public String toString(){
		return this.ID + " " + this.name + " " + this.lab1 + " " + this.lab2 + " " + this.lab3 + 
				" " + this.midTerm + " " + this.finalExam + " " + this.totalGrade;
	}
	
	/*-------------------------------------------
	 * ��J �@�� Double value
	 * �^�Ǩ�|�ˤ��J�� "��Ʀ�" �� integer 
	 -------------------------------------------*/
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}

}
