package com.ELfront.GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ELfront.Constant.ConClass;
import com.ELfront.Constant.ConNet;
import com.ELfront.GUI.Fragment.Day_Fragment;
import com.ELfront.GUI.Fragment.Personal_Fragment;
import com.ELfront.GUI.Fragment.Shengci_Fragment;
import com.ELfront.GUI.Fragment.Study_Fragment;
import com.ELfront.po.Restudy;
import com.ELfront.po.Study;

public class PersonalGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JTabbedPane jTabbedPane;
	private JPanel jperson,jday,jstudy,jshengci;

	public PersonalGUI() {
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jperson = new Personal_Fragment();
		jday = new Day_Fragment();
		frame = new JPanel();
		if(ConClass.getUser().getCikuid()!=0) {
			net();
			ShowStudy(ConNet.STUDYMOREURL+"?Userid="+ConClass.getUser().getUserid());
			ShowReStudy(ConNet.RESTUDYMOREURL+"?Userid="+ConClass.getUser().getUserid());
		}
		jstudy = new Study_Fragment();
		ShowShengcihttp(ConNet.SHOWSHENGCIURL+"?Userid="+ConClass.getUser().getUserid());
		jshengci = new Shengci_Fragment();
		init();
	}
	
	public void init() {
		
		frame.setLayout(null);
		
		jTabbedPane.addTab("用户中心",jperson);
		jTabbedPane.addTab("学习", jstudy);
		jTabbedPane.addTab("生词本", jshengci);
		jTabbedPane.addTab("每日一句",jday);
		jTabbedPane.setBounds(30, 20, 900, 460);
		
		frame.add(jTabbedPane);
		
		validate();
		setResizable(false);
		add(frame);
		setVisible(true);
		setSize(960, 540);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	public void net() {
		String string = ShowCikuHttp();
		System.out.println(string);
		try {
			CallBack(string);
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

	public List<List<Map<Integer,String>>> changejsontolist(String string) throws Exception {
		System.out.println("string:"+string);
			Map<Integer, String> map;
			List<List<Map<Integer,String>>> list = new ArrayList<List<Map<Integer,String>>>();
			JSONArray jsonstr = new JSONArray(string);
	        System.out.println(jsonstr);
	        System.out.println(jsonstr.length());
//	        for(int i=0;i<10;i++){
//	        	for(int j=0;j<10;j++) {
//	        		JSONObject jsonObject = jsonstr.getJSONObject(i*10+j);
//	              map = new HashMap<Integer, String>();
//	              map.put(1,jsonObject.get("1").toString());
//	              map.put(2,jsonObject.get("2").toString());
//	              listmap.add(map);
//	        	}
//	        	list.add(listmap);
//	        }
	        for(int i=0;i<10;i++) {
	        	List<Map<Integer,String>> listmap = new ArrayList<Map<Integer,String>>();
	        	for(int j=0;j<10;j++) {
		        	JSONObject jsonObject = jsonstr.getJSONObject(i*10+j);
		        	System.out.println("jsonObject:"+jsonObject);
		              map = new HashMap<Integer, String>();
		              map.put(1,jsonObject.get("1").toString());
		              map.put(2,jsonObject.get("2").toString());
		              listmap.add(map);
	        	}
	        	list.add(listmap);
	        }
	        	
	        System.out.println("你看这是数据："+list.size());
	        System.out.println("你看这是数据："+list.get(1));
//	        System.out.println("你看这是数据："+list.get(1));
			return list;
	}
	
	public void CallBack(String string) throws Exception {
		if(string==null)
			JOptionPane.showMessageDialog(null, "词库获取失败，请稍后再试","警告",JOptionPane.ERROR_MESSAGE);
		else {
			System.out.println(changejsontolist(string));
			ConClass.setLimapst(changejsontolist(string));
		}
			
	}

	public String ShowStudy(String string) {
		String result = "";
		String url = string;
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
                System.out.println("showstudy收到："+result);
                if(result!=null) {
                	String[] strings = result.split("#");
                	Study restudy = new Study();
                	restudy.setStuid(Integer.valueOf(strings[0]));
                	restudy.setUserid(Integer.valueOf(strings[1]));
                	restudy.setMon(Integer.valueOf(strings[2]));
                	restudy.setTue(Integer.valueOf(strings[3]));
                	restudy.setWed(Integer.valueOf(strings[4]));
                	restudy.setThu(Integer.valueOf(strings[5]));
                	restudy.setFri(Integer.valueOf(strings[6]));
                	restudy.setSat(Integer.valueOf(strings[7]));
                	restudy.setSun(Integer.valueOf(strings[8]));
                	ConClass.setStudy(restudy);
                }else {
                	Study restudy = new Study();
                	restudy.setUserid(ConClass.getUser().getUserid());
                	restudy.setMon(0);
                	restudy.setTue(0);
                	restudy.setWed(0);
                	restudy.setThu(0);
                	restudy.setFri(0);
                	restudy.setSat(0);
                	restudy.setSun(0);
                	ConClass.setStudy(restudy);
                }
                
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String ShowReStudy(String string) {
		String result = "";
		String url = string;
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
                System.out.println("reshowstudy收到："+result);
                if(result!=null) {
                	String[] strings = result.split("#");
                	Restudy restudy = new Restudy();
                	restudy.setRestuid(Integer.valueOf(strings[0]));
                	restudy.setUserid(Integer.valueOf(strings[1]));
                	restudy.setMon(Integer.valueOf(strings[2]));
                	restudy.setTue(Integer.valueOf(strings[3]));
                	restudy.setWed(Integer.valueOf(strings[4]));
                	restudy.setThu(Integer.valueOf(strings[5]));
                	restudy.setFri(Integer.valueOf(strings[6]));
                	restudy.setSat(Integer.valueOf(strings[7]));
                	restudy.setSun(Integer.valueOf(strings[8]));
                	ConClass.setRestudy(restudy);
                }
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String ShowShengcihttp(String string) {
		String result = "";
		String url = string;
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
                System.out.println("reshowstudy收到："+result);
                if(result!=null) {
                	JSONArray jsonArray = new JSONArray(result);
                	List<String> list = new ArrayList<String>();
                	for(int i=0;i<jsonArray.length();i++) {
                		JSONObject jsonObject = jsonArray.getJSONObject(i);
                		list.add(jsonObject.get("1").toString());
                	}
                	ConClass.setListshengci(list);
                }
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
