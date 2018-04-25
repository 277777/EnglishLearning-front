package com.ELfront.po;

public class User {

	private int userid;
	private String username;
	private String userpwd;
	private String usertele;
	private int userlearn;
	private int cikuid;
	private int shengcibenid;
	private int usermainid;
	private String userimg;
	public User() {
		super();
	}
	public User(int userid, String username, String userpwd, String usertele, int userlearn, int cikuid,
			int shengcibenid, int usermainid, String userimg) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.usertele = usertele;
		this.userlearn = userlearn;
		this.cikuid = cikuid;
		this.shengcibenid = shengcibenid;
		this.usermainid = usermainid;
		this.userimg = userimg;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsertele() {
		return usertele;
	}
	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}
	public int getUserlearn() {
		return userlearn;
	}
	public void setUserlearn(int userlearn) {
		this.userlearn = userlearn;
	}
	public int getCikuid() {
		return cikuid;
	}
	public void setCikuid(int cikuid) {
		this.cikuid = cikuid;
	}
	public int getShengcibenid() {
		return shengcibenid;
	}
	public void setShengcibenid(int shengcibenid) {
		this.shengcibenid = shengcibenid;
	}
	public int getUsermainid() {
		return usermainid;
	}
	public void setUsermainid(int usermainid) {
		this.usermainid = usermainid;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	
}
