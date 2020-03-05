package myproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class Login {

	protected JFrame frame;
	private JTextField HID;
	private JPasswordField HPW;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("부산IT병원 로그인 화면");
		frame.setSize(508, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,100));
		panel.setBounds(108, 72, 272, 162);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(32, 35, 72, 18);
		panel.add(lblNewLabel);
		
		JLabel lblPasswoad = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblPasswoad.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPasswoad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswoad.setBounds(32, 72, 72, 15);
		panel.add(lblPasswoad);
		
		HID = new JTextField();
		HID.setBounds(116, 33, 123, 23);
		panel.add(HID);
		HID.setColumns(10);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Hid = HID.getText();
				String Hpw = HPW.getText();

				if(Myprojectsql.login(Hid, Hpw)) {
				
				JLabel timerLabel = new JLabel();
				timerLabel.setBounds(140, 210, 197, 24);
				frame.getContentPane().add(timerLabel);
				
				TimeThread th = new TimeThread(timerLabel);
				th.start();
				}
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(86, 116, 97, 23);
		panel.add(btnNewButton);
		
		HPW = new JPasswordField();
		HPW.setBounds(116, 68, 123, 23);
		panel.add(HPW);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1\\Desktop\\프로젝트\\양부산.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 497, 309);
		frame.getContentPane().add(lblNewLabel_1);

	}
	class TimeThread extends Thread{
		private JLabel loginLabel;

		public TimeThread(JLabel loginLabel) {
			this.loginLabel = loginLabel;
		}
		public void run() {
			int n = 3;
			while(true) {
				try {
					if(n == 0) {
						System.out.println("BB");
						frame.dispose(); // > 창 끄는 방법
						new PEnroll().setVisible(true);
						return;
					}
					loginLabel.setText("로그인에 성공하였습니다."+Integer.toString(n));
					n--;
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
					return;
				}
			}
		}
	}
}


