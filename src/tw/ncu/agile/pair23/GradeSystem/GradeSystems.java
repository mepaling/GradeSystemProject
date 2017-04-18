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
 * gradesList 	//Grades �� LinkedList, �s��Ҧ��� Grades�ܼ�
 * 
 * �榡�p�U:
 * 962001044 ��v�� 87 86 98 88 87
 * 962001051 ���§� 81 98 84 90 93
 * 
 * ���tpublic function�p�U:
 * GradeSystems()			//�غc�l, Ū��(�ɦW:gradeInput_less.txt)�üg�� GradeSystems ��
 * GradeSystems(fileName)	//�غc�l, Ū��(�ɦW:fileName)�üg�� GradeSystems ��
 * containsID(ID)			//��aGradeSystem���_�t��ID
 * showGrade(ID)			//��ܸ�ID������
 * showRank(ID)				//��ܸ�ID���W��
 * updateWeights()			//��令�s���v��
 * 
 * ���tprotected function�p�U:
 * ConstructFromFile		//�غc��method
 * DoubleRoundToInteger		//��JDouble, ��X Integer �ù�ƭȰ��|�ˤ��J���Ʀ�
 * showOldWeights			//updateWeights��
 * getNewWeights			//updateWeights��
 * setWeights				//updateWeights��
 */

public class GradeSystems {
	private Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	private LinkedList<Grades> gradesList;
	
	public GradeSystems() {
		ConstructFromFile("gradeInput_less.txt");
	}
	
	public GradeSystems(String fileString) {
		ConstructFromFile(fileString);
	}
	
	public LinkedList<Grades> getGradesList () {return new LinkedList<Grades>(this.gradesList);	}
	public Double[] getWeights() { return this.weights.clone(); }

	public boolean containsID(String id) {
		for (Grades ele : this.gradesList) {
			if (ele.getID().equals(id))
				return true;
		}
		return false;
	}
	
	public void showGrade(String id) {
		String ret = "";
		for (Grades ele : this.gradesList) {
			if (ele.getID().equals(id)) {
				ele.calculateTotalGrade(this.weights);
				ret = ele.getName() + "���Z�G" + ele.printGrades();
				break;
			}
		}
		System.out.println(ret);
	}
	
	public void showRank(String id) {
		Integer rank = 1;
		String name = "";
		int totalGrade = 0;
		for (Grades ele : this.gradesList) {
			if (ele.getID().equals(id)) {
				totalGrade = ele.getTotalGrade();
				name = ele.getName();
				break;
			}
		}
		for (Grades ele : this.gradesList) {
			if (ele.getTotalGrade() > totalGrade) {
				rank++;
			}
		}
		System.out.println(name + "�ƦW��" + rank.toString());
	}

	public void updateWeights() {
		showOldWeights();
		
		Scanner sc = new Scanner(System.in);
		Integer newWeight[] = getNewWeights(sc);
		
		String str = "�нT�{�s�t��\n" + "lab1\t" + newWeight[0] + "%\n" + 
				"lab2\t" + newWeight[1] + "%\n" +
				"lab3\t" + newWeight[2] + "%\n" +
				"mid-term\t" + newWeight[3] + "%\n" +
				"fianl exam\t" + newWeight[4] + "%\n" + 
				"�H�W���T��? Y(Yes) �� N(No)\n" + 
				"�ϥΪ̿�J�G";
		System.out.print(str);
		
		String comString = sc.nextLine();
		//System.out.println("IN GradeSystems:" + comString + "ob'_'ov");
		sc.close();
		if (comString.equals("Y")) {
			this.setWeights(newWeight);
		}
		for (Grades grades : gradesList){
			grades.calculateTotalGrade(this.weights);
		}
	}
	
	void ConstructFromFile(String fileString) {
		try {
			File file = new File(fileString);
			Scanner input = new Scanner(file);
			this.gradesList = new LinkedList<>();
			while(input.hasNextLine()) {
				String[] ele = input.nextLine().split(" ");
				Grades eleGrades = new Grades(ele[0], ele[1], Integer.parseInt(ele[2]),
						Integer.parseInt(ele[3]), Integer.parseInt(ele[4]),
						Integer.parseInt(ele[5]), Integer.parseInt(ele[6]));
				eleGrades.calculateTotalGrade(this.weights);
				this.gradesList.add(eleGrades);
			}
			input.close();
		}
		catch (Exception e) {
			e.printStackTrace();
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
		newWeight[0] = Integer.parseInt(sc.nextLine());
		System.out.print("lab2\t");
		newWeight[1] = Integer.parseInt(sc.nextLine());
		System.out.print("lab3\t");
		newWeight[2] = Integer.parseInt(sc.nextLine());
		System.out.print("mid-term\t");
		newWeight[3] = Integer.parseInt(sc.nextLine());
		System.out.print("final exam\t");
		newWeight[4] = Integer.parseInt(sc.nextLine());
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
