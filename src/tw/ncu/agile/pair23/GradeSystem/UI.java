package tw.ncu.agile.pair23.GradeSystem;

import java.util.Scanner;

public class UI {
	GradeSystems aGradeSystem;
	String id;
	String command;

	public UI() {
		aGradeSystem = new GradeSystems();
		while (true) {
			promptID();
			if (checkID(id) == false) {
				// TODO
				continue;
			}
			if (id == "Q")
				break;
			showWelcomeMsg();
			while (true) {
				boolean exit = false;
				promptCommand();
				switch (command) {
				case "G":
					// TODO
					break;
				case "R":
					// TODO
					break;
				case "W":
					// TODO
					break;
				case "E":
					exit = true;
					break;
				default:
					// TODO
				}
				if (exit)
					break;
			}
		}
		showFinishMsg();
	}

	public boolean checkID(String id) {
		if (aGradeSystem.containsID(id))
			return true;
		else
			return false;
	}

	public void promptID() {
		System.out.println("輸入ID或 Q (結束使用)？");
		Scanner scanner = new Scanner(System.in);
		id = scanner.next();
		scanner.close();
	}

	public void promptCommand() {
		System.out.println("輸入指令");
		System.out.println("1) G 顯示成績 (Grade)");
		System.out.println("2) R 顯示排名 (Rank)");
		System.out.println("3) W 更新配分 (Weight)");
		System.out.println("4) E 離開選單 (Exit)");
		Scanner scanner = new Scanner(System.in);
		command = scanner.next();
		scanner.close();
	}

	public void showWelcomeMsg() {
		// TODO
	}

	public void showFinishMsg() {
		System.out.println("結束了");
	}
}
