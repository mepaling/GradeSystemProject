package tw.ncu.agile.pair23.GradeSystem;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

/*******************************************************************************
class GradeSystems 
�� class �x�s a list of student grades �H�θ� system ���U���ƥe���v��
�ܼ�:
weights		//Double �}�C, �s��U���ƹ����v��
gradesList 	//Grades �� LinkedList, �s��Ҧ��� Grades�ܼ�

�榡�p�U:
962001044 ��v�� 87 86 98 88 87
962001051 ���§� 81 98 84 90 93

���tpublic function�p�U:
GradeSystems()				//�غc�l, Ū��(�ɦW: gradeInput_less.txt )�üg�� GradeSystems ��
GradeSystems(fileName)		//�غc�l, Ū��(�ɦW: fileName )�üg�� GradeSystems ��
containsID(ID)				//�� aGradeSystem �O�_�֦��� ID
showGrade(ID)				//��ܸ� ID������
showRank(ID)				//��ܸ�ID���W��
updateWeights()				//��令�s���v��

���tprotected function�p�U:
ConstructFromFile			//�غc��method
DoubleRoundToInteger		//��JDouble, ��X Integer �ù�ƭȰ��|�ˤ��J���Ʀ�
showOldWeights				//updateWeights��
getNewWeights				//updateWeights��
setWeights					//updateWeights��
*******************************************************************************/

public class GradeSystems {
	private Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	private LinkedList<Grades> gradesList;
	public String queryName;
	
	/*--------------------------------------
	 * �I�s ConstructFromFile(gradeInput_less.txt)
	 * �q gradeInput_less.txt
	 * �غc GradeSystems �ܼ�
	 -------------------------------------*/
	public GradeSystems() {
		/* Call ConstructFromFile(filename=gradeInput_less.txt) */
		
			ConstructFromFile("gradeInput_less.txt");
	}
	
	/*--------------------------------------
	 * �I�s ConstructFromFile(fileName)
	 * �q fileName �o���ɮ�
	 * �غc GradeSystems �ܼ�
	 -------------------------------------*/
	public GradeSystems(String fileName) {
		/* Call ConstructFromFile(filename) */
		
			ConstructFromFile(fileName);
	}
	
	/*--------------------------------------
	 * �o�O gradesList �� getter
	 * �^�Ǹ� instance �� gradesList LinkedList
	 -------------------------------------*/
	public LinkedList<Grades> getGradesList () {return this.gradesList;	}
	
	/*--------------------------------------
	 * �o�O getWeights �� getter
	 * �^�� �� instance �� weights array
	 -------------------------------------*/
	public Double[] getWeights() { return this.weights; }
	
	/* 
	 * �P�_�� GradeSystems ���S���o�� givenID �s�b,
	 * ������ return true, �w�]�O return false
	 */
	public boolean containsID(String id) {
		/*	for ���� in GradesList:
				if ����.ID == givenID:
					return true
				end if
			end for
			�w�] return false
		*/
			for (Grades ele : this.gradesList) {
				if (ele.getID().equals(id)) {
					queryName = ele.getName();
					return true;
				}
			}
			return false;
	}
	
	/*--------------------------------------
	 * showGrade(ID) �Ψ���� givenID ���������Z 
	 -------------------------------------*/
	public void showGrade(String id) {
		/*	for ���� in GradesList:
				if ����.id == givenID:
					�p�� ����.totalGrade(weights)
					�����H�᪽���q for-loop ����
				end if
		   	end for
		   	�b�ù��W���
		*/
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
	
	/*--------------------------------------
	 * showRank(ID) �Ψ���� givenID �������ƦW
	 -------------------------------------*/
	public void showRank(String id) {
		/*	�O rank �� 1
		 	���o�� givenID �� totalGrade
			for ���� in GradesList:
				if ����.totalGrade > givenID.totalGrade
					rank += 1 (�h 1 �W)
				end if
			end for
			show givenID �� rank
		*/
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
	
	/*--------------------------------------
	 * ��s�v���H��O�o��s�U ID �� totalGrade
	 -------------------------------------*/
	public void updateWeights() {
		/*	�I�s showOldWeights
			�I�s getNewWeights
			�I�s setWeights
			loop aGrade in GradesList
				�I�s aGrade.calculateTotalGrade(�{�b�� weights)
			end loop
		*/
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
	
	/*--------------------------------------
	 * �ھڵ��� fileName (ex: a.txt) �Ӷ}�ҹ������ɮ�
	 * �ñq�ɮ׸�T�غc aGradeSystem
	 -------------------------------------*/
	void ConstructFromFile(String fileName) {
		/*	try {
				�}��(fileString)
				loop �@��@��Ū��:
					new �@�ӷs�� Grades instance (aGrade)
					�N������T��J�� aGrade (�Q�Ψ�غc�l)
					���K�ھڲ{�b�� weights �� totalGrade
					�N��instance �[�J gradesList
				end loop
				����
			}
			catch Exception { �N exception ��T�L�X��}
		*/
			try {
				File file = new File(fileName);
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
	
	/*-------------------------------------------
	 * ��J �@�� Double value
	 * �^�Ǩ�|�ˤ��J�� "��Ʀ�" �� integer 
	 -------------------------------------------*/
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}
	
	/*-------------------------------------------
	 * �L�X���v��
	 -------------------------------------------*/
	void showOldWeights() {
		/*	Print ���v�� */
			String str = "�°t��\n" +
					"lab1\t" + DoubleRoundToInteger(this.weights[0]*100) + "%\n" + 
					"lab2\t" + DoubleRoundToInteger(this.weights[1]*100) + "%\n" +
					"lab3\t" + DoubleRoundToInteger(this.weights[2]*100) + "%\n" +
					"mid-term\t" + DoubleRoundToInteger(this.weights[3]*100) + "%\n" +
					"fianl exam\t" + DoubleRoundToInteger(this.weights[4]*100) + "%\n";
			System.out.println(str);
	}

	/*-------------------------------------------
	 * �q��J����s�v��
	 -------------------------------------------*/
	Integer[] getNewWeights(Scanner sc) {
		/*	Get �s�v�� by scanner */
		
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

	/*-------------------------------------------
	 * �]�w�s�v�� �Y weights �� setter
	 -------------------------------------------*/
	void setWeights(Integer[] newWeights) {
		/* ���P�_ �v���[�_�Ӧ��S�� 100%
		 * �p�G��
		 * set �v��array �� this.weights array
		 * �S��
		 * print "�S�� 100%"
		 */
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
