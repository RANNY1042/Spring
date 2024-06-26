package edu.pnu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVOBuilder {

	private int id;
	private String pass;
	private String name;
	private Date regidate;
	
	public MemberVOBuilder() {
		
	}

	public MemberVOBuilder(int id, String pass, String name, Date regidate) {
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.regidate=regidate;		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public MemberVOBuilder Build() {
		return new MemberVOBuilder(id,pass,name,regidate);
	}


}

