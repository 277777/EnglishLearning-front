package com.ELfront.GUI.Fragment;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ELfront.Constant.ClassThis;
import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.Constant;
import com.ELfront.GUI.PictureGUI;
import com.ELfront.GUI.Learning.ChroseGUI;

public class Personal_Fragment extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel userphoto;
	private JLabel Jname, Jsex, Jcollege, Jclass, Jdaylearn;
	private JLabel name, sex, college, classes, daylearn;
	private JButton jButton;

	public Personal_Fragment() {
		ClassThis.PFragment = this;
		init();
	}

	public void init() {

		// new ImageIcon("resource/image/2.jpg")
		userphoto = new JLabel();
		userphoto.setSize(400, 400);
		userphoto.setBounds(10, 10, 400, 400);

		if (ConClass.getUser().getUserimg().equals("default"))
			setIcon("resource/image/2.jpg", userphoto);
		else
			setIcon("resource/UserPerson/" + ConClass.getUser().getUsername() + "/touxiang.png", userphoto);
		userphoto.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc=new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg","png","PNG","jpeg","jpeg");
				jfc.setFileFilter(filter);
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "选择");  
		        File file=jfc.getSelectedFile();  
		        if(file.isDirectory()){  
		            System.out.println("文件夹:"+file.getAbsolutePath());  
		        }else if(file.isFile()){ 
		        	
		            System.out.println("文件:"+file.getAbsolutePath());
		            Constant.PICTURE = file.getAbsolutePath();
		            new PictureGUI();
		        }  
		        System.out.println(jfc.getSelectedFile().getName()); 
			}
		});

		Jname = new JLabel("姓名：");
		Jname.setBounds(455, 10, 180, 50);
		Jname.setFont(new Font("宋体", 1, 30));
		add(Jname);

		Jsex = new JLabel("性别：");
		Jsex.setBounds(455, 65, 180, 50);
		Jsex.setFont(new Font("宋体", 1, 30));
		add(Jsex);

		Jcollege = new JLabel("学校：");
		Jcollege.setBounds(455, 120, 180, 50);
		Jcollege.setFont(new Font("宋体", 1, 30));
		add(Jcollege);

		Jclass = new JLabel("年级：");
		Jclass.setBounds(455, 175, 180, 50);
		Jclass.setFont(new Font("宋体", 1, 30));
		add(Jclass);

		Jdaylearn = new JLabel("已选择词库：");
		Jdaylearn.setBounds(455, 230, 280, 50);
		Jdaylearn.setFont(new Font("宋体", 1, 30));
		add(Jdaylearn);

		name = new JLabel(ConClass.getUserMain().getUsermainname());
		name.setBounds(635, 10, 260, 50);
		name.setFont(new Font("宋体", 1, 30));
		add(name);

		sex = new JLabel(ConClass.getUserMain().getUsermainsex());
		sex.setBounds(635, 65, 260, 50);
		sex.setFont(new Font("宋体", 1, 30));
		add(sex);

		college = new JLabel(ConClass.getUserMain().getUsermaincollege());
		college.setBounds(635, 120, 260, 50);
		college.setFont(new Font("宋体", 1, 30));
		add(college);

		classes = new JLabel(ConClass.getUserMain().getUsermainclass());
		classes.setBounds(635, 175, 260, 50);
		classes.setFont(new Font("宋体", 1, 30));
		add(classes);

		daylearn = new JLabel();
		daylearn.setBounds(635, 230, 180, 50);
		daylearn.setFont(new Font("宋体", 1, 30));
		add(daylearn);

		jButton = new JButton("选择");
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChroseGUI();
			}
		});
		
		if(ConClass.getUser().getCikuid()==0) {
			daylearn.setText("未选择");
			jButton.setBounds(760, 240, 80, 30);
			add(jButton);
		}else {
			switch(ConClass.getUser().getCikuid()) {
			case 1:
				daylearn.setText("四级");
				break;
			case 10:
				daylearn.setText("六级");
				break;
			case 100:
				daylearn.setText("考研");
				break;
			case 1000:
				daylearn.setText("GRE");
				break;
				default:
					break;
			}
		}
		
		
		this.setLayout(null);
		add(userphoto);

	}

	
	
	public void setIcon(String file, JLabel com) {
		ImageIcon ico = new ImageIcon(file);
		ico.getImage();
		Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
	}

	public String HttpUpload(String strings) {
		String urlStr = strings;
		String rsp = "";
		HttpURLConnection conn = null;
		String BOUNDARY = "|";
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			OutputStream out = new DataOutputStream(conn.getOutputStream());

			File file = new File("resource/UserPerson/" + ConClass.getUser().getUsername() + "/touxiang.png");
			String filePath = "resource/UserPerson/" + ConClass.getUser().getUsername() + "/touxiang.png";

			String filename = file.getName();
			String contentType = "image/png";
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
			strBuf.append(
					"Content-Disposition: form-data; name=\"" + filePath + "\"; filename=\"" + filename + "\"\r\n");
			strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
			out.write(strBuf.toString().getBytes());
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();
			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			rsp = buffer.toString();
			reader.close();
			reader = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		return rsp;
	}

	public void initmore() {
		jButton.setVisible(false);
		switch(ConClass.getUser().getCikuid()) {
		case 1:
			daylearn.setText("四级");
			break;
		case 10:
			daylearn.setText("六级");
			break;
		case 100:
			daylearn.setText("考研");
			break;
		case 1000:
			daylearn.setText("GRE");
			break;
			default:
				break;
		}
	}
}
