package edu.pnu.domain;

import java.util.Date;

public class Member {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
	
	public Member(Builder builder) {
		this.id=builder.id;
		this.pass=builder.pass;
		this.name=builder.name;
		this.regidate=builder.regidate;		
	}
	
	public static Builder builder() {
		return new Builder();
		
	}	
	
	public static class Builder{
		private int id;
		private String pass;
		private String name;
		private Date regidate;
		
		public Builder id(int id) {
			this.id=id;
			return this;
		}
		
		public Builder pass(String pass) {
			this.pass=pass;
			return this;
		}
		
		public Builder name(String name) {
			this.name=name;
			return this;
		}
		
		public Builder regidate(Date regidate) {
			this.regidate=regidate;
			return this;
			
		}
		public Member build() {
			return new Member(this);
		}
		
	
	}

}
