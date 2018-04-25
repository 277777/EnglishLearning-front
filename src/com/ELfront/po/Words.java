package com.ELfront.po;

public class Words {

	private int ID;
	private String Word;
	private String GQS;
	private String GQFC;
	private String XZFC;
	private String FS;
	private String meaning;
	private String lx;
	
	public Words(int iD, String word, String gQS, String gQFC, String xZFC, String fS, String meaning, String lx) {
		super();
		ID = iD;
		Word = word;
		GQS = gQS;
		GQFC = gQFC;
		XZFC = xZFC;
		FS = fS;
		this.meaning = meaning;
		this.lx = lx;
	}

	public Words() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public String getGQS() {
		return GQS;
	}

	public void setGQS(String gQS) {
		GQS = gQS;
	}

	public String getGQFC() {
		return GQFC;
	}

	public void setGQFC(String gQFC) {
		GQFC = gQFC;
	}

	public String getXZFC() {
		return XZFC;
	}

	public void setXZFC(String xZFC) {
		XZFC = xZFC;
	}

	public String getFS() {
		return FS;
	}

	public void setFS(String fS) {
		FS = fS;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}
	
	
	
}
