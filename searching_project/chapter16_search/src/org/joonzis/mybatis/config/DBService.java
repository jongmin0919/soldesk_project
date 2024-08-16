package org.joonzis.mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {	// factory를 만드는게 목적

	// 필드
	private static SqlSessionFactory factory = null;
	
	// 정적 초기화 변수 (클래스가 로드될때 자동으로 실행되는 코드라고 보면 됨)
	// 아래의 메서드들은 마이바티스를 사용하기 위한 주요 메서드들이라서
	// 마이바티스 사용을 위한 하나의 그림으로 외워둘 필요가 있음.
	static {
		try {
			// 클래스 패스에서 위치한 sqlmap (마이바티스 설정 관련 xml)을 읽어오기 위한 경로를 설정
			String resource = "org/joonzis/mybatis/config/sqlmap.xml";
			// 설정된 경로의 파일을 읽어들어와 is 스트림에 저장
			InputStream is = Resources.getResourceAsStream(resource);
			// 마이바티스의 세션 팩토리를 생성(빌더의 builder메서드)한 뒤 factory 필드에 할당
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 사용자가 getFactory 메서드를 호출하면 정적으로 
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}











