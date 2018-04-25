package com.ELfront.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel frame; 
	private JButton login;
	private JButton register;
	private JLabel labeltitle;

	public MainGUI() {
		super("E学习");
		
		frame = new JPanel();
		login = new JButton("登录");
		register = new JButton("注册");
		labeltitle = new JLabel("欢迎使用\"E学习\"单词学习软件");
		
		labeltitle.setBounds(180, 100, 480, 50);
		labeltitle.setFont(new Font("宋体", 1, 30));
		login.setBounds(250, 320, 100, 40);
		register.setBounds(450,320,100,40);
		
		frame.setLayout(null);
		frame.add(login);
		frame.add(register);
		frame.add(labeltitle);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(login.getText());
				new LoginGUI();
			}
		});
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterGUI();
			}
		});
		
		add(frame);
		setVisible(true);
		setSize(800, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
