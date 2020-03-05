package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.sourceforge.jdatepicker.impl.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class TTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField personField;
	private SpringLayout springLayout;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd"); //날짜
	//SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTable frame = new TTable();
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
	public TTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("부산IT병원 로그인 화면");
		setSize(1240,660);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu Pmanage = new JMenu("\uD658\uC790\uAD00\uB9AC");
		Pmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Pmanage);
		
		JMenuItem Penroll = new JMenuItem("\uD658\uC790 \uB4F1\uB85D");
		Penroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\broken.png"));
		Penroll.setFont(new Font("돋움", Font.PLAIN, 15));
		Penroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PTable().setVisible(true);
			}
		});
		Pmanage.add(Penroll);
		
		JMenu Tmanage = new JMenu("\uAC80\uC0AC\uAD00\uB9AC");
		Tmanage.setFont(new Font("돋움", Font.PLAIN, 15));
		menuBar.add(Tmanage);
		
		JMenuItem Tenroll = new JMenuItem("\uAC80\uC0AC \uB4F1\uB85D");
//		Tenroll.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new TTable().setVisible(true);
//			}
//		});
		
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
		panel.setBounds(0, 0, 1224, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 0, 1223, 96);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(175, 53, 60, 33);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField.setBounds(247, 58, 97, 26);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(341, 53, 74, 33);
		panel_1.add(lblNewLabel_1_2);
		
		personField = new JTextField();
		personField.setColumns(10);
		personField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		personField.setBounds(426, 58, 97, 26);
		panel_1.add(personField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\uAC80\uC0AC\uC77C");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(535, 53, 55, 33);
		panel_1.add(lblNewLabel_1_2_1);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		springLayout = (SpringLayout) datePicker.getLayout();
		datePicker.setBounds(597, 57, 116, 29);
		panel_1.add(datePicker);
		
		String[] testlist = {"검진 기본 검사 I", "검진 기본 검사 II","검진 고급 검사"};
		JComboBox Tcode = new JComboBox(testlist);
		Tcode.setBounds(805, 57, 142, 26);
		panel_1.add(Tcode);
	
		JLabel lblNewLabel_1_2_1_1 = new JLabel("\uAC80\uC0AC\uD56D\uBAA9");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(714, 53, 80, 33);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(969, 59, 66, 23);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\uAC80\uC0AC \uB4F1\uB85D");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.BOLD, 23));
		lblNewLabel_2.setBounds(0, 0, 1223, 43);
		panel_1.add(lblNewLabel_2);
		
		String[][] data2 = Myprojectsql.showTdate();
		String[] headers2 = {"내원일"};
		DefaultTableModel tb2 = new DefaultTableModel(data2,headers2);
		
		JButton btnNewButton_1 = new JButton("\uB4F1\uB85D");
		btnNewButton_1.setBounds(1103, 556, 97, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAC80\uC0AC \uC785\uB825 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.menuText));
		panel_2.setBounds(31, 133, 261, 352);
		panel_2.setLayout(null);
		
		JLabel pnameget = new JLabel("\uC774\uB984");
		pnameget.setHorizontalAlignment(SwingConstants.RIGHT);
		pnameget.setFont(new Font("굴림", Font.PLAIN, 14));
		pnameget.setBounds(0, 30, 74, 33);
		panel_2.add(pnameget);
		
		JLabel pnumget = new JLabel("\uD658\uC790\uBC88\uD638");
		pnumget.setHorizontalAlignment(SwingConstants.RIGHT);
		pnumget.setFont(new Font("굴림", Font.PLAIN, 14));
		pnumget.setBounds(0, 65, 74, 33);
		panel_2.add(pnumget);
		
		JLabel pdateget = new JLabel("\uAC80\uC0AC\uC77C");
		pdateget.setHorizontalAlignment(SwingConstants.RIGHT);
		pdateget.setFont(new Font("굴림", Font.PLAIN, 14));
		pdateget.setBounds(0, 100, 74, 33);
		panel_2.add(pdateget);
		
		JLabel ptestlistget = new JLabel("\uAC80\uC0AC\uD56D\uBAA9");
		ptestlistget.setHorizontalAlignment(SwingConstants.RIGHT);
		ptestlistget.setFont(new Font("굴림", Font.PLAIN, 14));
		ptestlistget.setBounds(0, 135, 74, 33);
		panel_2.add(ptestlistget);
		
		JLabel pnameset = new JLabel("");
		pnameset.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnameset.setHorizontalAlignment(SwingConstants.CENTER);
		pnameset.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pnameset.setBounds(86, 33, 160, 33);
		panel_2.add(pnameset);
		
		JLabel pnumset = new JLabel("");
		pnumset.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnumset.setHorizontalAlignment(SwingConstants.CENTER);
		pnumset.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pnumset.setBounds(86, 68, 160, 33);
		panel_2.add(pnumset);
		
		JLabel pdateset = new JLabel("");
		pdateset.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pdateset.setHorizontalAlignment(SwingConstants.CENTER);
		pdateset.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pdateset.setBounds(86, 103, 160, 33);
		panel_2.add(pdateset);
		
		JLabel ptestlistset = new JLabel("");
		ptestlistset.setBorder(new LineBorder(Color.LIGHT_GRAY));
		ptestlistset.setHorizontalAlignment(SwingConstants.CENTER);
		ptestlistset.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		ptestlistset.setBounds(86, 138, 160, 33);
		panel_2.add(ptestlistset);
		
		
		//"검진 기본 검사 I"		String[] testlist = {"검진 기본 검사 I", "검진 기본 검사 II","검진 고급 검사"};
		JPanel testI = new JPanel();
		testI.setBackground(new Color(255, 255, 255));
		testI.setBounds(301, 81, 922, 519);
		testI.setLayout(null);
		
		String[][] data1 = Myprojectsql.showTresultlist1();
		String[] headers1 = {"검사코드","검사이름","검사 결과 입력"};
		DefaultTableModel tb1 = new DefaultTableModel(data1,headers1);
		JTable table1 = new JTable(tb1){
			
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
		
		JScrollPane Testpane = new JScrollPane(table1);
		Testpane.setBounds(12, 61, 886, 405);
		testI.add(Testpane);
		
		//"검진 기본 검사 II"
		JPanel testII = new JPanel();
		testII.setBackground(new Color(255, 255, 255));
		testII.setBounds(301, 81, 922, 519);
		testII.setLayout(null);
		
		String[][] tdata1 = Myprojectsql.showTresultlist2();
		String[] theaders1 = {"검사코드","검사이름","검사 결과 입력"};
		DefaultTableModel ttb1 = new DefaultTableModel(tdata1,theaders1);
		JTable ttable1 = new JTable(ttb1){
			
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
		
		JScrollPane Testpane1 = new JScrollPane(ttable1);
		Testpane1.setBounds(12, 61, 886, 405);
		testII.add(Testpane1);
		
		//"검진 기본 검사 III"
		JPanel testIII = new JPanel();
		testIII.setBackground(new Color(255, 255, 255));
		testIII.setBounds(301, 81, 922, 519);
		testIII.setLayout(null);
		
		String[][] tdata2 = Myprojectsql.showTresultlist3();
		String[] theaders2 = {"검사코드","검사이름","검사 결과 입력"};
		DefaultTableModel ttb2 = new DefaultTableModel(tdata2,theaders2);
		JTable ttable2 = new JTable(ttb2){
			
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
		
		JScrollPane Testpane2 = new JScrollPane(ttable2);
		Testpane2.setBounds(12, 61, 886, 405);
		testIII.add(Testpane2);
		
		panel.add(panel_2);
		
		JLabel ptestlistget_1 = new JLabel("\uD658\uC790 \uD2B9\uC774\uC0AC\uD56D \uC785\uB825");
		ptestlistget_1.setHorizontalAlignment(SwingConstants.CENTER);
		ptestlistget_1.setFont(new Font("굴림", Font.PLAIN, 14));
		ptestlistget_1.setBounds(0, 178, 261, 33);
		panel_2.add(ptestlistget_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setBounds(29, 221, 217, 108);
		panel_2.add(textArea);
				
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String selectedtest = Tcode.getSelectedItem().toString();
			try {
				String pname = textField.getText(); //환자 이름
				String pnum = personField.getText(); //환자 번호
				Date pdate = (Date) datePicker.getModel().getValue(); //날짜 
				String time1 = format1.format(pdate);// 날짜 포맷 변경 yyyy_mm_dd
				String testid = Tcode.getSelectedItem().toString();
				
				pnameset.setText(pname);
				pnumset.setText(pnum);
				pdateset.setText(time1);
				ptestlistset.setText(testid);
				
				if(pname.equals("")||pnum.equals("")) {
					JOptionPane.showMessageDialog(null,"모든 창을 입력해 주세요.");
				}else {
					switch(selectedtest) { //검사 코드 패키지
					case "검진 기본 검사 I": panel.add(testI); textArea.setText("기본 혈액 검사 리스트 입니다."); break;
					case "검진 기본 검사 II" : panel.add(testII);break;
					case "검진 고급 검사" : panel.add(testIII); break;
					}
				}
			}
			catch(NullPointerException e1) {JOptionPane.showMessageDialog(null,"모든 창을 입력해 주세요.");}
			}
		});	
	}
}
