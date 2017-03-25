package tw.ncu.agile.pair23.GradeSystem;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

/*
 * GradeSystems Class
 * �x�s a list of student grades �H�� �� system �� �����v��
 * �ܼ�:
 * weights	//Double �}�C, �s��U���ƹ����v��
 * aList 	//Grades �� LinkedList, �s��Ҧ��� Grades�ܼ�
 * 
 * �榡�p�U:
 * 962001044 ��v�� 87 86 98 88 87
 * 962001051 ���§� 81 98 84 90 93
 * 
 * ���tpublic function�p�U:
 * GradeSystems ()	//�غc�l, Ū�ɨüg�� GradeSystems ��
 * containsID(ID)	//��aGradeSystem���_�t��ID
 * showGrade(ID)	//��ܸ�ID������
 * showRank(ID)		//��ܸ�ID���W��
 * updateWeights ()	//��令�s���v��
 * 
 * ���tprotected function�p�U:
 * DoubleRoundToInteger	//��JDouble, ��X Integer �ù�ƭȰ��|�ˤ��J���Ʀ�
 * showOldWeights		//updateWeights��
 * getNewWeights		//updateWeights��
 * setWeights			//updateWeights��
 */

public class GradeSystems {
	Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	LinkedList<Grades> aList;
	
	public GradeSystems() {
		try {
			File file = new File("gradeInput_less.txt");
			Scanner input = new Scanner(file);
			aList = new LinkedList<>();
			while(input.hasNextLine()) {
				String[] ele = input.nextLine().split(" ");
				Grades eleGrades = new Grades(ele[0], ele[1], Integer.parseInt(ele[2]),
						Integer.parseInt(ele[3]), Integer.parseInt(ele[4]),
						Integer.parseInt(ele[5]), Integer.parseInt(ele[6]));
				eleGrades.calculateTotalGrade(this.weights);
				aList.add(eleGrades);
			}
			input.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean containsID(String id) {
		for (Grades ele : this.aList) {
			if (ele.ID.equals(id))
				return true;
		}
		return false;
	}
	
	public void showGrade(String id) {
		String ret = "";
		for (Grades ele : this.aList) {
			if (ele.ID.equals(id)) {
				ele.calculateTotalGrade(this.weights);
				ret = ele.name + "���Z�G" + ele.toString();
				break;
			}
		}
		System.out.println(ret);
	}
	
	public void showRank(String id) {
		Integer rank = 1;
		String name = "";
		int totalGrade = 0;
		for (Grades ele : this.aList) {
			if (ele.ID.equals(id)) {
				totalGrade = ele.totalGrade;
				name = ele.name;
				break;
			}
		}
		for (Grades ele : this.aList) {
			if (ele.totalGrade > totalGrade) {
				rank++;
			}
		}
		System.out.println(name + "�ƦW��" + rank.toString());
	}
	
	public void updateWeights() {
		this.showOldWeights();
		
		Scanner sc = new Scanner(System.in);
		Integer newWeight[] = this.getNewWeights(sc);
		
		String str = "�нT�{�s�t��\n" + "lab1\t" + newWeight[0] + "%\n" + 
				"lab2\t" + newWeight[1] + "%\n" +
				"lab3\t" + newWeight[2] + "%\n" +
				"mid-term\t" + newWeight[3] + "%\n" +
				"fianl exam\t" + newWeight[4] + "%\n" + 
				"�H�W���T��? Y(Yes) �� N(No)\n" + 
				"�ϥΪ̿�J�G";
		System.out.print(str);
		
		String comString = sc.next();
		sc.close();
		if (comString.equals("Y")) {
			this.setWeights(newWeight);
		}
		for (Grades grades : aList){
			grades.calculateTotalGrade(this.weights);
		}
	}
	
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}
	
	void showOldWeights() {
		String str = "�°t��\n" + "lab1\t" + DoubleRoundToInteger(this.weights[0]*100) + "%\n" + 
				"lab2\t" + DoubleRoundToInteger(this.weights[1]*100) + "%\n" +
				"lab3\t" + DoubleRoundToInteger(this.weights[2]*100) + "%\n" +
				"mid-term\t" + DoubleRoundToInteger(this.weights[3]*100) + "%\n" +
				"fianl exam\t" + DoubleRoundToInteger(this.weights[4]*100) + "%\n";
		System.out.println(str);
	}
	
	Integer[] getNewWeights(Scanner sc) {
		Integer newWeight[] = {0, 0, 0, 0, 0};
		System.out.print("��J�s�t��\nlab1\t");
		newWeight[0] = sc.nextInt();
		System.out.print("lab2\t");
		newWeight[1] = sc.nextInt();
		System.out.print("lab3\t");
		newWeight[2] = sc.nextInt();
		System.out.print("mid-term\t");
		newWeight[3] = sc.nextInt();
		System.out.print("final exam\t");
		newWeight[4] = sc.nextInt();
		return newWeight;
	}
	
	void setWeights(Integer[] newWeights) {
		int all = 0;
		for (int w : newWeights) {
			all += w;
		}
		if (all == 100) {
			for (int i=0; i<5; i++) {
				this.weights[i] = newWeights[i] / 100.0;
				System.out.println(this.weights[i]);
			}
		}
		else {
			System.out.println("�S��100%");
		}
	}
}
