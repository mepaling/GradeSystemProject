package tw.ncu.agile.pair23.GradeSystem;

import java.util.Scanner;

public class UI {
	GradeSystems aGradeSystem;
	Scanner scanner;
	String id;
	String command;
	
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
			promptCommand();
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
		id = scanner.nextLine();
	}

	public void promptCommand() {
		while (true) {
			boolean exit = false;
			System.out.println("��J���O");
			System.out.println("1) G ��ܦ��Z (Grade)");
			System.out.println("2) R ��ܱƦW (Rank)");
			System.out.println("3) W ��s�t�� (Weight)");
			System.out.println("4) E ���}��� (Exit)");
			command = scanner.nextLine();
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

	public void showWelcomeMsg() {
		System.out.println("Welcome");
	}

	public void showFinishMsg() {
		System.out.println("End");
	}
}
