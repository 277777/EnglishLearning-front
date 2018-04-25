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
import javax.swing.JTextField;

import com.ELfront.Check.Check;
import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.po.User;

public class RegisterGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JLabel labelname;
	private JLabel labelpwd;
	private JLabel relabelpwd;
	private JLabel labeltelt;
	private JTextField textFieldname;
	private JTextField textFieldpwd;
	private JTextField textFieldrepwd;
	private JTextField textFieldtele;
	private JButton buttonregister;
	private JLabel labeltitle;
	private Check check = new Check();
	private User user = new User();
	
	public RegisterGUI() {
		
		init();
	}
	
	public void init() {
		frame = new JPanel();
		labelname = new JLabel("用户名:");
		labelpwd = new JLabel("密码:");
		relabelpwd = new JLabel("确认密码:");
		labeltelt = new JLabel("手机号:");
		textFieldname = new JTextField();
		textFieldpwd = new JTextField();
		textFieldrepwd = new JTextField();
		textFieldtele = new JTextField();
		buttonregister = new JButton("注册");
		labeltitle = new JLabel("输入信息进行注册");
		
		buttonregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("用户名"+textFieldname.getText()+"密码"+textFieldpwd.getText()+"确认密码："+textFieldrepwd.getText()+
						"手机号"+textFieldtele.getText());
				String username = textFieldname.getText();
				String password = textFieldpwd.getText();
				String repassword = textFieldrepwd.getText();
				String telephone = textFieldtele.getText();
				if(password.equals(repassword)) {
					if(check.checktele(telephone.trim())) {
						user.setUsername(username);
						user.setUserpwd(password);
						user.setUsertele(telephone);
						ConClass.setUser(user);
						String result = RegisterHttp();
						CallBack(result);
					}
					else JOptionPane.showMessageDialog(null, "手机号不符合格式","警告",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "两次密码输入不一致","警告",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		frame.setLayout(null);
		labeltitle.setBounds(90, 70, 300, 50);
		labeltitle.setFont(new Font("宋体", 1, 30));
		labelname.setBounds(100, 150, 50, 30);
		textFieldname.setBounds(160, 150, 180, 30);
		labelpwd.setBounds(100,190,50,30);
		textFieldpwd.setBounds(160,190,180,30);
		relabelpwd.setBounds(100, 230, 80, 30);
		textFieldrepwd.setBounds(160,230,180,30);
		labeltelt.setBounds(100,270,50,30);
		textFieldtele.setBounds(160,270,180,30);
		buttonregister.setBounds(195, 350, 90, 40);
		
		frame.add(labelname);
		frame.add(textFieldname);
		frame.add(labelpwd);
		frame.add(textFieldpwd);
		frame.add(buttonregister);
		frame.add(labeltelt);
		frame.add(textFieldtele);
		frame.add(labeltitle);
		frame.add(relabelpwd);
		frame.add(textFieldrepwd);
		
		setTitle("注册");
		add(frame);
		setVisible(true);
		setSize(480, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	//回调
	public void CallBack(String string) {
		if(string.equals(Constant.SUCCESSFUL)) {
			JOptionPane.showMessageDialog(null, "注册成功", "提示",JOptionPane.PLAIN_MESSAGE);
			dispose();
		}else if(string.equals(Constant.DEFEATE)) {
			JOptionPane.showMessageDialog(null, "注册失败，请稍后再试","警告",JOptionPane.ERROR_MESSAGE);
		}else if(string.equals(Constant.EXITNAME)) {
			textFieldname.setText("");
			textFieldpwd.setText("");
			textFieldrepwd.setText("");
			textFieldtele.setText("");
			JOptionPane.showMessageDialog(null, "用户名已被使用","警告",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String RegisterHttp() {
		String result = "";
		User user = ConClass.getUser();
		String url = ConNet.REGISTERURL+"?Name="+user.getUsername()+"&Pwd="+
				user.getUserpwd()+"&Tele="+user.getUsertele();
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
                //result = result.substring(36);
                System.out.println("收到："+result);
                //new RegisterGUI().CallBack(result);
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
