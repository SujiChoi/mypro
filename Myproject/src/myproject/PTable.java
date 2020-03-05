package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;

public class PTable extends JFrame {

	private JPanel contentPane;
	private JTextField pname;
	private JTextField pbirth;
	private JTextField pphone1;
	private JTextField phight;
	private JTextField pweight;
	private String[] plist = new String[9];
	private int PlistRow;
	private JTextField textField;
	private JTextField pphone2;
	private JTextField pphone3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTable frame = new PTable();
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
	public PTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("부산IT병원 로그인 화면");
		setSize(1240,660);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Pmanage = new JMenu("\uD658\uC790\uAD00\uB9AC");
		Pmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Pmanage);
		
		JMenuItem Penroll = new JMenuItem("\uD658\uC790 \uB4F1\uB85D");
		Penroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\broken.png"));
		Penroll.setFont(new Font("돋움", Font.PLAIN, 15));
//		Penroll.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				new PTable().setVisible(true);
//			}
//		});
		Pmanage.add(Penroll);
		
		JMenu Tmanage = new JMenu("\uAC80\uC0AC\uAD00\uB9AC");
		Tmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Tmanage);
		
		JMenuItem Tenroll = new JMenuItem("\uAC80\uC0AC \uB4F1\uB85D");
		Tenroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TTable().setVisible(true);
			}
		});
		
		Tenroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\blood-sample.png"));
		Tenroll.setFont(new Font("돋움", Font.PLAIN, 15));
		Tmanage.add(Tenroll);
		
		JMenuItem Tresult = new JMenuItem("\uAC80\uC0AC\uACB0\uACFC\uD655\uC778");
		Tresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TResultTable().setVisible(true);
			}
		});
		Tresult.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\chart1.png"));
		Tresult.setFont(new Font("돋움", Font.PLAIN, 15));
		Tmanage.add(Tresult);
		
		JMenu Mmanage = new JMenu("\uC6D0\uBB34\uAD00\uB9AC");
		Mmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Mmanage);
		
		JMenuItem Mresult = new JMenuItem("\uC6D0\uBB34 \uC5C5\uBB34");
		Mresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ATable().setVisible(true);
			}
		});
		Mresult.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\chart1.png"));
		Mresult.setFont(new Font("돋움", Font.PLAIN, 15));
		Mmanage.add(Mresult);
		
		JMenu Hmanage = new JMenu("\uC758\uB8CC\uC9C4\uAD00\uB9AC");
		Hmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Hmanage);
		
		JMenuItem Henroll = new JMenuItem("\uC758\uB8CC\uC9C4 \uB4F1\uB85D");
		Henroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\app.png"));
		Henroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Htable().setVisible(true);
			}
		});
		Henroll.setFont(new Font("돋움", Font.PLAIN, 15));
		Hmanage.add(Henroll);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1284, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 0, 325, 607);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD658\uC790 \uC815\uBCF4 \uB4F1\uB85D");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 23, 325, 40);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-27, 116, 116, 33);
		panel_1.add(lblNewLabel_1);
		
		pname = new JTextField();
		pname.setHorizontalAlignment(SwingConstants.CENTER);
		pname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pname.setBounds(127, 121, 136, 26);
		panel_1.add(pname);
		pname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(-27, 159, 116, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(-27, 202, 116, 33);
		panel_1.add(lblNewLabel_1_1_1);
		
		pbirth = new JTextField();
		pbirth.setHorizontalAlignment(SwingConstants.CENTER);
		pbirth.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pbirth.setColumns(10);
		pbirth.setBounds(127, 207, 136, 26);
		panel_1.add(pbirth);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(-27, 245, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		pphone1 = new JTextField();
		pphone1.setHorizontalAlignment(SwingConstants.CENTER);
		pphone1.setText("010");
		pphone1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pphone1.setColumns(10);
		pphone1.setBounds(127, 250, 35, 26);
		panel_1.add(pphone1);
		
		pphone2 = new JTextField();
		pphone2.setHorizontalAlignment(SwingConstants.CENTER);
		pphone2.setColumns(10);
		pphone2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pphone2.setBounds(177, 250, 35, 26);
		panel_1.add(pphone2);
		
		pphone3 = new JTextField();
		pphone3.setHorizontalAlignment(SwingConstants.CENTER);
		pphone3.setColumns(10);
		pphone3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pphone3.setBounds(228, 250, 35, 26);
		panel_1.add(pphone3);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\uD0A4");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(-27, 288, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		phight = new JTextField();
		phight.setHorizontalAlignment(SwingConstants.RIGHT);
		phight.setBorder(new LineBorder(Color.LIGHT_GRAY));
		phight.setColumns(10);
		phight.setBounds(127, 293, 116, 26);
		panel_1.add(phight);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("\uBAB8\uBB34\uAC8C");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(-27, 331, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		pweight = new JTextField();
		pweight.setHorizontalAlignment(SwingConstants.RIGHT);
		pweight.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pweight.setColumns(10);
		pweight.setBounds(127, 336, 116, 26);
		panel_1.add(pweight);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("\uD608\uC561\uD615");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(-27, 374, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(-27, 417, 116, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton input = new JButton("\uC800\uC7A5");
		input.setBounds(60, 520, 69, 31);
		panel_1.add(input);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.setBounds(141, 520, 69, 31);
		panel_1.add(modify);
		
		String[] Gender = {"여자 ","남자 "};
		JComboBox gender = new JComboBox(Gender);
		gender.setAlignmentX(Component.RIGHT_ALIGNMENT);
		gender.setBounds(127, 163, 136, 26);
		panel_1.add(gender);
		
		String[] Bloodty = {"RH+ A ","RH+ B ","RH+ AB ","RH+ O ","RH- A ","RH- B ","RH- AB ","RH- O "};
		JComboBox booldty = new JComboBox(Bloodty);
		booldty.setBounds(127, 378, 136, 26);
		panel_1.add(booldty);
		
		JTextArea address = new JTextArea();
		address.setBorder(new LineBorder(new Color(192, 192, 192)));
		address.setBounds(127, 423, 136, 60);
		address.setLineWrap(true);
		panel_1.add(address);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(-27, 73, 116, 33);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel pid = new JLabel("\uD658\uC790\uBC88\uD638");
		pid.setHorizontalAlignment(SwingConstants.CENTER);
		pid.setFont(new Font("굴림", Font.PLAIN, 14));
		pid.setBounds(127, 73, 116, 33);
		panel_1.add(pid);
		
		JLabel plistcol = new JLabel("New label");
		plistcol.setBounds(12, 452, -1, 15);
		panel_1.add(plistcol);
		
		JLabel plistrow = new JLabel("New label");
		plistrow.setBounds(12, 452, 7, 15);
		panel_1.add(plistrow);
		
		JButton delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(221, 520, 69, 31);
		panel_1.add(delete);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(325, 0, 899, 607);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		String[][] data = Myprojectsql.showPlist();
		String[] headers = {"환자번호","이름","성별","생년월일","전화번호","키","몸무게","혈액형","주소"};
		DefaultTableModel tb = new DefaultTableModel(data,headers);
		JTable table = new JTable(tb){
			
			public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
		        Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

		        Object value = getModel().getValueAt(rowIndex,columnIndex);
		        
		        if((rowIndex%2)==0) {
		        	componenet.setBackground(new Color(239,242,247));
		        }else {
		        	componenet.setBackground(Color.white);
		        }
		        return componenet;
			}
		};
		//table.setRowHeight(30);
		
		JScrollPane plistpane = new JScrollPane(table);
		plistpane.setBounds(40, 80, 837, 501);
		panel_2.add(plistpane);
		
		JLabel la_searchname = new JLabel("\uC774\uB984");
		la_searchname.setBounds(507, 37, 116, 33);
		la_searchname.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchname.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(la_searchname);
		
		JTextField searchname = new JTextField();
		searchname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String val = searchname.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchname.setBounds(635, 42, 93, 26);
		searchname.setColumns(10);
		searchname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.add(searchname);
		
		JLabel la_searchjob = new JLabel("\uC9C1\uCC45");
		la_searchjob.setBounds(729, 37, 43, 33);
		la_searchjob.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchjob.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(la_searchjob);
		
		String[] joblist = {"의사","간호사","원무","DB매니저"};
		JComboBox searchjob = new JComboBox(joblist);
		searchjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = searchjob.getSelectedItem().toString();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchjob.setBounds(784, 44, 93, 21);
		searchjob.setAlignmentX(1.0f);
		panel_2.add(searchjob);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("cm");
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_2.setBounds(245, 288, 35, 40);
		panel_1.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("kg");
		lblNewLabel_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(245, 329, 35, 40);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1);
		
		
		JLabel lblNewLabel_1_1_1_1_1_2_2 = new JLabel("-");
		lblNewLabel_1_1_1_1_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_2_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_2_2.setBounds(163, 245, 21, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2_2_1 = new JLabel("-");
		lblNewLabel_1_1_1_1_1_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_2_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_2_2_1.setBounds(214, 245, 21, 33);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_2_1);
				
		input.addActionListener(new ActionListener() {  // 등록 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				
				String strpname = pname.getText();
				String strgender = gender.getSelectedItem().toString();
				String strpbirth = pbirth.getText();
				String strpphone1 = pphone1.getText();
				String strpphone2 = pphone2.getText();
				String strpphone3 = pphone3.getText();
				String strphight = phight.getText();
				String strpweight = pweight.getText();
				String strbloodty = booldty.getSelectedItem().toString();
				String straddress = address.getText();    // 텍스트필드의 값 불러오기
				
				String strpphone = strpphone1+strpphone2+strpphone3;

				
				Myprojectsql.InputPlist(strpname,strgender,strpbirth,strpphone,strphight,strpweight,strbloodty,straddress); //DB에 입력하기
				
				String strpid = Myprojectsql.OutputPlist(); // DB에서 생성된 환자번호 가져오기
				
				pname.setText(" ");pbirth.setText(" ");pphone2.setText(" ");pphone3.setText(" ");phight.setText(" ");address.setText(" "); // 칸 삭제하기
				
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
				  
				  String[] pphonenum = {plist[4].substring(0,3),plist[4].substring(3,7),plist[4].substring(7,11)};
				  
				  pid.setText(plist[0]);pname.setText(plist[1]);gender.setSelectedItem(plist[2]);pbirth.setText(plist[3]);pphone1.setText(pphonenum[0]);
				  pphone2.setText(pphonenum[1]);pphone3.setText(pphonenum[2]);phight.setText(plist[5]);pweight.setText(plist[6]);booldty.setSelectedItem(plist[7]);address.setText(plist[8]);
				  //리스트 값을 변환
			}
		});
		
		modify.addActionListener(new ActionListener() { // 수정 버튼 이벤트
			public void actionPerformed(ActionEvent e) {
				
				String strpid = pid.getText();
				String strpname = pname.getText();
				String strgender = gender.getSelectedItem().toString();
				String strpbirth = pbirth.getText();
				String strpphone1 = pphone1.getText();
				String strpphone2 = pphone2.getText();
				String strpphone3 = pphone3.getText();
				String strphight = phight.getText();
				String strpweight = pweight.getText();
				String strbloodty = booldty.getSelectedItem().toString();
				String straddress = address.getText(); // 데이터 다 불러오기 >> 수정 뭐가 될지 모르기 때문에
				
				String strpphone = strpphone1+strpphone2+strpphone3;
				
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

