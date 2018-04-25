package com.ELfront.Text;


import java.util.Arrays;
import java.util.Random;

import com.ELfront.GUI.Learning.EnglishExamGUI;

public class TextMain {
	
	private static int[] num = new int[3];
	private static int[] number = new int[4];
	
	public static void main(String args[]){  
//		new EnglishExamGUI();
        num[0]=(int)(Math.random()*10)-5;
        num[1]=(int)(Math.random()*10)-5;
        num[2]=(int)(Math.random()*10)-5;
        for(int i=0;i<3;i++) {
        	if(num[i]==0)
        		num[i]++;
        	//System.out.println(num[i]);
        }
        Arrays.sort(num);
        number[3] = 0;
        for(int i=0;i<3;i++) {
        	if(num[0]==num[1])
        		num[0]=-12;
        	if(num[1]==num[2])
        		num[2]=12;
        	number[i] = num[i];
        }
        Arrays.sort(number);
        for(int i=0;i<4;i++) {
        	System.out.println(number[i]);
        }
	}  

}
