package com.ELfront.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.GUI.PictureGUI;
import com.ELfront.GUI.Learning.EnglishExamGUI;
import com.ELfront.po.User;


public class TestMainGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JButton buttonlogin;

	
	public TestMainGUI() {
		frame = new JPanel();

		buttonlogin = new JButton("完善");

		frame.setLayout(null);
		buttonlogin.setBounds(195, 390, 90, 40);
		frame.add(buttonlogin);
		buttonlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WordHttp(ConNet.ENGLISHEXAMURL+"?Word="+"work");
			}
		});

		add(frame);
		setVisible(true);
		setSize(480, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}
	
	public String WordHttp(String path) {
		String result = "";
		String url = path;
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
	
	
	public static void main(String[] args) {
//		try {
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InstantiationException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IllegalAccessException e) {
//		// TODO Auto-generated catch block
//		//e.printStackTrace();
//	} catch (UnsupportedLookAndFeelException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	new PersonalGUI();
//		new TestMainGUI();
//		doGet(ConNet.ENGLISHEXAMURL+"?Word="+"work");
//		new EnglishExamGUI();
	}
}
