package myproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Htable extends JFrame {

	private JPanel contentPane;
	private JTextField searchname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Htable frame = new Htable();
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
	public Htable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ºÎ»êITº´¿ø ·Î±×ÀÎ È­¸é");
		setSize(1240,660);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
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
//		Henroll.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new Htable().setVisible(true);
//			}
//		});
		Henroll.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
		Hmanage.add(Henroll);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1284, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 0, 325, 601);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(325, 0, 901, 601);
		panel.add(panel_2);
		
		String[][] data = Myprojectsql.showHlist();
		String[] headers = {"ÀÌ¸§","¼ºº°","Á÷Ã¥","¾ÆÀÌµð","ºñ¹Ð¹øÈ£","ÁÖ¼Ò"};
		DefaultTableModel tb = new DefaultTableModel(data,headers);
		panel_2.setLayout(null);
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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 80, 836, 496);
		panel_2.add(scrollPane);
		
		JLabel la_searchname = new JLabel("\uC774\uB984");
		la_searchname.setBounds(506, 37, 116, 33);
		la_searchname.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchname.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_2.add(la_searchname);
		
		searchname = new JTextField();
		searchname.setBounds(634, 42, 93, 26);
		searchname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String val = searchname.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchname.setColumns(10);
		searchname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.add(searchname);
		
		JLabel la_searchjob = new JLabel("\uC9C1\uCC45");
		la_searchjob.setBounds(728, 37, 43, 33);
		la_searchjob.setHorizontalAlignment(SwingConstants.RIGHT);
		la_searchjob.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_2.add(la_searchjob);
		
		String[] joblist = {"ÀÇ»ç","°£È£»ç","¿ø¹«","DB¸Å´ÏÀú"};
		JComboBox searchjob = new JComboBox(joblist);
		searchjob.setBounds(783, 44, 93, 21);
		searchjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = searchjob.getSelectedItem().toString();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		searchjob.setAlignmentX(1.0f);
		panel_2.add(searchjob);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC758\uB8CC\uC9C4 \uC815\uBCF4 \uB4F1\uB85D");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 33, 325, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 23));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(-20, 135, 116, 33);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_1);
		
		JTextField hname = new JTextField();
		hname.setBounds(134, 140, 139, 26);
		hname.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.add(hname);
		hname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_1.setBounds(-20, 178, 116, 33);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC9C1\uCC45");
		lblNewLabel_1_1_1.setBounds(-20, 221, 116, 33);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1_1_1_1.setBounds(-20, 264, 116, 33);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JTextField hid = new JTextField();
		hid.setBounds(134, 269, 139, 26);
		hid.setBorder(new LineBorder(Color.LIGHT_GRAY));
		hid.setColumns(10);
		panel_1.add(hid);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1_1_1_1.setBounds(-20, 307, 116, 33);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JTextField hpw = new JTextField();
		hpw.setBounds(134, 312, 139, 26);
		hpw.setBorder(new LineBorder(Color.LIGHT_GRAY));
		hpw.setColumns(10);
		panel_1.add(hpw);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(-20, 350, 116, 33);
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton input = new JButton("\uC800\uC7A5");
		input.setBounds(56, 525, 69, 26);
		panel_1.add(input);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.setBounds(137, 525, 69, 26);
		panel_1.add(modify);
		
		String[] Gender = {"¿©ÀÚ ","³²ÀÚ "};
		JComboBox hgender = new JComboBox(Gender);
		hgender.setBounds(134, 185, 139, 21);
		hgender.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(hgender);
		
		String[] Position = {"ÀÇ»ç","°£È£»ç","¿ø¹«"};
		JComboBox hjob = new JComboBox(Position);
		hjob.setBounds(134, 228, 139, 21);
		hjob.setAlignmentX(1.0f);
		panel_1.add(hjob);
			
		JTextArea haddress = new JTextArea();
		haddress.setBounds(134, 356, 139, 86);
		haddress.setBorder(new LineBorder(new Color(192, 192, 192)));
		haddress.setLineWrap(true);
		panel_1.add(haddress);
		
		JLabel plistcol = new JLabel("New label");
		plistcol.setBounds(12, 452, -1, 15);
		panel_1.add(plistcol);
		
		JLabel plistrow = new JLabel("New label");
		plistrow.setBounds(12, 452, 7, 15);
		panel_1.add(plistrow);
		
		JButton delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(217, 525, 69, 26);
		panel_1.add(delete);
		
		
	}
}
