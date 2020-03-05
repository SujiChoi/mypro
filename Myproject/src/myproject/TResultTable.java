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

public class TResultTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TResultTable frame = new TResultTable();
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
	public TResultTable() {
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
//		Tresult.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new TResultTable().setVisible(true);
//			}
//		});
		Tresult.setIcon(new ImageIcon("C:\\Users\\1\\\uD504\uB85C\uC81D\uD2B8\\Myproject\\img\\chart1.png"));
		Tresult.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Tmanage.add(Tresult);
		
		JMenu Mmanage = new JMenu("\uC6D0\uBB34\uAD00\uB9AC");
		Mmanage.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		menuBar.add(Mmanage);
		
		JMenuItem Mresult = new JMenuItem("\uC6D0\uBB34 \uC5C5\uBB34");
		Mresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ATable().setVisible(true);
			}
		});
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 0, 1223, 96);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(175, 53, 60, 33);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField.setBounds(247, 58, 97, 26);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD658\uC790\uBC88\uD638");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(341, 53, 74, 33);
		panel_1.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_1.setBounds(426, 58, 97, 26);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\uAC80\uC0AC\uC77C");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(535, 53, 55, 33);
		panel_1.add(lblNewLabel_1_2_1);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		datePicker.setBounds(597, 57, 116, 29);
		panel_1.add(datePicker);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("\uAC80\uC0AC\uD56D\uBAA9");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(714, 53, 80, 33);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		String[] testlist = {"°ËÁø ±âº» °Ë»ç I", "°ËÁø ±âº» °Ë»ç II","°ËÁø °í±Þ °Ë»ç"};
		JComboBox Tcode = new JComboBox(testlist);
		Tcode.setBounds(805, 57, 142, 26);
		panel_1.add(Tcode);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(969, 59, 66, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC80\uC0AC \uACB0\uACFC \uD655\uC778");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 23));
		lblNewLabel_2.setBounds(0, 0, 1223, 43);
		panel_1.add(lblNewLabel_2);
		
		
	}
}
