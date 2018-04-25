package com.ELfront.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.Tools.ScreenShotTest;

public class PictureGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	private JPanel frame;
	private JButton btnok;
	
	public PictureGUI() {
		init();
	}
	
	public void init() {
		
		btnok = new JButton("确认");
		btnok.setBounds(1406, 20, 150, 50);
		btnok.addActionListener(this);
		
		
		jLabel = new JLabel();
		jLabel.setSize(1366, 768);
		jLabel.setBounds(20, 20, 1366, 768);
		setIcon(Constant.PICTURE, jLabel);
		
		frame = new JPanel();
		frame.setLayout(null);
		frame.add(jLabel);
		frame.add(btnok);
		
		setSize(1600, 850);
		add(frame);
		setVisible(true);
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

	public static void copyFile(String src,String target)  
    {     
        File srcFile = new File(src);    
           File targetFile = new File(target);    
           try {    
               InputStream in = new FileInputStream(srcFile);     
               OutputStream out = new FileOutputStream(targetFile);    
               byte[] bytes = new byte[1024];    
               int len = -1;    
               while((len=in.read(bytes))!=-1)  
               {    
                   out.write(bytes, 0, len);    
               }    
               in.close();    
               out.close();    
           } catch (FileNotFoundException e) {    
               e.printStackTrace();    
           } catch (IOException e) {    
               e.printStackTrace();    
           }    
           System.out.println("文件复制成功");   


    }  
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnok) {
			String path = "resource/UserPerson/"+ConClass.getUser().getUsername();
			File file = new File(path);
			if(!file.exists())
				file.mkdirs();
			File image = new File(path+"/touxiang.png");
			if(image.exists())
				image.delete();
			copyFile(Constant.PICTURE,path+"/touxiang.png");
			String result = HttpUpload(ConNet.UPLOADURL+"?Name="+ConClass.getUser().getUsername());
			callback(result);
		}
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
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            
            File file = new File("F:\\Java\\Eclipse-oxygen2\\EnglishLearning-front\\resource\\UserPerson\\"+ConClass.getUser().getUsername()+"\\touxiang.png");
            String filePath = "F:\\Java\\Eclipse-oxygen2\\EnglishLearning-front\\resource\\UserPerson\\"+ConClass.getUser().getUsername()+"\\touxiang.png";
            
            String filename = file.getName();
            String contentType = "image/png";
            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"" + filePath
                    + "\"; filename=\"" + filename + "\"\r\n");
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
	
	public void callback(String string) {
		System.out.println("您现在看到的是："+string);
	}
}
