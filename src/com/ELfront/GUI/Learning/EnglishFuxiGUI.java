package com.ELfront.GUI.Learning;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.Tools.GetMouth;
import com.ELfront.Tools.JinshanParseUtil;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class EnglishFuxiGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<List<Map<Integer, String>>> list;
	private static int learning = 0;
	private int number;
	private JPanel frame;
	private JLabel engword, nextword, ph_en, ph_en_mp3, ph_am, ph_am_mp3, ph_enl, ph_aml, jmain, maineng, jlj, lje, ljc;

	public EnglishFuxiGUI(List<List<Map<Integer, String>>> liststr,int number) {
		super();
		list = liststr;
		this.number = number;
		init();
		System.out.println("In Eng:" + list.get(learning));
		String path = "http://dict-co.iciba.com/api/dictionary.php?w=" + list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2)
				+ "&type=xml&key=313A73223317189FBA1B82AB00AD0ED4";
		learning++;
		doGet(path);
		
		//
//		super();
//		list = liststr;
//		this.number = number;
//		init();
//		System.out.println("In Eng:" + list.get(learning));
//		doGet(ConNet.ENGLISHEXAMURL+"?Word="+list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2));
//		learning++;
	}

	private void init() {

		frame = new JPanel();
		frame.setLayout(null);

		engword = new JLabel();
		engword.setText("Word");
		engword.setBounds(30, 30, 300, 40);
		engword.setFont(new Font("宋体", 1, 30));
		frame.add(engword);

		nextword = new JLabel();
		nextword.setSize(40, 40);
		setIcon("resource/image/next.png", nextword);
		nextword.setBounds(800, 30, 40, 40);
		frame.add(nextword);

		nextword.addMouseListener(new MouseListener() {

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
				// MusicThread musicThread = new MusicThread();
				// musicThread.start();
				if (learning == 10) {
					if(ConClass.getUser().getUserlearn()==9) {
						JOptionPane.showMessageDialog(null, "课程完成，请选择新课程", "提示",JOptionPane.PLAIN_MESSAGE);
						new ChroseGUI();
					}else {
						int mouth = new GetMouth().getm();
						switch(mouth) {
						case 1:
							ConClass.getStudy().setMon(ConClass.getStudy().getMon()+10);
							break;
						case 2:
							ConClass.getStudy().setTue(ConClass.getStudy().getTue()+10);
							break;
						case 3:
							ConClass.getStudy().setWed(ConClass.getStudy().getWed()+10);
							break;
						case 4:
							ConClass.getStudy().setThu(ConClass.getStudy().getThu()+10);
							break;
						case 5:
							ConClass.getStudy().setFri(ConClass.getStudy().getFri()+10);
							break;
						case 6:
							ConClass.getStudy().setSat(ConClass.getStudy().getSat()+10);
							break;
						case 7:
							ConClass.getStudy().setSun(ConClass.getStudy().getSun()+10);
							break;
						}
						UpdateStudyHttp(ConNet.UPDATERESTUDYURL+"?Userid="+ConClass.getUser().getUserid()+"&Mouth="+mouth);
						ConClass.getUser().setUserlearn(ConClass.getUser().getUserlearn()+1);
						if(number!=1) {
							number--;
							learning=0;
							String path = "http://dict-co.iciba.com/api/dictionary.php?w=" + list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2)
									+ "&type=xml&key=313A73223317189FBA1B82AB00AD0ED4";
							doGet(path);
						}else {
							dispose();
						}
					}
					
				} else {
					String path = "http://dict-co.iciba.com/api/dictionary.php?w=" + list.get(ConClass.getUser().getUserlearn()-number).get(learning).get(2)
							+ "&type=xml&key=313A73223317189FBA1B82AB00AD0ED4";
					learning++;
					doGet(path);
				}
			}
		});

		ph_en = new JLabel();
		ph_en.setBounds(180, 150, 300, 30);
		ph_en.setFont(new Font("Times New Roman", 1, 25));
		frame.add(ph_en);

		ph_en_mp3 = new JLabel();
		ph_en_mp3.setSize(30, 30);
		setIcon("resource/image/539887.png", ph_en_mp3);
		ph_en_mp3.setBounds(350, 150, 30, 30);
		// ph_en_mp3.setFont(new Font("Times New Roman", 1,25));
		ph_en_mp3.addMouseListener(new MouseListener() {

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
				 MusicenThread musicenThread = new MusicenThread();
				 musicenThread.start();
			}
		});
		frame.add(ph_en_mp3);

		ph_am = new JLabel();
		ph_am.setBounds(180, 200, 300, 30);
		ph_am.setFont(new Font("Times New Roman", 1, 25));
		frame.add(ph_am);

		ph_am_mp3 = new JLabel();
		ph_am_mp3.setSize(30, 30);
		setIcon("resource/image/539887.png", ph_am_mp3);
		ph_am_mp3.setBounds(350, 200, 30, 30);
		// ph_am_mp3.setFont(new Font("Times New Roman", 1,25));
		ph_am_mp3.addMouseListener(new MouseListener() {

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
				 MusicamThread musicamThread = new MusicamThread();
				 musicamThread.start();
			}
		});
		frame.add(ph_am_mp3);

		ph_enl = new JLabel();
		ph_enl.setText("英式发音");
		ph_enl.setBounds(30, 150, 300, 30);
		ph_enl.setFont(new Font("宋体", 1, 20));
		frame.add(ph_enl);

		ph_aml = new JLabel();
		ph_aml.setText("美式发音");
		ph_aml.setBounds(30, 200, 300, 30);
		ph_aml.setFont(new Font("宋体", 1, 20));
		frame.add(ph_aml);

		jmain = new JLabel("详细释义：");
		jmain.setBounds(30, 300, 300, 30);
		jmain.setFont(new Font("宋体", 1, 20));
		frame.add(jmain);

		jlj = new JLabel("例句：");
		jlj.setBounds(30, 450, 300, 30);
		jlj.setFont(new Font("宋体", 1, 20));
		frame.add(jlj);

		lje = new JLabel();
		lje.setSize(800, 200);
		lje.setBounds(30, 470, 800, 100);
		lje.setFont(new Font("宋体", 1, 20));
		frame.add(lje);

		ljc = new JLabel();
		ljc.setSize(800, 200);
		ljc.setBounds(30, 580, 800, 100);
		ljc.setFont(new Font("宋体", 1, 20));
		frame.add(ljc);

		maineng = new JLabel();
		maineng.setBounds(30, 310, 800, 100);
		maineng.setSize(900, 100);
		maineng.setFont(new Font("宋体", 1, 25));
		frame.add(maineng);

		add(frame);
		validate();// 使控件合法化（下拉列表会有下箭头）
		setResizable(false);// c窗体无法改变大小
		setVisible(true);
		setSize(980, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setIcon(String file, JLabel com) {
		ImageIcon ico = new ImageIcon(file);
		ico.getImage();
		Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
	}

	public void setword() {

		engword.setText(ConClass.getEnglishWord().getQueryText());
		engword.setFont(new Font("宋体", 1, 30));

		ph_en.setText(ConClass.getEnglishWord().getVoiceEnText());

		ph_en_mp3.setText(ConClass.getEnglishWord().getVoiceEnUrlText());

		ph_am.setText(ConClass.getEnglishWord().getVoiceAmText());

		ph_am_mp3.setText(ConClass.getEnglishWord().getVoiceAmUrlText());

		try {

			JlabelSetText(maineng, ConClass.getEnglishWord().getMeanText());
			JlabelSetText(lje, ConClass.getEnglishWord().getExampleText()[0]);
			JlabelSetText(ljc, ConClass.getEnglishWord().getCnexampleText()[0]);

			try {
				musicUpload(ConClass.getEnglishWord().getVoiceEnUrlText(), "en");
				musicUpload(ConClass.getEnglishWord().getVoiceAmUrlText(), "am");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
				JinshanParseUtil.parseJinshanEnglishToChineseXMLWithPull(result);
				setword();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String UpdateLearningHttp(String string) {
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String UpdateStudyHttp(String string) {
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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

	public void musicUpload(String path, String string) throws Exception {
		// new一个URL对象
		URL url = new URL(path);
		// 打开链接
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置请求方式为"GET"
		conn.setRequestMethod("GET");
		// 超时响应时间为5秒
		conn.setConnectTimeout(5 * 1000);
		// 通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
		byte[] data = readInputStream(inStream);
		// new一个文件对象用来保存图片，默认保存当前工程根目录
		File imageFile = new File(Constant.USERPERSON + "/" + string + ".mp3");
		// 创建输出流
		FileOutputStream outStream = new FileOutputStream(imageFile);
		// 写入数据
		outStream.write(data);
		// 关闭输出流
		outStream.close();
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}

	class MusicenThread extends Thread {
		public void run() {
			try {
				System.out.println("执行");
				new Player(new BufferedInputStream(new FileInputStream(new File(Constant.USERPERSON + "/en.mp3"))))
						.play();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class MusicamThread extends Thread {
		public void run() {
			try {
				System.out.println("执行");
				new Player(new BufferedInputStream(new FileInputStream(new File(Constant.USERPERSON + "/am.mp3"))))
						.play();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
