package com.ELfront.GUI.Fragment;

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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.Constant;
import com.ELfront.Tools.JinshanParseUtil;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Shengci_Fragment extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel engword, nextword, ph_en, ph_en_mp3, ph_am, ph_am_mp3, ph_enl, ph_aml, jmain, maineng;
	int m = 0;
	
	public Shengci_Fragment() {
		init();
		System.out.println("ConClass.getListshengci():"+ConClass.getListshengci());
		if(ConClass.getListshengci()!=null) {
			String path = "http://dict-co.iciba.com/api/dictionary.php?w=" + ConClass.getListshengci().get(m)
					+ "&type=xml&key=313A73223317189FBA1B82AB00AD0ED4";
			doGet(path);
		}
	}
	
	public void init() {
		
		setLayout(null);
		
		engword = new JLabel();
		engword.setText("Word");
		engword.setBounds(30, 30, 300, 40);
		engword.setFont(new Font("宋体", 1, 30));
		add(engword);
	
		nextword = new JLabel();
		nextword.setSize(40, 40);
		setIcon("resource/image/next.png", nextword);
		nextword.setBounds(800, 30, 40, 40);
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
				m++;
				if(m==ConClass.getListshengci().size()) {
					m=0;
				}
				String path = "http://dict-co.iciba.com/api/dictionary.php?w=" + ConClass.getListshengci().get(m)
						+ "&type=xml&key=313A73223317189FBA1B82AB00AD0ED4";
				doGet(path);
			}
		});
		add(nextword);

		ph_en = new JLabel();
		ph_en.setBounds(180, 100, 300, 30);
		ph_en.setFont(new Font("Times New Roman", 1, 25));
		add(ph_en);

		ph_en_mp3 = new JLabel();
		ph_en_mp3.setSize(30, 30);
		setIcon("resource/image/539887.png", ph_en_mp3);
		ph_en_mp3.setBounds(400, 100, 30, 30);
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
		add(ph_en_mp3);

		ph_am = new JLabel();
		ph_am.setBounds(180, 150, 300, 30);
		ph_am.setFont(new Font("Times New Roman", 1, 25));
		add(ph_am);

		ph_am_mp3 = new JLabel();
		ph_am_mp3.setSize(30, 30);
		setIcon("resource/image/539887.png", ph_am_mp3);
		ph_am_mp3.setBounds(400, 150, 30, 30);
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
		add(ph_am_mp3);

		ph_enl = new JLabel();
		ph_enl.setText("英式发音");
		ph_enl.setBounds(30, 100, 300, 30);
		ph_enl.setFont(new Font("宋体", 1, 20));
		add(ph_enl);

		ph_aml = new JLabel();
		ph_aml.setText("美式发音");
		ph_aml.setBounds(30, 150, 300, 30);
		ph_aml.setFont(new Font("宋体", 1, 20));
		add(ph_aml);

		jmain = new JLabel("详细释义：");
		jmain.setBounds(30, 250, 300, 30);
		jmain.setFont(new Font("宋体", 1, 20));
		add(jmain);

		maineng = new JLabel();
		maineng.setBounds(30, 300, 850, 100);
		maineng.setSize(850, 100);
		maineng.setFont(new Font("宋体", 1, 20));
		add(maineng);

		validate();// 使控件合法化（下拉列表会有下箭头）
		setVisible(true);
		setSize(980, 720);
	}
	
	public void setIcon(String file, JLabel com) {
		ImageIcon ico = new ImageIcon(file);
		ico.getImage();
		Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
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

	public void setword() {

		engword.setText(ConClass.getListshengci().get(m));
		engword.setFont(new Font("宋体", 1, 30));

		ph_en.setText(ConClass.getEnglishWord().getVoiceEnText());

		ph_en_mp3.setText(ConClass.getEnglishWord().getVoiceEnUrlText());

		ph_am.setText(ConClass.getEnglishWord().getVoiceAmText());

		ph_am_mp3.setText(ConClass.getEnglishWord().getVoiceAmUrlText());
		
		try {
			JlabelSetText(maineng, ConClass.getEnglishWord().getMeanText());
			musicUpload(ConClass.getEnglishWord().getVoiceEnUrlText(), "en");
			musicUpload(ConClass.getEnglishWord().getVoiceAmUrlText(), "am");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	
}
