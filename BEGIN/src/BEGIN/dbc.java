package BEGIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbc {
	
	//메소드를 만들면
	// 메소드의 데이터타입과 같은 객체 생성
	// 생성한 객체를 return
	
	
	public static Connection DBConnect() {
		
		//DB에 접속정보 저장을 위한 Connection타입의 변수 con 선언
		Connection con = null;
		
		//접속할 DB의 계정정보
		String user = "JOYPEB";
		String password = "1111";
		
		//접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//여기서 예외처리가 발생하면 ClassNotFoundException으로 이동
			
			con = DriverManager.getConnection(url,user,password);
			//여기서 예외처리가 발생하면 SQLException로 이동
			
		}
		catch(ClassNotFoundException cne) {
			System.out.println("DB접속 실패 : 드라이버 로딩 실패");
			cne.printStackTrace();
		}
		catch(SQLException se) {
			System.out.println("DB접속 실패 : DB계정 주소 확인");
			se.printStackTrace();
		}
		
		return con;
	}
}
