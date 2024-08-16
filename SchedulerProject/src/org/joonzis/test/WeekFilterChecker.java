package org.joonzis.test;

import java.util.Scanner;

public class WeekFilterChecker {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public WeekFilterChecker() {
		
	}
	
	static String checkValue(String input) {
		int count = 0;
		while (count != 2) {
			for (String day : WeekScheduler.getWeek()) {
				if (input.equals(day))
					return input;
			}
			count++;
			System.out.printf(
					"잘못된 입력입니다. 다시 입력해 주세요. (%d회 틀릴 경우 메뉴로 돌아갑니다.) \n----------------------------------------",
					3 - count);
			input = sc.next();
		}
		return null;
	}
	
	static boolean checkWeek(String week){
		boolean flag = true;
		while (flag) {
			System.out.println(
					"입력하신 요일은 : " + week + "요일 입니다. 맞습니까?\n(Y/N)\n----------------------------------------");
			String userIndication = sc.next();

			char indication = userIndication.charAt(0);
			if (userIndication.length() > 1 || (indication != 'N' && indication != 'Y')) {
				System.out.println("잘못된 입력입니다. 올바르게 입력해 주세요.\n----------------------------------------");
			} else if (indication == 'N') {
				System.out.println("요일을 다시 입력해 주세요.");
				return false; // 메서드를 종료하여 반복문을 탈출합니다.
			} else {
				flag = false; // flag 값을 false로 변경하여 반복문을 종료합니다.
			}
		}
		return true;
	}

	static boolean checkSchedule() {
		while (true) {
			System.out.println("입력하신 일정을 저장할까요?\n(Y/N)\n----------------------------------------");
			
			String userInput = sc.next(); // Y/N 입력 받기
			
			if (userInput.length() != 1) {
				System.out.println("잘못된 입력입니다. 다시 선택해 주세요.\n----------------------------------------");
				continue; // 반복문의 처음으로 돌아감
			}

			char indication = userInput.charAt(0);
			if (indication == 'N') {
				return false;
			} else if (indication == 'Y') {
				break; // 반복문 종료
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.\n----------------------------------------");
			}
		}
		return true;
	}

	static boolean confirm() {
		while (true) {

			String userInput = sc.next();

			if (userInput.length() > 1 || userInput.charAt(0) != 'Y' && userInput.charAt(0) != 'N') {
				System.out.print("올바른 입력이 아닙니다. Y 또는 N을 입력해 주세요.\n----------------------------------------");
				continue;
			}

			if (userInput.charAt(0) == 'Y') {
				break; // 그냥 리턴하여 메서드 종료
			} else if (userInput.charAt(0) == 'N') {
				return false;
			} else {
				System.out.println("올바른 입력이 아닙니다. Y 또는 N을 입력해 주세요.\n----------------------------------------");
				continue;
			}
		}return true;
	}

	static boolean allSchedulesNull() {
		for (Day day : WeekScheduler.getDays()) {
			if (day.getSchedule() != null) {
				return false; // 하나라도 schedule이 null이 아니면 false 반환
			}
		}
		return true; // 모든 요소의 schedule이 null일 때 true 반환
	}
}