package myproject;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;


public class PEnroll extends JFrame {

	private JPanel contentPane;
	private JTextField pname;
	private JTextField pbirth;
	private JTextField pphone;
	private JTextField phight;
	private JTextField pweight;
	private String[] plist = new String[9];
	private int PlistRow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PEnroll frame = new PEnroll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PEnroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("부산IT병원 로그인 화면");
		setSize(1300,700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton penroll = new JButton("\uD658\uC790\uAD00\uB9AC");
		penroll.setBackground(SystemColor.textHighlight);
		penroll.setFont(new Font("굴림", Font.PLAIN, 11));
		penroll.setBounds(39, 25, 100, 31);
		contentPane.add(penroll);
		
		JButton tenroll = new JButton("\uAC80\uC0AC\uB4F1\uB85D");
		tenroll.setBackground(SystemColor.control);
		tenroll.setFont(new Font("굴림", Font.PLAIN, 11));
		tenroll.setBounds(139, 25, 100, 31);
		contentPane.add(tenroll);
		
		JButton tmanage = new JButton("\uAC80\uC0AC\uAD00\uB9AC");
		tmanage.setBackground(SystemColor.control);
		tmanage.setFont(new Font("굴림", Font.PLAIN, 11));
		tmanage.setBounds(239, 25, 100, 31);
		contentPane.add(tmanage);
		
		JButton mmanage = new JButton("\uC6D0\uBB34\uAD00\uB9AC");
		mmanage.setBackground(SystemColor.control);
		mmanage.setFont(new Font("굴림", Font.PLAIN, 11));
		mmanage.setBounds(339, 25, 100, 31);
		contentPane.add(mmanage);
		
		JButton hmanage = new JButton("\uC758\uB8CC\uC9C4\uAD00\uB9AC");
		hmanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Henroll().setVisible(true);
			}
		});
		hmanage.setBackground(SystemColor.control);
		hmanage.setFont(new Font("굴림", Font.PLAIN, 11));
		hmanage.setBounds(439, 25, 100, 31);
		contentPane.add(hmanage);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 56, 1210, 575);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(61, 48, 325, 477);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD658\uC790\uC815\uBCF4\uB4F1\uB85D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 10, 325, 40);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 77, 116, 33);
		panel_1.add(lblNewLabel_1);
		
		pname = new JTextField();
		pname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pname.setBounds(154, 82, 116, 26);
		panel_1.add(pname);
		pname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(0, 110, 116, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(0, 141, 116, 33);
		panel_1.add(lblNewLabel_1_1_1);
		
		pbirth = new JTextField();
		pbirth.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pbirth.setColumns(10);
		pbirth.setBounds(154, 146, 116, 26);
		panel_1.add(pbirth);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(0, 173, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		pphone = new JTextField();
		pphone.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pphone.setColumns(10);
		pphone.setBounds(154, 178, 116, 26);
		panel_1.add(pphone);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\uD0A4");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(0, 208, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		phight = new JTextField();
		phight.setBorder(new LineBorder(Color.LIGHT_GRAY));
		phight.setColumns(10);
		phight.setBounds(154, 213, 116, 26);
		panel_1.add(phight);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("\uBAB8\uBB34\uAC8C");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 245, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		pweight = new JTextField();
		pweight.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pweight.setColumns(10);
		pweight.setBounds(154, 250, 116, 26);
		panel_1.add(pweight);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("\uD608\uC561\uD615");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 279, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(0, 310, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton input = new JButton("\uC800\uC7A5");
		input.setBounds(62, 422, 69, 23);
		panel_1.add(input);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.setBounds(143, 422, 69, 23);
		panel_1.add(modify);
		
		String[] Gender = {"여자 ","남자 "};
		JComboBox gender = new JComboBox(Gender);
		gender.setAlignmentX(Component.RIGHT_ALIGNMENT);
		gender.setBounds(154, 117, 116, 21);
		panel_1.add(gender);
		
		String[] Bloodty = {"RH+ A ","RH+ B ","RH+ AB ","RH+ O ","RH- A ","RH- B ","RH- AB ","RH- O "};
		JComboBox booldty = new JComboBox(Bloodty);
		booldty.setBounds(154, 286, 116, 21);
		panel_1.add(booldty);
		
		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(new Color(192, 192, 192)));
		address.setBounds(154, 316, 116, 60);
		address.setLineWrap(true);
		panel_1.add(address);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(0, 47, 116, 33);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel pid = new JLabel("\uD658\uC790\uBC88\uD638");
		pid.setHorizontalAlignment(SwingConstants.CENTER);
		pid.setFont(new Font("굴림", Font.PLAIN, 14));
		pid.setBounds(154, 47, 116, 33);
		panel_1.add(pid);
		
		JLabel plistcol = new JLabel("New label");
		plistcol.setBounds(12, 452, -1, 15);
		panel_1.add(plistcol);
		
		JLabel plistrow = new JLabel("New label");
		plistrow.setBounds(12, 452, 7, 15);
		panel_1.add(plistrow);
		
		JButton delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(223, 422, 69, 23);
		panel_1.add(delete);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBounds(435, 48, 724, 477);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		String[][] data = Myprojectsql.showPlist();
		String[] headers = {"환자번호","이름","성별","생년월일","전화번호","키","몸무게","혈액형","주소"};
		DefaultTableModel tb = new DefaultTableModel(data,headers);
		JTable table = new JTable(tb);
		//table.setRowHeight(30);
		
		JScrollPane plistpane = new JScrollPane(table);
		plistpane.setBounds(49, 34, 635, 404);
		panel_2.add(plistpane);
				
		input.addActionListener(new ActionListener() {  // 등록 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				
				String strpname = pname.getText();
				String strgender = gender.getSelectedItem().toString();
				String strpbirth = pbirth.getText();
				String strpphone = pphone.getText();
				String strphight = phight.getText();
				String strpweight = pweight.getText();
				String strbloodty = booldty.getSelectedItem().toString();
				String straddress = address.getText();    // 텍스트필드의 값 불러오기
				
				Myprojectsql.InputPlist(strpname,strgender,strpbirth,strpphone,strphight,strpweight,strbloodty,straddress); //DB에 입력하기
				
				String strpid = Myprojectsql.OutputPlist(); // DB에서 생성된 환자번호 가져오기
				
				pname.setText(" ");pbirth.setText(" ");pphone.setText(" ");phight.setText(" ");address.setText(" "); // 칸 삭제하기
				
				String[] newtb = {strpid,strpname,strgender,strpbirth,strpphone,strphight,strpweight,strbloodty,straddress}; // 입력할 자로 새로 만들기
				
				tb.addRow(newtb);  // 모델 addRow로 업데이트
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() { //클릭시 빈칸에 데이터 들어가도록 만들기
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  int row = table.getSelectedRow(); // 선택된 행 값을 인트로 반환
				  int col = table.getSelectedColumn(); // 선택된 열 값을 인트로 변환
				  PlistRow = row;
				  for (int i = 0; i < 9; i++) {
					  plist[i] = new String((String) table.getModel().getValueAt(row, i ));  //모델에서 값 불러오기 , plist에 저장
				  }
				  
				  pid.setText(plist[0]);pname.setText(plist[1]);gender.setSelectedItem(plist[2]);pbirth.setText(plist[3]);pphone.setText(plist[4]);
				  phight.setText(plist[5]);pweight.setText(plist[6]);booldty.setSelectedItem(plist[7]);address.setText(plist[8]);
				  //리스트 값을 변환
			}
		});
		
		modify.addActionListener(new ActionListener() { // 수정 버튼 이벤트
			public void actionPerformed(ActionEvent e) {
				
				String strpid = pid.getText();
				String strpname = pname.getText();
				String strgender = gender.getSelectedItem().toString();
				String strpbirth = pbirth.getText();
				String strpphone = pphone.getText();
				String strphight = phight.getText();
				String strpweight = pweight.getText();
				String strbloodty = booldty.getSelectedItem().toString();
				String straddress = address.getText(); // 데이터 다 불러오기 >> 수정 뭐가 될지 모르기 때문에
				
				Myprojectsql.ModifyPlist(strpid,strpname,strgender,strpbirth,strpphone,strphight,strpweight,strbloodty,straddress); // DB에 수정값 입력
				String[] newtb = {strpid,strpname,strgender,strpbirth,strpphone,strphight,strpweight,strbloodty,straddress}; //수정값 정리

				for(int i = 0;i<9;i++) {
					tb.setValueAt(newtb[i], PlistRow, i);} //테이블 하나하나를 수정
			}
		});
		
		delete.addActionListener(new ActionListener() { //제거 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				
				String strpid = pid.getText(); //환자번호 불러오기
				int row = table.getSelectedRow(); //클릭 값 불러오기
				
				Myprojectsql.DeletePlist(strpid);	//DB에서 삭제하기
				tb.removeRow(row); //테이블에서 제거
			}
		});
		
	}
}
