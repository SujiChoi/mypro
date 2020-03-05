package myproject;

import java.awt.BorderLayout;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.*;


public class Henroll extends JFrame {

	private JPanel contentPane;
	private JTextField searchname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Henroll frame = new Henroll();
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
	public Henroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ºÎ»êITº´¿ø ·Î±×ÀÎ È­¸é");
		setSize(1300,700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton penroll = new JButton("\uD658\uC790\uAD00\uB9AC");
		penroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PEnroll().setVisible(true);
			}
		});
		penroll.setBackground(SystemColor.control);
		penroll.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		penroll.setBounds(39, 25, 100, 31);
		contentPane.add(penroll);
		
		JButton tenroll = new JButton("\uAC80\uC0AC\uB4F1\uB85D");
		tenroll.setBackground(SystemColor.control);
		tenroll.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tenroll.setBounds(139, 25, 100, 31);
		contentPane.add(tenroll);
		
		JButton tmanage = new JButton("\uAC80\uC0AC\uAD00\uB9AC");
		tmanage.setBackground(SystemColor.control);
		tmanage.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		tmanage.setBounds(239, 25, 100, 31);
		contentPane.add(tmanage);
		
		JButton mmanage = new JButton("\uC6D0\uBB34\uAD00\uB9AC");
		mmanage.setBackground(SystemColor.control);
		mmanage.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		mmanage.setBounds(339, 25, 100, 31);
		contentPane.add(mmanage);
		
		JButton hmanage = new JButton("\uC758\uB8CC\uC9C4\uAD00\uB9AC");
		hmanage.setBackground(SystemColor.textHighlight);
		hmanage.setFont(new Font("±¼¸²", Font.PLAIN, 11));
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBounds(435, 48, 724, 477);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		String[][] data = Myprojectsql.showHlist();
		String[] headers = {"ÀÇ·áÁø¹øÈ£","ÀÌ¸§","¼ºº°","Á÷Ã¥","¾ÆÀÌµð","ºñ¹Ð¹øÈ£","ÁÖ¼Ò"};
		DefaultTableModel tb = new DefaultTableModel(data,headers);
		JTable table = new JTable(tb);
		//table.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 80, 646, 361);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC774\uB984");
		lblNewLabel_1_3.setBounds(309, 37, 116, 33);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1_3);
		
		searchname = new JTextField();
		searchname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String val = searchname.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchname.setBounds(437, 42, 93, 26);
		searchname.setColumns(10);
		searchname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.add(searchname);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("\uC9C1\uCC45");
		lblNewLabel_1_1_1_2.setBounds(531, 37, 43, 33);
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1_1_1_2);
		
		String[] joblist = {"ÀÇ»ç","°£È£»ç","¿ø¹«","DB¸Å´ÏÀú"};
		JComboBox searchjob = new JComboBox(joblist);
		searchjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = searchjob.getSelectedItem().toString();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchjob.setBounds(586, 44, 93, 21);
		searchjob.setAlignmentX(1.0f);
		panel_2.add(searchjob);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC758\uB8CC\uC9C4\uC815\uBCF4\uB4F1\uB85D");
		lblNewLabel.setBounds(0, 21, 325, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(0, 122, 116, 33);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_1);
		
		JTextField hname = new JTextField();
		hname.setBounds(154, 127, 116, 26);
		hname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.add(hname);
		hname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_1.setBounds(0, 155, 116, 33);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC9C1\uCC45");
		lblNewLabel_1_1_1.setBounds(0, 186, 116, 33);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1_1_1_1.setBounds(0, 218, 116, 33);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JTextField hid = new JTextField();
		hid.setBounds(154, 223, 116, 26);
		hid.setBorder(new LineBorder(Color.LIGHT_GRAY));
		hid.setColumns(10);
		panel_1.add(hid);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1_1_1_1.setBounds(0, 253, 116, 33);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JTextField hpw = new JTextField();
		hpw.setBounds(154, 258, 116, 26);
		hpw.setBorder(new LineBorder(Color.LIGHT_GRAY));
		hpw.setColumns(10);
		panel_1.add(hpw);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(0, 296, 116, 33);
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton input = new JButton("\uC800\uC7A5");
		input.setBounds(62, 422, 69, 23);
		panel_1.add(input);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.setBounds(143, 422, 69, 23);
		panel_1.add(modify);
		
		String[] Gender = {"¿©ÀÚ ","³²ÀÚ "};
		JComboBox hgender = new JComboBox(Gender);
		hgender.setBounds(154, 162, 116, 21);
		hgender.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(hgender);
		
		String[] Position = {"ÀÇ»ç","°£È£»ç","¿ø¹«"};
		JComboBox hjob = new JComboBox(Position);
		hjob.setBounds(154, 193, 116, 21);
		hjob.setAlignmentX(1.0f);
		panel_1.add(hjob);
			
		JTextArea haddress = new JTextArea();
		haddress.setBounds(154, 302, 116, 60);
		haddress.setBorder(new LineBorder(new Color(192, 192, 192)));
		haddress.setLineWrap(true);
		panel_1.add(haddress);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC758\uB8CC\uC9C4\uBC88\uD638");
		lblNewLabel_1_2.setBounds(0, 92, 116, 33);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_2);
		
		JLabel pid = new JLabel("\uC758\uB8CC\uC9C4\uBC88\uD638");
		pid.setBounds(154, 92, 116, 33);
		pid.setHorizontalAlignment(SwingConstants.CENTER);
		pid.setFont(new Font("±¼¸²", Font.PLAIN, 14));
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
		
		
	}
}
