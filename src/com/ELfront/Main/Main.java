package com.ELfront.Main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.ELfront.GUI.MainGUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		new MainGUI();
	}

}
