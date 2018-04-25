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

public class ForgetpwdGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel frame;
	private JLabel labelname;
	private JLabel labeltelt;
	private JLabel labelpwd;
	private JLabel relabelpwd;
	private JTextField textFieldname;
	private JTextField textFieldtele;
	private JTextField passwordFieldpwd;
	private JTextField repasswordFieldpwd;
	private JButton buttonregister;
	private JLabel labeltitle;
	private Check check = new Check();
	private User user = new User();
	
	
	public ForgetpwdGUI() {
		super("找回密码");
		init();
	}

	public void init() {
		frame = new JPanel();
		labelname = new JLabel("用户名:");
		labeltelt = new JLabel("手机号:");
		labelpwd = new JLabel("密码:");
		relabelpwd = new JLabel("确认密码:");
		textFieldname = new JTextField();
		textFieldtele = new JTextField();
		passwordFieldpwd = new JTextField();
		repasswordFieldpwd = new JTextField();
		buttonregister = new JButton("找回");
		labeltitle = new JLabel("输入信息核实身份并找回密码");
		
		buttonregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		frame.setLayout(null);
		labeltitle.setBounds(75, 70, 350, 50);
		labeltitle.setFont(new Font("宋体", 1, 25));
		labelname.setBounds(100, 150, 50, 30);
		textFieldname.setBounds(160, 150, 180, 30);
		labeltelt.setBounds(100,190,50,30);
		textFieldtele.setBounds(160,190,180,30);
		labelpwd.setBounds(100,230,50,30);
		passwordFieldpwd.setBounds(160,230,180,30);
		relabelpwd.setBounds(100,270,60,30);
		repasswordFieldpwd.setBounds(160,270,180,30);
		
		buttonregister.setBounds(195, 350, 90, 40);
		
		buttonregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//两次密码是否相同
				if(passwordFieldpwd.getText().equals(repasswordFieldpwd.getText())) {
					if(check.checktele(textFieldtele.getText())) {
						user.setUsername(textFieldname.getText().trim());
						user.setUserpwd(passwordFieldpwd.getText().trim());
						user.setUsertele(textFieldtele.getText().trim());
						ConClass.setUser(user);
						//userinitTask.Repassword();
						String result = ForgetHttp();
						CallBack(result);
					}else 
						JOptionPane.showMessageDialog(null, "手机号格式不正确","警告",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "两次密码输入不一致","警告",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		frame.add(labelname);
		frame.add(textFieldname);
		frame.add(labelpwd);
		frame.add(passwordFieldpwd);
		frame.add(buttonregister);
		frame.add(labeltelt);
		frame.add(textFieldtele);
		frame.add(labeltitle);
		frame.add(relabelpwd);
		frame.add(repasswordFieldpwd);
		
		add(frame);
		setVisible(true);
		setSize(480, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void CallBack(String string) {
		if(string.equals(Constant.SUCCESSFUL)) {
			dispose();
		}else if(string.equals(Constant.DEFEATE)) {
			JOptionPane.showMessageDialog(null, "修改失败，请稍后再试","警告",JOptionPane.ERROR_MESSAGE);
		}else if(string.equals(Constant.NOUSER)) {
			textFieldname.setText("");
			passwordFieldpwd.setText("");
			textFieldtele.setText("");
			JOptionPane.showMessageDialog(null, "用户信息不匹配","警告",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String ForgetHttp() {
		String result = "";
		User user = ConClass.getUser();
		String url = ConNet.REPASSWORDURL+"?Name="+user.getUsername()+"&Pwd="+
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
                System.out.println("收到："+result);
                System.out.println("收到："+result);
                //new ForgetpwdGUI().CallBack(result);
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
