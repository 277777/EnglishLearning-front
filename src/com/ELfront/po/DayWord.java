package com.ELfront.po;

import java.util.List;

public class DayWord {

	/*
	 * 'sid':'' #每日一句ID
		'tts': '' #音频地址
		'content':'' #英文内容
		'note': '' #中文内容
		'love': '' #每日一句喜欢个数
		'translation':'' #词霸小编
		'picture': '' #图片地址
		'picture2': '' #大图片地址
		'caption':'' #标题
		'dateline':'' #时间
		's_pv':'' #浏览数
		'sp_pv':'' #语音评测浏览数
		'tags':'' #相关标签
		'fenxiang_img':'' #合成图片，建议分享微博用的
	 * */
	
	
	private int sid;
	private String tts;
	private String content;
	private String note;
	private String love;
	private String translation;
	private String picture;
	private String picture2;
	private String caption;
	private String dateline;
	private String s_pv;
	private String sp_pv;
	private List<Tags> tags;
	private String fenxiang_img;
	public DayWord() {
		super();
	}
	public DayWord(int sid, String tts, String content, String note, String love, String translation, String picture,
			String picture2, String caption, String dateline, String s_pv, String sp_pv, List<Tags> tags,
			String fenxiang_img) {
		super();
		this.sid = sid;
		this.tts = tts;
		this.content = content;
		this.note = note;
		this.love = love;
		this.translation = translation;
		this.picture = picture;
		this.picture2 = picture2;
		this.caption = caption;
		this.dateline = dateline;
		this.s_pv = s_pv;
		this.sp_pv = sp_pv;
		this.tags = tags;
		this.fenxiang_img = fenxiang_img;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getTts() {
		return tts;
	}
	public void setTts(String tts) {
		this.tts = tts;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getDateline() {
		return dateline;
	}
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	public String getS_pv() {
		return s_pv;
	}
	public void setS_pv(String s_pv) {
		this.s_pv = s_pv;
	}
	public String getSp_pv() {
		return sp_pv;
	}
	public void setSp_pv(String sp_pv) {
		this.sp_pv = sp_pv;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public String getFenxiang_img() {
		return fenxiang_img;
	}
	public void setFenxiang_img(String fenxiang_img) {
		this.fenxiang_img = fenxiang_img;
	}
	
	
	
}
