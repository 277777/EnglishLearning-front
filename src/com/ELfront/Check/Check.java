package com.ELfront.Check;

public class Check {

	//检查
	public boolean checktele(String string) {
		System.out.println("输入的数字是"+string);
		boolean result=string.matches("[0-9]+");
		if(result==true&&string.length()==11)
			return true;
		else return false;
	}
	
}
