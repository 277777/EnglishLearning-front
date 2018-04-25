package com.ELfront.po;


public class UserMain {
	
	private int usermainid;
	private String usermainname;
	private String usermainsex;
	private String usermaincollege;
	private String usermainclass;
	private String usermainemail;
	
	public UserMain() {
		super();
	}

	public UserMain(int usermainid, String usermainname, String usermainsex,String usermaincollege, 
			String usermainclass, String usermainemail) {
		super();
		this.usermainid = usermainid;
		this.usermainname = usermainname;
		this.usermainsex = usermainsex;
		this.usermaincollege = usermaincollege;
		this.usermainclass = usermainclass;
		this.usermainemail = usermainemail;
	}

	public int getUsermainid() {
		return usermainid;
	}

	public void setUsermainid(int usermainid) {
		this.usermainid = usermainid;
	}

	public String getUsermainname() {
		return usermainname;
	}

	public void setUsermainname(String usermainname) {
		this.usermainname = usermainname;
	}

	public String getUsermainsex() {
		return usermainsex;
	}

	public void setUsermainsex(String usermainsex) {
		this.usermainsex = usermainsex;
	}

	public String getUsermaincollege() {
		return usermaincollege;
	}

	public void setUsermaincollege(String usermaincollege) {
		this.usermaincollege = usermaincollege;
	}

	public String getUsermainclass() {
		return usermainclass;
	}

	public void setUsermainclass(String usermainclass) {
		this.usermainclass = usermainclass;
	}

	public String getUsermainemail() {
		return usermainemail;
	}

	public void setUsermainemail(String usermainemail) {
		this.usermainemail = usermainemail;
	}
	
	
	
}
