package tw.ncu.agile.pair23.GradeSystem;

import java.util.Scanner;

public class UI {
	GradeSystems aGradeSystem;
	Scanner scanner;
	String id;
	String command;
	
	public UI() {
		aGradeSystem = new GradeSystems();
		while (true) {
			promptID();
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
		scanner.close();
		showFinishMsg();
	}

	public boolean checkID(String id) {
		if (aGradeSystem.containsID(id))
			return true;
		else
			return false;
	}

	public void promptID() {
		scanner = new Scanner(System.in);
		System.out.println("��JID�� Q (�����ϥ�)�H");
		id = scanner.next();
	}

	public void promptCommand() {
		scanner = new Scanner(System.in);
		System.out.println("��J���O");
		System.out.println("1) G ��ܦ��Z (Grade)");
		System.out.println("2) R ��ܱƦW (Rank)");
		System.out.println("3) W ��s�t�� (Weight)");
		System.out.println("4) E ���}��� (Exit)");
		command = scanner.next();
	}

	public void showWelcomeMsg() {
		System.out.println("Welcome");
	}

	public void showFinishMsg() {
		System.out.println("End");
	}
}
