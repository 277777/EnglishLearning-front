package com.ELfront.po.Word;

public class EnglishWord {

	/*
	 *             System.out.println("queryText:   "+queryText);
            System.out.println("voiceEnText:   "+"["+voiceArray[0]+"]");
            System.out.println("voiceEnUrlText:   "+voiceUrlArray[0]);
            System.out.println("voiceAmText:   "+"["+voiceArray[1]+"]");
            System.out.println("voiceAmUrlText:   "+voiceUrlArray[1]);
            System.out.println("meanText:   "+meanText);
            System.out.println("exampleText:   "+exampleText);
	 * */
	private String queryText;
	private String voiceEnText;
	private String voiceEnUrlText;
	private String voiceAmText;
	private String voiceAmUrlText;
	private String meanText;
	private String[] exampleText;
	private String[] cnexampleText;
	public EnglishWord() {
		super();
	}
	public EnglishWord(String queryText, String voiceEnText, String voiceEnUrlText, String voiceAmText,
			String voiceAmUrlText, String meanText, String[] exampleText, String[] cnexampleText) {
		super();
		this.queryText = queryText;
		this.voiceEnText = voiceEnText;
		this.voiceEnUrlText = voiceEnUrlText;
		this.voiceAmText = voiceAmText;
		this.voiceAmUrlText = voiceAmUrlText;
		this.meanText = meanText;
		this.exampleText = exampleText;
		this.cnexampleText = cnexampleText;
	}
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public String getVoiceEnText() {
		return voiceEnText;
	}
	public void setVoiceEnText(String voiceEnText) {
		this.voiceEnText = voiceEnText;
	}
	public String getVoiceEnUrlText() {
		return voiceEnUrlText;
	}
	public void setVoiceEnUrlText(String voiceEnUrlText) {
		this.voiceEnUrlText = voiceEnUrlText;
	}
	public String getVoiceAmText() {
		return voiceAmText;
	}
	public void setVoiceAmText(String voiceAmText) {
		this.voiceAmText = voiceAmText;
	}
	public String getVoiceAmUrlText() {
		return voiceAmUrlText;
	}
	public void setVoiceAmUrlText(String voiceAmUrlText) {
		this.voiceAmUrlText = voiceAmUrlText;
	}
	public String getMeanText() {
		return meanText;
	}
	public void setMeanText(String meanText) {
		this.meanText = meanText;
	}
	public String[] getExampleText() {
		return exampleText;
	}
	public void setExampleText(String[] exampleText) {
		this.exampleText = exampleText;
	}
	public String[] getCnexampleText() {
		return cnexampleText;
	}
	public void setCnexampleText(String[] cnexampleText) {
		this.cnexampleText = cnexampleText;
	}
	
}
