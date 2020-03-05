package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ATable extends JFrame {

	private JPanel contentPane;
	private int sum = 0;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATable frame = new ATable();
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
	public ATable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ºÎ»êITº´¿ø ·Î±×ÀÎ È­¸é");
		setSize(1240,660);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Pmanage = new JMenu("\uD658\uC790\uAD00\uB9AC");
		Pmanage.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		menuBar.add(Pmanage);
		
		//È¯ÀÚµî·Ï
		JMenuItem Penroll = new JMenuItem("\uD658\uC790 \uB4F1\uB85D");
		Penroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\broken.png"));
		Penroll.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Penroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PTable().setVisible(true);
			}
		});
		Pmanage.add(Penroll);
		
		
		JMenu Tmanage = new JMenu("\uAC80\uC0AC\uAD00\uB9AC");
		Tmanage.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		menuBar.add(Tmanage);
		
		//°Ë»çµî·Ï
		JMenuItem Tenroll = new JMenuItem("\uAC80\uC0AC \uB4F1\uB85D");
		Tenroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TTable().setVisible(true);
			}
		});
		
		Tenroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\blood-sample.png"));
		Tenroll.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Tmanage.add(Tenroll);
		
		JMenuItem Tresult = new JMenuItem("\uAC80\uC0AC\uACB0\uACFC\uD655\uC778");
		Tresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TResultTable().setVisible(true);
			}
		});
		Tresult.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\chart1.png"));
		Tresult.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Tmanage.add(Tresult);
		
		JMenu Mmanage = new JMenu("\uC6D0\uBB34\uAD00\uB9AC");
		Mmanage.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		menuBar.add(Mmanage);
		
		JMenuItem Mresult = new JMenuItem("\uC6D0\uBB34 \uC5C5\uBB34");
//		Mresult.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new ATable().setVisible(true);
//			}
//		});
		Mresult.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\chart1.png"));
		Mresult.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Mmanage.add(Mresult);
		
		JMenu Hmanage = new JMenu("\uC758\uB8CC\uC9C4\uAD00\uB9AC");
		Hmanage.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		menuBar.add(Hmanage);
		
		JMenuItem Henroll = new JMenuItem("\uC758\uB8CC\uC9C4 \uB4F1\uB85D");
		Henroll.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\app.png"));
		Henroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Htable().setVisible(true);
			}
		});
		Henroll.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Hmanage.add(Henroll);
		contentPane.setLayout(null);
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 120, 901, 381);
		getContentPane().add(scrollPane);
		
		// Table
		final JTable table = new JTable() {
			
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
		table.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		scrollPane.setViewportView(table);


		// Model for Table
		DefaultTableModel model = new DefaultTableModel(){

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C \uC644\uB8CC");
		btnNewButton.setBounds(1115, 545, 97,33);
		contentPane.add(btnNewButton);
		
		JLabel paylabel1 = new JLabel("");
		paylabel1.setForeground(new Color(255, 0, 0));
		paylabel1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		paylabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		paylabel1.setBounds(991, 500, 102, 42);
		contentPane.add(paylabel1);
		
		JLabel paylabel2 = new JLabel("");
		paylabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		paylabel2.setForeground(Color.RED);
		paylabel2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		paylabel2.setBounds(1158, 500, 54, 42);
		contentPane.add(paylabel2);
		
		JLabel totalamount = new JLabel("");
		totalamount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalamount.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 18));
		totalamount.setBounds(1067, 500, 116, 42);
		contentPane.add(totalamount);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		TitledBorder titleb = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "È¯ÀÚ Á¤º¸", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.menuText);
		panel_5.setBorder(titleb);
		titleb.setTitleFont(new Font("³ª´®¹Ù¸§°íµñ", Font.BOLD, 15));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(18, 108, 281, 216);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(12, 73, 90, 33);
		panel_5.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(12, 101, 90, 33);
		panel_5.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(12, 128, 90, 33);
		panel_5.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(12, 155, 90, 33);
		panel_5.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(12, 42, 90, 33);
		panel_5.add(lblNewLabel_1_2_2);
		
		JLabel pid = new JLabel("\uD658\uC790\uBC88\uD638");
		pid.setHorizontalAlignment(SwingConstants.CENTER);
		pid.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pid.setBounds(142, 42, 116, 33);
		panel_5.add(pid);
		
		JLabel plistcol = new JLabel("New label");
		plistcol.setBounds(12, 452, -1, 15);
		panel_5.add(plistcol);
		
		JLabel plistrow = new JLabel("New label");
		plistrow.setBounds(12, 452, 7, 15);
		panel_5.add(plistrow);
		
		JLabel pid_1 = new JLabel("\uD658\uC790\uBC88\uD638");
		pid_1.setHorizontalAlignment(SwingConstants.CENTER);
		pid_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pid_1.setBounds(142, 73, 116, 33);
		panel_5.add(pid_1);
		
		JLabel pid_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		pid_2.setHorizontalAlignment(SwingConstants.CENTER);
		pid_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pid_2.setBounds(142, 101, 116, 33);
		panel_5.add(pid_2);
		
		JLabel pid_2_1 = new JLabel("\uD658\uC790\uBC88\uD638");
		pid_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		pid_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pid_2_1.setBounds(142, 128, 116, 33);
		panel_5.add(pid_2_1);
		
		JLabel pid_2_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		pid_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		pid_2_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		pid_2_2.setBounds(142, 155, 116, 33);
		panel_5.add(pid_2_2);
		
		JPanel panel_6 = new JPanel();
		TitledBorder titleb1 = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "³»¿ø ±â·Ï", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.menuText);
		panel_6.setBorder(titleb1);
		titleb1.setTitleFont(new Font("³ª´®¹Ù¸§°íµñ", Font.BOLD, 15));
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(18, 334, 280, 167);
		contentPane.add(panel_6);
		
		String[][] data2 = Myprojectsql.showTdate();
		String[] headers2 = {"³»¿øÀÏ"};
		DefaultTableModel tb2 = new DefaultTableModel(data2,headers2);
		JTable table2 = new JTable(tb2);
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(12, 31, 256, 121);
		panel_6.add(scrollPane_1);
		
		JButton btnNewButton_1 = new JButton("\uC911\uAC04 \uC815\uC0B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				paylabel1.setText("ÃÑ °áÁ¦ ±Ý¾×");
				paylabel2.setText("¿ø");
				
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if (chked) {
						String A = table.getValueAt(i, 5).toString();
						sum += Integer.parseInt(A);
						totalamount.setText(Integer.toString(sum));
					}
				}
			}
		});
		btnNewButton_1.setBounds(1004, 545, 97, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC6D0\uBB34 \uC5C5\uBB34");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 23));
		lblNewLabel_1_2.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_2.setBounds(0, 0, 1224, 50);
		contentPane.add(lblNewLabel_1_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 1224, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel la_searchname_2 = new JLabel("\uC774\uB984");
		la_searchname_2.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchname_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		la_searchname_2.setBounds(701, 53, 116, 33);
		panel.add(la_searchname_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField.setBounds(829, 58, 93, 26);
		panel.add(textField);
		
		JLabel la_searchname_1_1 = new JLabel("\uB0A0\uC9DC");
		la_searchname_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchname_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		la_searchname_1_1.setBounds(860, 52, 116, 33);
		panel.add(la_searchname_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_1.setBounds(988, 57, 93, 26);
		panel.add(textField_1);
		
		JButton btnNewButton_2_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_2_1.setBounds(1115, 53, 97, 33);
		panel.add(btnNewButton_2_1);
		
		model.addColumn("¼±  ÅÃ");
		model.addColumn("È¯ÀÚÀÌ¸§");
		model.addColumn("È¯ÀÚ¹øÈ£");
		model.addColumn("°Ë»çÄÚµå");
		model.addColumn("°Ë»ç³¯Â¥");
		model.addColumn("°Ë»ç±Ý¾×");
		model.addColumn("¼ö³³ÇöÈ²");
		
		String[][] payresult = Myprojectsql.showPayresultlist();
		// Data Row
		for (int i = 0; i < payresult.length; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(payresult[i][0], i, 1);
			model.setValueAt(payresult[i][1], i, 2);
			model.setValueAt(payresult[i][2], i, 3);
			model.setValueAt(payresult[i][3], i, 4);
			model.setValueAt(payresult[i][4], i, 5);
			model.setValueAt(payresult[i][5], i, 6);
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sum==0) {
					JOptionPane.showMessageDialog(null, "¼ö³³ÇÒ °Ë»ç¸¦ ¼±ÅÃÇØ ÁÖ¼¼¿ä.");
				}else {
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0)
							.toString());
					if (chked) {
						table.setValueAt("¼ö³³",i , 6);// ¼ö³³À¸·Î º¯°æ >> ÀÌÈÄ
						}
					
					}
				JOptionPane.showMessageDialog(null, "¼ö³³ ¿Ï·á µÇ¾ú½À´Ï´Ù.");
				}
			}	
		});
	}
}
