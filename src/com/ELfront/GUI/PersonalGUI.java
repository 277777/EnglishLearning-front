package com.ELfront.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.ELfront.GUI.Fragment.Day_Fragment;
import com.ELfront.GUI.Fragment.Personal_Fragment;
import com.ELfront.GUI.Fragment.Shengci_Fragment;
import com.ELfront.GUI.Fragment.Study_Fragment;

public class PersonalGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JTabbedPane jTabbedPane;
	private JPanel jperson,jday,jstudy,jshengci;

	public PersonalGUI() {
		init();
	}
	
	public void init() {
		
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jperson = new Personal_Fragment();
		jday = new Day_Fragment();
		jshengci = new Shengci_Fragment();
		jstudy = new Study_Fragment();
		frame = new JPanel();
		
		frame.setLayout(null);
		
		jTabbedPane.addTab("用户中心",jperson);
		jTabbedPane.addTab("学习", jstudy);
		jTabbedPane.addTab("生词本", jshengci);
		jTabbedPane.addTab("每日一句",jday);
		jTabbedPane.setBounds(30, 20, 900, 460);
		
		frame.add(jTabbedPane);
		
		validate();
		setResizable(false);
		add(frame);
		setVisible(true);
		setSize(960, 540);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
