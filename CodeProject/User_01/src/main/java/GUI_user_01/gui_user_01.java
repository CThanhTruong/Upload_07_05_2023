package GUI_user_01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Pub_Sub.Pub_Redis;
import Pub_Sub.Sub_Redis;


public class gui_user_01 extends JFrame implements ActionListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextArea textarea ,textview;
	private JButton btnSend, btnClose, btnShowMessage;
	private JTextField txtContent;
	private JLabel lbcontent;
	public void init() {
		this.setTitle("User_01");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textarea = new JTextArea();
		getContentPane().add(textarea);
		textarea.setBounds(10, 10, 560, 300);
		textarea.setBorder(border);
		
		btnSend = new JButton("Send");
		getContentPane().add(btnSend);
		btnSend.setBounds(200, 500, 100, 30);
		
		lbcontent = new JLabel("Text Field:");
		getContentPane().add(lbcontent);
		lbcontent.setBounds(20,350,70,50);
		
		txtContent = new JTextField();
		getContentPane().add(txtContent);
		txtContent.setBounds(100, 350, 400, 60);
		
		textview = new JTextArea();
		getContentPane().add(textview);
		textview.setBounds(10,100,50,50);
		
		btnClose = new JButton("Close");
		getContentPane().add(btnClose);
		btnClose.setBounds(310, 500, 100, 30);
		
		btnShowMessage = new JButton("Show Message");
		getContentPane().add(btnShowMessage);
		btnShowMessage.setBounds(640, 360, 100, 30);
		btnSend.addActionListener(this);
		btnClose.addActionListener(this);
		this.setVisible(true);
		
	}
	
	
	public static void setTextArea(String text) {
		textarea.append(text + "\n");
	}
	
	
	public static void main(String[] args) throws Exception {
		
		new gui_user_01().init();
		Sub_Redis.subscriber();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnSend)) {
			try {
				Pub_Redis.publisher("User_01: " + txtContent.getText() + "\n");
				//textarea.append("User1: " + txtContent.getText() + "\n");
				txtContent.setText("");
				txtContent.requestFocus();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(obj.equals(btnClose)) {
		
			System.exit(0);
			
		}
		
	}
}
