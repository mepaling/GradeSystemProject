package tw.ncu.agile.pair23.GradeSystem;

import java.util.Scanner;

public class UI {
	GradeSystems aGradeSystem;
	Scanner scanner;
	String id;
	String command;
	String StdName;

	public UI() {
		aGradeSystem = new GradeSystems();
		scanner = new Scanner(System.in);
		while (true) {
			promptID();
			System.out.println(id);
			if (id.equals("Q"))
				break;
			if (checkID(id) == false) {
				// TODO
				continue;
			}
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
		if (aGradeSystem.containsID(id)) {
			// TODO
			return true;
		} else
			return false;
	}

	public void promptID() {
		System.out.println("輸入ID或 Q (結束使用)？");
		id = scanner.nextLine();
	}

	public void promptCommand() {
		System.out.println("輸入指令");
		System.out.println("1) G 顯示成績 (Grade)");
		System.out.println("2) R 顯示排名 (Rank)");
		System.out.println("3) W 更新配分 (Weight)");
		System.out.println("4) E 離開選單 (Exit)");
		command = scanner.nextLine();
	}

	public void showWelcomeMsg() {
		System.out.println("Welcome");
	}

	public void showFinishMsg() {
		System.out.println("End");
	}
}