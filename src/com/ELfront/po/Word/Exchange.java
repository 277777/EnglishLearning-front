package com.ELfront.po.Word;

import java.util.List;

public class Exchange {

	private List<String> word_pl;
	private List<String> word_past;
	private List<String> word_done;
	private List<String> word_ing;
	private List<String> word_third;
	private List<String> word_er;
	private List<String> word_est;
	public Exchange() {
		super();
	}
	public Exchange(List<String> word_pl, List<String> word_past, List<String> word_done, List<String> word_ing,
			List<String> word_third, List<String> word_er, List<String> word_est) {
		super();
		this.word_pl = word_pl;
		this.word_past = word_past;
		this.word_done = word_done;
		this.word_ing = word_ing;
		this.word_third = word_third;
		this.word_er = word_er;
		this.word_est = word_est;
	}
	public List<String> getWord_pl() {
		return word_pl;
	}
	public void setWord_pl(List<String> word_pl) {
		this.word_pl = word_pl;
	}
	public List<String> getWord_past() {
		return word_past;
	}
	public void setWord_past(List<String> word_past) {
		this.word_past = word_past;
	}
	public List<String> getWord_done() {
		return word_done;
	}
	public void setWord_done(List<String> word_done) {
		this.word_done = word_done;
	}
	public List<String> getWord_ing() {
		return word_ing;
	}
	public void setWord_ing(List<String> word_ing) {
		this.word_ing = word_ing;
	}
	public List<String> getWord_third() {
		return word_third;
	}
	public void setWord_third(List<String> word_third) {
		this.word_third = word_third;
	}
	public List<String> getWord_er() {
		return word_er;
	}
	public void setWord_er(List<String> word_er) {
		this.word_er = word_er;
	}
	public List<String> getWord_est() {
		return word_est;
	}
	public void setWord_est(List<String> word_est) {
		this.word_est = word_est;
	}
	
	
}
