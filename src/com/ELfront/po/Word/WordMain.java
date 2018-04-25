package com.ELfront.po.Word;

public class WordMain {

	private String word_name;
	private int is_CRI;
	//private Exchange exchange;
	private Symbols symbols;
	public WordMain() {
		super();
	}
	public WordMain(String word_name, int is_CRI,Symbols symbols) {
		super();
		this.word_name = word_name;
		this.is_CRI = is_CRI;
		this.symbols = symbols;
	}
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public int getIs_CRI() {
		return is_CRI;
	}
	public void setIs_CRI(int is_CRI) {
		this.is_CRI = is_CRI;
	}
//	public Exchange getExchange() {
//		return exchange;
//	}
//	public void setExchange(Exchange exchange) {
//		this.exchange = exchange;
//	}
	public Symbols getSymbols() {
		return symbols;
	}
	public void setSymbols(Symbols symbols) {
		this.symbols = symbols;
	}
	
	
}
