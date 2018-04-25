package com.ELfront.GUI.Fragment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ELfront.Constant.ConClass;
import com.ELfront.GUI.Learning.EnglishExamGUI;
import com.ELfront.GUI.Learning.EnglishFuxiGUI;
import com.ELfront.GUI.Learning.EnglishLearnGUI;
import com.ELfront.Tools.GetMouth;
import com.ELfront.Tools.TimeSeriesChart;

public class Study_Fragment extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jx,jf,jt;
	private JPanel jPanel;
	
	public Study_Fragment() {
		init();
	}
	
//	public void zhexian() {}

	public void init() {
		  
		setLayout(null);
		
		jPanel = new TimeSeriesChart().getframe();
		jPanel.setBounds(30, 10, 700, 400);
		add(jPanel);
		
		jx = new JButton("学习");
		jx.setBounds(760, 10, 80, 40);
		add(jx);
		jx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(ConClass.getLimapst());
				List<Map<Integer,String>> list = ConClass.getLimapst().get(ConClass.getUser().getUserlearn());
				System.out.println("系统提取后："+list);
				new EnglishLearnGUI(list);
			}
		});
		
		jf = new JButton("复习");
		jf.setBounds(760, 100, 80, 40);
		add(jf);
		jf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(ConClass.getLimapst());
//				new EnglishLearnGUI(ConClass.getLimapst().get(ConClass.getUser().getUserlearn()));
				if(ConClass.getUser().getUserlearn()==0)
					System.out.println("未开始学习");
				else {
					int mouth = new GetMouth().getm();
					int res = 0 ;
					switch(mouth) {
					case 1:
						res = ConClass.getStudy().getMon()/10;
						break;
					case 2:
						res = ConClass.getStudy().getTue()/10;
						break;
					case 3:
						res = ConClass.getStudy().getWed()/10;
						break;
					case 4:
						res = ConClass.getStudy().getThu()/10;
						break;
					case 5:
						res = ConClass.getStudy().getFri()/10;
						break;
					case 6:
						res = ConClass.getStudy().getSat()/10;
						break;
					case 7:
						res = ConClass.getStudy().getSun()/10;
						break;
						default:
							break;
					}
					new EnglishFuxiGUI(ConClass.getLimapst(),res);
				}
			}
		});
		
		jt = new JButton("测试");
		jt.setBounds(760, 200, 80, 40);
		add(jt);
		jt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int mouth = new GetMouth().getm();
				int res = 0 ;
				switch(mouth) {
				case 1:
					res = ConClass.getStudy().getMon()/10;
					break;
				case 2:
					res = ConClass.getStudy().getTue()/10;
					break;
				case 3:
					res = ConClass.getStudy().getWed()/10;
					break;
				case 4:
					res = ConClass.getStudy().getThu()/10;
					break;
				case 5:
					res = ConClass.getStudy().getFri()/10;
					break;
				case 6:
					res = ConClass.getStudy().getSat()/10;
					break;
				case 7:
					res = ConClass.getStudy().getSun()/10;
					break;
					default:
						break;
				}
				if(ConClass.getUser().getUserlearn()==0)
					System.out.println("未开始学习");
				else {
//					new EnglishFuxiGUI(ConClass.getLimapst().get(ConClass.getUser().getUserlearn()-1));
					System.out.println(ConClass.getLimapst().getClass()+""+res);
					new EnglishExamGUI(ConClass.getLimapst(), res);
				}
			}
		});
		
		
		
//	    add(new TimeSeriesChart().getframe());    //添加折线图  
//	    setBounds(10, 10, 800, 600);
	    setVisible(true); 
		
	}
}