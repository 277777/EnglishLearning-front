package com.ELfront.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ELfront.Constant.Constant;
import com.ELfront.GUI.PictureGUI;


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
		        
//				ScreenShotWindow ssw;
//				try {
//					ssw = new ScreenShotWindow();
//					ssw.setVisible(true);
//				} catch (AWTException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				new PictureGUI();
			}
		});

		add(frame);
		setVisible(true);
		setSize(480, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
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
		new TestMainGUI();
	}
}
