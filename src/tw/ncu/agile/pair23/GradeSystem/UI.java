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
		System.out.println("��JID�� Q (�����ϥ�)�H");
		Scanner scanner = new Scanner(System.in);
		id = scanner.next();
		scanner.close();
	}

	public void promptCommand() {
		System.out.println("��J���O");
		System.out.println("1) G ��ܦ��Z (Grade)");
		System.out.println("2) R ��ܱƦW (Rank)");
		System.out.println("3) W ��s�t�� (Weight)");
		System.out.println("4) E ���}��� (Exit)");
		Scanner scanner = new Scanner(System.in);
		command = scanner.next();
		scanner.close();
	}

	public void showWelcomeMsg() {
		// TODO
	}

	public void showFinishMsg() {
		System.out.println("�����F");
	}
}
