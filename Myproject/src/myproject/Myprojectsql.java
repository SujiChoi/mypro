
package myproject;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Myprojectsql {

	public static void main(String[] args) {
		//creatPEnrollTable();
		//creatWorkerTable();
		//creatTestlistTable();
		creatTestresultlistTable();
		//Inputhlist("문재인","남자","원무","jeang","jeang1","북한");
		//createCustomer("sujichoi","tnwl","남","010-1234-5678","1년");
		//InputPlist("sujichoi","여자","19910327","01046635949","168","100","RH+ A","부산광역시 사하구");
	}
	
	public static void creatPEnrollTable() {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_PLIST("
					+"PID int NOT NULL AUTO_INCREMENT," //자동으로 숫자가 증가함
					+"PNAME varChar(255),"
					+"PSEX varChar(255),"
					+"PBIRTH varChar(255),"
					+"PPHONE varChar(255),"
					+"PHIGHT varChar(255),"
					+"PWEIGHT varChar(255),"
					+"PBLOODT varChar(255),"
					+"PADDRESS varChar(255),"
					+"PRIMARY KEY(PID))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	public static void creatTestlistTable() {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_TLIST("
					+"TCODE varChar(255)," //자동으로 숫자가 증가함
					+"TNAME varChar(255),"
					+"TPRICE varChar(255),"
					+"PRIMARY KEY(TCODE))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	public static void creatWorkerTable() {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			System.out.println("AA");
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_HLIST("
					+"HNAME varChar(255)," 
					+"HGENDER varChar(255),"
					+"HJOB varChar(255),"
					+"HID varChar(255),"
					+"HPW varChar(255),"
					+"HADDRESS varChar(255),"
					+"PRIMARY KEY(HID))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	
	public static void creatTestresultlistTable() {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_TRESULT("
					+"TPKCODE varChar(255)," //PID + 날짜 + 코드
					+"TCODE varChar(255),"
					+"PID varChar(255),"
					+"TDATE DATE," //입력날짜
					+"TRESULT varChar(255),"
					+"TRESULT1 varChar(255) default '',"
					+"PPAYREULT varChar(255) default '미납',"
					+"PRIMARY KEY(TPKCODE))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	

	public static boolean login(String hid, String hpw) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			System.out.println("AA");
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_hlist where hid =? and hpw =?" //물음표값을  setString으로 넣어준다.
					);
			statement.setString(1, hid);
			statement.setString(2, hpw);
			System.out.println("BB");
			
			ResultSet results = statement.executeQuery();
			System.out.println("EE");
			if(results.next()) { //결과값이 있으면 로그인이 됨
				System.out.println("CC");
				return true;
				//원래 있던창 끄기
			}else {
				System.out.println("DD");
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 한번 확인해 주세요.");
				return false;
			}
		}
		catch(Exception e){return false;}
	}
	public static void InputPlist(String strpname,String strgender,String strpbirth,String strpphone,String strphight,String strweight,String strbloodty,String straddress) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn.prepareStatement(
					"insert into tbl_plist(pname,psex,pbirth,pphone,phight,pweight,pbloodt,paddress)"
					+ "values('"+strpname+"','"+strgender+"','"+strpbirth+"','"+strpphone+"','"+strphight+"','"+strweight+"','"+strbloodty+"','"+straddress+"')"
					);
			create1.execute();
			JOptionPane.showMessageDialog(null, "환자정보 저장이 완료 되었습니다.");
		}
		catch(Exception e){}
	}
	public static void Inputhlist(String hname,String hgender,String hjob, String hid,String hpw,String haddress) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"insert into tbl_hlist(hname,hgender,hjob,hid,hpw,haddress)"
					+ "values('"+hname+"','"+hgender+"','"+hjob+"','"+hid+"','"+hpw+"','"+haddress+"')"
					);
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
		
	}
	
	public static String OutputPlist() {
		try {
			Connection conn = getConnection();
			System.out.println("AA");
			PreparedStatement pid = conn.prepareStatement(
					"SELECT * FROM dbhospital.tbl_plist ORDER BY PID DESC LIMIT 1");
			ResultSet results = pid.executeQuery();
			results.next();
			String PID = results.getString("pid");
			return PID;
		}
		
		catch(Exception e){return null;}
	}
	
	public static void ModifyPlist(String strpid,String strpname,String strgender,String strpbirth,String strpphone,String strphight,String strweight,String strbloodty,String straddress) {
		try {
			String[] modiplist = {strpname,strgender,strpbirth,strpphone,strphight,strweight,strbloodty,straddress,strpid};
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn.prepareStatement(
					"UPDATE dbhospital.tbl_plist SET PNAME=?,PSEX=?,pbirth=?,pphone=?,phight=?,pweight=?,pbloodt=?,paddress=? WHERE PID=?"
					);
			for(int i =0;i<9;i++) {
				create1.setString(i+1, modiplist[i]);
			}
			create1.execute();
			
			JOptionPane.showMessageDialog(null, "환자정보 수정이 완료 되었습니다.");
		}
		catch(Exception e){}
	}
	
	public static void DeletePlist(String strpid) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create2 = conn.prepareStatement(
					"delete from dbhospital.tbl_plist where pid=?");
			create2.setString(1,strpid);
			create2.execute();
			
			JOptionPane.showMessageDialog(null, "환자정보 삭제가 완료 되었습니다.");
			
		}
		catch(Exception e){}
	}
	public static String[][] showPlist(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_plist"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("pid"),
						results.getString("pname"),
						results.getString("psex"),
						results.getString("pbirth"),
						results.getString("pphone"),
						results.getString("phight"),
						results.getString("pweight"),
						results.getString("pbloodt"),
						results.getString("paddress"),
				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][5];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
			
//				System.out.print(results.getString("id"+" "));
//				System.out.print(results.getString("pw"+" "));
//				System.out.print(results.getString("gender"+" "));
//				System.out.print(results.getString("phone"+" "));
//				System.out.println(results.getString("peri"+" "));
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
		
	}
	
	public static String[][] showHlist(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_hlist"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("hname"),
						results.getString("hgender"),
						results.getString("hjob"),
						results.getString("hid"),
						results.getString("hpw"),
						results.getString("haddress"),
				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][5];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
			
//				System.out.print(results.getString("id"+" "));
//				System.out.print(results.getString("pw"+" "));
//				System.out.print(results.getString("gender"+" "));
//				System.out.print(results.getString("phone"+" "));
//				System.out.println(results.getString("peri"+" "));
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
	}
	
	public static String[][] showTdate(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT distinct TDATE FROM dbhospital.tbl_tresult"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("TDATE"),
				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][5];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
	}
	
	public static String[][] showTresultlist1(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"select distinct T.TCODE,T.TNAME,R.TRESULT1 from dbhospital.tbl_tlist T,dbhospital.tbl_tresult R where T.TCODE REGEXP '[B]'"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("TCODE"),
						results.getString("TNAME"),
						results.getString("TRESULT1"),

				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][3];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
	}
	public static String[][] showTresultlist2(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"select distinct T.TCODE,T.TNAME,R.TRESULT1 from dbhospital.tbl_tlist T,dbhospital.tbl_tresult R where T.TCODE REGEXP '[BC]'"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("TCODE"),
						results.getString("TNAME"),
						results.getString("TRESULT1"),

				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][3];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
	}
	
	public static String[][] showPayresultlist(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * from dbhospital.tbl_tresult R, dbhospital.tbl_plist P,dbhospital.tbl_tlist T where R.PID = P.PID && T.TCODE = R.TCODE"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("PNAME"),
						results.getString("PID"),
						results.getString("TCODE"),
						results.getString("TDATE"),
						results.getString("TPRICE"),
						results.getString("PPAYREULT"),
				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][9];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
		}
		catch(Exception e){
			System.out.println("검색실패3");return null;}
	}
	
	public static String[][] showTresultlist3(){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"select distinct T.TCODE,T.TNAME,R.TRESULT1 from dbhospital.tbl_tlist T,dbhospital.tbl_tresult R where T.TCODE REGEXP '[BCD]'"
					);
			
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("TCODE"),
						results.getString("TNAME"),
						results.getString("TRESULT1"),

				});
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][3];  //행 사이즈 열 사이즈
			return list.toArray(arr); //리스트를 어레이로 바꾸는데 arr형식으로
		}
		catch(Exception e){
			System.out.println("검색실패");return null;}
	}
	
	public static Connection getConnection() {
		String drive = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/dbhospital?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "1234";
		try {
			Class.forName(drive);
			System.out.println("연결중");
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 완료");
			return conn;
			
		}catch(Exception e){
			System.out.println("연결 문제");
			return null;
		}
	}
}

//String selectedtest = Tcode.getSelectedItem().toString();
//switch(selectedtest) {
//case "검진 기본 검사 I": panel.add(panel_3); break;
//case "검진 기본 검사 II" : panel.add(panel_4); break;
////case "검진 고급 검사" : panel.add(panel_5); break;
//}

//btnNewButton.addActionListener(new ActionListener() {
//public void actionPerformed(ActionEvent e) {
//	String selectedtest = Tcode.getSelectedItem().toString();
//	switch(selectedtest) {
//	case "검진 기본 검사 I": panel.add(testI); break;
//	case "검진 기본 검사 II" : panel.add(testII); break;
//	case "검진 고급 검사" : panel.add(testIII); break;
//	}
//}
//});	