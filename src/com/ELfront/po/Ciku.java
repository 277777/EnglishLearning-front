package com.ELfront.po;

public class Ciku {

	private int cikuid;
	private String cikuname;
	
	public Ciku(int cikuid, String cikuname) {
		super();
		this.cikuid = cikuid;
		this.cikuname = cikuname;
	}
	public Ciku() {
		super();
	}
	public int getCikuid() {
		return cikuid;
	}
	public void setCikuid(int cikuid) {
		this.cikuid = cikuid;
	}
	public String getCikuname() {
		return cikuname;
	}
	public void setCikuname(String cikuname) {
		this.cikuname = cikuname;
	}
	
	
}
