package com.ELfront.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.po.User;
import com.ELfront.po.UserMain;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JLabel labelname;
	private JLabel labelpwd;
	private JTextField textFieldname;
	private JPasswordField passwordFieldpwd;
	private JButton buttonlogin;
	private JButton buttonforpwd;
	private JLabel labeltitle;

	private User user = new User();

	public LoginGUI() {
		super("E学习");
		init();
	}

	public void init() {
		frame = new JPanel();
		labelname = new JLabel("用户名：");
		labelpwd = new JLabel("密码：");
		textFieldname = new JTextField();
		passwordFieldpwd = new JPasswordField();
		buttonlogin = new JButton("登录");
		buttonforpwd = new JButton("忘记密码");
		labeltitle = new JLabel("请登录");

		buttonlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldname.getText();
				String password = new String(passwordFieldpwd.getPassword());
				user.setUsername(username);
				user.setUserpwd(password);
				ConClass.setUser(user);
				String result = LoginHttp();
				CallBack(result);
			}
		});
		buttonforpwd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ForgetpwdGUI();

			}
		});

		frame.setLayout(null);
		labeltitle.setBounds(190, 70, 130, 30);
		labeltitle.setFont(new Font("宋体", 1, 30));
		labelname.setBounds(100, 150, 70, 30);
		textFieldname.setBounds(160, 150, 180, 30);
		labelpwd.setBounds(100, 190, 50, 30);
		passwordFieldpwd.setBounds(160, 190, 180, 30);
		buttonlogin.setBounds(120, 300, 90, 40);
		buttonforpwd.setBounds(270, 300, 90, 40);

		frame.add(labelname);
		frame.add(textFieldname);
		frame.add(labelpwd);
		frame.add(passwordFieldpwd);
		frame.add(buttonlogin);
		frame.add(buttonforpwd);
		frame.add(labeltitle);

		validate();
		setResizable(false);
		add(frame);
		setVisible(true);
		setSize(480, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 回调
	public void CallBack(String string) {
		if (string.equals(Constant.NOUSER)) {
			JOptionPane.showMessageDialog(null, "用户名或密码错误","警告",JOptionPane.ERROR_MESSAGE);
		} else {
            String[] strings = string.split("#");
            user.setUserid(Integer.valueOf(strings[0]));
            user.setUsername(strings[1]);
            user.setUserpwd(strings[2]);
            user.setUsertele(strings[3]);
            user.setUserlearn(Integer.valueOf(strings[4]));
            user.setCikuid(Integer.valueOf(strings[5]));
            user.setShengcibenid(Integer.valueOf(strings[6]));
            user.setUsermainid(Integer.valueOf(strings[7]));
            user.setUserimg(strings[8]);
            ConClass.setUser(user);
			if(ConClass.getUser().getUsermainid()==0) {
				JOptionPane.showMessageDialog(null, "请完善个人信息", "提示",JOptionPane.PLAIN_MESSAGE);
				new UserMainGUI();
			}
			else {
				String result = UserMainSelectHttp();
				SelectBack(result);
			}
			dispose();
		}
	}
	
	public void SelectBack(String result) {
		if(result.equals(Constant.DEFEATE)) {
			JOptionPane.showMessageDialog(null, "个人信息查询出错","警告",JOptionPane.ERROR_MESSAGE);
		}else {
			String[] string = result.split("#");
			UserMain userMain = new UserMain();
			userMain.setUsermainid(Integer.valueOf(string[0]));
			userMain.setUsermainname(string[1]);
			userMain.setUsermainsex(string[2]);
			userMain.setUsermaincollege(string[3]);
			userMain.setUsermainclass(string[4]);
			userMain.setUsermainemail(string[5]);
			ConClass.setUserMain(userMain);
			new PersonalGUI();
		}
	}
	
	public String LoginHttp() {
		String result = "";
		User user = ConClass.getUser();
		String url = ConNet.LOGINURL+"?Name="+user.getUsername()+"&Pwd="+
				user.getUserpwd();
        try {
        	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(200);
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("超时");
            }else {
            	InputStreamReader in = new InputStreamReader(connection.getInputStream());
                BufferedReader buf = new BufferedReader(in);
                String readLine = null;
                while ((readLine = buf.readLine()) != null) {
                    result += readLine;
                }
                System.out.println("收到："+result);
                //result = result.substring(36);
                System.out.println("收到："+result);
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String UserMainSelectHttp() {
		String result = "";
		User user = ConClass.getUser();
		String url = ConNet.USERMAINSELECTURL+"?Userid="+user.getUserid();
        try {
        	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(200);
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("超时");
            }else {
            	InputStreamReader in = new InputStreamReader(connection.getInputStream());
                BufferedReader buf = new BufferedReader(in);
                String readLine = null;
                while ((readLine = buf.readLine()) != null) {
                    result += readLine;
                }
                System.out.println("收到："+result);
                
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
