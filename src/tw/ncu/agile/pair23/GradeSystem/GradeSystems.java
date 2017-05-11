package tw.ncu.agile.pair23.GradeSystem;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

/*******************************************************************************
class GradeSystems 
本 class 儲存 a list of student grades 以及該 system 的各分數占分權重
變數:
weights		//Double 陣列, 存放各分數對應權重
gradesList 	//Grades 的 LinkedList, 存放所有的 Grades變數
格式如下:
962001044 凌宗廷 87 86 98 88 87
962001051 李威廷 81 98 84 90 93
內含public function如下:
GradeSystems()				//建構子, 讀檔(檔名: gradeInput_less.txt )並寫到 GradeSystems 中
GradeSystems(fileName)		//建構子, 讀檔(檔名: fileName )並寫到 GradeSystems 中
containsID(ID)				//看 aGradeSystem 是否擁有此 ID
showGrade(ID)				//顯示該 ID的分數
showRank(ID)				//顯示該ID的名次
updateWeights()				//更改成新的權重
內含protected function如下:
ConstructFromFile			//建構用method
DoubleRoundToInteger		//輸入Double, 輸出 Integer 並對數值做四捨五入到整數位
showOldWeights				//updateWeights用
getNewWeights				//updateWeights用
setWeights					//updateWeights用
*******************************************************************************/

public class GradeSystems {
	private Double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	private LinkedList<Grades> gradesList;
	public String queryName;
	
	/*--------------------------------------
	 * 呼叫 ConstructFromFile(gradeInput_less.txt)
	 * 從 gradeInput_less.txt
	 * 建構 GradeSystems 變數
	 -------------------------------------*/
	public GradeSystems() {
		/* Call ConstructFromFile(filename=gradeInput_less.txt) */
		
			ConstructFromFile("gradeInput_less.txt");
	}
	
	/*--------------------------------------
	 * 呼叫 ConstructFromFile(fileName)
	 * 從 fileName 這個檔案
	 * 建構 GradeSystems 變數
	 -------------------------------------*/
	public GradeSystems(String fileName) {
		/* Call ConstructFromFile(filename) */
		
			ConstructFromFile(fileName);
	}
	
	/*--------------------------------------
	 * 這是 gradesList 的 getter
	 * 回傳該 instance 的 gradesList LinkedList
	 -------------------------------------*/
	public LinkedList<Grades> getGradesList () {return this.gradesList;	}
	
	/*--------------------------------------
	 * 這是 getWeights 的 getter
	 * 回傳 該 instance 的 weights array
	 -------------------------------------*/
	public Double[] getWeights() { return this.weights; }
	
	/* 
	 * 判斷該 GradeSystems 有沒有這個 givenID 存在,
	 * 有的話 return true, 預設是 return false
	 */
	public boolean containsID(String id) {
		/*	for 元素 in GradesList:
				if 元素.ID == givenID:
					return true
				end if
			end for
			預設 return false
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
	 * showGrade(ID) 用來顯示 givenID 的對應成績 
	 -------------------------------------*/
	public void showGrade(String id) {
		/*	for 元素 in GradesList:
				if 元素.id == givenID:
					計算 元素.totalGrade(weights)
					做完以後直接從 for-loop 跳離
				end if
		   	end for
		   	在螢幕上顯示
		*/
			String ret = "";
			for (Grades ele : this.gradesList) {
				if (ele.getID().equals(id)) {
					ele.calculateTotalGrade(this.weights);
					ret = ele.getName() + "成績：" + ele.printGrades();
					break;
				}
			}
			System.out.println(ret);
	}
	
	/*--------------------------------------
	 * showRank(ID) 用來顯示 givenID 的對應排名
	 -------------------------------------*/
	public void showRank(String id) {
		/*	令 rank 為 1
		 	取得該 givenID 的 totalGrade
			for 元素 in GradesList:
				if 元素.totalGrade > givenID.totalGrade
					rank += 1 (退 1 名)
				end if
			end for
			show givenID 的 rank
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
			System.out.println(name + "排名第" + rank.toString());
	}
	
	/*--------------------------------------
	 * 更新權重以後記得更新各 ID 的 totalGrade
	 -------------------------------------*/
	public void updateWeights() {
		/*	呼叫 showOldWeights
			呼叫 getNewWeights
			呼叫 setWeights
			loop aGrade in GradesList
				呼叫 aGrade.calculateTotalGrade(現在的 weights)
			end loop
		*/
			showOldWeights();
			
			Scanner sc = new Scanner(System.in);
			Integer newWeight[] = getNewWeights(sc);
			
			String str = "請確認新配分\n" + "lab1\t" + newWeight[0] + "%\n" + 
					"lab2\t" + newWeight[1] + "%\n" +
					"lab3\t" + newWeight[2] + "%\n" +
					"mid-term\t" + newWeight[3] + "%\n" +
					"fianl exam\t" + newWeight[4] + "%\n" + 
					"以上正確嗎? Y(Yes) 或 N(No)\n" + 
					"使用者輸入：";
			System.out.print(str);
			
			String comString = sc.nextLine();
			//System.out.println("IN GradeSystems:" + comString + "ob'_'ov");
			//sc.close();
			if (comString.equals("Y")) {
				this.setWeights(newWeight);
			}
			for (Grades grades : gradesList){
				grades.calculateTotalGrade(this.weights);
			}
	}
	
	/*--------------------------------------
	 * 根據給的 fileName (ex: a.txt) 來開啟對應的檔案
	 * 並從檔案資訊建構 aGradeSystem
	 -------------------------------------*/
	void ConstructFromFile(String fileName) {
		/*	try {
				開檔(fileString)
				loop 一行一行讀檔:
					new 一個新的 Grades instance (aGrade)
					將對應資訊填入該 aGrade (利用其建構子)
					順便根據現在的 weights 算 totalGrade
					將該instance 加入 gradesList
				end loop
				關檔
			}
			catch Exception { 將 exception 資訊印出來}
		*/
			try {
				File file = new File(fileName);
				Scanner input = new Scanner(file, "utf-8");
				this.gradesList = new LinkedList<>();
				while(input.hasNextLine()) {
					String line = input.nextLine();
					String[] ele = line.split(" ");
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
	 * 輸入 一個 Double value
	 * 回傳其四捨五入到 "整數位" 的 integer 
	 -------------------------------------------*/
	int DoubleRoundToInteger(Double aDouble) {
		BigDecimal aBigDecimal = new BigDecimal(aDouble.toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
		int ret = Integer.parseInt(aBigDecimal.toString());
		return ret;
	}
	
	/*-------------------------------------------
	 * 印出舊權重
	 -------------------------------------------*/
	void showOldWeights() {
		/*	Print 舊權重 */
			String str = "舊配分\n" +
					"lab1\t" + DoubleRoundToInteger(this.weights[0]*100) + "%\n" + 
					"lab2\t" + DoubleRoundToInteger(this.weights[1]*100) + "%\n" +
					"lab3\t" + DoubleRoundToInteger(this.weights[2]*100) + "%\n" +
					"mid-term\t" + DoubleRoundToInteger(this.weights[3]*100) + "%\n" +
					"fianl exam\t" + DoubleRoundToInteger(this.weights[4]*100) + "%\n";
			System.out.println(str);
	}

	/*-------------------------------------------
	 * 從輸入拿到新權重
	 -------------------------------------------*/
	Integer[] getNewWeights(Scanner sc) {
		/*	Get 新權重 by scanner */
		
			Integer newWeight[] = {0, 0, 0, 0, 0};
			System.out.print("輸入新配分\nlab1\t");
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
	 * 設定新權重 即 weights 的 setter
	 -------------------------------------------*/
	void setWeights(Integer[] newWeights) {
		/* 先判斷 權重加起來有沒有 100%
		 * 如果有
		 * set 權重array 到 this.weights array
		 * 沒有
		 * print "沒有 100%"
		 */
			int all = 0;
			for (int w : newWeights) {
				all += w;
			}
			if (all == 100) {
				for (int i=0; i<5; i++) {
					this.weights[i] = newWeights[i] / 100.0;
					//System.out.println(this.weights[i]);
				}
			}
			else {
				System.out.println("配分比例合計需要100%, 請檢查");
			}
	}
	
}