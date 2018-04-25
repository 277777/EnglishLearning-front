package com.ELfront.GUI.Fragment;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.Tools.GsonTools;
import com.ELfront.po.DayWord;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Day_Fragment extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DayWord newsJson;

	private JLabel labelpicture;
	private JLabel english, chinese, je, jc;
	private JLabel voice;
	private JLabel date;
	private JLabel day;

	private String dates, days;

	public Day_Fragment() {
		init();
	}

	public void init() {
		int result = doGet(ConNet.JSCBDAYAPI);
		if (result != 0) {
			Constant.USERPERSON = Constant.USERPERSON + ConClass.getUser().getUsername();
			File file = new File(Constant.USERPERSON);
			if (!file.exists())
				file.mkdirs();
			System.out.println(newsJson.getPicture2());
			System.out.println(newsJson.getTts());
			try {
				picUpload(newsJson.getPicture2());
				zoomImage(Constant.USERPERSON + "/dayword.jpg", Constant.USERPERSON + "/daywords.jpg", 469, 290);
				dateday(newsJson.getDateline());
				musicUpload(newsJson.getTts());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			labelpicture = new JLabel(new ImageIcon(Constant.USERPERSON + "/daywords.jpg"));
			labelpicture.setBounds(10, 130, 469, 290);

			je = new JLabel("English:");
			je.setBounds(489, 20, 200, 50);
			je.setFont(new Font("宋体", 1, 30));

			voice = new JLabel();
			voice.setSize(50, 50);
			setIcon("resource/image/voice.png", voice);
			voice.setBounds(800, 20, 50, 50);
			voice.addMouseListener(new MouseListener() {

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
					MusicThread musicThread = new MusicThread();
					musicThread.start();
				}
			});

			english = new JLabel();
			english.setSize(400, 50);// 注意JLabel一定要设置宽度
			try {
				JlabelSetText(english, "&nbsp;&nbsp;" + newsJson.getContent());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			english.setBounds(489, 80, 400, 90);
			english.setFont(new Font("宋体", 1, 20));

			chinese = new JLabel();
			chinese.setSize(400, 50);// 注意JLabel一定要设置宽度
			try {
				JlabelSetText(chinese, "&nbsp;&nbsp;" + newsJson.getNote());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chinese.setBounds(489, 260, 400, 90);
			chinese.setFont(new Font("宋体", 1, 20));

			jc = new JLabel("中文:");
			jc.setBounds(489, 200, 140, 50);
			jc.setFont(new Font("宋体", 1, 30));

			date = new JLabel(dates);
			date.setBounds(40, 40, 140, 50);
			date.setFont(new Font("宋体", 1, 50));

			day = new JLabel(days);
			day.setBounds(140, 40, 140, 50);
			day.setFont(new Font("宋体", 1, 40));

			this.setLayout(null);
			add(labelpicture);
			add(je);
			add(jc);
			add(english);
			add(chinese);
			add(date);
			add(day);
			add(voice);
		}
	}

	public int doGet(String path) {
		long end = 0;
		long start = System.currentTimeMillis();
		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			String dataString = new String(GsonTools.IsToByte(connection.getInputStream()), "utf-8");
			System.out.println(dataString);
			newsJson = GsonTools.getObjectData(dataString, DayWord.class);
			end = System.currentTimeMillis();
			System.out.println("timeGap:" + (end - start));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int) (end - start);
	}

	public void picUpload(String path) throws Exception {
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
		File imageFile = new File(Constant.USERPERSON + "/dayword.jpg");
		// 创建输出流
		FileOutputStream outStream = new FileOutputStream(imageFile);
		// 写入数据
		outStream.write(data);
		// 关闭输出流
		outStream.close();
	}

	public void musicUpload(String path) throws Exception {
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
		File imageFile = new File(Constant.USERPERSON + "/dayword.mp3");
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

	public static void zoomImage(String src, String dest, int w, int h) throws Exception {

		double wr = 0, hr = 0;
		File srcFile = new File(src);
		File destFile = new File(dest);

		BufferedImage bufImg = ImageIO.read(srcFile); // 读取图片
		Image Itemp = bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);// 设置缩放目标图片模板

		wr = w * 1.0 / bufImg.getWidth(); // 获取缩放比例
		hr = h * 1.0 / bufImg.getHeight();

		AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
		Itemp = ato.filter(bufImg, null);
		try {
			ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile); // 写入缩减后的图片
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public void dateday(String string) {
		String[] sdd = string.split("-");
		switch (sdd[1]) {
		case "01":
			dates = "Jan";
			break;
		case "02":
			dates = "Feb";
			break;
		case "03":
			dates = "Mar";
			break;
		case "04":
			dates = "Apr";
			break;
		case "05":
			dates = "May";
			break;
		case "06":
			dates = "Jun";
			break;
		case "07":
			dates = "Jul";
			break;
		case "08":
			dates = "Aug";
			break;
		case "09":
			dates = "Sept";
			break;
		case "10":
			dates = "Oct";
			break;
		case "11":
			dates = "Nov";
			break;
		case "12":
			dates = "Dec";
			break;
		}
		days = sdd[2];
	}

	public void setIcon(String file, JLabel com) {
		ImageIcon ico = new ImageIcon(file);
		ico.getImage();
		Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
	}

	class MusicThread extends Thread {
		public void run() {
			try {
				System.out.println("执行");
				new Player(new BufferedInputStream(new FileInputStream(new File(Constant.USERPERSON + "/dayword.mp3"))))
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
