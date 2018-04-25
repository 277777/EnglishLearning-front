package com.ELfront.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.Tools.Escape;
import com.ELfront.po.UserMain;

public class UserMainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel frame;

	private JLabel labelname;
	private JLabel labelsex;
	private JLabel labelcollege;
	private JLabel labelclass;
	private JLabel labelemail;

	private JTextField textFieldname;
	private JTextField textFieldcollege;
	private JTextField textFieldclass;
	private JTextField textFieldemail;

	private JButton buttonlogin;
	private JLabel labeltitle;
	private ButtonGroup buttonGroup;
	private JRadioButton sex1, sex2;

	private String sexcheck = "m";

	public UserMainGUI() {
		super("完善信息");
		init();
	}

	public void init() {

		frame = new JPanel();
		labelname = new JLabel("姓名：");
		labelname.setForeground(Color.RED);
		labelsex = new JLabel("性别：");
		labelsex.setForeground(Color.RED);
		labelcollege = new JLabel("学校：");
		labelcollege.setForeground(Color.RED);
		labelclass = new JLabel("学历：");
		labelclass.setForeground(Color.RED);
		labelemail = new JLabel("邮箱：");
		labelemail.setForeground(Color.RED);
		textFieldname = new JTextField();

		buttonGroup = new ButtonGroup();
		sex1 = new JRadioButton("男", true);
		sex2 = new JRadioButton("女");

		textFieldcollege = new JTextField();
		textFieldclass = new JTextField();
		textFieldemail = new JTextField();
		buttonlogin = new JButton("完善");
		labeltitle = new JLabel("注：红字为必填项");
		labeltitle.setForeground(Color.RED);

		frame.setLayout(null);

		labeltitle.setBounds(90, 70, 300, 30);
		labeltitle.setFont(new Font("宋体", 1, 30));
		labelname.setBounds(100, 150, 55, 30);
		textFieldname.setBounds(160, 150, 180, 30);
		labelsex.setBounds(100, 190, 50, 30);

		buttonGroup.add(sex1);
		buttonGroup.add(sex2);

		sex1.setBounds(160, 190, 90, 30);
		sex2.setBounds(260, 190, 90, 30);

		labelcollege.setBounds(100, 230, 50, 30);
		textFieldcollege.setBounds(160, 230, 180, 30);
		labelclass.setBounds(100, 270, 50, 30);
		textFieldclass.setBounds(160, 270, 180, 30);
		labelemail.setBounds(100, 310, 50, 30);
		textFieldemail.setBounds(160, 310, 180, 30);
		buttonlogin.setBounds(195, 390, 90, 40);
		frame.add(labelname);
		frame.add(textFieldname);
		frame.add(labelsex);

		frame.add(sex1);
		frame.add(sex2);

		frame.add(labelcollege);
		frame.add(textFieldcollege);
		frame.add(labelclass);
		frame.add(textFieldclass);
		frame.add(labelemail);
		frame.add(textFieldemail);
		frame.add(buttonlogin);
		frame.add(labeltitle);

		sex1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sexcheck = "m";
			}
		});
		sex2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sexcheck = "w";
			}
		});

		buttonlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textFieldname.getText() == null)
					JOptionPane.showMessageDialog(null, "姓名不能为空", "警告", JOptionPane.ERROR_MESSAGE);
				else if (textFieldcollege.getText() == null)
					JOptionPane.showMessageDialog(null, "学校不能为空", "警告", JOptionPane.ERROR_MESSAGE);
				else if (textFieldclass.getText() == null)
					JOptionPane.showMessageDialog(null, "学历不能为空", "警告", JOptionPane.ERROR_MESSAGE);
				else {
					String path = ConNet.USERMAINURL + "?Userid=" + ConClass.getUser().getUserid() + "&Usermainname="
							+ Escape.escape(Escape.escape(textFieldname.getText())) + "&Usermainsex=" + sexcheck
							+ "&Usermaincollege=" + Escape.escape(Escape.escape(textFieldcollege.getText()))
							+ "&Usernameclass=" + Escape.escape(Escape.escape(textFieldclass.getText()))
							+ "&Usermainemail=" + textFieldemail.getText();
					System.out.println(path);
					String string = UserMainHttp(path);
					CallBack(string);
				}

			}
		});

		add(frame);
		setVisible(true);
		setSize(480, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}

	// 回调
	public void CallBack(String string) {
		if (string.equals(Constant.DEFEATE))
			JOptionPane.showMessageDialog(null, "个人信息注册失败", "警告", JOptionPane.ERROR_MESSAGE);
		else {
			ConClass.getUser().setUsermainid(Integer.valueOf(string));
			UserMain userMain = new UserMain();
			userMain.setUsermainid(Integer.valueOf(string));
			userMain.setUsermainname(textFieldname.getText());
			userMain.setUsermaincollege(textFieldcollege.getText());
			userMain.setUsermainclass(textFieldclass.getText());
			userMain.setUsermainemail(textFieldemail.getText());
			if (sexcheck.equals("m"))
				userMain.setUsermainsex("男");
			else
				userMain.setUsermainsex("女");
			ConClass.setUserMain(userMain);
			JOptionPane.showMessageDialog(null, "个人信息注册成功", "提示", JOptionPane.PLAIN_MESSAGE);
			new PersonalGUI();
			dispose();
		}
	}

	public String UserMainHttp(String url) {
		String result = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(200);
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("超时");
			} else {
				InputStreamReader in = new InputStreamReader(connection.getInputStream());
				BufferedReader buf = new BufferedReader(in);
				String readLine = null;
				while ((readLine = buf.readLine()) != null) {
					result += readLine;
				}
				result = result.substring(36);
				System.out.println("收到：" + result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
