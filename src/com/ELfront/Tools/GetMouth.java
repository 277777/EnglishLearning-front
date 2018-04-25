package com.ELfront.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetMouth {

	public int getm() {
		Date date = new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String path = dateFm.format(date);
		String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日"};
        int index1 = printArray(weekDays,path);  
        System.out.println("下标是："+index1); 
		return index1+1;
	}
    //遍历数组  
    public static int printArray(String[] array,String value){  
        for(int i = 0;i<array.length;i++){  
            if(array[i].equals(value)){  
                return i;  
            }  
        }  
        return -1;//当if条件不成立时，默认返回一个负数值-1  
    } 
	
}
