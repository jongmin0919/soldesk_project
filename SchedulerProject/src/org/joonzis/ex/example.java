package org.joonzis.ex;

import java.util.HashMap;
import java.util.Map;

public class example {

	public static void main(String[] args) {
		// 동적 배열 생성 후 요소들을 push
		HashMap<String, Integer> ageMap = new HashMap<>();
		ageMap.put("James", 30);
		ageMap.put("Martin", 20);
		ageMap.put("Michel", 29);

		for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
			String name = entry.getKey();
			int age = entry.getValue();
			System.out.println(name + "의 나이는" + age + "살 입니다.");
		}
	}

}
