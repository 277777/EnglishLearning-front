package com.ELfront.Constant;

import com.ELfront.po.User;
import com.ELfront.po.UserMain;

public class ConClass {

	private static User user;
	private static UserMain userMain;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		ConClass.user = user;
	}

	public static UserMain getUserMain() {
		return userMain;
	}

	public static void setUserMain(UserMain userMain) {
		ConClass.userMain = userMain;
	}
	
	
}
