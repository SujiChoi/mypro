
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
		//Inputhlist("������","����","����","jeang","jeang1","����");
		//createCustomer("sujichoi","tnwl","��","010-1234-5678","1��");
		//InputPlist("sujichoi","����","19910327","01046635949","168","100","RH+ A","�λ걤���� ���ϱ�");
	}
	
	public static void creatPEnrollTable() {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_PLIST("
					+"PID int NOT NULL AUTO_INCREMENT," //�ڵ����� ���ڰ� ������
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
			System.out.println("�����߽��ϴ�.");
		}
		catch(Exception e){}
	}
	public static void creatTestlistTable() {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_TLIST("
					+"TCODE varChar(255)," //�ڵ����� ���ڰ� ������
					+"TNAME varChar(255),"
					+"TPRICE varChar(255),"
					+"PRIMARY KEY(TCODE))");
			create.execute();
			System.out.println("�����߽��ϴ�.");
		}
		catch(Exception e){}
	}
	public static void creatWorkerTable() {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�����߽��ϴ�.");
		}
		catch(Exception e){}
	}
	
	public static void creatTestresultlistTable() {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_TRESULT("
					+"TPKCODE varChar(255)," //PID + ��¥ + �ڵ�
					+"TCODE varChar(255),"
					+"PID varChar(255),"
					+"TDATE DATE," //�Է³�¥
					+"TRESULT varChar(255),"
					+"TRESULT1 varChar(255) default '',"
					+"PPAYREULT varChar(255) default '�̳�',"
					+"PRIMARY KEY(TPKCODE))");
			create.execute();
			System.out.println("�����߽��ϴ�.");
		}
		catch(Exception e){}
	}
	

	public static boolean login(String hid, String hpw) {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			System.out.println("AA");
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_hlist where hid =? and hpw =?" //����ǥ����  setString���� �־��ش�.
					);
			statement.setString(1, hid);
			statement.setString(2, hpw);
			System.out.println("BB");
			
			ResultSet results = statement.executeQuery();
			System.out.println("EE");
			if(results.next()) { //������� ������ �α����� ��
				System.out.println("CC");
				return true;
				//���� �ִ�â ����
			}else {
				System.out.println("DD");
				JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �ٽ� �ѹ� Ȯ���� �ּ���.");
				return false;
			}
		}
		catch(Exception e){return false;}
	}
	public static void InputPlist(String strpname,String strgender,String strpbirth,String strpphone,String strphight,String strweight,String strbloodty,String straddress) {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create1 = conn.prepareStatement(
					"insert into tbl_plist(pname,psex,pbirth,pphone,phight,pweight,pbloodt,paddress)"
					+ "values('"+strpname+"','"+strgender+"','"+strpbirth+"','"+strpphone+"','"+strphight+"','"+strweight+"','"+strbloodty+"','"+straddress+"')"
					);
			create1.execute();
			JOptionPane.showMessageDialog(null, "ȯ������ ������ �Ϸ� �Ǿ����ϴ�.");
		}
		catch(Exception e){}
	}
	public static void Inputhlist(String hname,String hgender,String hjob, String hid,String hpw,String haddress) {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create = conn.prepareStatement(
					"insert into tbl_hlist(hname,hgender,hjob,hid,hpw,haddress)"
					+ "values('"+hname+"','"+hgender+"','"+hjob+"','"+hid+"','"+hpw+"','"+haddress+"')"
					);
			create.execute();
			System.out.println("�����߽��ϴ�.");
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
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create1 = conn.prepareStatement(
					"UPDATE dbhospital.tbl_plist SET PNAME=?,PSEX=?,pbirth=?,pphone=?,phight=?,pweight=?,pbloodt=?,paddress=? WHERE PID=?"
					);
			for(int i =0;i<9;i++) {
				create1.setString(i+1, modiplist[i]);
			}
			create1.execute();
			
			JOptionPane.showMessageDialog(null, "ȯ������ ������ �Ϸ� �Ǿ����ϴ�.");
		}
		catch(Exception e){}
	}
	
	public static void DeletePlist(String strpid) {
		try {
			Connection conn = getConnection(); // db ���� conn��ü
			PreparedStatement create2 = conn.prepareStatement(
					"delete from dbhospital.tbl_plist where pid=?");
			create2.setString(1,strpid);
			create2.execute();
			
			JOptionPane.showMessageDialog(null, "ȯ������ ������ �Ϸ� �Ǿ����ϴ�.");
			
		}
		catch(Exception e){}
	}
	public static String[][] showPlist(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][5];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
			
//				System.out.print(results.getString("id"+" "));
//				System.out.print(results.getString("pw"+" "));
//				System.out.print(results.getString("gender"+" "));
//				System.out.print(results.getString("phone"+" "));
//				System.out.println(results.getString("peri"+" "));
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
		
	}
	
	public static String[][] showHlist(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][5];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
			
//				System.out.print(results.getString("id"+" "));
//				System.out.print(results.getString("pw"+" "));
//				System.out.print(results.getString("gender"+" "));
//				System.out.print(results.getString("phone"+" "));
//				System.out.println(results.getString("peri"+" "));
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
	}
	
	public static String[][] showTdate(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][5];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
	}
	
	public static String[][] showTresultlist1(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][3];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
	}
	public static String[][] showTresultlist2(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][3];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
	}
	
	public static String[][] showPayresultlist(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][9];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
		}
		catch(Exception e){
			System.out.println("�˻�����3");return null;}
	}
	
	public static String[][] showTresultlist3(){
		try {
			Connection conn = getConnection(); // db ���� conn��ü
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
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][3];  //�� ������ �� ������
			return list.toArray(arr); //����Ʈ�� ��̷� �ٲٴµ� arr��������
		}
		catch(Exception e){
			System.out.println("�˻�����");return null;}
	}
	
	public static Connection getConnection() {
		String drive = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/dbhospital?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "1234";
		try {
			Class.forName(drive);
			System.out.println("������");
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB ���� �Ϸ�");
			return conn;
			
		}catch(Exception e){
			System.out.println("���� ����");
			return null;
		}
	}
}

//String selectedtest = Tcode.getSelectedItem().toString();
//switch(selectedtest) {
//case "���� �⺻ �˻� I": panel.add(panel_3); break;
//case "���� �⺻ �˻� II" : panel.add(panel_4); break;
////case "���� ��� �˻�" : panel.add(panel_5); break;
//}

//btnNewButton.addActionListener(new ActionListener() {
//public void actionPerformed(ActionEvent e) {
//	String selectedtest = Tcode.getSelectedItem().toString();
//	switch(selectedtest) {
//	case "���� �⺻ �˻� I": panel.add(testI); break;
//	case "���� �⺻ �˻� II" : panel.add(testII); break;
//	case "���� ��� �˻�" : panel.add(testIII); break;
//	}
//}
//});	