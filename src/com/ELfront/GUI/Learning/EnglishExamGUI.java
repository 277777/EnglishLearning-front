package com.ELfront.GUI.Learning;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;


public class EnglishExamGUI extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<List<Map<Integer, String>>> list;
	private static int learning = 0;
	private JPanel frame;
	private JLabel engword, nextword;
	private JLabel SelectA , SelectB , SelectC , SelectD; 
	private JLabel SelectAA , SelectBB , SelectCC , SelectDD;
	private JLabel PSelectA , PSelectB , PSelectC , PSelectD;
	private String[] strings = new String[6];
	private int number;
	
	public EnglishExamGUI(List<List<Map<Integer, String>>> liststr,int number) {
//		List<Map<Integer, String>> liststr
		super();
		list = liststr;
		this.number = number;
		init();
		System.out.println("In Eng:" + list.get(learning));
		doGet(ConNet.ENGLISHEXAMURL+"?Word="+list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2));
		learning++;
	}
	
	private void init() {

		frame = new JPanel();
		frame.setLayout(null);

		engword = new JLabel("H",JLabel.CENTER);
		engword.setText("");
		engword.setBounds(10, 50, 300, 40);
		engword.setFont(new Font("宋体", 1, 30));
		frame.add(engword);

		nextword = new JLabel();
		nextword.setSize(40, 40);
		setIcon("resource/image/next.png", nextword);
		nextword.setBounds(400, 50, 40, 40);
		nextword.addMouseListener(this);
		frame.add(nextword);


		SelectA = new JLabel("A");
		SelectA.setSize(30, 30);
		SelectA.setBounds(100, 200, 30, 30);
		SelectA.setFont(new Font("Times New Roman", 1, 25));
		frame.add(SelectA);
		
		SelectB = new JLabel("B");
		SelectB.setSize(30, 30);
		SelectB.setBounds(100, 250, 30, 30);
		SelectB.setFont(new Font("Times New Roman", 1, 25));
		frame.add(SelectB);
		
		SelectC = new JLabel("C");
		SelectC.setSize(30, 30);
		SelectC.setBounds(100, 300, 30, 30);
		SelectC.setFont(new Font("Times New Roman", 1, 25));
		frame.add(SelectC);
		
		SelectD = new JLabel("D");
		SelectD.setSize(30, 30);
		SelectD.setBounds(100, 350, 30, 30);
		SelectD.setFont(new Font("Times New Roman", 1, 25));
		frame.add(SelectD);
		
		PSelectA = new JLabel("A");
		PSelectA.setSize(30, 30);
		PSelectA.setBounds(40, 200, 30, 30);
		setIcon("resource/image/wenhao.png", PSelectA);
		frame.add(PSelectA);
		
		PSelectB = new JLabel("B");
		PSelectB.setSize(30, 30);
		PSelectB.setBounds(40, 250, 30, 30);
		setIcon("resource/image/wenhao.png", PSelectB);
		frame.add(PSelectB);
		
		PSelectC = new JLabel("C");
		PSelectC.setSize(30, 30);
		PSelectC.setBounds(40, 300, 30, 30);
		setIcon("resource/image/wenhao.png", PSelectC);
		frame.add(PSelectC);
		
		PSelectD = new JLabel("D");
		PSelectD.setSize(30, 30);
		PSelectD.setBounds(40, 350, 30, 30);
		setIcon("resource/image/wenhao.png", PSelectD);
		frame.add(PSelectD);
		
		
		SelectAA = new JLabel("A");
		SelectAA.setSize(100, 30);
		SelectAA.setBounds(155, 200, 300, 30);
		SelectAA.addMouseListener(this);
		frame.add(SelectAA);
		
		SelectBB = new JLabel("B");
		SelectBB.setSize(100, 30);
		SelectBB.setBounds(155, 250, 300, 30);
		SelectBB.addMouseListener(this);
		frame.add(SelectBB);
		
		SelectCC = new JLabel("C");
		SelectCC.setSize(100, 30);
		SelectCC.setBounds(155, 300, 300, 30);
		SelectCC.addMouseListener(this);
		frame.add(SelectCC);
		
		SelectDD = new JLabel("D");
		SelectDD.setSize(100, 30);
		SelectDD.setBounds(155, 350, 300, 30);
		SelectDD.addMouseListener(this);
		frame.add(SelectDD);
		
		
		add(frame);
		validate();// 使控件合法化（下拉列表会有下箭头）
		setResizable(false);// c窗体无法改变大小
		setVisible(true);
		setSize(480, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setword() {

		try {
			JlabelSetText(engword,list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2).trim());
			JlabelSetText(SelectAA,strings[0].trim());
			JlabelSetText(SelectBB,strings[1].trim());
			JlabelSetText(SelectCC,strings[2].trim());
			JlabelSetText(SelectDD,strings[3].trim());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String doGet(String string) {
		String result = "";
		String url = string;
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
				System.out.println("收到：" + result);
				strings = result.split("#");
				setword();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void setIcon(String file, JLabel com) {
		ImageIcon ico = new ImageIcon(file);
		ico.getImage();
		Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
	}
	
	public void JlabelSetText(JLabel jLabel, String longString) throws InterruptedException {
		StringBuilder builder = new StringBuilder("<html>");
		char[] chars = longString.toCharArray();
		FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
		int start = 0;
		int len = 0;
		while (start + len < longString.length()) {
			while (true) {
				len++;
				if (start + len > longString.length())
					break;
				if (fontMetrics.charsWidth(chars, start, len) > jLabel.getWidth()) {
					break;
				}
			}
			builder.append(chars, start, len - 1).append("<br/>");
			start = start + len - 1;
			len = 0;
		}
		builder.append(chars, start, longString.length() - start);
		builder.append("</html>");
		jLabel.setText(builder.toString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==SelectAA||e.getSource()==SelectBB||e.getSource()==SelectCC||e.getSource()==SelectDD) {
			setIcon("resource/image/cuohao.png", PSelectA);
			setIcon("resource/image/cuohao.png", PSelectB);
			setIcon("resource/image/cuohao.png", PSelectC);
			setIcon("resource/image/cuohao.png", PSelectD);
			int result = Integer.valueOf(strings[4]);
			switch(result) {
			case 1:
				setIcon("resource/image/duihao.png", PSelectA);
				break;
			case 2:
				setIcon("resource/image/duihao.png", PSelectB);
				break;
			case 3:
				setIcon("resource/image/duihao.png", PSelectC);
				break;
			case 4:
				setIcon("resource/image/duihao.png", PSelectD);
				break;
			}
		}
		if(e.getSource()==nextword) {
			setIcon("resource/image/wenhao.png", PSelectA);
			setIcon("resource/image/wenhao.png", PSelectB);
			setIcon("resource/image/wenhao.png", PSelectC);
			setIcon("resource/image/wenhao.png", PSelectD);
			if(learning==9) {
				if(number!=1) {
					number--;
					learning=0;
					doGet(ConNet.ENGLISHEXAMURL+"?Word="+list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2));
				}
			}else {
				// TODO
				learning++;
				System.out.println("learn:"+learning+"number:"+number+"userlearn:"+ConClass.getUser().getUserlearn());
				doGet(ConNet.ENGLISHEXAMURL+"?Word="+list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2));
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}
