package tw.ncu.agile.pair23.GradeSystem;

import java.util.Scanner;

/***************************************************************************************************************
class UI (user interface) 

不斷prompt 使用者 ID. 直到使用者 quit.
check 使用者 ID , 
showWelcomeMsg
    不斷prompt command. 做下列command直到使用者exit
    showGrade, 
    showRank, 
    updateWeights 
    exit

checkID(ID)
promptID()
promptCommand()
showFinishMsg()
showWelcomeMsg()
UI() 建構子 建構 aGradeSystem
**************************************************************************************************************/
public class UI {
	GradeSystems aGradeSystem;
	Scanner scanner;
	String id;
	String command;
	String name;

	/** --------------------------------------------------------------------------------------------------------
	UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
	--------------------------------------------------------------------------------------------------------- */
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		/*
		try
		    1.call GradeSystems() to建構 aGradeSystem
		
		    2.loop1 until Q (Quit)
		          1. promptID() to get user ID  輸入ID或 Q (結束使用)？
		          2. checkID (ID) 看 ID 是否在 aGradeSystem內
		          3. showWelcomeMsg (ID)      ex. Welcome李威廷
		          4. loop2 until E (Exit)
		                 promptCommand() to prompt for inputCommand
		             end loop2
		      end loop1
		
		    3.showFinishMsg()           結束了
		end try
		finally {}
		*/
		try {
			aGradeSystem = new GradeSystems();
			scanner = new Scanner(System.in);
			while (true) {
				promptID();
				if (id.equals("Q"))
					break;
				checkID(id);
				showWelcomeMsg();
				while (true) {
					boolean exit = false;
					promptCommand();
					switch (command) {
					case "G":
						aGradeSystem.showGrade(id);
						break;
					case "R":
						aGradeSystem.showRank(id);
						break;
					case "W":
						aGradeSystem.updateWeights();
						break;
					case "E":
						exit = true;
						break;
					default:
						throw new NoSuchCommandExceptions();
					}
					if (exit)
						break;
				}
			}
			showFinishMsg();
		} finally {

		}
	}

	/** ----------------------------------------------------------------------------------------------------------
	checkID(ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem 內全班人數
	---------------------------------------------------------------------------------------------------------- */
	public boolean checkID(String id) throws NoSuchIDExceptions {
		/*
		1. 要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
		2. if not, throw an object of NoSuchIDExceptions
		3. 回傳 true
		*/
		if (aGradeSystem.containsID(id) == false) {
			throw new NoSuchIDExceptions();
		}
		name = aGradeSystem.queryName;
		return true;
	}

	/** ---------------------------------------------------------------------------------------------------------
	promptID()
	---------------------------------------------------------------------------------------------------------- */
	public void promptID() {
		/*
		1. prompt user for inputID
		2. if input is "Q" then break
		   else assign inputID to userID end if
		*/
		System.out.println("輸入ID或 Q (結束使用)？");
		id = scanner.nextLine();
	}

	/** -------------------------------------------------------------------------------------------------------------
	promptCommand() throws NoSuchCommandExceptions
	----------------------------------------------------------------------------------------------------------- */
	public void promptCommand() {
		/*
		1. prompt user for inputCommand
		2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
		   throws an object of NoSuchCommandException  end if
		3. if inputCommand is E (Exit) then break
		   else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
		*/
		System.out.println("輸入指令");
		System.out.println("1) G 顯示成績 (Grade)");
		System.out.println("2) R 顯示排名 (Rank)");
		System.out.println("3) W 更新配分 (Weight)");
		System.out.println("4) E 離開選單 (Exit)");
		command = scanner.nextLine();
	}

	/** ---------------------------------------------------------------------------------------------------------
	showWelcomeMsg()
	---------------------------------------------------------------------------------------------------------- */
	public void showWelcomeMsg() {
		/*
		輸出："Welcome "+ userName
		*/
		System.out.println("Welcome " + name);
	}

	/** ---------------------------------------------------------------------------------------------------------
	showFinishMsg()
	---------------------------------------------------------------------------------------------------------- */
	public void showFinishMsg() {
		/*
		輸出："結束了"
		*/
		System.out.println("結束了");
	}
}
