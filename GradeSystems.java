package tw.ncu.agile.pair23.GradeSystem;

public class GradeSystems {

/*
 * class GradeSystems
 * 本 class 儲存 a list of student grades 以及該 system 的各分數占分權重
 * 變數:
 * weights		//Double 陣列, 存放各分數對應權重, 有預設值 {0.1, 0.1, 0.1, 0.3, 0.4}
 * gradesList	//Grades 的 LinkedList, 存放所有的 Grades 變數
 * 
 * 格式如下:
 * 962001044 凌宗廷 87 86 98 88 87
 * 962001051 李威廷 81 98 84 90 93
 * 
 * 內含public function如下:
 * GradeSystems()			//建構子, 讀檔(檔名:gradeInput_less.txt)並寫到 GradeSystems 中
 * GradeSystems(fileName)	//建構子, 讀檔(檔名:fileName)並寫到 GradeSystems 中
 * containsID(ID)			//看 aGradeSystem 是否含此 ID
 * showGrade(ID)			//顯示該ID的分數
 * showRank(ID)				//顯示該ID的名次
 * updateWeights()			//更改成新的權重
 * 
 * 內含protected function如下:
 * ConstructFromFile		//建構用method
 * DoubleRoundToInteger		//輸入Double, 輸出 Integer 並對數值做四捨五入到整數位
 * showOldWeights			//updateWeights用
 * getNewWeights			//updateWeights用
 * setWeights				//updateWeights用
 */

	public GradeSystems() {
		/* 呼叫 ConstructFromFile() 來從"gradeInput_less.txt"來建構 GradeSystems 變數*/
		ConstructFromFile("gradeInput_less.txt")
	}
	
	public GradeSystems(String fileString) {
		/* 呼叫 ConstructFromFile() 來從"filename"來建構 GradeSystems 變數*/
		ConstructFromFile(fileString)
	}
	
	//Getter for variables
	public LinkedList<Grades> getGradesList () {
		/* GradesList 的 getter, 回傳這個 instance 的 GradesList */
		return GradesList
	}
	public Double[] getWeights() {
		/* Weights 的 getter, 回傳這個 instance 的 Weights */
		return Weights
	}

	public boolean containsID(String id) {
		/* 
		 * containsID(givenID) 是用來判斷該 GradeSystems 有沒有這個 givenID 存在,
		 * 有的話 return true, 預設是 return false
		 */
		for 元素 in GradesList:
			if 元素.ID == givenID:
				return true
			end if
		end for
		預設 return false
	}
	
	public void showGrade(String id) {
		/* showGrade(ID) 用來顯示 givenID 的對應成績 */
		for 元素 in GradesList:
			if 元素.id == givenID:
				計算 元素.totalGrade(weights)
				在螢幕上顯示
				做完以後直接從 for-loop 跳離
			end if
		end for
	}
	
	public void showRank(String id) {
		/* showGrade(ID) 用來顯示 givenID 的對應成績 */
		取得該 givenID 的 totalGrade
		令 rank 為 1
		for 元素 in GradesList:
			if 元素.totalGrade > givenID.totalGrade
				rank += 1 (退 1 名)
			end if
		end for
		show givenID 的 rank
	}

	public void updateWeights() {
		/* 更新權重以後記得更新各 ID 的 totalGrade */
		呼叫 showOldWeights
		呼叫 getNewWeights
		呼叫 setWeights
		loop aGrade in GradesList
			呼叫 aGrade.calculateTotalGrade(現在的 weights)
		end loop
	}
	
	void ConstructFromFile(String fileString) {
		/* 根據給的 fileString (ex: a.txt) 來開啟對應的檔案
		 * 並從檔案資訊建構 aGradeSystem
		 */
		try {
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
		
	}
	
	int DoubleRoundToInteger(Double aDouble) {
		/* 輸入 一個 Double value, 回傳其四捨五入到 "整數位" 的 int */
		return aInt
	}
	
	void showOldWeights() {
		/* 印出舊權重" */
		print (oldWeights)
	}
	
	Integer[] getNewWeights(Scanner sc) {
		/* 從輸入拿到新權重 */
		weights[] get from scanner
 	}
	
	void setWeights(Integer[] newWeights) {
		/* 設定新權重 即 weights 的 setter */
		set new weights to aGradeSystem
	}
	
}