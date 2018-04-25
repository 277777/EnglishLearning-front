package com.ELfront.GUI.Learning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ELfront.Constant.ClassThis;
import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.Constant.Constant;
import com.ELfront.po.Restudy;
import com.ELfront.po.Study;

public class ChroseGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> jComboBox;
	private JButton jButton;
	private JPanel jPanel;
	private String ciku[]={"四级","六级",	"考研","GRE"};
	
	private static int cikunum = 0;
	
	public ChroseGUI() {
		init();
	}
	
	public void init() {
	
		jPanel = new JPanel();
		jPanel.setLayout(null);
		
		jButton = new JButton("确认");
		jButton.setBounds(150, 30, 80, 40);
		jPanel.add(jButton);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(jComboBox.getSelectedIndex());
				System.out.println(ciku[jComboBox.getSelectedIndex()]);
				switch(jComboBox.getSelectedIndex()) {
				case 0:
					cikunum = 1;
					break;
				case 1:
					cikunum = 10;
					break;
				case 2:
					cikunum = 100;
					break;
				case 3:
					cikunum = 1000;
					break;
					default:
						break;
				}
				String result = CikuSelectHttp(ConNet.SELECTCIKUURL+"?Cikuid="+cikunum+"&Userid="+ConClass.getUser().getUserid());
				Callback(result);
			}
		});
		
		//头像下拉列表
		jComboBox =new JComboBox<String>(ciku);
		jComboBox.setBounds(10, 30, 120, 40);
		jPanel.add(jComboBox);
		
		validate();//使控件合法化（下拉列表会有下箭头）
		setResizable(false);//c窗体无法改变大小
		add(jPanel);
		setVisible(true);
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public String CikuSelectHttp(String string) {
		String result = "";
		String url = string;
		System.out.println(string);
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
	
	public void  Callback(String string) {
		if(string.equals(Constant.DEFEATE))
			JOptionPane.showMessageDialog(null, "失败","警告",JOptionPane.ERROR_MESSAGE);
		else {
			ConClass.getUser().setCikuid(cikunum);
			ClassThis.PFragment.initmore();
			net();
			dispose();
		}
	}
	
	public void net() {
		String string = ShowCikuHttp();
		System.out.println(string);
		try {
			StackBack(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String ShowCikuHttp() {
		String result = "";
		String url = ConNet.SHOWCIKUURL+"?Cikuid="+ConClass.getUser().getCikuid();
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
	
	public void StackBack(String string) throws Exception {
		if(string==null)
			JOptionPane.showMessageDialog(null, "词库获取失败，请稍后再试","警告",JOptionPane.ERROR_MESSAGE);
		else {
			System.out.println(changejsontolist(string));
			ConClass.setLimapst(changejsontolist(string));
			
			Study study = new Study();
			study.setUserid(ConClass.getUser().getUserid());
			study.setMon(0);
			study.setThu(0);
			study.setWed(0);
			study.setTue(0);
			study.setFri(0);
			study.setSat(0);
			study.setSun(0);
			ConClass.setStudy(study);
			Restudy restudy = new Restudy();
			restudy.setUserid(ConClass.getUser().getUserid());
			restudy.setMon(0);
			restudy.setThu(0);
			restudy.setWed(0);
			restudy.setTue(0);
			restudy.setFri(0);
			restudy.setSat(0);
			restudy.setSun(0);
			ConClass.setRestudy(restudy);
		}
			
	}
	
	public List<List<Map<Integer,String>>> changejsontolist(String string) throws Exception {
		System.out.println("string:"+string);
			Map<Integer, String> map;
			List<Map<Integer,String>> listmap = new ArrayList<Map<Integer,String>>();
			List<List<Map<Integer,String>>> list = new ArrayList<List<Map<Integer,String>>>();
			JSONArray jsonstr = new JSONArray(string);
	        System.out.println(jsonstr);
	        System.out.println(jsonstr.length());
	        for(int i=0;i<10;i++){
	        	for(int j=0;j<10;j++) {
	        		JSONObject jsonObject = jsonstr.getJSONObject(i*10+j);
	              map = new HashMap<Integer, String>();
	              map.put(1,jsonObject.get("1").toString());
	              map.put(2,jsonObject.get("2").toString());
	              listmap.add(map);
	        	}
	        	list.add(listmap);
	        }
	        
	        System.out.println(list.size()+"    "+listmap.size()+"    "+list);
			return list;
	}
	

	public String InitCikuHttp() {
		String result = "";
		String url = ConNet.INITCIKUURL+"?Userid="+ConClass.getUser().getUserid();
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