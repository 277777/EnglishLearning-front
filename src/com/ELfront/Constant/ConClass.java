package com.ELfront.Constant;

import java.util.List;
import java.util.Map;

import com.ELfront.po.Restudy;
import com.ELfront.po.Study;
import com.ELfront.po.User;
import com.ELfront.po.UserMain;
import com.ELfront.po.Word.EnglishWord;

public class ConClass {

	private static User user;
	private static UserMain userMain;
	private static List<List<Map<Integer,String>>> limapst;
	private static EnglishWord englishWord;
	private static Study study;
	private static Restudy restudy;
	private static List<String> listshengci;
	

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

	public static List<List<Map<Integer, String>>> getLimapst() {
		return limapst;
	}

	public static void setLimapst(List<List<Map<Integer, String>>> limapst) {
		ConClass.limapst = limapst;
	}

	public static EnglishWord getEnglishWord() {
		return englishWord;
	}

	public static void setEnglishWord(EnglishWord englishWord) {
		ConClass.englishWord = englishWord;
	}

	public static Study getStudy() {
		return study;
	}

	public static void setStudy(Study study) {
		ConClass.study = study;
	}

	public static Restudy getRestudy() {
		return restudy;
	}

	public static void setRestudy(Restudy restudy) {
		ConClass.restudy = restudy;
	}

	public static List<String> getListshengci() {
		return listshengci;
	}

	public static void setListshengci(List<String> listshengci) {
		ConClass.listshengci = listshengci;
	}
	
	
}
