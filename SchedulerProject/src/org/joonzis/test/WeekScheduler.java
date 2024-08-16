package org.joonzis.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeekScheduler {
	private static Day[] days;
	Scanner sc = new Scanner(System.in);
	private static String[] week = { "일", "월", "화", "수", "목", "금", "토" };
	int count = 3;
	private static int schedulerCounter = 0;
	private String userId = "";
	private int schedulerNumber = 0;

	public static Day[] getDays() {
		return days;
	}

	public static String[] getWeek() {
		return week;
	}

	public int getSchedulerNumber() {
		return schedulerNumber;
	}

	public void showSchedulerNumber() {
		System.out.printf("귀하의 스케쥴러 번호는 %d입니다.\n", this.schedulerNumber);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
		System.out.printf("유저의 ID가 변경되었습니다. 변경된 ID는 %s입니다.\n", this.userId);
	}

	public void showUserId() {
		System.out.printf("귀하의 ID는 %s입니다.\n", this.userId);
	}

	public WeekScheduler() {
		days = new Day[week.length];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
		schedulerNumber = ++schedulerCounter;
		System.out.println("유저 ID를 입력해 주세요.");
		this.userId = sc.nextLine();
		System.out.printf("유저 ID가 설정되었습니다. 유저의 아이디는 %s 입니다.\n", this.userId);
	}

	void menu() {
		while (true) {
			try {
				System.out.println("번호를 입력해 주세요.");
				System.out.println("1. 스케줄 생성 2. 삭제 3. 수정 4. 보기 0. 종료");
				System.out.println("----------------------------------------");
				int num = sc.nextInt();
				sc.nextLine(); // 숫자를 입력 받는 메서드의 경우 끝에 \n(개행) 이 들어가기 때문에 이 개행을 입력 받기만 하는 메서드(nextLine)중 하나를 사용해
								// 처리
				switch (num) {
				case 1:
					makeSchedule();
					break;
				case 2:
					removeSchedule();
					break;
				case 3:
					modifySchedule();
					break;
				case 4:
					selectSchedule();
					break;
				case 0:
					exit();
					break;
				default:
					System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.\n----------------------------------------");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.\n----------------------------------------");
				sc.nextLine();
			}
		}
	}

	void makeSchedule() {

		System.out.print("요일을 입력해 주세요.\n(월요일은 '월'과 같이 입력해 주세요)\n----------------------------------------");
		String week = WeekFilterChecker.checkValue(sc.next());

		if (week == null) {
			System.out.print("3회 이상 잘못된 입력을 하여 메뉴로 돌아갑니다. \n----------------------------------------\n");
			return;
		}

		if (!WeekFilterChecker.checkWeek(week)) {
			makeSchedule();
			return;
		}
		
		sc.nextLine(); // 

		while (true) {
			System.out.print("일정을 입력해 주세요.");
			String schedule = sc.nextLine();

			if (!WeekFilterChecker.checkSchedule())
				continue;
			boolean flag = false;
			for (int i = 0; i < WeekScheduler.week.length; i++) {
				if (week.equals(WeekScheduler.week[i])) {
					if (WeekScheduler.days[i].getSchedule() != null) {
						System.out.println("해당 요일에는 이미 일정이 있습니다. 다른 요일을 선택해 주세요.");
						System.out.println(WeekScheduler.week[i] + " : " + WeekScheduler.days[i].getSchedule());
						System.out.println("----------------------------------------");
						makeSchedule();
						return;
					}
					WeekScheduler.days[i].setSchedule(schedule);
					System.out.println("일정이 정상적으로 등록되었습니다.\n----------------------------------------");
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
	}

	void removeSchedule() {
		if (WeekFilterChecker.allSchedulesNull()) {
			System.out.println("일정이 존재하지 않습니다. 하나 이상의 일정을 생성해 주세요. \n----------------------------------------");
			return;
		} else {
			System.out.print("요일을 입력해 주세요.\n(월요일은 '월'과 같이 입력해 주세요)\n");
			viewAllSchedule();
			String week = WeekFilterChecker.checkValue(sc.nextLine());
			if (week == null) {
				System.out.print("3회 이상 잘못된 입력을 하여 메뉴로 돌아갑니다. \n----------------------------------------\n");
				return;
			}
			if (!WeekFilterChecker.checkWeek(week)) {
				removeSchedule();
				return;
			}
			for (int i = 0; i < WeekScheduler.week.length; i++) {
				if (week.equals(WeekScheduler.week[i]) && WeekScheduler.days[i].getSchedule() != null) {
					WeekScheduler.days[i].setSchedule(null);
					System.out.println("일정이 정상적으로 삭제되었습니다.\n----------------------------------------");
					return;
				} else if (week.equals(WeekScheduler.week[i]) && WeekScheduler.days[i].getSchedule() == null) {
					System.out.println(
							"해당 요일은 이미 일정이 비어있습니다. 삭제하실 다른 요일을 선택해 주세요.\n----------------------------------------");
					sc.nextLine();
					removeSchedule();
					return;
				}
			}
			System.out.println("사용자가 입력을 취소하였습니다. 메뉴로 돌아갑니다.\n----------------------------------------");
			return;
		}
	}

	void modifySchedule() {
		System.out.print("요일을 입력해 주세요.\n(월요일은 '월'과 같이 입력해 주세요)\n----------------------------------------");
		String week = WeekFilterChecker.checkValue(sc.nextLine());
		if (week == null) {
			System.out.print("3회 이상 잘못된 입력을 하여 메뉴로 돌아갑니다. \n----------------------------------------\n");
			return;
		}
		if (!WeekFilterChecker.checkWeek(week)) {
			modifySchedule();
			return;
		}

		boolean flag = false; 
		
		while (true) {
			System.out.println("일정을 입력해 주세요.");
			String schedule = sc.nextLine();

			if (!WeekFilterChecker.checkSchedule())
				continue;

			for (int i = 0; i < WeekScheduler.week.length; i++) {
				if (week.equals(WeekScheduler.week[i])) {
					if (days[i].getSchedule() == null) {
						System.out.println(
								"현재 요일에는 일정이 없습니다. 일정을 새로 등록할까요?\n(Y/N)\n----------------------------------------");
						if (!WeekFilterChecker.confirm())
							continue;
						WeekScheduler.days[i].setSchedule(schedule);
						System.out.println("일정이 정상적으로 등록되었습니다.");
						System.out.printf("%s : %s \n", WeekScheduler.week[i], days[i].output());
						System.out.println("-----------------------------------------");
						flag = true;
						break;
					} else {
						System.out.println(
								"현재 요일에는 이미 일정이 있습니다. 정말 일정을 수정할까요?\n(Y/N)\n----------------------------------------");
						if (!WeekFilterChecker.confirm())
							continue;
						WeekScheduler.days[i].setSchedule(schedule);
						System.out.println("일정이 정상적으로 수정되었습니다.");
						System.out.printf("%s : %s \n", WeekScheduler.week[i], days[i].output());
						System.out.println("-----------------------------------------");
						flag = true;
						break;
					}
				}
			}
			if(flag) return;
		}
	}

	void selectSchedule() {
		while (true) {
			try {
				System.out.println("----------------------------------------");
				System.out.println("보실 내용을 선택해 주세요. ");
				System.out.println("1. 전체 보기 2. 검색하기 3. 초기 메뉴 이동");
				System.out.println("----------------------------------------");
				int num = sc.nextInt();
				sc.nextLine();
				switch (num) {
				case 1:
					viewAllSchedule();
					break;
				case 2:
					seelctAndViewSchedule();
					break;
				case 3:
					seelctAndViewSchedule();
					break;
				default:
					System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.");
				sc.nextLine();
			}
		}
	}

	void viewAllSchedule() {
		System.out.println("----------------------------------------");
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%s : %s \n", week[i], days[i].output());
		}
		System.out.println("----------------------------------------");
	}

	void seelctAndViewSchedule() {
		System.out.print("요일을 입력해 주세요.\n(월요일은 '월'과 같이 입력해 주세요)\n----------------------------------------");
		String week = WeekFilterChecker.checkValue(sc.next());
		if (week == null) {
			System.out.print("3회 이상 잘못된 입력을 하여 메뉴로 돌아갑니다. \n----------------------------------------\n");
			menu();
			return;
		}

		if (!WeekFilterChecker.checkWeek(week)) {
			seelctAndViewSchedule();
			return;
		}

		for (int i = 0; i < WeekScheduler.week.length; i++) {
			if (WeekScheduler.week[i].equals(week)) {
				System.out.println("----------------------------------------");
				System.out.println("검색하신 요일의 현재 일정은 다음과 같습니다.");
				System.out.printf("%s : %s \n", WeekScheduler.week[i], days[i].output());
				System.out.println("----------------------------------------");
			}
		}
		while (true) {
			try {
				System.out.println("검색을 계속 하시겠습니까?");
				System.out.println("1. 메뉴로 돌아가기 2. 검색하기 3. 초기 메뉴 이동");
				System.out.println("----------------------------------------");
				int num = sc.nextInt();
				sc.nextLine();
				switch (num) {
				case 1:
					menu();
					break;
				case 2:
					seelctAndViewSchedule();
					break;
				case 3:
					menu();
					break;
				default:
					System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.\n----------------------------------------");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("올바르지 않은 입력입니다. 올바른 값을 입력해 주세요.\n----------------------------------------");
				sc.nextLine();
			}
		}

	}

	void exit() {
		System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
		System.exit(0);
	}

	void run() {
		System.out.printf("%s님 환영합니다.\n%d번째 스케쥴러실행합니다.", this.userId, this.schedulerNumber);
		menu();
	}
}