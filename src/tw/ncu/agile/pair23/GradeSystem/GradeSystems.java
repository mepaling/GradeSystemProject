package tw.ncu.agile.pair23.GradeSystem;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

/*
 * GradeSystems Class
 * 儲存 a list of student grades 以及 該 system 的 分數權重
 * 變數:
 * weights	//Double 陣列, 存放各分數對應權重
 * aList 	//Grades 的 LinkedList, 存放所有的 Grades變數
 * 
 * 格式如下:
 * 962001044 凌宗廷 87 86 98 88 87
 * 962001051 李威廷 81 98 84 90 93
 * 
 * 內含public function如下:
 * GradeSystems ()	//建構子, 讀檔並寫到 GradeSystems 中
 * containsID(ID)	//看aGradeSystem有否含此ID
 * showGrade(ID)	//顯示該ID的分數
 * showRank(ID)		//顯示該ID的名次
 * updateWeights ()	//更改成新的權重
 * 
 * 內含protected function如下:
 * DoubleRoundToInteger	//輸入Double, 輸出 Integer 並對數值做四捨五入到整數位
 * showOldWeights		//updateWeights用
 * getNewWeights		//updateWeights用
 * setWeights			//updateWeights用
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
				ret = ele.name + "成績：" + ele.toString();
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
		System.out.println(name + "排名第" + rank.toString());
	}
	
	public void updateWeights() {
		this.showOldWeights();
		
		Scanner sc = new Scanner(System.in);
		Integer newWeight[] = this.getNewWeights(sc);
		
		String str = "請確認新配分\n" + "lab1\t" + newWeight[0] + "%\n" + 
				"lab2\t" + newWeight[1] + "%\n" +
				"lab3\t" + newWeight[2] + "%\n" +
				"mid-term\t" + newWeight[3] + "%\n" +
				"fianl exam\t" + newWeight[4] + "%\n" + 
				"以上正確嗎? Y(Yes) 或 N(No)\n" + 
				"使用者輸入：";
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
		String str = "舊配分\n" + "lab1\t" + DoubleRoundToInteger(this.weights[0]*100) + "%\n" + 
				"lab2\t" + DoubleRoundToInteger(this.weights[1]*100) + "%\n" +
				"lab3\t" + DoubleRoundToInteger(this.weights[2]*100) + "%\n" +
				"mid-term\t" + DoubleRoundToInteger(this.weights[3]*100) + "%\n" +
				"fianl exam\t" + DoubleRoundToInteger(this.weights[4]*100) + "%\n";
		System.out.println(str);
	}
	
	Integer[] getNewWeights(Scanner sc) {
		Integer newWeight[] = {0, 0, 0, 0, 0};
		System.out.print("輸入新配分\nlab1\t");
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
			System.out.println("沒有100%");
		}
	}
}
